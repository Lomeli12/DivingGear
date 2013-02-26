package com.lomeli.diving.config;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import net.minecraftforge.common.EnumHelper;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.armor.*;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterItems {
	static EnumArmorMaterial plastic = EnumHelper.addArmorMaterial("Snorkel", 20, new int[]{1,1,1,1}, 14);
	static EnumArmorMaterial iron = EnumHelper.addArmorMaterial("ADS-T", 170, new int[]{3, 1, 1, 1}, 14);
	static EnumArmorMaterial scuba = EnumHelper.addArmorMaterial("Scuba", 200, new int[]{4,1,1,1},14);
	
	public static Item Snorkel;
	public static Item ADS_T;
	public static Item Scuba1;
	public static Item Scuba2;
	
	public static Item airTank;
	public static Item doubleTank;
	
	public static String SnorkelName;
	public static String ADS_TName;
	public static String Scuba1Name;
	public static String Scuba2Name;
	
	public static String airTankName;
	public static String doubleTankName;
	
	public static int SnorkelID;
	public static int ADS_TID;
	public static int Scuba1ID;
	public static int Scuba2ID;
	public static int airTankID;
	public static int doubleTankID;
	
	public static void registerArmor()
	{
		Snorkel = new ItemSnorkel(SnorkelID, plastic, DivingGear.proxy.addArmor("Snorkel"), 0).setItemName("Snorkel").setIconIndex(0);
		LanguageRegistry.addName(Snorkel, SnorkelName);
		ADS_T = new ItemADS(ADS_TID, iron, DivingGear.proxy.addArmor("ADS-T"), 0).setItemName("ADS-T").setIconIndex(1);
		LanguageRegistry.addName(ADS_T, ADS_TName);
		Scuba1 = new ItemScuba1(Scuba1ID, scuba, DivingGear.proxy.addArmor("Scuba1"),0).setItemName("Scuba1").setIconIndex(2);
		LanguageRegistry.addName(Scuba1, Scuba1Name);
		Scuba2 = new ItemScuba2(Scuba2ID, scuba, DivingGear.proxy.addArmor("Scuba2"),0).setItemName("Scuba2").setIconIndex(2);
		LanguageRegistry.addName(Scuba2, Scuba2Name);
	}
	
	public static void registerItems()
	{
		airTank = new ItemDiving(airTankID).setItemName("AirTank").setIconIndex(16);
		LanguageRegistry.addName(airTank, airTankName);
		doubleTank = new ItemDiving(doubleTankID).setItemName("DoubleTank").setIconIndex(17);
		LanguageRegistry.addName(doubleTank, doubleTankName);
	}
	
	public static void registerRecipies()
	{
		//Items
		GameRegistry.addRecipe(new ItemStack(airTank, 1), new Object[]
		{
			"IGI","IGI","LIL", 'I',Item.ingotIron, 'G',Item.glassBottle, 'L',(new ItemStack(Item.dyePowder, 1, 4))
		});
		GameRegistry.addRecipe(new ItemStack(doubleTank, 1), new Object[]
		{
			"SIS","TST", 'I',Item.ingotIron, 'S',Item.silk, 'T',airTank
		});
		
		//Diving Gear
		GameRegistry.addRecipe(new ItemStack(Snorkel, 1), new Object[]
		{
			"I I","GSG","LTL", 'L',(new ItemStack(Item.dyePowder, 1, 4)), 'I',Item.ingotIron, 'S',Item.silk, 'G',Block.thinGlass, 'T',Item.glassBottle
		});
		GameRegistry.addRecipe(new ItemStack(ADS_T, 1), new Object[]
		{
			"IVI","IGI","III", 'I',Item.ingotIron, 'V',Block.vine, 'G',Block.glass
		});
		GameRegistry.addRecipe(new ItemStack(Scuba1, 1), new Object[]
		{
			"LIL","ITI","RIR", 'L',(new ItemStack(Item.dyePowder, 1, 4)), 'I',Item.ingotIron, 'R',Item.leather, 'T',airTank
		});
		GameRegistry.addRecipe(new ItemStack(Scuba2, 1), new Object[]
		{
			"LIL","ITI","RIR", 'L',(new ItemStack(Item.dyePowder, 1, 4)), 'I',Item.ingotIron, 'R',Item.leather, 'T',doubleTank
		});
	}
}
