package com.subatomicnetworks.subatomicscience.init;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.events.RegistryEventHandler;
import net.minecraftforge.common.MinecraftForge;

public final class SSEvents {

    public static void initEvents() {
        SubatomicScience.logger.info("Initializing Events");
        MinecraftForge.EVENT_BUS.register(new RegistryEventHandler());
    }
}
