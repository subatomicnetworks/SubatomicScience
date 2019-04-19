package com.subatomicnetworks.subatomicscience.tiles;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.containers.ContainerFakePlayer;
import com.subatomicnetworks.subatomicscience.entities.EntityFakePlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerDispenser;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.WorldServer;

import javax.annotation.Nullable;

public class TileFakePlayer extends TileEntityLockableLoot implements ITickable
{

    private EntityFakePlayer player;
    private float pitch;
    private float yaw;
    private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);

    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.fake_player";
    }

    public int getSizeInventory()
    {
        return 9;
    }

    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.stacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    // TODO: Have an actual inventory and GUI instead of a copy of an item that you right click onto the block.
    private ItemStack storedItem;

    //TODO: So don't use this anymore.
    public ItemStack getStoredItem()
    {
        return storedItem;
    }

    //TODO: Use this instead.
    protected NonNullList<ItemStack> getItems()
    {
        return this.stacks;
    }

    private void updateState()
    {
        this.markDirty();
        if (world != null)
        {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
    }

    boolean direction = false;

    @Override
    public void update()
    {
        if (world.isRemote)
            return;

        if (player == null)
        {
            player = new EntityFakePlayer((WorldServer) world);
            player.setPosition(pos.getX(), pos.getY(), pos.getZ());
        }

        /*int yawIncr = 3;

        yaw += yawIncr;
        if (yaw > 360)
            yaw -= 360;

        int pitchIncr = 10;

        if (direction)
        {
            pitch += pitchIncr;
            if (pitch > 45)
                direction = false;
        } else {
            pitch -= pitchIncr;
            if (pitch < -45)
                direction = true;
        }*/

        updateState();

        player.rotationYaw = yaw;
        player.rotationPitch = pitch;

        if (storedItem != null && storedItem.getItem() != null)
            storedItem.getItem().onUpdate(storedItem, world, player, 0, true);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        if (compound.hasKey("item"))
            storedItem = new ItemStack(compound.getCompoundTag("item"));
        else
            storedItem = null;

        if (compound.hasKey("pitch"))
            pitch = compound.getFloat("pitch");
        if (compound.hasKey("yaw"))
            yaw = compound.getFloat("yaw");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        if (storedItem != null)
        {
            NBTTagCompound item = new NBTTagCompound();
            storedItem.writeToNBT(item);
            compound.setTag("item", item);
        }

        compound.setFloat("pitch", pitch);
        compound.setFloat("yaw", yaw);

        return compound;
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound compound = new NBTTagCompound();
        writeToNBT(compound);
        return new SPacketUpdateTileEntity(getPos(), 1, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.readFromNBT(packet.getNbtCompound());
    }

    public void setStoredItem(ItemStack stack)
    {
        storedItem = stack;
        this.updateState();
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        this.fillWithLoot(playerIn);
        return new ContainerFakePlayer(playerInventory, this);
    }

    public String getGuiID()
    {
        return Reference.MOD_ID + ":fake_player";
    }

    public void setPitch(float pitch)
    {
        this.pitch = pitch;
        this.updateState();
    }

    public float getPitch()
    {
        return pitch;
    }

    public void setYaw(float yaw)
    {
        this.yaw = yaw;
        this.updateState();
    }

    public float getYaw()
    {
        return yaw;
    }

}
