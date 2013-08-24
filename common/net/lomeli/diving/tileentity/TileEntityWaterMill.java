package net.lomeli.diving.tileentity;

import buildcraft.api.power.IPowerEmitter;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;

import net.lomeli.diving.lib.ModInts;

import net.lomeli.lomlib.block.BlockUtil;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeDirection;

public class TileEntityWaterMill extends TileEntity 
	implements IPowerEmitter, IPowerReceptor
{
	private PowerHandler powerHandler;
	
	private int tick;
	
	public TileEntityWaterMill(){
		powerHandler = new PowerHandler(this, Type.ENGINE);
		initPowerHandler();
	}

	private void initPowerHandler(){
		if(powerHandler != null){
				powerHandler.configurePowerPerdition(0, 0);
				powerHandler.configure(8F, 16F, 2F, 400F);
		}
	}
	
	public boolean isActive(){
		int j = 0;
		if(BlockUtil.isBlockAdjacentToWaterSource(worldObj, xCoord, yCoord, zCoord)){
			if(this.worldObj.getBlockId(xCoord, yCoord, zCoord - 1) == Block.waterStill.blockID)
				j++;
			if(this.worldObj.getBlockId(xCoord, yCoord, zCoord + 1) == Block.waterStill.blockID)
				j++;
			if(this.worldObj.getBlockId(xCoord + 1, yCoord, zCoord) == Block.waterStill.blockID)
				j++;
			if(this.worldObj.getBlockId(xCoord - 1, yCoord, zCoord) == Block.waterStill.blockID)
				j++;
		}
		
		return j > 1;
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound){
		super.readFromNBT(par1NBTTagCompound);
		this.loadNBT(par1NBTTagCompound);
    }
	
	public void loadNBT(NBTTagCompound nbtTag){
		this.powerHandler.readFromNBT(nbtTag);
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound){
		super.writeToNBT(par1NBTTagCompound);
		this.addToNBT(par1NBTTagCompound);
	}
	
	public void addToNBT(NBTTagCompound nbtTag){
		this.powerHandler.writeToNBT(nbtTag);
	}
	
	@Override
	public Packet getDescriptionPacket(){
		Packet132TileEntityData packet = (Packet132TileEntityData)super.getDescriptionPacket();
		NBTTagCompound tag = packet != null ? packet.customParam1 : new NBTTagCompound();
		this.addToNBT(tag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	}
	
	@Override
	public void onDataPacket(INetworkManager networkManager, Packet132TileEntityData packet){
		super.onDataPacket(networkManager, packet);
		NBTTagCompound nbtTag = packet.customParam1;
		this.loadNBT(nbtTag);
	}
	
	@Override
    public void updateEntity(){
		super.updateEntity();
		if(!this.worldObj.isRemote){
			sendPower();
			if(isActive()){
				this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 2);
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				tick++;
				if(tick >= ModInts.ticks){
					this.powerHandler.setEnergy(this.powerHandler.getEnergyStored() + 8F);
					tick = 0;
				}
			}
			else{
				tick = 0;
				this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
    }
	
	public void sendPower(){
		TileEntity tile = this.worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
		if(tile != null){
			PowerReceiver receptor = ((IPowerReceptor) tile).getPowerReceiver(ForgeDirection.DOWN);
			if(receptor != null){
				float extracted = getPowerToExtract(receptor);
				if(extracted > 0F && this.powerHandler.getEnergyStored() >= extracted){
					receptor.receiveEnergy(Type.ENGINE, extracted, ForgeDirection.DOWN);
					this.powerHandler.useEnergy(extracted, extracted, false);
				}
			}
			
		}
	}
	
	public float getPowerToExtract(PowerReceiver receptor){
		return receptor.getMinEnergyReceived() + receptor.getMaxEnergyReceived() / 2;
	}
	
	public float getCurrentPower(){
		return powerHandler.getEnergyStored();
	}
	
    public boolean canEmitPowerFrom(ForgeDirection side){
	    return side == ForgeDirection.UP;
    }

	@Override
    public PowerReceiver getPowerReceiver(ForgeDirection side){
	    return powerHandler.getPowerReceiver();
    }

	@Override
    public void doWork(PowerHandler workProvider)
	{}

	@Override
    public World getWorld(){
	    return this.getWorldObj();
	}
}
