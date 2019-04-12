package com.subatomicnetworks.subatomicscience.compat.waila;

import com.subatomicnetworks.subatomicscience.util.IToolTipBuilder;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ToolTipBuilderWaila implements IToolTipBuilder
{
    private List<String> textLines;
    private ItemStack displayItem;

    protected ToolTipBuilderWaila()
    {
        this.textLines = new ArrayList<>();
    }

    @Nonnull
    protected ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        if (displayItem != null)
            return displayItem;
        return accessor.getStack();
    }

    @Nonnull
    protected List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Nonnull
    protected List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        currenttip.addAll(textLines);
        return currenttip;
    }

    @Nonnull
    protected List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public void setDisplayItem(ItemStack itemStack)
    {
        this.displayItem = itemStack;
    }

    @Override
    public void addText(String text)
    {
        this.textLines.add(text);
    }

    @Override
    public void addItem(ItemStack itemStack)
    {
        String displayText = "None";
        if (itemStack != null)
            displayText = itemStack.getDisplayName() + " x" + itemStack.getCount();

        this.textLines.add("Item: " + displayText);
    }

}
