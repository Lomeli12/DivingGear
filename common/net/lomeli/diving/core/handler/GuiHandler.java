package net.lomeli.diving.core.handler;

import net.lomeli.diving.client.gui.GuiADS;
import net.lomeli.diving.client.gui.GuiAirCompressor;
import net.lomeli.diving.client.gui.GuiScuba;
import net.lomeli.diving.inventory.ContainerAirCompressor;
import net.lomeli.diving.inventory.ContainerDiving;
import net.lomeli.diving.inventory.InventoryDiving;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (ID == 1) {
            InventoryDiving inventory = new InventoryDiving(
                    player.inventory.getCurrentItem(), player, 1);
            return new ContainerDiving(player.inventory.getCurrentItem(),
                    inventory, player.inventory);
        } else if (ID == 2 || ID == 3) {
            InventoryDiving inventory = new InventoryDiving(
                    player.inventory.getCurrentItem(), player, 3);
            return new ContainerDiving(player.inventory.getCurrentItem(),
                    inventory, player.inventory);
        } else if (tile instanceof TileEntityAirCompressor) {
            return new ContainerAirCompressor(player.inventory,
                    (TileEntityAirCompressor) tile);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tile = world.getBlockTileEntity(x, y, z);
        if (ID == 1) {
            InventoryDiving inventory = new InventoryDiving(
                    player.inventory.getCurrentItem(), player, 1);
            return new GuiADS(inventory, player.inventory);
        } else if (ID == 2 || ID == 3) {
            InventoryDiving inventory = new InventoryDiving(
                    player.inventory.getCurrentItem(), player, 3);
            return new GuiScuba(inventory, player.inventory);
        } else if (tile instanceof TileEntityAirCompressor) {
            return new GuiAirCompressor((TileEntityAirCompressor) tile,
                    player.inventory);
        }
        return null;
    }

}
