package net.lomeli.diving.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryDiving implements IInventory
{
	protected ItemStack[] inventory;
	protected int size;
	
	public InventoryDiving(int par1)
	{
		this.size = par1;
		this.inventory = new ItemStack[this.size];
	}
	
	@Override
    public int getSizeInventory()
    {
	    return this.inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int i)
    {
	    return this.inventory[i];
    }

	@Override
    public ItemStack decrStackSize(int i, int j)
    {
		if(this.inventory[i] == null)
			return null;
		
		ItemStack returnStack;
		
		if(this.inventory[i].stackSize > j)
			returnStack = this.inventory[i].splitStack(j);
		else
		{
			returnStack = this.inventory[i];
			this.inventory[i] = null;
		}
		
	    return returnStack;
    }

	@Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
	    ItemStack stack = getStackInSlot(i);
	    setInventorySlotContents(i, null);
	    return stack;
    }

	@Override
    public void setInventorySlotContents(int i, ItemStack itemStack)
    {
	    if(0 <= i && i < size)
	    	this.inventory[i] = itemStack;
	    
    }

	@Override
    public String getInvName()
    {
	    return null;
    }

	@Override
    public boolean isInvNameLocalized()
    {
	    return false;
    }

	@Override
    public int getInventoryStackLimit()
    {
	    return 64;
    }

	@Override
    public void onInventoryChanged()
    {
	    for(int i = 0; i < size; i++)
	    {
	    	ItemStack temp = getStackInSlot(i);
	    	if(temp != null && temp.stackSize == 0)
	    		setInventorySlotContents(i, null);
	    }
    }

	@Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
	    return true;
    }

	@Override
    public void openChest()
    {}

	@Override
    public void closeChest()
    {}

	@Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
	    return true;
    }

}
