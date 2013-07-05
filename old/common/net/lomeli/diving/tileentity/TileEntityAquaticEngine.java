package net.lomeli.diving.tileentity;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

import buildcraft.api.core.SafeTimeTracker;
import buildcraft.api.power.IPowerProvider;
import buildcraft.api.power.IPowerReceptor;

public class TileEntityAquaticEngine extends TileEntity 
	implements IPowerProvider, ITankContainer
{
	public static final int MAX_LIQUID = 10000;
	
	public InventoryBasic liquidInv;
	public ItemStack slotLiquid;
	
	public boolean active;
	
	public IPowerProvider provider;
	
	public LiquidTank waterTank;
	
	public byte orientation;
	
	public boolean isRedstonePowered = false;

	public TileEntityAquaticEngine()
	{
		initPowerProvider();
		this.waterTank = new LiquidTank(MAX_LIQUID);
		this.liquidInv = new InventoryBasic("aquaticEngine.stack", false, 2);
		this.liquidInv.setInventorySlotContents(0, (ItemStack)null);
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();

		
	}
	
	private void initPowerProvider() 
	{
		this.provider.configure(20, 8, 64, 16, 300);
	}
	
	@Override
    public int fill(ForgeDirection from, LiquidStack resource, boolean doFill)
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public int fill(int tankIndex, LiquidStack resource, boolean doFill)
    {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public ILiquidTank[] getTanks(ForgeDirection direction)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public ILiquidTank getTank(ForgeDirection direction, LiquidStack type)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

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
	    return this.provider.getEnergyStored();
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
