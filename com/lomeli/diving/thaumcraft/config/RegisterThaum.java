package com.lomeli.diving.thaumcraft.config;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import com.lomeli.diving.thaumcraft.armor.*;
import com.lomeli.diving.DivingGear;

import thaumcraft.api.*;
import thaumcraft.api.research.*;

public class RegisterThaum {
	public static Item thaumADS;
	
	public static int thaumADS_ID;
	
	public static String thaumADS_Name;
	
	
	public static String research = "/com/lomeli/diving/thaumcraft/config/research/reasearch.xml";
	public static void register()
	{
		thaumADS = new ItemThaumADS(thaumADS_ID, ThaumcraftApi.armorMatThaumium, DivingGear.proxy.addArmor("ThaumADS"), 0).setIconIndex(2).setItemName("thaumADS");
		LanguageRegistry.addName(thaumADS, thaumADS_Name);
		
		ThaumcraftApi.addArcaneCraftingRecipe("AQUALIS", "AQUALIS", 75, new ItemStack(thaumADS, 1), new Object[]
		{
			"WTW","TGT","ATA", 'T',ItemApi.getItem("itemThaumium", 1), 'G',Block.glass, 'W',ItemApi.getItem("itemShard", 1), 'A',ItemApi.getItem("itemShard", 1)
		});
	}
	public static void researchAqua()
	{
		try
		{
			InputStream stream = DivingGear.class.getResourceAsStream(research);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			ThaumcraftApi.researchDoc = dBuilder.parse(stream);
			ThaumcraftApi.researchDoc.getDocumentElement().normalize();
		}catch(Exception e){}
		new ResearchItem("AQUALIS", new ObjectTags().add(EnumTag.MAGIC, 4).add(EnumTag.WIND, 10).add(EnumTag.WATER, 5).add(EnumTag.ARMOR, 6), -3,0, new ItemStack(thaumADS, 1), 2).registerResearchItem();
	}
}
