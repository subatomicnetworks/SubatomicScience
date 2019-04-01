package com.subatomicnetworks.subatomicscience.events;

import com.subatomicnetworks.subatomicscience.SubatomicScience;
import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryEventHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        SubatomicScience.logger.info("Registering Blocks!");

        for (SSRegistry.BlockContainer blockContainer : SSRegistry.getBlockList()) {
            Block block = blockContainer.getBlock();
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        SubatomicScience.logger.info("Registering Items!");

        for (SSRegistry.BlockContainer blockContainer : SSRegistry.getBlockList()) {
            ItemBlock item = blockContainer.getItem();
            event.getRegistry().register(item);
        }

        for (Item item : SSRegistry.getItemList()) {
            event.getRegistry().register(item);
        }
    }

}