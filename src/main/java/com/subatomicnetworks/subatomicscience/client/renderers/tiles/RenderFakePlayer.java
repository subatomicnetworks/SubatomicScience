package com.subatomicnetworks.subatomicscience.client.renderers.tiles;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.tiles.TileFakePlayer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_GREATER;

@SideOnly(Side.CLIENT)
public class RenderFakePlayer extends TileEntitySpecialRenderer<TileFakePlayer>
{
    private static ResourceLocation HEAD_TEX = new ResourceLocation(Reference.MOD_ID, "textures/blocks/fakeplayer_head.png");

    @Override
    public void render(TileFakePlayer te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        GlStateManager.translate(0.5D, 0.5D, 0.5D);
        GlStateManager.rotate(te.getYaw(), 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(te.getPitch(), 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(-0.25D, -0.25D, -0.25D);
        renderHead();

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    private void renderHead()
    {
        this.bindTexture(HEAD_TEX);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(GL_GREATER, 0.1F);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();

        this.renderCube(0.0D, 0.0D, 0.0D, 0.5D);

        GlStateManager.cullFace(GlStateManager.CullFace.BACK);
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }

    private void renderCube(double x, double y, double z, double size)
    {
        GlStateManager.pushMatrix();

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 1, 0, EnumFacing.NORTH);
        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 1, 1, EnumFacing.SOUTH);
        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 0, 0, EnumFacing.EAST);
        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 2, 0, EnumFacing.WEST);
        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 2, 1, EnumFacing.UP);
        this.renderQuad(bufferBuilder, x, y, z, size, size, size, 0, 1, EnumFacing.DOWN);

        tessellator.draw();

        GlStateManager.popMatrix();
    }

    private void renderQuad(BufferBuilder renderer, double x, double y, double z, double xSize, double ySize, double zSize, int texX, int texY, EnumFacing facing)
    {
        double minX = x;
        double maxX = x + xSize;
        double minY = y;
        double maxY = y + ySize;
        double minZ = z;
        double maxZ = z + zSize;

        double texSizeX = 48;
        double texSizeY = 32;

        double gridSize = 16;
        double gridX = texX * gridSize;
        double gridY = texY * gridSize;

        double sizeU = gridSize / texSizeX;
        double sizeV = gridSize / texSizeY;

        double minU = gridX / texSizeX;
        double maxU = minU + sizeU;
        double minV = gridY / texSizeY;
        double maxV = minV + sizeV;

        switch (facing)
        {
            case NORTH:
                renderer.pos(minX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                renderer.pos(minX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                break;
            case SOUTH:
                renderer.pos(minX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(minX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                break;
            case EAST:
                renderer.pos(minX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(minX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                renderer.pos(minX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                renderer.pos(minX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                break;
            case WEST:
                renderer.pos(maxX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                break;
            case UP:
                renderer.pos(minX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                renderer.pos(minX, maxY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                break;
            case DOWN:
                renderer.pos(minX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, minY, minZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, minV).lightmap(240, 0).endVertex();
                renderer.pos(maxX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(maxU, maxV).lightmap(240, 0).endVertex();
                renderer.pos(minX, minY, maxZ).color(0xFF, 0xFF, 0xFF, 0xFF).tex(minU, maxV).lightmap(240, 0).endVertex();
                break;
        }
    }
}
