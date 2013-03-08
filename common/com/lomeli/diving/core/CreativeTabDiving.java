package com.lomeli.diving.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.lomeli.diving.config.RegisterItems;

public class CreativeTabDiving extends CreativeTabs
{
	public static String tabName;
	
	public CreativeTabDiving(int par1, String par2Str) {
		super(par1, par2Str);
		tabName = par2Str;
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(RegisterItems.airTank);
	}
	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
    {
		return tabName;	
    }
}
