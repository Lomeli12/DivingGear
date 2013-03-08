package com.lomeli.diving.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCoral extends ModelBase
{
	ModelRenderer CoralBase;
    ModelRenderer Branch3;
    ModelRenderer Branch2;
    ModelRenderer Branch1;
    ModelRenderer Minibranch1;
    ModelRenderer Minibranch2;
    ModelRenderer Minibranch3;
    ModelRenderer Minibranch4;
    ModelRenderer Minibranch5;
    ModelRenderer Minibranch6;
    ModelRenderer Minibranch7;
    ModelRenderer Minibranch8;
    ModelRenderer Minibranch9;
  
  public ModelCoral()
  {
    textureWidth = 32;
    textureHeight = 32;
    
    CoralBase = new ModelRenderer(this, 0, 0);
    CoralBase.addBox(0F, 0F, 0F, 6, 6, 6);
    CoralBase.setRotationPoint(-3F, 18F, -3F);
    CoralBase.setTextureSize(32, 32);
    CoralBase.mirror = false;
    setRotation(CoralBase, 0F, 0F, 0F);
    Minibranch1 = new ModelRenderer(this, 0, 12);
    Minibranch1.addBox(1F, 0F, 0F, 1, 4, 1);
    Minibranch1.setRotationPoint(0F, 11F, -3F);
    Minibranch1.setTextureSize(32, 32);
    Minibranch1.mirror = false;
    setRotation(Minibranch1, -0.715585F, 0F, 0F);
    Minibranch2 = new ModelRenderer(this, 0, 12);
    Minibranch2.addBox(0F, 0F, 0F, 1, 4, 1);
    Minibranch2.setRotationPoint(0F, 11F, 0F);
    Minibranch2.setTextureSize(32, 32);
    Minibranch2.mirror = false;
    setRotation(Minibranch2, -0.9599311F, 1.896109F, -0.1115358F);
    Minibranch3 = new ModelRenderer(this, 0, 12);
    Minibranch3.addBox(0F, 1F, 0F, 1, 3, 1);
    Minibranch3.setRotationPoint(-1F, 8F, -1F);
    Minibranch3.setTextureSize(32, 32);
    Minibranch3.mirror = false;
    setRotation(Minibranch3, 0.0279872F, 0F, 0F);
    Minibranch4 = new ModelRenderer(this, 0, 12);
    Minibranch4.addBox(0F, 0F, 0F, 1, 5, 1);
    Minibranch4.setRotationPoint(-2F, 12F, -7F);
    Minibranch4.setTextureSize(32, 32);
    Minibranch4.mirror = false;
    setRotation(Minibranch4, 0.0279872F, -0.3346075F, -0.9666439F);
    Minibranch5 = new ModelRenderer(this, 0, 12);
    Minibranch5.addBox(0F, 0F, 0F, 1, 4, 1);
    Minibranch5.setRotationPoint(2F, 16F, -4F);
    Minibranch5.setTextureSize(32, 32);
    Minibranch5.mirror = false;
    setRotation(Minibranch5, -1.942479F, 0F, 0.669215F);
    Minibranch6 = new ModelRenderer(this, 0, 12);
    Minibranch6.addBox(0F, 0F, 0F, 1, 4, 1);
    Minibranch6.setRotationPoint(4F, 13F, 4F);
    Minibranch6.setTextureSize(32, 32);
    Minibranch6.mirror = false;
    setRotation(Minibranch6, -1.942479F, 0F, 0.669215F);
    Minibranch7 = new ModelRenderer(this, 0, 12);
    Minibranch7.addBox(0F, 10F, 0F, 1, 3, 1);
    Minibranch7.setRotationPoint(4F, 0F, 0F);
    Minibranch7.setTextureSize(32, 32);
    Minibranch7.mirror = false;
    setRotation(Minibranch7, 0.0174533F, 0.1487144F, -0.0219973F);
    Minibranch8 = new ModelRenderer(this, 0, 12);
    Minibranch8.addBox(0F, 0F, 0F, 1, 5, 1);
    Minibranch8.setRotationPoint(-8F, 12F, 0F);
    Minibranch8.setTextureSize(32, 32);
    Minibranch8.mirror = false;
    setRotation(Minibranch8, -0.04637F, 0F, -1.07818F);
    Minibranch9 = new ModelRenderer(this, 0, 12);
    Minibranch9.addBox(0F, 0F, 0F, 1, 5, 1);
    Minibranch9.setRotationPoint(-1F, 13F, 2F);
    Minibranch9.setTextureSize(32, 32);
    Minibranch9.mirror = false;
    setRotation(Minibranch9, 0.0279872F, -0.3346075F, -0.9666439F);
    Branch3 = new ModelRenderer(this, 24, 0);
    Branch3.addBox(0F, 4F, 0F, 2, 11, 2);
    Branch3.setRotationPoint(-6F, 6F, 0F);
    Branch3.setTextureSize(32, 32);
    Branch3.mirror = false;
    setRotation(Branch3, -0.1487144F, -0.1487144F, -0.242797F);
    Branch2 = new ModelRenderer(this, 24, 0);
    Branch2.addBox(3F, 1F, 1F, 2, 11, 2);
    Branch2.setRotationPoint(2F, 8F, 3F);
    Branch2.setTextureSize(32, 32);
    Branch2.mirror = false;
    setRotation(Branch2, -0.2602503F, -0.1115358F, 0.3717861F);
    Branch1 = new ModelRenderer(this, 24, 0);
    Branch1.addBox(2F, 1F, 0F, 2, 11, 2);
    Branch1.setRotationPoint(-1F, 10F, -8F);
    Branch1.setTextureSize(32, 32);
    Branch1.mirror = false;
    setRotation(Branch1, 0.5205006F, 0.1115358F, 0.1115358F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {	
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	CoralBase.render(f5);
    	Minibranch1.render(f5);
    	Minibranch2.render(f5);
    	Minibranch3.render(f5);
    	Minibranch4.render(f5);
    	Minibranch5.render(f5);
    	Minibranch6.render(f5);
    	Minibranch7.render(f5);
    	Minibranch8.render(f5);
    	Minibranch9.render(f5);
    	Branch3.render(f5);
    	Branch2.render(f5);
    	Branch1.render(f5);
    }
    
    public void render(float f5)
	{
    	CoralBase.render(f5);
    	Minibranch1.render(f5);
    	Minibranch2.render(f5);
    	Minibranch3.render(f5);
    	Minibranch4.render(f5);
    	Minibranch5.render(f5);
    	Minibranch6.render(f5);
    	Minibranch7.render(f5);
    	Minibranch8.render(f5);
    	Minibranch9.render(f5);
    	Branch3.render(f5);
    	Branch2.render(f5);
    	Branch1.render(f5);
	}
	  
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	}
	  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}