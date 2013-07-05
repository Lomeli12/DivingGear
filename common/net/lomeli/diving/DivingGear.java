package net.lomeli.diving;

import net.lomeli.diving.items.ModItems;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.blocks.ModBlocks;

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
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		ModBlocks.loadBlocks();
		ModItems.loadItems();
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
