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
