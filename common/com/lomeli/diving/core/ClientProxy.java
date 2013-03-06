package com.lomeli.diving.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraftforge.client.MinecraftForgeClient;

import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.config.RegisterBlocks;
import com.lomeli.diving.client.render.RenderCoral;
import com.lomeli.diving.block.*;

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
	
	@Override
	public void initRendering() {
		RenderIDs.coralRenderID = RenderingRegistry.getNextAvailableRenderId();
		RenderCoral coral = new RenderCoral(RenderIDs.coralRenderID);
		MinecraftForgeClient.registerItemRenderer(RegisterBlocks.coral.blockID, new RenderCoral(RenderIDs.coralRenderID));
		//MinecraftForgeClient.renderBlock(new RenderCoral(), RegisterBlocks.coral, 0,0,0);
	}
}
