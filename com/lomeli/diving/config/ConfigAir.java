package com.lomeli.diving.config;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

import com.lomeli.diving.armor.*;

public class ConfigAir 
{
	/**
	 * Allows users to modify the amount of air the helms give
	 * and how many times they do.
	 */
	public static void airConfigure(FMLPreInitializationEvent event, String Loc)
	{
		Configuration config = new Configuration(
				new File(Loc, "DivingGearAirDuration.cfg"));
		
		config.load();
		
		ItemSnorkel.uses = config.get("Uses", "Snorkel-Uses", 1).getInt();
		ItemSnorkel.amount = config.get("Air", "Snorkel-AirAmount", 150).getInt();
		
		ItemADS.uses = config.get("Uses", "ADS-Tritonia-Uses", 1).getInt();
		ItemADS.amount = config.get("Air", "ADS-Tritonia-AirAmount", 300).getInt();
		
		ItemScuba1.uses = config.get("Uses", "Scuba1-Uses", 6).getInt();
		ItemScuba1.amount = config.get("Air", "Scuba1-AirAmount", 300).getInt();
		
		ItemScuba2.uses = config.get("Uses", "Scuba2-Uses", 12).getInt();
		ItemScuba2.amount = config.get("Air", "Scuba2-AirAmount", 300).getInt();
		
		config.save();
	}
}