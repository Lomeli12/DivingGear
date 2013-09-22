package net.lomeli.diving.client.gui;

import org.lwjgl.opengl.GL11;

import net.lomeli.diving.inventory.ContainerDiving;
import net.lomeli.diving.inventory.InventoryDiving;
import net.lomeli.diving.lib.ModStrings;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiScuba extends GuiContainer {

    public InventoryDiving adsInventory;
    public InventoryPlayer playerI;

    public GuiScuba(InventoryDiving inventory, InventoryPlayer playerInv) {
        super(new ContainerDiving(playerInv.getCurrentItem(), inventory,
                playerInv));
        this.adsInventory = inventory;
        this.playerI = playerInv;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(ModStrings.MOD_ID
                .toLowerCase(), ModStrings.GUI_LOC + "diving2.png"));
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        if (this.adsInventory.getStackInSlot(0) != null) {
            int l = (this.adsInventory.getStackInSlot(0).getMaxDamage() - this.adsInventory
                    .getStackInSlot(0).getItemDamage());
            this.drawTexturedModalRect(var5 + 80, var6 + 14, 185, 0, 12, 29 * l);
        }
    }

}
