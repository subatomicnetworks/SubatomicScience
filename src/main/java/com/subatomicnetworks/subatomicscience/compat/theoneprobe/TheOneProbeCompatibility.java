package com.subatomicnetworks.subatomicscience.compat.theoneprobe;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.util.IToolTipProvider;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;

import javax.annotation.Nullable;
import java.util.function.Function;

public class TheOneProbeCompatibility
{
    private static boolean registered;

    public static void register()
    {
        if (registered)
            return;

        registered = true;

        FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "com.subatomicnetworks.subatomicscience.compat.theoneprobe.TheOneProbeCompatibility$GetTheOneProbe");
    }

    public static class GetTheOneProbe implements Function<ITheOneProbe, Void>
    {
        public static ITheOneProbe probe;

        @Nullable
        @Override
        public Void apply(ITheOneProbe probe)
        {
            this.probe = probe;

            this.probe.registerProvider(new IProbeInfoProvider()
            {
                @Override
                public String getID()
                {
                    return Reference.PREFIX + "default";
                }

                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data)
                {
                    if (blockState.getBlock() instanceof IToolTipProvider)
                    {
                        IToolTipProvider provider = (IToolTipProvider) blockState.getBlock();
                        provider.addToolTipInfo(new ToolTipBuilderTOP(probeInfo), player, world, blockState, data.getPos(), data.getSideHit());
                    }
                }
            });

            return null;
        }

    }
}
