package com.lomeli.diving.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCoral extends ModelBase
{
	  //fields
	    ModelRenderer CoralBase;
	    ModelRenderer Branch1;
	  
	  public ModelCoral()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	    
	      CoralBase = new ModelRenderer(this, 0, 0);
	      CoralBase.addBox(0F, 0F, 0F, 6, 6, 6);
	      CoralBase.setRotationPoint(-3F, 18F, -3F);
	      CoralBase.setTextureSize(64, 64);
	      CoralBase.mirror = true;
	      setRotation(CoralBase, 0F, 0F, 0F);
	      Branch1 = new ModelRenderer(this, 24, 0);
	      Branch1.addBox(2F, 0F, 0F, 2, 11, 2);
	      Branch1.setRotationPoint(3F, 9F, 4F);
	      Branch1.setTextureSize(64, 64);
	      Branch1.mirror = true;
	      setRotation(Branch1, -0.2602503F, 0.1115358F, 0.3717861F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    CoralBase.render(f5);
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