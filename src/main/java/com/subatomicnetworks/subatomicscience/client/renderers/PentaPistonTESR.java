package com.subatomicnetworks.subatomicscience.client.renderers;

import com.subatomicnetworks.subatomicscience.tileentities.PentaPistonTileEntity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PentaPistonTESR extends TileEntitySpecialRenderer<PentaPistonTileEntity> {

    @Override
    public void render(PentaPistonTileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        net.minecraft.item.ItemStack stack = new ItemStack(Items.APPLE);

        net.minecraft.client.renderer.RenderHelper.enableStandardItemLighting();
        GlStateManager.enableLighting();

        GlStateManager.translate(.5, .5, .5);
        GlStateManager.scale(.75f, .75f, .75f);

        //Render an apple to test it
        net.minecraft.client.Minecraft.getMinecraft().getRenderItem().renderItem(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.NONE);

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }
}
