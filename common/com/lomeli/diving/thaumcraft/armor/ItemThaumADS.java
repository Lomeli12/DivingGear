package com.lomeli.diving.thaumcraft.armor;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceIntegers;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.common.IArmorTextureProvider;

import thaumcraft.api.*;

public class ItemThaumADS extends ItemArmor implements IArmorTextureProvider
{

	public ItemThaumADS(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(DivingGear.divingGearTab);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.func_94245_a(ReferenceStrings.modID.toLowerCase() + ":thaumichelm.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTextureFile(ItemStack itemstack) {
		return "/mods/divinggear/textures/models/thaumicHelmModel.png";
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1){
		return EnumRarity.uncommon;
	}

	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		if(player.isWet()==true)
		{
			if(player.getAir() <= 0)
			{
				int x = (int)player.posX;
				int y = (int)player.posY;
				int z = (int)player.posZ;
				AuraNode node = getNodeWithinRange(world, x, y, z, ReferenceIntegers.visArea);
				if (node != null)
			    {
					ThaumcraftApi.queueNodeChanges(node.key, 0, 0, false, new ObjectTags().add(EnumTag.WIND, ReferenceIntegers.fluxAmount), 0, 0, 0);
			    	player.setAir(ReferenceIntegers.thaumAmount);
			    }
			}
		}else
		{
			
		}
    }
	
	protected AuraNode getNodeWithinRange(World world, int x, int y, int z, double range)
	{
	    AuraNode node = null;

	    int nodeId = ThaumcraftApi.getClosestAuraWithinRange(world, x, y, z, range);
	    if (nodeId >= 0)
	    {
	      node = ThaumcraftApi.getNodeCopy(nodeId);
	    }

	    return node;
	}
}
