package net.lomeli.diving.core;

import java.io.File;

import net.lomeli.diving.lib.ModStrings;
import net.minecraftforge.common.Configuration;

public class Config
{
	public static void configureMod(String Loc)
	{
		Configuration config = new Configuration(new File(Loc, ModStrings.MOD_NAME + ".cfg"));
		
		config.load();
		
		config.save();
	}
}
