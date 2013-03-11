package com.lomeli.diving.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.*;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/Coral.png");
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/ADS.png");
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/scubahelm.png");
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/scuba2helm.png");
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/snorkel.png");
		MinecraftForgeClient.preloadTexture("/mods/divinggear/models/thaumicHelm.png");
	}
	
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public void initRendering() {
		RenderIDs.coralRenderID = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoral.class, new TileEntityCoralRenderer());
		
		ClientRegistry.registerTileEntity(TileEntityCoral.class, Integer.toString(RenderIDs.coralRenderID), new TileEntityCoralRenderer());
	}
}
