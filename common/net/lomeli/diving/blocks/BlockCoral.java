package net.lomeli.diving.blocks;

import net.lomeli.diving.lib.ModStrings;

import net.lomeli.lomlib.block.BlockGeneric;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCoral extends BlockGeneric
{
	public BlockCoral(int id, String texture)
    {
	    super(id, Material.coral, ModStrings.MOD_ID, texture);
	    setTickRandomly(true);
    }

	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) 
	{
		return null;
	}
	
	public int getRenderType()
    {
        return 1;
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) 
	{
		return canBlockStay(world, x, y, z);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborBlockID)
	{
		if(!canBlockStay(world, x, y, z))
		{
			dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	}
	
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		if((world.getBlockId(x, y - 1, z) == Block.dirt.blockID ||
			world.getBlockId(x, y - 1, z) == Block.glass.blockID ||
			world.getBlockId(x, y - 1, z) == Block.sand.blockID ||
			world.getBlockId(x, y - 1, z) == Block.blockClay.blockID) &&
			(world.getBlockId(x, y + 1, z) == Block.waterStill.blockID ||
			world.getBlockId(x, y + 1, z) == Block.waterMoving.blockID))
			return true;
		else
			return false;
	}
}
