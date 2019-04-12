package com.subatomicnetworks.subatomicscience.items;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.init.SSTabs;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import net.minecraft.item.Item;

public class GenericItem extends Item {

    public GenericItem(String name) {
        this.setTranslationKey(name);
        this.setCreativeTab(SSTabs.mainTab);

        this.setRegistryName(Reference.PREFIX + name);

        SSRegistry.registerItem(this);
    }
}
