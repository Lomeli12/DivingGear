package com.lomeli.diving.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigOptions {
	
	public static void configure(FMLPreInitializationEvent event, String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearOptions.cfg"));
		
        config.load();
        
        RegisterItems.hardcore = config.get("Options", "hardmode", false).getBoolean(false);
        
        config.save();
	}

}
