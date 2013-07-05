package net.lomeli.diving.block;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.tileentity.TileEntityAquaticEngine;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;

public class BlockAquaticEngine extends BlockContainer
{

	public BlockAquaticEngine(int par1, Material par2Material)
    {
	    super(par1, Material.iron);
	    setHardness(0.5F);
	    setCreativeTab(DivingGear.divingGearTab);
	    setUnlocalizedName("aquaticEngine");
    }
	
	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}

	@Override
    public TileEntity createNewTileEntity(World world)
    {
	    return new TileEntityAquaticEngine();
    }
	
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		
		if(tile instanceof TileEntityAquaticEngine)
			return ForgeDirection.getOrientation(((TileEntityAquaticEngine)tile).orientation).getOpposite() == side;
		
		return false;
	}

}
