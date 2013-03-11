package com.lomeli.diving.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.*;

import com.lomeli.diving.core.helper.LogHelper;
import com.lomeli.diving.thaumcraft.config.*;

public class ConfigID {
	/**
	 * Registered all the id(s) for all the items and other variables
	 */
	public static void configure(String Loc)
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
}
