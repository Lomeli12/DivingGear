package net.lomeli.diving.client.gui.slot;

import net.lomeli.diving.items.IAirTanks;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTank extends Slot {

    public SlotTank(IInventory par1iInventory, int par2, int par3, int par4) {
        super(par1iInventory, par2, par3, par4);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        if (itemStack.getItem() instanceof IAirTanks
                && !((IAirTanks) itemStack.getItem()).doubleTank())
            return true;
        else
            return false;
    }
}
