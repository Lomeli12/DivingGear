package com.lomeli.diving.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.lomeli.diving.lib.RenderIDs;

public class BlockCoral extends DivingBlock
{

	public BlockCoral(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
		
	}
	@Override
	public boolean renderAsNormalBlock() 
	{
		return true;
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
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/models/Coral.png";
	}

}
