package net.lomeli.diving.inventory;

import net.lomeli.diving.client.gui.slot.SlotDualTank;
import net.lomeli.diving.client.gui.slot.SlotTank;
import net.lomeli.diving.items.IAirTanks;
import net.lomeli.diving.items.gear.IGear;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDiving extends Container{
	public InventoryDiving helmInventory;
	public boolean updateNotification;
	public int type;
	
	public ContainerDiving(ItemStack stack, InventoryDiving inventory, InventoryPlayer playerInv){
		this.helmInventory = inventory;
		this.updateNotification = false;
		if(stack.getItem() instanceof IGear){
			type = ((IGear)stack.getItem()).getGearType();
			if(type <= 0)
				this.addSlotToContainer(new SlotTank(this.helmInventory, 0, 79, 53));
			else if(type == 1){
				this.addSlotToContainer(new SlotTank(this.helmInventory, 0, 79, 53));
				this.addSlotToContainer(new SlotTank(this.helmInventory, 1, 56, 46));
				this.addSlotToContainer(new SlotTank(this.helmInventory, 2, 102, 46));
			}
			else if(type == 2){
				this.addSlotToContainer(new SlotDualTank(this.helmInventory, 0, 79, 53));
				this.addSlotToContainer(new SlotDualTank(this.helmInventory, 1, 56, 46));
				this.addSlotToContainer(new SlotDualTank(this.helmInventory, 2, 102, 46));
			}
		}
		
		for(int l = 0; l < 3; ++l){
        	for(int i1 = 0; i1 < 9; ++i1){
        		this.addSlotToContainer(new Slot(playerInv, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
        	}
        }

        for(int j1 = 0; j1 < 9; j1++){
        	this.addSlotToContainer(new Slot(playerInv, j1, 8 + j1 * 18, 142));
        }
	}
	
	@Override
	public ItemStack slotClick(int slotID, int buttonPressed, int flag, EntityPlayer player){
		Slot tmpSlot;
		if (slotID >= 0 && slotID < inventorySlots.size())
			tmpSlot = (Slot) inventorySlots.get(slotID);
		else
			tmpSlot = null;
		
		if (tmpSlot != null && tmpSlot.isSlotInInventory(player.inventory, player.inventory.currentItem))
			return tmpSlot.getStack();
		
		updateNotification = true;
		return super.slotClick(slotID, buttonPressed, flag, player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if(!(itemstack.getItem() instanceof IAirTanks))
            	return null;
            else if(this.type < 2 && (((IAirTanks)itemstack.getItem()).doubleTank()))
            	return null;
            
            if (par2 < 9)
            {
                if (!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true))
                    return null;
            }
            else if (!this.mergeItemStack(itemstack1, 0, 9, false))
                return null;

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack)null);
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
