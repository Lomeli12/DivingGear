package com.lomeli.diving.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.*;
import com.lomeli.diving.core.capes.*;
import com.lomeli.diving.*;

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
		
		renderCapes(DivingGear.capesOn);
	}
	
	public static void renderCapes(boolean capes)
	{
		if(capes == true)
			DeveloperCapesAPI.init("http://anthony-lomeli.net/MinecraftMods/DivingGearMod/devCapes/UserCapes.txt");
		else{}
	}
}
