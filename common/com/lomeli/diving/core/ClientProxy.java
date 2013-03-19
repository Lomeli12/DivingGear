package com.lomeli.diving.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.*;
import com.lomeli.diving.core.capes.*;
import com.lomeli.diving.*;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		renderCapes(DivingGear.capesOn);
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
	
	public void renderCapes(boolean capes)
	{
		if(capes == true)
			{DeveloperCapesAPI.getInstance().init("https://dl.dropbox.com/u/17430088/Minecraft%20Mods/DivingGear/UserCapes.txt");
			}else{}
	}
}
