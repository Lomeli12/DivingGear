package com.lomeli.diving.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.lomeli.diving.armor.*;
import com.lomeli.diving.core.helper.LogHelper;
import com.lomeli.diving.thaumcraft.armor.*;

public class ConfigAir 
{
	/**
	 * Allows users to modify the amount of air the helms give
	 * and how many times they do.
	 */
	public static void airConfigure(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearAirDuration.cfg"));
			
		config.load();
		
		ItemSnorkel.uses = config.get("Uses", "Snorkel-Uses", 1).getInt(1);
		ItemSnorkel.amount = config.get("Air", "Snorkel-AirAmount", 150).getInt(150);
		
		ItemADS.uses = config.get("Uses", "ADS-Tritonia-Uses", 1).getInt(1);
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
}
