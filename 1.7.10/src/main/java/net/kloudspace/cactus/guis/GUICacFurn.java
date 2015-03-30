package net.kloudspace.cactus.guis;

import net.kloudspace.cactus.block.containers.ContainerFurnace;
import net.kloudspace.cactus.block.containers.ContainerHalf;
import net.kloudspace.cactus.entity.HalfFurnace;
import net.kloudspace.cactus.entity.TileEntityCactusFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GUICacFurn  extends GuiContainer{
	public static final ResourceLocation texture = new ResourceLocation("textures/gui/container/furnace.png");
	
	public TileEntityCactusFurnace tileFurnace;
	public HalfFurnace tileFurnace2;
	//GuiFurnace
    public GUICacFurn(InventoryPlayer p_i1091_1_, TileEntityCactusFurnace p_i1091_2_)
    {
        super(new ContainerFurnace(p_i1091_1_, p_i1091_2_));
        this.tileFurnace = p_i1091_2_;
    }
    public GUICacFurn(InventoryPlayer inventory, HalfFurnace entity) {
    	super(new ContainerHalf(inventory, entity));
    	this.tileFurnace2 = entity;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
    	if(tileFurnace != null) {
    		String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
    		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
    		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    	}
    	if(tileFurnace2 !=null) {
    		String s = this.tileFurnace2.hasCustomInventoryName() ? this.tileFurnace2.getInventoryName() : I18n.format(this.tileFurnace2.getInventoryName(), new Object[0]);
            this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
            this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    	}
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if(this.tileFurnace != null) {
        	if (this.tileFurnace.isBurning()) {
        		int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
        		this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        		i1 = this.tileFurnace.getCookProgressScaled(24);
        		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        	}
        }
        if(this.tileFurnace2 != null) {
        	if(this.tileFurnace2.isBurning()) {
        		int i1 = this.tileFurnace2.getBurnTimeRemainingScaled(13);
        		this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
        		i1 = this.tileFurnace2.getCookProgressScaled(24);
        		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        	}
        }
    }
}