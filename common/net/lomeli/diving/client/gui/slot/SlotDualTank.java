package net.lomeli.diving.client.gui.slot;

import net.lomeli.diving.items.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotDualTank extends Slot
{

	public SlotDualTank(IInventory par1iInventory, int par2, int par3, int par4)
    {
	    super(par1iInventory, par2, par3, par4);
    }

	@Override
    public boolean isItemValid(ItemStack itemStack)
	{
		if(itemStack.itemID == ModItems.airTank.itemID)
			return true;
		else
			return false;
	}
}
