package com.subatomicnetworks.subatomicscience.registry;

import com.subatomicnetworks.subatomicscience.References;
import com.subatomicnetworks.subatomicscience.blocks.PentaPistonBlock;
import com.subatomicnetworks.subatomicscience.blocks.SSBlock;
import com.subatomicnetworks.subatomicscience.tileentities.PentaPistonTileEntity;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class SSRegistry {

    private static List<BlockContainer> blocks = new ArrayList<BlockContainer>();
    private static List<Item> items = new ArrayList<Item>();

    public static void registerBlock(BlockContainer blockContainer) {
        SSRegistry.blocks.add(blockContainer);
    }

    public static void registerBlock(Block block, ItemBlock item) {
        SSRegistry.registerBlock(new BlockContainer(block, item));
    }

    public static void registerBlock(Block block) {
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(item.getBlock().getRegistryName());
        SSRegistry.registerBlock(new BlockContainer(block, item));
        //TODO: Maybe register SSTileEntities
    }

    public static void registerItem(Item item) {
        SSRegistry.items.add(item);
    }

    public static List<BlockContainer> getBlockList() {
        return SSRegistry.blocks;
    }

    public static List<Item> getItemList() {
        return SSRegistry.items;
    }

    public static class BlockContainer {
        private Block block;
        private ItemBlock item;

        public BlockContainer(Block block, ItemBlock item) {
            this.block = block;
            this.item = item;
        }

        public Block getBlock() {
            return this.block;
        }

        public ItemBlock getItem() {
            return this.item;
        }
    }
}
