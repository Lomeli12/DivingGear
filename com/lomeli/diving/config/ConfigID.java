package com.lomeli.diving.config;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.*;

public class ConfigID {
	/**
	 * Registered all the id(s) for all the items and other variables
	 */
	public static void configure(FMLPreInitializationEvent event, String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearIDs.cfg"));
		
        config.load();
        
        RegisterItems.SnorkelID = config.get("Gear", "Snorkel", 5050).getInt();
        RegisterItems.ADS_TID = config.get("Gear", "ADS-T", 5051).getInt();
        RegisterItems.Scuba1ID = config.get("Gear", "Scuba1", 5052).getInt();
        RegisterItems.Scuba2ID = config.get("Gear", "Scuba2", 5053).getInt();
        
        RegisterItems.airTankID = config.get("Item", "AirTank", 5060).getInt();
        RegisterItems.doubleTankID = config.get("Item", "DoubleTank", 5061).getInt();
        
        config.save();
	}
}
