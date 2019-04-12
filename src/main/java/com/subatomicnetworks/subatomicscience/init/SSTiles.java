package com.subatomicnetworks.subatomicscience.init;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.tiles.TilePentaPiston;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SSTiles {

    public static void initTiles()
    {
        GameRegistry.registerTileEntity(TilePentaPiston.class, new ResourceLocation(Reference.PREFIX + "penta_piston"));
    }
}
