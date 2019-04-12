package com.subatomicnetworks.subatomicscience.compat.theoneprobe;

import com.subatomicnetworks.subatomicscience.util.IToolTipBuilder;
import mcjty.theoneprobe.api.IProbeInfo;
import net.minecraft.item.ItemStack;

public class ToolTipBuilderTOP implements IToolTipBuilder
{
    private IProbeInfo probeInfo;

    protected ToolTipBuilderTOP(IProbeInfo probeInfo)
    {
        this.probeInfo = probeInfo;
    }

    @Override
    public void setDisplayItem(ItemStack itemStack)
    {
        // TODO: Is this even possible in The One Probe?
    }

    @Override
    public void addText(String text)
    {
        probeInfo.text(text);
    }

    @Override
    public void addItem(ItemStack itemStack)
    {
        if (itemStack == null)
        {
            probeInfo.text("No Item");
            return;
        }
        probeInfo.item(itemStack);
        probeInfo.itemLabel(itemStack);
    }

}
