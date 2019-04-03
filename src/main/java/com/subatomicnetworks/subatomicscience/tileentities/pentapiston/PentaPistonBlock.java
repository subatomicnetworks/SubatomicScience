package com.subatomicnetworks.subatomicscience.tileentities.pentapiston;

import com.subatomicnetworks.subatomicscience.blocks.SSBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class PentaPistonBlock extends SSBlock implements ITileEntityProvider {

    public PentaPistonBlock() {
        super("penta_piston", Material.PISTON, SoundType.STONE, 0.5f);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return tileEntity();
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            if (world.isBlockIndirectlyGettingPowered(pos) > 0) {

            }
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        //If blockState says piston is extended return false. Or else return true.
        return false;
    }

    @Override
    public TileEntity tileEntity(){
        return new PentaPistonTileEntity();
    }

    @Override
    public TileEntitySpecialRenderer specialRenderer(){
        return new PentaPistonTESR();
    }
}
