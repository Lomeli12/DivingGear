package com.lomeli.diving.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import com.lomeli.diving.client.model.ModelCoral;
import com.lomeli.diving.lib.RenderIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

@SideOnly(Side.CLIENT)
public class RenderCoral implements ISimpleBlockRenderingHandler
{	
	@SuppressWarnings("unused")
	private ModelCoral coralModel;
	
	public RenderCoral(int ID)
	{
		coralModel = new ModelCoral();
		RenderIDs.coralRenderID = ID;
	}
	
	@Override
	public int getRenderId()
	{
		return RenderIDs.coralRenderID;
	}
	

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}
}
