package com.lomeli.diving.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.lomeli.diving.client.model.*;

public class TileEntityCoralRenderer extends TileEntitySpecialRenderer
{
	private ModelCoral coralModel;
	
	public TileEntityCoralRenderer()
	{
		coralModel = new ModelCoral();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		renderModelAt((TileEntityCoral) var1, var2, var4, var6, var8);
	}
	
	public void renderModelAt(TileEntityCoral tile, double par2, double par4, double par6, float par8) 
	{
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F - 1F, 0.5F);
        bindTextureByName("/com/lomeli/diving/art/models/Coral.png");

        coralModel.render(0.0625F);

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
