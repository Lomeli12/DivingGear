package com.lomeli.diving.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import com.lomeli.diving.*;
import com.lomeli.diving.core.helper.*;

public class ConfigOptions {
	
	public static void configure(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, "DivingGearOptions.cfg"));
			
		config.load();
		RegisterItems.hardcore = config.get("Options", "hardmode", false).getBoolean(false);
        
		DivingGear.capesOn = config.get("Options", "enable-capes", true).getBoolean(true);
        
		config.save();
	}

}
