package com.subatomicnetworks.subatomicscience.init;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.blocks.SSBlock;
import com.subatomicnetworks.subatomicscience.blocks.PentaPistonBlock;

public class SSBlocks {

    public static SSBlock pentaPiston;

    public static final void initBlocks() {
        SubatomicScience.logger.info("Initializing Blocks");
        pentaPiston = new PentaPistonBlock();
    }
}
