package net.lomeli.diving.tileentity;

import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;

import net.lomeli.diving.items.ItemTanks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAirCompressor extends TileEntity 
	implements ISidedInventory, IPowerReceptor
{
	public static final int[] sidedTop = new int[] { 0 };
	public static final int[] sidedOther = new int[] { 1, 2};
	
	private ItemStack[] inventory;
	
	private PowerHandler powerHandler;
	
	private int tick;
	
	public TileEntityAirCompressor()
	{
		powerHandler = new PowerHandler(this, PowerHandler.Type.MACHINE);
		initPowerProvider();
		inventory = new ItemStack[2];
	}
	
	private boolean isActive(){
		return powerHandler.getEnergyStored() > 16F;
	}
	
	@Override
    public void updateEntity()
    {
		super.updateEntity();
		if(!this.worldObj.isRemote)
		{
			if(isActive())
			{
				if(getStackInSlot(0) != null && getStackInSlot(0).getItem() instanceof ItemTanks)
				{
					if(getStackInSlot(0).getItemDamage() >= 0)
					{
						tick++;
						if(tick >= 10)
						{
							getStackInSlot(0).damageItem(-2, null);
							powerHandler.useEnergy(3F, 5F, false);
							tick = 0;
						}
					}
				}
			}
			else
				tick = 0;
		}
    }
	
	private void initPowerProvider() 
	{
		try{
			if(powerHandler != null)
			{
				powerHandler.configure(8F, 16F, 20F, 150F);
				powerHandler.configurePowerPerdition(2, 1);
			}
		}catch(Exception e){}
	}
	
	@Override
    public int getSizeInventory(){
	    return inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int i){
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
    public String getInvName(){
	    return null;
    }

	@Override
    public boolean isInvNameLocalized(){
	    return false;
    }

	@Override
    public int getInventoryStackLimit(){
	    return 64;
    }

	@Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer){
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
    public int[] getAccessibleSlotsFromSide(int var1){
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

	@Override
    public PowerReceiver getPowerReceiver(ForgeDirection side){
	    return powerHandler.getPowerReceiver();
    }

	@Override
    public void doWork(PowerHandler workProvider){}

	@Override
    public World getWorld(){
		return this.getWorldObj();
    }

}
