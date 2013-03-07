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
    ModelRenderer Minibranch1;
    ModelRenderer Minibranch2;
    ModelRenderer Minibranch3;
    ModelRenderer Branch3;
    ModelRenderer Branch2;
    ModelRenderer Branch1;
  
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
        Minibranch1.mirror = true;
        Minibranch1 = new ModelRenderer(this, 0, 12);
        Minibranch1.addBox(2F, 0F, 0F, 1, 4, 1);
        Minibranch1.setRotationPoint(2F, 9F, -3F);
        Minibranch1.setTextureSize(32, 32);
        Minibranch1.mirror = false;
        setRotation(Minibranch1, -0.715585F, 0F, 0F);
        Minibranch1.mirror = false;
        Minibranch2 = new ModelRenderer(this, 0, 12);
        Minibranch2.addBox(0F, 0F, 0F, 1, 4, 1);
        Minibranch2.setRotationPoint(-1F, 11F, 0F);
        Minibranch2.setTextureSize(32, 32);
        Minibranch2.mirror = false;
        setRotation(Minibranch2, -0.9599311F, 1.896109F, -0.1115358F);
        Minibranch3 = new ModelRenderer(this, 0, 12);
        Minibranch3.addBox(0F, 1F, 0F, 1, 3, 1);
        Minibranch3.setRotationPoint(-2F, 8F, -1F);
        Minibranch3.setTextureSize(32, 32);
        Minibranch3.mirror = false;
        setRotation(Minibranch3, 0.0279872F, 0F, 0F);
        Branch3 = new ModelRenderer(this, 24, 0);
        Branch3.addBox(0F, 4F, 0F, 2, 11, 2);
        Branch3.setRotationPoint(-9F, 6F, 0F);
        Branch3.setTextureSize(32, 32);
        Branch3.mirror = false;
        setRotation(Branch3, -0.1858931F, -0.2230717F, -0.4089647F);
        Branch2 = new ModelRenderer(this, 24, 0);
        Branch2.addBox(4F, 1F, 1F, 2, 11, 2);
        Branch2.setRotationPoint(2F, 6F, 3F);
        Branch2.setTextureSize(32, 32);
        Branch2.mirror = false;
        setRotation(Branch2, -0.2602503F, -0.1115358F, 0.3717861F);
        Branch1 = new ModelRenderer(this, 24, 0);
        Branch1.addBox(2F, 0F, 0F, 2, 11, 2);
        Branch1.setRotationPoint(2F, 9F, -8F);
        Branch1.setTextureSize(32, 32);
        Branch1.mirror = false;
        setRotation(Branch1, 0.4461433F, 0.1115358F, 0.3717861F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {	
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	CoralBase.render(f5);
    	Minibranch1.render(f5);
    	Minibranch2.render(f5);
    	Minibranch3.render(f5);
    	Branch3.render(f5);
    	Branch2.render(f5);
    	Branch1.render(f5);
    }
    
    public void render(float par1)
	{
    	CoralBase.render(par1);
		Branch1.render(par1);
		Branch2.render(par1);
		Branch3.render(par1);
		Minibranch1.render(par1);
		Minibranch2.render(par1);
		Minibranch3.render(par1);
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