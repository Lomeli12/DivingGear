package com.lomeli.diving.config;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import net.minecraftforge.common.EnumHelper;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.armor.*;
import com.lomeli.diving.item.*;
import com.lomeli.diving.lib.*;

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
	
	public static void registerArmor()
	{
		Snorkel = new ItemGear(ReferenceIntegers.SnorkelID, plastic, DivingGear.proxy.addArmor("Snorkel"), 0, 
				ReferenceIntegers.snorkelUses, ReferenceIntegers.snorkelAmount, "snorkel", 
				"snorkelModel").setUnlocalizedName("Snorkel");
		LanguageRegistry.addName(Snorkel, SnorkelName);
		ADS_T = new ItemGear(ReferenceIntegers.ADS_TID, iron, DivingGear.proxy.addArmor("ADS-T"), 0,
				ReferenceIntegers.adsUses, ReferenceIntegers.adsAmount, "ads", "ADSModel").setUnlocalizedName("ADS=T");
		LanguageRegistry.addName(ADS_T, ADS_TName);
		Scuba1 = new ItemGear(ReferenceIntegers.Scuba1ID, scuba, DivingGear.proxy.addArmor("Scuba1"), 0,
				ReferenceIntegers.scuba1Uses, ReferenceIntegers.scuba1Amount, "scuba",
				"scubahelmModel").setUnlocalizedName("Scuba1");
		LanguageRegistry.addName(Scuba1, Scuba1Name);
		Scuba2 = new ItemGear(ReferenceIntegers.Scuba2ID, scuba, DivingGear.proxy.addArmor("Scuba2"), 0,
				ReferenceIntegers.scuba2Uses, ReferenceIntegers.scuba2Amount, "scuba2",
				"scuba2helmModel").setUnlocalizedName("Scuba2");
		LanguageRegistry.addName(Scuba2, Scuba2Name);
	}
	
	public static void registerItems()
	{
		airTank = new ItemAirTankFull(ReferenceIntegers.airTankID).setUnlocalizedName("AirTank");
		LanguageRegistry.addName(airTank, airTankName);
		doubleTank = new ItemDoubleAirTankFull(ReferenceIntegers.doubleTankID).setUnlocalizedName("DoubleTank");
		LanguageRegistry.addName(doubleTank, doubleTankName);
	}
	public static boolean hardcore;
	public static void registerRecipes()
	{
		if(hardcore == true) { hardRecipes();}
		else easyRecipes();
	}
	
	public static void easyRecipes()
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
	public static void hardRecipes()
	{
		//Items
		GameRegistry.addRecipe(new ItemStack(airTank, 1), new Object[]
		{
			"IGI","IGI","LIL", 'I',Item.ingotIron, 'G',Item.diamond, 'L',(new ItemStack(Item.dyePowder, 1, 4))
		});
		GameRegistry.addRecipe(new ItemStack(doubleTank, 1), new Object[]
		{
			"SIS","TDT","FFF", 'I',Item.ingotIron, 'S',Item.silk, 'T',airTank, 'D',Item.diamond, 'F',Block.netherBrick
		});
		
		//Diving Gear
		GameRegistry.addRecipe(new ItemStack(Snorkel, 1), new Object[]
		{
			"IFI","GSG","LTL", 'L',(new ItemStack(Item.dyePowder, 1, 4)), 'I',Item.ingotIron, 'S',Item.silk, 'G',Block.thinGlass, 'T',Item.glassBottle, 'F',Block.glowStone
		});
		GameRegistry.addRecipe(new ItemStack(ADS_T, 1), new Object[]
		{
			"SVS","IGI","SIS", 'I',Item.ingotIron, 'V',Block.cobblestoneMossy, 'G',Block.glass, 'S',Block.slowSand
		});
		GameRegistry.addRecipe(new ItemStack(Scuba1, 1), new Object[]
		{
			"LIL","ITI","RIR", 'L',Block.blockLapis, 'I',Item.ingotIron, 'R',Item.bucketEmpty, 'T',airTank
		});
		GameRegistry.addRecipe(new ItemStack(Scuba2, 1), new Object[]
		{
			"LIL","ITI","RIR", 'L',Block.blockLapis, 'I',Item.ingotIron, 'R',Item.bucketEmpty, 'T',doubleTank
		});
	}
}
