package com.lomeli.diving.config;

import java.io.File;

import net.minecraftforge.common.*;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.armor.ItemADS;
import com.lomeli.diving.armor.ItemScuba1;
import com.lomeli.diving.armor.ItemScuba2;
import com.lomeli.diving.armor.ItemSnorkel;
import com.lomeli.diving.thaumcraft.armor.ItemThaumADS;
import com.lomeli.diving.thaumcraft.config.*;

public class ConfigMod {
	/**
	 * Registered all the id(s) for all the items and other variables
	 */
	public static void configureIDs(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearIDs.cfg"));
		
		config.load();
       
		RegisterItems.SnorkelID = config.get("Gear", "Snorkel", 6050).getInt(6050);
		RegisterItems.ADS_TID = config.get("Gear", "ADS-T", 6051).getInt(6051);
		RegisterItems.Scuba1ID = config.get("Gear", "Scuba1", 6052).getInt(6052);
		RegisterItems.Scuba2ID = config.get("Gear", "Scuba2", 6053).getInt(6053);
		
		RegisterItems.airTankID = config.get("Item", "AirTank", 6060).getInt(6060);
		RegisterItems.doubleTankID = config.get("Item", "DoubleTank", 6061).getInt(6061);
		
		RegisterThaum.thaumADS_ID = config.get("ThaumGear", "AqualisH", 6080).getInt(6080);
		RegisterThaum.thaumTankID = config.get("ThaumGear", "VisTank", 6081).getInt(6081);
		
		RegisterBlocks.coralID = config.get("Blocks", "Coral1", 600).getInt(600);
			
		config.save();
	}
	/**
	 * Allows users to modify the amount of air the helms give
	 * and how many times they do.
	 */
	public static void airConfigure(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearAirDuration.cfg"));
			
		config.load();
		
		ItemSnorkel.uses = config.get("Uses", "Snorkel-Uses", 1).getInt(2);
		ItemSnorkel.amount = config.get("Air", "Snorkel-AirAmount", 150).getInt(150);
		
		ItemADS.uses = config.get("Uses", "ADS-Tritonia-Uses", 1).getInt(2);
		ItemADS.amount = config.get("Air", "ADS-Tritonia-AirAmount", 300).getInt(300);
		
		ItemScuba1.uses = config.get("Uses", "Scuba1-Uses", 6).getInt(6);
		ItemScuba1.amount = config.get("Air", "Scuba1-AirAmount", 300).getInt(300);
		
		ItemScuba2.uses = config.get("Uses", "Scuba2-Uses", 12).getInt(12);
		ItemScuba2.amount = config.get("Air", "Scuba2-AirAmount", 300).getInt(300);
		
		//Thaumcraft
		ItemThaumADS.amount = config.get("Air", "Aqualis-AirAmount", 300).getInt(300);
		ItemThaumADS.flux = config.get("Flux", "Aqualis-FluxAmount", 2).getInt(2);
		ItemThaumADS.range = config.get("FluxRange", "Aqualis-FluxRange", 300).getInt(300);
		
		config.save();
	}
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
	/**
	 * Get/Sets the options for certain options.
	 */
	public static void configureOptions(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearOptions.cfg"));
			
		config.load();
		RegisterItems.hardcore = config.get("Options", "hardmode", false).getBoolean(false);
        
		DivingGear.capesOn = config.get("Options", "enable-capes", true).getBoolean(true);
        
		config.save();
	}
}
