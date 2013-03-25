package com.lomeli.diving.config;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.lomeli.diving.block.*;
import com.lomeli.diving.lib.ReferenceIntegers;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterBlocks {
	
	public static Block coral;
	public static Block airCompressor;
	
	public static String coralName;
	public static String airCompressorName;
	
	public static void registerBlock()
	{
		coral = new BlockCoral(ReferenceIntegers.coralID, Material.glass).setUnlocalizedName("Coral").setHardness(1F).setResistance(3F).setStepSound(Block.soundStoneFootstep);
		airCompressor = new BlockAirCompressor(ReferenceIntegers.airCompressorID).setUnlocalizedName("AirCompressor").setHardness(4F).setResistance(5F).setStepSound(Block.soundMetalFootstep);
		
		GameRegistry.registerBlock(coral, coralName);
		GameRegistry.registerBlock(airCompressor, airCompressorName);
		
		LanguageRegistry.addName(coral, coralName);
		LanguageRegistry.addName(airCompressor, airCompressorName);
		
	}
	public static void registerRecipes()
	{
		if(ConfigMod.hardcore == true) { hardRecipes();}
		else easyRecipes();
	}
	
	public static void hardRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(airCompressor, 1), new Object[]
		{
			" B ","CIC","PRP", 'B',Item.bucketEmpty, 'C',RegisterItems.coralFragment, 'I',Item.diamond, 'P',Block.pistonStickyBase, 'R',Block.blockRedstone
		});
	}
	public static void easyRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(airCompressor, 1), new Object[]
		{
			" B ","CIC","PRP", 'B',Item.bucketEmpty, 'C',RegisterItems.coralFragment, 'I',Item.ingotIron, 'P',Block.pistonBase, 'R',Item.redstone
		});
	}

}
