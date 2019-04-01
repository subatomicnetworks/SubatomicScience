package com.subatomicnetworks.subatomicscience.tileentities.pentapiston;

import com.subatomicnetworks.subatomicscience.blocks.SSBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class PentaPiston extends SSBlock implements ITileEntityProvider {

    public PentaPiston() {
        super("penta_piston", Material.PISTON, SoundType.STONE, 0.5f);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            if (world.isBlockIndirectlyGettingPowered(pos) > 0) {

            }
        }
    }
}
