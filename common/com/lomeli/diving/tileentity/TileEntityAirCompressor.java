package com.lomeli.diving.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAirCompressor extends TileEntity
{
	private String rotationTagName = "ROTATION";
	private ForgeDirection rotation;
	
	public ForgeDirection getRotation() {
        return rotation;
    }

    public void setRotation(ForgeDirection rotation) {
        this.rotation = rotation;
    }
    
    public void setRotation(int direction) {
        this.setRotation(ForgeDirection.getOrientation(direction));
    }
	
	public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte(rotationTagName, (byte)this.rotation.ordinal());
    }
	public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        this.rotation = ForgeDirection.getOrientation(tag.getByte(rotationTagName));
    }
}
