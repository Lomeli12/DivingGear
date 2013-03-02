package com.lomeli.diving.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/com/lomeli/diving/art/itemSheet1.png");
	}
	
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
