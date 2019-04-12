package com.subatomicnetworks.subatomicscience.blocks;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.init.SSTabs;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import com.subatomicnetworks.subatomicscience.tiles.TileFakePlayer;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockFakePlayer extends Block implements ITileEntityProvider {
    public BlockFakePlayer(String name, Material material)
    {
        super(material);

        this.setCreativeTab(SSTabs.mainTab);

        this.setTranslationKey(name);
        this.setRegistryName(Reference.PREFIX + name);
        SSRegistry.registerBlock(this);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
            return true;

        // TODO: Replace this with a GUI
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity instanceof TileFakePlayer)
        {
            TileFakePlayer tile = (TileFakePlayer) tileEntity;

            tile.setStoredItem(player.getHeldItem(hand).copy());
        }

        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isTopSolid(IBlockState state)
    {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileFakePlayer();
    }

}
