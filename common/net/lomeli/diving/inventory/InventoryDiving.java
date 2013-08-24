package net.lomeli.diving.inventory;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryDiving implements IInventory
{
	protected ItemStack[] inventory;
	protected int size;
	protected String uniqueID;
	
	public InventoryDiving(ItemStack stack, EntityPlayer player, int par1){
		this.size = par1;
		this.inventory = new ItemStack[this.size];
		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
			
			uniqueID = UUID.randomUUID().toString();
		}
		readFromNBT(stack.stackTagCompound);
	}
	
	public void readFromNBT(NBTTagCompound nbtTagCompound){
		NBTTagCompound contentTag = ((NBTTagCompound) nbtTagCompound.getTag("divingGearInv"));
		if(contentTag == null)
			return;
		
		if("".equals(this.uniqueID)){
			this.uniqueID = nbtTagCompound.getString("uniqueID");
			if("".equals(this.uniqueID))
				this.uniqueID = UUID.randomUUID().toString();
		}
		NBTTagList list = contentTag.getTagList("indexList");
		for(int i = 0; i < list.tagCount() && i < this.inventory.length; i++){
			NBTTagCompound indexTag = (NBTTagCompound)list.tagAt(i);
			int index = indexTag.getInteger("index");
			try{
				this.inventory[index] = ItemStack.loadItemStackFromNBT(indexTag);
			}
			catch (NullPointerException e){
				this.inventory[index] = null;
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound myCompound, String id){
		NBTTagList myList = new NBTTagList();

        for (int i = 0; i < this.inventory.length; i++){
            if (this.inventory[i] != null && this.inventory[i].stackSize > 0){
                NBTTagCompound indexTag = new NBTTagCompound();
                myList.appendTag(indexTag);
                indexTag.setInteger("index", i);
                inventory[i].writeToNBT(indexTag);
            }
        }
        NBTTagCompound contentTag = new NBTTagCompound();
        contentTag.setTag("indexList", myList);
        myCompound.setTag("divingGearInv", contentTag);
        myCompound.setString("uniqueID", id);
	}
	
	public void writeToNBT(NBTTagCompound myCompound){
        writeToNBT(myCompound, this.uniqueID);
    }
	
	@Override
    public int getSizeInventory(){
	    return this.inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int i){
	    return this.inventory[i];
    }

	@Override
    public ItemStack decrStackSize(int i, int j){
		if(this.inventory[i] == null)
			return null;
		
		ItemStack returnStack;
		
		if(this.inventory[i].stackSize > j)
			returnStack = this.inventory[i].splitStack(j);
		else{
			returnStack = this.inventory[i];
			this.inventory[i] = null;
		}
		
	    return returnStack;
    }

	@Override
    public ItemStack getStackInSlotOnClosing(int i){
	    ItemStack stack = getStackInSlot(i);
	    setInventorySlotContents(i, null);
	    return stack;
    }

	@Override
    public void setInventorySlotContents(int i, ItemStack itemStack){
	    if(0 <= i && i < size)
	    	this.inventory[i] = itemStack;
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
    public void onInventoryChanged(){
	    for(int i = 0; i < size; i++){
	    	ItemStack temp = getStackInSlot(i);
	    	if(temp != null && temp.stackSize == 0)
	    		setInventorySlotContents(i, null);
	    }
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
    public boolean isItemValidForSlot(int i, ItemStack itemStack){
		if(inventory[i] == null)
			return true;
		else if(itemStack == null)
			return false;
		else{
			if(inventory[i].getItem().equals(itemStack.getItem())){
				if((inventory[i].stackSize + itemStack.stackSize) <= inventory[i].getMaxStackSize())
					return true;
				else
					return false;
			}
			else
				return true;
		}
    }

}
