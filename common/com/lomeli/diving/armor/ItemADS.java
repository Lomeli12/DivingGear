package com.lomeli.diving.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.common.IArmorTextureProvider;

import com.lomeli.diving.core.AirHandler;

public class ItemADS extends ItemArmor implements IArmorTextureProvider
{
	public ItemADS(int par1, EnumArmorMaterial par2EnumArmorMaterial,
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
		return "/com/lomeli/diving/art/models/ADS.png";
	}
	
	private int used = 0;
	public static int uses;
	public static int amount;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		AirHandler.givePlayerAir(player, used, uses, amount);
	}
}