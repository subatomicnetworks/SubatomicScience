package com.subatomicnetworks.subatomicscience.proxy;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.compat.CompatHandler;
import com.subatomicnetworks.subatomicscience.init.SSBlocks;
import com.subatomicnetworks.subatomicscience.init.SSItems;
import com.subatomicnetworks.subatomicscience.init.SSTiles;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        SubatomicScience.logger.info("Pre-Initializing Proxy");

        SSBlocks.initBlocks();
        SSItems.initItems();
        SSTiles.initTiles();

        CompatHandler.registerCompat();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        SubatomicScience.logger.info("Initializing Proxy");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        SubatomicScience.logger.info("Post-Initializing Proxy");
    }
}
