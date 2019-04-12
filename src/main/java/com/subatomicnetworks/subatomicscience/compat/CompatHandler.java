package com.subatomicnetworks.subatomicscience.compat;

import com.subatomicnetworks.subatomicscience.compat.theoneprobe.TheOneProbeCompatibility;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public final class CompatHandler
{
    public static void registerCompat()
    {
        registerTheOneProbe();
        registerWaila();
    }

    private static void registerTheOneProbe()
    {
        if (Loader.isModLoaded("theoneprobe"))
        {
            TheOneProbeCompatibility.register();
        }
    }

    private static void registerWaila()
    {
        if (Loader.isModLoaded("waila"))
        {
            FMLInterModComms.sendMessage("waila", "register", "com.subatomicnetworks.subatomicscience.compat.waila.WailaProvider.register");
        }
    }
}
