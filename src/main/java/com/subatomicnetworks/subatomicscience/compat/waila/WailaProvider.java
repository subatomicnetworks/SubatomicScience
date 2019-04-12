package com.subatomicnetworks.subatomicscience.compat.waila;

import com.subatomicnetworks.subatomicscience.registry.SSRegistry;
import com.subatomicnetworks.subatomicscience.util.IToolTipProvider;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class WailaProvider
{
    public static void register(IWailaRegistrar registry)
    {
        GenericWailaProvider gwpInstance = new GenericWailaProvider();

        for (int i = 0; i < SSRegistry.getBlockList().size(); i++)
        {
            Block block = SSRegistry.getBlockList().get(i).getBlock();
            if (block instanceof IToolTipProvider)
            {
                registry.registerStackProvider(gwpInstance, block.getClass());
                registry.registerHeadProvider(gwpInstance, block.getClass());
                registry.registerBodyProvider(gwpInstance, block.getClass());
                registry.registerTailProvider(gwpInstance, block.getClass());
            }
        }
    }

    public static class GenericWailaProvider implements IWailaDataProvider
    {

        @Nonnull
        @Override
        public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
        {
            Block block = accessor.getBlock();
            if (block instanceof IToolTipProvider)
            {
                IToolTipProvider provider = (IToolTipProvider) block;
                ToolTipBuilderWaila builder = new ToolTipBuilderWaila();
                provider.addToolTipInfo(builder, accessor.getPlayer(), accessor.getWorld(), accessor.getBlockState(), accessor.getPosition(), accessor.getSide());
                return builder.getWailaStack(accessor, config);
            }
            return accessor.getStack();
        }

        @Nonnull
        @Override
        public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
        {
            Block block = accessor.getBlock();
            if (block instanceof IToolTipProvider)
            {
                IToolTipProvider provider = (IToolTipProvider) block;
                ToolTipBuilderWaila builder = new ToolTipBuilderWaila();
                provider.addToolTipInfo(builder, accessor.getPlayer(), accessor.getWorld(), accessor.getBlockState(), accessor.getPosition(), accessor.getSide());
                return builder.getWailaHead(itemStack, currenttip, accessor, config);
            }
            return currenttip;
        }

        @Nonnull
        @Override
        public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
        {
            Block block = accessor.getBlock();
            if (block instanceof IToolTipProvider)
            {
                IToolTipProvider provider = (IToolTipProvider) block;
                ToolTipBuilderWaila builder = new ToolTipBuilderWaila();
                provider.addToolTipInfo(builder, accessor.getPlayer(), accessor.getWorld(), accessor.getBlockState(), accessor.getPosition(), accessor.getSide());
                return builder.getWailaBody(itemStack, currenttip, accessor, config);
            }
            return currenttip;
        }

        @Nonnull
        @Override
        public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
        {
            Block block = accessor.getBlock();
            if (block instanceof IToolTipProvider)
            {
                IToolTipProvider provider = (IToolTipProvider) block;
                ToolTipBuilderWaila builder = new ToolTipBuilderWaila();
                provider.addToolTipInfo(builder, accessor.getPlayer(), accessor.getWorld(), accessor.getBlockState(), accessor.getPosition(), accessor.getSide());
                return builder.getWailaTail(itemStack, currenttip, accessor, config);
            }
            return currenttip;
        }

    }
}
