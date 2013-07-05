package net.lomeli.diving.items;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.lomeli.diving.lib.ModStrings;
import net.lomeli.lomlib.item.ItemGeneric;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.EnumArmorMaterial;

public class ModItems
{
	//Gear
	public static Item snorkel, ADS, subaTypeA, scubaTypeB;
	
	//Air Tanks
	public static Item airTank, doubleAirTank;
	
	public static void loadItems()
	{
		//Air Tanks
		airTank = new ItemGeneric(9001, ModStrings.MOD_ID, "airtank").setMaxDamage(1)
			.setUnlocalizedName("airTank").setCreativeTab(CreativeTabs.tabMaterials);
		
		//Gear
		snorkel = new ItemSnorkel(9000, EnumArmorMaterial.CHAIN, 0, 0, 150, 1)
			.setUnlocalizedName("snorkel").setCreativeTab(CreativeTabs.tabCombat);
		
		LanguageRegistry.addName(snorkel, "Snorkel");
	}
}
