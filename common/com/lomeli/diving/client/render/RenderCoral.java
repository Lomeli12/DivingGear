package com.lomeli.diving.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.lomeli.diving.client.model.ModelCoral;
import com.lomeli.diving.lib.RenderIDs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

@SideOnly(Side.CLIENT)
public class RenderCoral implements IItemRenderer, ISimpleBlockRenderingHandler
{
	
	private ModelCoral coralModel;
	
	public RenderCoral(int ID)
	{
		coralModel = new ModelCoral();
		RenderIDs.coralRenderID = ID;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type)
		{
			case ENTITY:
			{
				renderCoral(-0.5F, 0F, -0.5F);
				break;
			}
			case EQUIPPED:
			{
				renderCoral(0F, 0.4F, 0F);
				break;
			}
			default: break;
		}
		
	}
	
	private void renderCoral(float x, float y, float z)
	{
		Tessellator tesselator = Tessellator.instance;
		//ForgeHooksClient.bindTexture(Sprites., subID)
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		GL11.glPopMatrix();
	}
	
	@Override
	public int getRenderId()
	{
		return RenderIDs.coralRenderID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return false;
	}
}
