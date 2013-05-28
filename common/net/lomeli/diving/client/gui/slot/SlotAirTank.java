package net.lomeli.diving.client.gui.slot;

import net.lomeli.diving.item.ItemAirTank;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAirTank extends Slot
{

	public SlotAirTank(IInventory par1iInventory, int par2, int par3, int par4)
    {
	    super(par1iInventory, par2, par3, par4);
    }

	public boolean isItemValid(ItemStack itemStack)
	{
		return (itemStack == null) || (!(itemStack.getItem() instanceof ItemAirTank));
	}
}
