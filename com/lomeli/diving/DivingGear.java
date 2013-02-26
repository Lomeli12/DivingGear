package com.lomeli.diving;

import net.minecraftforge.common.*;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

import net.minecraft.creativetab.CreativeTabs;

import com.lomeli.diving.lib.*;
import com.lomeli.diving.core.*;
import com.lomeli.diving.config.*;

@Mod(modid=ReferenceStrings.modID,name=ReferenceStrings.modName,version=ReferenceStrings.version)
@NetworkMod(clientSideRequired=true,serverSideRequired=false)

public class DivingGear {
	@SidedProxy(clientSide = ReferenceStrings.clientProxy, serverSide = ReferenceStrings.commonProxy)
	public static CommonProxy proxy;
	
	@Instance(ReferenceStrings.modID)
    public static DivingGear instance;
	
	public static String configDir;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		configDir = event.getModConfigurationDirectory() + "\\DivingGearMod\\";
		
		ConfigID.configure(event, configDir);
		ConfigAir.airConfigure(event, configDir);
		ConfigLang.loadLanguages(event, configDir);
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		RegisterItems.registerArmor();
		RegisterItems.registerItems();
		
		RegisterItems.registerRecipies();
		proxy.registerRenderThings();
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event)
	{
		
	}
}
