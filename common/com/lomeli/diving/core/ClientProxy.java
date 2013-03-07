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
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/itemSheet1.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/Coral.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/ADS.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/scubahelm.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/scuba2helm.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/snorkel.png");
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/models/thaumicHelm.png");
		
		
	}
	
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public void initRendering() {
		RenderIDs.coralRenderID = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoral.class, new TileEntityCoralRenderer());
	}
}
