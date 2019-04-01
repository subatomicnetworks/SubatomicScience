package com.subatomicnetworks.subatomicscience.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class SSTabs {
    public static CreativeTabs mainTab = new CreativeTabs("subatomicscience") {

        @Override
        public ItemStack getTabIconItem() {
            // TODO: Change to something from the mod
            return new ItemStack(Items.STICK);
        }
    };
}
