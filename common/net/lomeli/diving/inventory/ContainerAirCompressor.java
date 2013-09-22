package net.lomeli.diving.inventory;

import net.lomeli.diving.client.gui.slot.SlotDualTank;
import net.lomeli.diving.items.IAirTanks;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAirCompressor extends Container {

    public TileEntityAirCompressor tile;

    public ContainerAirCompressor(InventoryPlayer inventoryPlayer,
            TileEntityAirCompressor tileE) {
        this.tile = tileE;

        this.addSlotToContainer(new SlotDualTank(this.tile, 0, 79, 53));

        for (int l = 0; l < 3; ++l) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i1 + l * 9
                        + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, j1, 8 + j1 * 18,
                    142));
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (!(itemstack.getItem() instanceof IAirTanks))
                return null;

            if (par2 < 9) {
                if (!this.mergeItemStack(itemstack1, 9, 0, true))
                    return null;
            } else if (!this.mergeItemStack(itemstack1, 0, 9, false))
                return null;

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }

}
