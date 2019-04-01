package com.subatomicnetworks.subatomicscience.items;

import com.subatomicnetworks.subatomicscience.References;
import com.subatomicnetworks.subatomicscience.init.SSTabs;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import net.minecraft.item.Item;

public class SSItem extends Item {

    public SSItem(String name) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(SSTabs.mainTab);

        this.setRegistryName(References.PREFIX + name);

        SSRegistry.registerItem(this);
    }
}
