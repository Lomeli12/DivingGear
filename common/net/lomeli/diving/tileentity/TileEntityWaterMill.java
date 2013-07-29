package net.lomeli.diving.tileentity;

import buildcraft.api.power.IPowerEmitter;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.power.PowerHandler.Type;

import net.lomeli.diving.lib.ModInts;

import net.lomeli.lomlib.block.BlockUtil;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeDirection;

public class TileEntityWaterMill extends TileEntity 
	implements IPowerEmitter, IPowerReceptor
{
	private PowerHandler powerHandler;
	
	private int tick;
	
	public TileEntityWaterMill()
	{
		powerHandler = new PowerHandler(this, Type.ENGINE);
		initPowerHandler();
	}

	private void initPowerHandler()
	{
		try
		{
			if(powerHandler != null)
			{
				powerHandler.configurePowerPerdition(1, 100);
			}
		}catch(Exception e){}
	}
	
	public boolean isActive(){
		return BlockUtil.isBlockAdjacentToWaterSource(worldObj, xCoord, yCoord, zCoord);
	}
	
	public float addEnergy(float amount)
	{
		System.out.println((powerHandler.getEnergyStored() + amount));
		powerHandler.setEnergy(powerHandler.getEnergyStored() + amount);
		if(powerHandler.getEnergyStored() > powerHandler.getMaxEnergyStored())
			powerHandler.setEnergy(powerHandler.getMaxEnergyStored());
		
		return amount;
	}
	
	@Override
    public void updateEntity()
    {
		super.updateEntity();
		if(!this.worldObj.isRemote)
		{
			if(isActive())
			{
				worldObj.setBlockMetadataWithNotify(xCoord, xCoord, zCoord, 1, 2);
				tick++;
				if(tick >= ModInts.ticks)
				{
					try{
						addEnergy(8F);
					}catch(Exception e){}
					
					tick = 0;
				}
			}
			else
			{
				tick = 0;
				worldObj.setBlockMetadataWithNotify(xCoord, xCoord, zCoord, 0, 2);
			}
		}
    }
	
	public float getCurrentPower(){
		return powerHandler.getEnergyStored();
	}
	
	@Override
    public boolean canEmitPowerFrom(ForgeDirection side){
	    return true;
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
