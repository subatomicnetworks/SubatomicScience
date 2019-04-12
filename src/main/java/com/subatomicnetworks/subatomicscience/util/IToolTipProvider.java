package com.subatomicnetworks.subatomicscience.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IToolTipProvider
{
    void addToolTipInfo(IToolTipBuilder builder, EntityPlayer player, World world, IBlockState blockState, BlockPos pos, EnumFacing side);
}
