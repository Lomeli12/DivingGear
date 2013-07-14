package net.lomeli.diving;

import net.lomeli.diving.items.ModItems;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.blocks.ModBlocks;
import net.lomeli.diving.core.Config;
import net.lomeli.diving.core.CreativeTabDG;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModStrings.MOD_ID, name = ModStrings.MOD_NAME, version = ModStrings.VERSION,
	dependencies="required-after:LomLib@[1.0.2,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DivingGear
{
	public static CreativeTabs modTab = new CreativeTabDG(CreativeTabs.getNextID(), ModStrings.MOD_NAME);
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		Config.configureMod(event.getSuggestedConfigurationFile());
		
		ModItems.loadItems();
		ModBlocks.loadBlocks();
    }

	@Mod.EventHandler
    public void main(FMLInitializationEvent event)
    {
		
    }

	@Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {
		
    }
}
