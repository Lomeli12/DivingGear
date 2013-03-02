package com.lomeli.diving.thaumcraft.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
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
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/itemsheet1.png";
	}
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		return "/com/lomeli/diving/art/models/thaumicHelm.png";
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1){
		return EnumRarity.uncommon;
	}

	public static int flux;
	public static double range;
	public static int amount;
	
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
				AuraNode node = getNodeWithinRange(world, x, y, z, range);
				if (node != null)
			    {
					ThaumcraftApi.queueNodeChanges(node.key, 0, 0, false, new ObjectTags().add(EnumTag.WIND, flux), 0, 0, 0);
			    	player.setAir(amount);
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
