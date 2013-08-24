package net.lomeli.diving.core;

import net.lomeli.diving.core.handler.KeybindingHandler;
import net.lomeli.diving.core.handler.VersionCheckTickHandler;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;
import net.lomeli.diving.tileentity.TileEntityWaterMill;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityWaterMill.class, "waterMill");
		GameRegistry.registerTileEntity(TileEntityAirCompressor.class, "airCompressor");
	}
	
	@Override
	public void registerTickHandler(){
		TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);
	}
	
	@Override
	public void registerKeyHandler(){
		KeyBindingRegistry.registerKeyBinding(new KeybindingHandler());
	}
}
