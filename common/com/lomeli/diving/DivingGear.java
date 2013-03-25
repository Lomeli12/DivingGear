package com.lomeli.diving;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.common.registry.*;

import net.minecraft.creativetab.CreativeTabs;

import com.lomeli.diving.lib.*;
import com.lomeli.diving.core.*;
import com.lomeli.diving.config.*;
import com.lomeli.diving.thaumcraft.*;
import com.lomeli.diving.block.gen.*;

@Mod(modid=ReferenceStrings.modID,name=ReferenceStrings.modName,version=ReferenceStrings.version)
@NetworkMod(clientSideRequired=true,serverSideRequired=false)

public class DivingGear 
{
	@SidedProxy(clientSide = ReferenceStrings.clientProxy, serverSide = ReferenceStrings.commonProxy)
	public static CommonProxy proxy;
	
	@Instance(ReferenceStrings.modID)
	public static DivingGear instance;
	
	public static CreativeTabs divingGearTab = new CreativeTabDiving(CreativeTabs.getNextID(), ReferenceStrings.modName);
	
	public static String configDir;
	
	public static boolean capesOn;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		configDir = event.getModConfigurationDirectory() + "\\DivingGearMod\\";
		
		//Loading Configs.
		ConfigMod.configureIDs(configDir);
		ConfigMod.airConfigure(configDir);
		ConfigMod.loadLanguages(configDir);
		ConfigMod.configureOptions(configDir);
		
		//Rendering stuff
		proxy.initRendering();
	}
	
	@Init
	public void main(FMLInitializationEvent event)
	{
		//Registers mod items and blocks.
		RegisterItems.registerArmor();
		RegisterItems.registerItems();
		RegisterItems.registerTools();
		RegisterBlocks.registerBlock();
		
		//Register Recipes.
		RegisterItems.registerRecipes();
		RegisterBlocks.registerRecipes();
		
		//Checking if Thaumcraft is installed.
		ThaumCraftSupport.isThaumInstalled();
		
		//Starting world Gen.
		GameRegistry.registerWorldGenerator(new CoralGen());
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event)
	{
		
	}
}
