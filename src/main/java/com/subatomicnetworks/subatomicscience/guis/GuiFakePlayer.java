package com.subatomicnetworks.subatomicscience.guis;

import com.subatomicnetworks.subatomicscience.Reference;
import com.subatomicnetworks.subatomicscience.containers.ContainerFakePlayer;
import com.subatomicnetworks.subatomicscience.tiles.TileFakePlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiFakePlayer extends GuiContainer {

    private static final ResourceLocation GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/gui/fake_player.png");
    private final InventoryPlayer playerInventory;
    public IInventory fakePlayerInventory;
    private final int BUTTON_CLICK_MODE = 0;
    private final int BUTTON_SLIDER_1 = 1;
    private final int BUTTON_SLIDER_2 = 2;

    boolean slider1 = false;
    boolean slider2 = false;
    int slotx = 44;
    int sloty = 17;

    public GuiFakePlayer(InventoryPlayer playerInv, IInventory fakePlayerInv){
        super(new ContainerFakePlayer(playerInv, fakePlayerInv));
        this.playerInventory = playerInv;
        this.fakePlayerInventory = fakePlayerInv;
    }

    @Override
    public void initGui(){
        super.initGui();
        int x = (this.width  - 176)/2;
        int y = (this.height - 166)/2;
        this.buttonList.add(new GuiButton(BUTTON_CLICK_MODE, x+121, y+20,20,20,""));
        this.buttonList.add(new GuiButton(BUTTON_SLIDER_1, x+12+Math.round(((TileFakePlayer)fakePlayerInventory).yaw), y+4,8,20,""));
        this.buttonList.add(new GuiButton(BUTTON_SLIDER_2, x+12+Math.round(((TileFakePlayer)fakePlayerInventory).pitch), y+62,8,20,""));

        TileEntity tileEntity = playerInventory.player.world.getTileEntity(((TileFakePlayer) fakePlayerInventory).getPos());

        System.out.println(((TileFakePlayer)tileEntity).getSelectedSlot());

        if (tileEntity instanceof TileFakePlayer)
        {
            for(int i=0; i<((TileFakePlayer)tileEntity).getSelectedSlot();i++){
                slotx+=18;
                if(i==4||i==7){
                    slotx=62;
                }
            }
            if(((TileFakePlayer)fakePlayerInventory).selectedSlot>3){
                sloty+=18;
                if(((TileFakePlayer)fakePlayerInventory).selectedSlot>6){
                    sloty+=18;
                }
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        mc.getTextureManager().bindTexture(GUI_TEXTURES);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);

        int x = (this.width  - 176)/2;
        int y = (this.height - 166)/2;

        //don't mess with zlevel just render this the same way drawTexturedModalRect does
        this.zLevel=100;
        this.drawTexturedModalRect(x+80, y+35, 88, 188, 22, 22);
        this.drawTexturedModalRect(x+slotx, y+sloty, 110, 188, 16, 16);
        this.zLevel=0;

        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int button, long timeSinceLastClick)
    {
        super.mouseClickMove(mouseX,mouseY,button,timeSinceLastClick);
        int x = (this.width  - 176)/2;
        if (mouseX>15+x&&mouseX<50+x) {
            if(slider1){
                this.buttonList.get(BUTTON_SLIDER_1).x=mouseX-(this.buttonList.get(BUTTON_SLIDER_1).width/2);
                ((TileFakePlayer)fakePlayerInventory).setYaw(mouseX-(this.buttonList.get(BUTTON_SLIDER_2).width/2));
            }
            if(slider2){
                this.buttonList.get(BUTTON_SLIDER_2).x=mouseX-(this.buttonList.get(BUTTON_SLIDER_2).width/2);
                ((TileFakePlayer)fakePlayerInventory).setPitch(mouseX-(this.buttonList.get(BUTTON_SLIDER_2).width/2));
            }
        }
    }

    @Override
    protected  void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type){
        try{
            super.handleMouseClick(slotIn,slotId,mouseButton,type);
        }catch (Exception e){
            e.printStackTrace();
        }

        TileEntity tileEntity = playerInventory.player.world.getTileEntity(((TileEntity) fakePlayerInventory).getPos());

        if (tileEntity instanceof TileFakePlayer)
        {
            if(mouseButton==2&&slotId<9){
                ((TileFakePlayer)tileEntity).setSelectedSlot(slotId+1);
                System.out.println(((TileFakePlayer)tileEntity).getSelectedSlot());
                slotx=slotIn.xPos;
                sloty=slotIn.yPos;
            }
        }
    }

    @Override
    public void actionPerformed(GuiButton button){
        //super.actionPerformed(button);
        switch(button.id){
            case BUTTON_CLICK_MODE:
                System.out.println("PUSHED!");
                break;
            case BUTTON_SLIDER_1:
                slider1 = true;
                slider2 = false;
                break;
            case BUTTON_SLIDER_2:
                slider2 = true;
                slider1 = false;
                break;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.fakePlayerInventory.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
