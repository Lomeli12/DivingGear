package com.lomeli.diving.config;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import com.lomeli.diving.thaumcraft.config.*;

public class ConfigLang 
{
	/**
	 * Saves item names to a config file that allows 
	 * the community to translate it into other languages.
	 */
	public static void loadLanguages(FMLPreInitializationEvent event, String Loc)
	{
		Configuration config = new Configuration(
				new File(Loc, "DivingGearLang.cfg"));
		
		config.load();
		
		RegisterItems.SnorkelName = config.get("Gear", "Snorkel", "Snorkel").value;
		RegisterItems.ADS_TName = config.get("Gear", "ADS-T", "ADS: 'Tritonia'").value;
		RegisterItems.Scuba1Name = config.get("Gear", "Scuba1", "Scuba: Single Air Tank").value;
		RegisterItems.Scuba2Name = config.get("Gear", "Scuba2", "Scuba: Double Air Tank").value;
		
		RegisterItems.airTankName = config.get("Item", "AirTank", "Air Tank").value;
		RegisterItems.doubleTankName = config.get("Item", "DoubleTank", "Double Air Tank").value;
		
		RegisterThaum.thaumADS_Name = config.get("ThaumGear", "AqualisH", "Aqualis Helm").value;
		RegisterThaum.thaumTankName = config.get("ThaumGear", "VisTank", "Vis Tank").value;
		
		RegisterBlocks.coralName = config.get("Blocks", "Coral1", "Coral").value;
		
		config.save();
	}
}
