package com.subatomicnetworks.subatomicscience;

import com.subatomicnetworks.subatomicscience.proxy.IProxy;
import com.subatomicnetworks.subatomicscience.util.SSLogger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class SubatomicScience {
    public static final boolean SHOW_LOG_NAME = true;
    public static SSLogger logger;

    @Instance
    public static SubatomicScience instance;

    @SidedProxy(clientSide = "com.subatomicnetworks.subatomicscience.proxy.ClientProxy", serverSide = "com.subatomicnetworks.subatomicscience.proxy.ServerProxy")
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SubatomicScience.logger = new SSLogger(event.getModLog(), SHOW_LOG_NAME);

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
