package net.lomeli.diving.client.gui;

import org.lwjgl.opengl.GL11;

import net.lomeli.diving.inventory.ContainerAirCompressor;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAirCompressor extends GuiContainer{

	public TileEntityAirCompressor tile;
	public GuiAirCompressor(TileEntityAirCompressor inventory, InventoryPlayer playerInv) {
		super(new ContainerAirCompressor(playerInv, inventory));
		this.tile = inventory;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine
        	.func_110577_a(new ResourceLocation(ModStrings.MOD_ID.toLowerCase(), 
        		ModStrings.GUI_LOC + "diving1.png"));
		int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        if(this.tile.getStackInSlot(0) != null){
        	if(this.tile.getStackInSlot(0).getItemDamage() > 0)
        		this.drawTexturedModalRect(var5 + 80, var6 + 14, 185, 0, 12, this.tile.time);
        }
	}

}
