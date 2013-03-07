package com.lomeli.diving.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.TileEntityCoral;

public class BlockCoral extends DivingBlock
{

	public BlockCoral(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		
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
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/models/Coral.png";
	}

}
