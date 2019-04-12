package com.subatomicnetworks.subatomicscience.blocks;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.init.SSTabs;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block{

    public GenericBlock(String name, boolean registerItem, Material material, SoundType sound, float hardness, float resistance, String toolName, int toolLevel) {
        super(material);

        this.setSoundType(sound);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setTranslationKey(name);
        this.setCreativeTab(SSTabs.mainTab);
        this.setHarvestLevel(toolName, toolLevel);

        this.setRegistryName(Reference.PREFIX + name);

        SSRegistry.registerBlock(this,registerItem);
    }

    public GenericBlock(String name, boolean registerItem, Material material, SoundType sound, float hardness) {
        super(material);

        this.setSoundType(sound);
        this.setHardness(hardness);
        this.setTranslationKey(name);
        this.setCreativeTab(SSTabs.mainTab);

        this.setRegistryName(Reference.PREFIX + name);

        SSRegistry.registerBlock(this,registerItem);
    }
}
