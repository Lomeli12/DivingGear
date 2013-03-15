package com.lomeli.diving.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;


import net.minecraftforge.common.ForgeDirection;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.TileEntityCoral;
import com.lomeli.diving.DivingGear;

public class BlockCoral extends Block
{
	public BlockCoral(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(DivingGear.divingGearTab);
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
	public int getRenderType()
	{
		return RenderIDs.coralRenderID;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta) 
	{
		return new TileEntityCoral();
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	@Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        par1World.setBlockTileEntity(par2, par3, par4, createTileEntity(par1World, par1World.getBlockMetadata(par2, par3, par4)));
    }
	
	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN )) ||
               (dir == UP    && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   )) ||
               (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
    }
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) ||
               par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   ) ||
               par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN );
    }
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var11 = par9 & 8;
        int var10 = par9 & 7;
        var10 = -1;

        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
        {
            var10 = par1World.rand.nextBoolean() ? 0 : 7;
        }

        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))
        {
            var10 = 5 + par1World.rand.nextInt(2);
        }

        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
        {
            var10 = 4;
        }

        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
        {
            var10 = 3;
        }

        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
        {
            var10 = 2;
        }

        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
        {
            var10 = 1;
        }

        return var10 + var11;
    }
}