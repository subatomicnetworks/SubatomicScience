package com.subatomicnetworks.subatomicscience.tileentities.pentapiston;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class PentaPistonTileEntity extends TileEntity {//extends TileEntityPiston {

    private IBlockState pistonState;
    private EnumFacing pistonFacing;

    /*public PentaPistonTileEntity(IBlockState pistonStateIn, EnumFacing pistonFacingIn)
    {
        this.pistonState = pistonStateIn;
        this.pistonFacing = pistonFacingIn;
    }*/

    public IBlockState getPistonState()
    {
        return this.pistonState;
    }

    public EnumFacing getFacing()
    {
        return this.pistonFacing;
    }
}
