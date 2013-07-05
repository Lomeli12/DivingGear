package net.lomeli.diving.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks
{
	//Coral
	public static Block coral1;
	
	public static void loadBlocks()
	{
		coral1 = new BlockCoral(900, "test").setUnlocalizedName("test").setCreativeTab(CreativeTabs.tabBlock);
	
		GameRegistry.registerBlock(coral1, "Test");
		
		LanguageRegistry.addName(coral1, "Test");
	}
}
