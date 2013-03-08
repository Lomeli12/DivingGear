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
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		configDir = event.getModConfigurationDirectory() + "\\DivingGearMod\\";
		
		ConfigID.configure(event, configDir);
		ConfigAir.airConfigure(event, configDir);
		ConfigLang.loadLanguages(event, configDir);
		ConfigOptions.configure(event, configDir);
	}
	
	@Init
	public void main(FMLInitializationEvent event)
	{
		RegisterItems.registerArmor();
		RegisterItems.registerItems();
		RegisterBlocks.registerBlock();

		RegisterItems.registerRecipes();
		
		ThaumCraftSupport.isThaumInstalled();
		
		GameRegistry.registerWorldGenerator(new CoralGen());
		
		proxy.registerRenderThings();
		proxy.initRendering();
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event)
	{
		
	}
}
