package com.subatomicnetworks.subatomicscience.proxy;

import com.subatomicnetworks.subatomicscience.client.renderers.tiles.RenderPentaPiston;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import com.subatomicnetworks.subatomicscience.tiles.TilePentaPiston;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        ClientRegistry.bindTileEntitySpecialRenderer(TilePentaPiston.class, new RenderPentaPiston());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        this.registerItemModels();
    }

    public void registerItemModels() {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

        for (SSRegistry.BlockContainer blockContainer : SSRegistry.getBlockList()) {
            Block block = blockContainer.getBlock();
            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }

        for (Item item : SSRegistry.getItemList()) {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
