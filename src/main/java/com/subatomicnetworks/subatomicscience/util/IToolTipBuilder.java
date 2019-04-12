package com.subatomicnetworks.subatomicscience.util;

import net.minecraft.item.ItemStack;

public interface IToolTipBuilder
{
    void setDisplayItem(ItemStack itemStack);
    void addText(String text);
    void addItem(ItemStack itemStack);
}
