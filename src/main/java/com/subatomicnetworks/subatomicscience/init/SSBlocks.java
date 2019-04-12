package com.subatomicnetworks.subatomicscience.init;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.blocks.BlockPentaPistonBase;
import com.subatomicnetworks.subatomicscience.blocks.BlockPentaPistonExtension;
import com.subatomicnetworks.subatomicscience.blocks.BlockPentaPistonMoving;

public class SSBlocks {

    public static BlockPentaPistonBase pentaPiston;
    public static BlockPentaPistonMoving pentaPistonMoving;
    public static BlockPentaPistonExtension pentaPistonExtension;
    public static BlockPentaPistonBase pentaPistonSticky;

    public static final void initBlocks() {
        SubatomicScience.logger.info("Initializing Blocks");

        pentaPiston = new BlockPentaPistonBase("penta_piston",false);
        pentaPistonSticky = new BlockPentaPistonBase("penta_piston_sticky",true);
        pentaPistonMoving = new BlockPentaPistonMoving("penta_piston_moving");
        pentaPistonExtension = new BlockPentaPistonExtension("penta_piston_extension");
    }
}
