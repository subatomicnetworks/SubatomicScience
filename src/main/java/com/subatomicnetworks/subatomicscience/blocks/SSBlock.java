package com.subatomicnetworks.subatomicscience.blocks;

import com.subatomicnetworks.subatomicscience.References;
import com.subatomicnetworks.subatomicscience.init.SSTabs;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class SSBlock extends Block{

    public SSBlock(String name, Material material, SoundType sound, float hardness, float resistance, String toolName, int toolLevel) {
        super(material);

        this.setSoundType(sound);
        this.setResistance(resistance);
        this.setHardness(hardness);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SSTabs.mainTab);
        this.setHarvestLevel(toolName, toolLevel);

        this.setRegistryName(References.PREFIX + name);

        SSRegistry.registerBlock(this);
    }

    public SSBlock(String name, Material material, SoundType sound, float hardness) {
        super(material);

        this.setSoundType(sound);
        this.setHardness(hardness);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SSTabs.mainTab);

        this.setRegistryName(References.PREFIX + name);

        SSRegistry.registerBlock(this);
    }
}
