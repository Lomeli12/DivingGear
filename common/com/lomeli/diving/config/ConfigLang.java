package com.lomeli.diving.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.lomeli.diving.core.helper.LogHelper;
import com.lomeli.diving.thaumcraft.config.*;

public class ConfigLang 
{
	/**
	 * Saves item names to a config file that allows 
	 * the community to translate it into other languages.
	 */
	public static void loadLanguages(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearLang.cfg"));
			
		config.load();
		
		RegisterItems.SnorkelName = config.get("Gear", "Snorkel", "Snorkel").getString();
		RegisterItems.ADS_TName = config.get("Gear", "ADS-T", "ADS: 'Tritonia'").getString();
		RegisterItems.Scuba1Name = config.get("Gear", "Scuba1", "Scuba: Single Air Tank").getString();
		RegisterItems.Scuba2Name = config.get("Gear", "Scuba2", "Scuba: Double Air Tank").getString();
		
		RegisterItems.airTankName = config.get("Item", "AirTank", "Air Tank").getString();
		RegisterItems.doubleTankName = config.get("Item", "DoubleTank", "Double Air Tank").getString();
		
		RegisterThaum.thaumADS_Name = config.get("ThaumGear", "AqualisH", "Aqualis Helm").getString();
		RegisterThaum.thaumTankName = config.get("ThaumGear", "VisTank", "Vis Tank").getString();
		
		RegisterBlocks.coralName = config.get("Blocks", "Coral1", "Coral").getString();
		
		config.save();
	}
}
