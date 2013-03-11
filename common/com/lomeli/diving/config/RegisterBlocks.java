package com.lomeli.diving.config;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.lomeli.diving.block.*;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterBlocks {
	
	public static Block coral;
	
	public static int coralID;
	
	public static String coralName;
	
	public static void registerBlock()
	{
		coral = new BlockCoral(coralID, Material.glass).setUnlocalizedName("Coral").setHardness(3F).setResistance(3F).setStepSound(Block.soundStoneFootstep);
		GameRegistry.registerBlock(coral, coralName);
		LanguageRegistry.addName(coral, coralName);	
	}

}
