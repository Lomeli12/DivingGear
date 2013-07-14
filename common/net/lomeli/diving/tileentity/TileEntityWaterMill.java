package net.lomeli.diving.tileentity;

import buildcraft.api.core.SafeTimeTracker;
import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityWaterMill extends TileEntity 
	implements IPowerProvider
{

	@Override
    public int getLatency()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public int getMinEnergyReceived()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public int getMaxEnergyReceived()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public int getMaxEnergyStored()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public int getActivationEnergy()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public float getEnergyStored()
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public void configure(int latency, int minEnergyReceived,
            int maxEnergyReceived, int minActivationEnergy, int maxStoredEnergy)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public void configurePowerPerdition(int powerLoss, int powerLossRegularity)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public boolean update(IPowerReceptor receptor)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public boolean preConditions(IPowerReceptor receptor)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public float useEnergy(float min, float max, boolean doUse)
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public void receiveEnergy(float quantity, ForgeDirection from)
    {
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public boolean isPowerSource(ForgeDirection from)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public SafeTimeTracker getTimeTracker()
    {
	    // TODO Auto-generated method stub
	    return null;
    }

}
