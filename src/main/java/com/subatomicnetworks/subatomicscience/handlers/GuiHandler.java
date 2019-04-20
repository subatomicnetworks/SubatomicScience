package com.subatomicnetworks.subatomicscience.handlers;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.containers.ContainerFakePlayer;
import com.subatomicnetworks.subatomicscience.guis.GuiFakePlayer;
import com.subatomicnetworks.subatomicscience.tiles.TileFakePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FAKE_PLAYER) return new ContainerFakePlayer(player.inventory, (TileFakePlayer)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FAKE_PLAYER) return new GuiFakePlayer(player.inventory, (TileFakePlayer)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}