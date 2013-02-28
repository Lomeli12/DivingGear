package com.lomeli.diving.thaumcraft;

import java.util.logging.Level;

import com.lomeli.diving.core.helper.LogHelper;
import com.lomeli.diving.thaumcraft.armor.*;
import com.lomeli.diving.thaumcraft.config.RegisterThaum;

import cpw.mods.fml.common.Loader;

public class ThaumCraftSupport 
{
	public static void isThaumInstalled()
	{
		if(Loader.isModLoaded("Thaumcraft"))
		{
			try
			{
				LogHelper.log(Level.FINEST, "Thaumcraft 3 Found!");
				addonActivate();
			}
			catch(Exception e)
			{
				LogHelper.log(Level.INFO, "Thaumcraft 3 not found!");
			}
			}
		else
		{
			LogHelper.log(Level.INFO, "Thaumcraft 3 not found!!");
		}
	}
	public static void addonActivate()
	{
		RegisterThaum.register();
		RegisterThaum.researchAqua();
	}
}
