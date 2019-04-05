package com.subatomicnetworks.subatomicscience.init;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.blocks.PentaPistonBlock;
import com.subatomicnetworks.subatomicscience.blocks.PentaPistonExtension;
import com.subatomicnetworks.subatomicscience.blocks.PentaPistonMoving;

public class SSBlocks {

    public static PentaPistonBlock pentaPiston;
    public static PentaPistonMoving pentaPistonMoving;
    public static PentaPistonExtension pentaPistonExtension;
    public static PentaPistonBlock pentaPistonSticky;

    public static final void initBlocks() {
        SubatomicScience.logger.info("Initializing Blocks");
        pentaPiston = new PentaPistonBlock("penta_piston",false);
        pentaPistonSticky = new PentaPistonBlock("penta_piston_sticky",true);
        pentaPistonMoving = new PentaPistonMoving();
        pentaPistonExtension = new PentaPistonExtension();
    }
}
