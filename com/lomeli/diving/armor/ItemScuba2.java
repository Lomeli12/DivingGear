package com.lomeli.diving.armor;

import com.lomeli.diving.config.RegisterItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.common.IArmorTextureProvider;

public class ItemScuba2 extends ItemArmor implements IArmorTextureProvider
{
	public ItemScuba2(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/itemsheet1.png";
	}
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == RegisterItems.Scuba2.itemID)
		{
			return "/com/lomeli/diving/art/models/scubahelm.png";
		}
		else return "/tutorial/armour/tutorial_2.png";
	}
	
	private int used = 0;
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		if(player.isWet()==true)
		{
			if(player.getAir() <= 0)
			{
				if(used <= 8)
				{
					player.setAir(300);
					used = used + 1;
				}else{}
			}
		}
		else
		{
			used = 0;
		}
	}
}
