package com.lomeli.diving.config;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.*;

import com.lomeli.diving.thaumcraft.config.*;

public class ConfigID {
	/**
	 * Registered all the id(s) for all the items and other variables
	 */
	public static void configure(FMLPreInitializationEvent event, String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearIDs.cfg"));
		
        config.load();
        
        RegisterItems.SnorkelID = config.get("Gear", "Snorkel", 6050).getInt();
        RegisterItems.ADS_TID = config.get("Gear", "ADS-T", 6051).getInt();
        RegisterItems.Scuba1ID = config.get("Gear", "Scuba1", 6052).getInt();
        RegisterItems.Scuba2ID = config.get("Gear", "Scuba2", 6053).getInt();
        
        RegisterItems.airTankID = config.get("Item", "AirTank", 6060).getInt();
        RegisterItems.doubleTankID = config.get("Item", "DoubleTank", 6061).getInt();
        
        RegisterThaum.thaumADS_ID = config.get("ThaumGear", "AqualisH", 6080).getInt();
        RegisterThaum.thaumTankID = config.get("ThaumGear", "VisTank", 6081).getInt();
        
        config.save();
	}
}
