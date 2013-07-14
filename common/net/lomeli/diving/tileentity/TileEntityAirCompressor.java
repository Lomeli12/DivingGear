package net.lomeli.diving.tileentity;

import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerFramework;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAirCompressor extends TileEntity 
	implements ISidedInventory, IPowerReceptor
{
	public static final int[] sidedTop = new int[] { 0 };
	public static final int[] sidedOther = new int[] { 1, 2};
	
	private ItemStack[] inventory;
	
	private IPowerProvider provider;
	
	public TileEntityAirCompressor()
	{
		initPowerProvider();
		inventory = new ItemStack[2];
	}
	
	private void initPowerProvider() 
	{
		this.provider.configure(20, 8, 64, 16, 300);
	}
	
	@Override
    public int getSizeInventory()
    {
	    return inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int i)
    {
	    return inventory[i];
    }

	@Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null)
        {
            if (itemStack.stackSize <= amount)
            {
                setInventorySlotContents(slot, null);
            } else
            {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return itemStack;
    }

	@Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null)
        {
            setInventorySlotContents(slot, null);
        }
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        inventory[slot] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
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
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
	    return true;
    }

	@Override
    public void openChest(){}

	@Override
    public void closeChest(){}

	@Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
		ItemStack slotItem = this.inventory[i];
		if(slotItem == null)
			return true;
		else
		{
			if(slotItem.isItemEqual(itemstack))
				return true;
			else
				return false;
		}
    }

	@Override
    public void setPowerProvider(IPowerProvider provider)
    {
	    this.provider = provider;
    }

	@Override
    public IPowerProvider getPowerProvider()
    {
	    return this.provider;
    }

	@Override
    public void doWork()
    {}

	@Override
    public int powerRequest(ForgeDirection from)
    {
	    return 16;
    }

	@Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
		return var1 == 1 ? sidedTop : sidedOther;
    }

	@Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side)
    {
		if(side == 1)
			return this.isItemValidForSlot(0, itemstack);
		else
			return false;
    }

	@Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
	    if(j == 1)
	    	return true;
	    else
	    	return false;
    }

}
