package com.subatomicnetworks.subatomicscience.proxy;

import com.subatomicnetworks.subatomicscience.blocks.SSBlock;
import com.subatomicnetworks.subatomicscience.blocks.SSBlockContainer;
import com.subatomicnetworks.subatomicscience.blocks.SSBlockDirectional;
import com.subatomicnetworks.subatomicscience.init.SSBlocks;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import com.subatomicnetworks.subatomicscience.tileentities.PentaPistonTileEntity;
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
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        //This is nasty
        GameRegistry.registerTileEntity(PentaPistonTileEntity.class, SSBlocks.pentaPiston.getRegistryName());
        //GameRegistry.registerTileEntity(PentaPistonTileEntity.class, SSBlocks.pentaPistonSticky.getRegistryName());
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
            if(block instanceof SSBlock && ((SSBlock)block).specialRenderer()!=null){
                ClientRegistry.bindTileEntitySpecialRenderer(((SSBlock)block).tileEntity().getClass(), ((SSBlock)block).specialRenderer());
            } else if(block instanceof SSBlockContainer && ((SSBlockContainer)block).specialRenderer()!=null){
                ClientRegistry.bindTileEntitySpecialRenderer(((SSBlockContainer)block).tileEntity().getClass(), ((SSBlockContainer)block).specialRenderer());
            } else if(block instanceof SSBlockDirectional && ((SSBlockDirectional)block).specialRenderer()!=null){
                ClientRegistry.bindTileEntitySpecialRenderer(((SSBlockDirectional)block).tileEntity().getClass(), ((SSBlockDirectional)block).specialRenderer());
            } else {
                ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
                ModelLoader.registerItemVariants(item, model);
                mesher.register(item, 0, model);
            }
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
