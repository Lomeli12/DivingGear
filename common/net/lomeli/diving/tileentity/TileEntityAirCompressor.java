package net.lomeli.diving.tileentity;

import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;

import net.lomeli.diving.items.IAirTanks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAirCompressor extends TileEntity implements
        ISidedInventory, IPowerReceptor {
    public static final int[] sidedTop = new int[] { 0 };
    public static final int[] sidedOther = new int[] { 1, 2 };

    private ItemStack[] inventory;

    private PowerHandler powerHandler;

    private int tick;

    public TileEntityAirCompressor() {
        powerHandler = new PowerHandler(this, PowerHandler.Type.MACHINE);
        initPowerProvider();
        inventory = new ItemStack[1];
    }

    public boolean isActive() {
        return powerHandler.getEnergyStored() > 16F;
    }

    public void repairItem(int slot, int repair) {
        getStackInSlot(slot).setItemDamage(
                getStackInSlot(slot).getItemDamage() - repair);
        powerHandler.useEnergy(3F, 5F, false);
    }

    public int time;

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            if (isActive()) {
                if (getStackInSlot(0) != null
                        && getStackInSlot(0).getItem() instanceof IAirTanks) {
                    if (getStackInSlot(0).getItemDamage() >= 0) {
                        tick++;
                        time += 3;
                        if (tick >= 10) {
                            repairItem(0, 1);
                            tick = 0;
                            time = 0;
                        }
                    }
                }
            } else {
                tick = 0;
                time = 0;
            }
        }
    }

    private void initPowerProvider() {
        if (powerHandler != null) {
            powerHandler.configure(8F, 16F, 20F, 150F);
            powerHandler.configurePowerPerdition(2, 1);
        }
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inventory[i];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount)
                setInventorySlotContents(slot, null);
            else {
                itemStack = itemStack.splitStack(amount);
                if (itemStack.stackSize == 0)
                    setInventorySlotContents(slot, null);
            }
        }
        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null)
            setInventorySlotContents(slot, null);
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
            itemStack.stackSize = getInventoryStackLimit();
    }

    @Override
    public String getInvName() {
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return true;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        ItemStack slotItem = this.inventory[i];
        if (slotItem == null)
            return true;
        else {
            if (slotItem.isItemEqual(itemstack))
                return true;
            else
                return false;
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 1 ? sidedTop : sidedOther;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
        if (side == 1)
            return this.isItemValidForSlot(0, itemstack);
        else
            return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        if (j == 0)
            return true;
        else
            return false;
    }

    @Override
    public PowerReceiver getPowerReceiver(ForgeDirection side) {
        return powerHandler.getPowerReceiver();
    }

    @Override
    public void doWork(PowerHandler workProvider) {
    }

    @Override
    public World getWorld() {
        return this.getWorldObj();
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.loadNBT(par1NBTTagCompound);
    }

    public void loadNBT(NBTTagCompound nbtTag) {
        this.powerHandler.readFromNBT(nbtTag);
        NBTTagList tagList = nbtTag.getTagList("Inventory");
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }

        }
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        this.addToNBT(par1NBTTagCompound);
    }

    public void addToNBT(NBTTagCompound nbtTag) {
        this.powerHandler.writeToNBT(nbtTag);
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);

                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTag.setTag("Inventory", tagList);
    }

    @Override
    public Packet getDescriptionPacket() {
        Packet132TileEntityData packet = (Packet132TileEntityData) super
                .getDescriptionPacket();
        NBTTagCompound tag = packet != null ? packet.data
                : new NBTTagCompound();
        this.addToNBT(tag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord,
                this.zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(INetworkManager networkManager,
            Packet132TileEntityData packet) {
        super.onDataPacket(networkManager, packet);
        NBTTagCompound nbtTag = packet.data;
        this.loadNBT(nbtTag);
    }
}
