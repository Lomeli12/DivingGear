package net.lomeli.diving.core;

import java.util.logging.Level;

import com.jadarstudios.api.developercapesapi.DeveloperCapesAPI;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.client.render.item.ItemCoralRenderer;
import net.lomeli.diving.config.RegisterBlocks;
import net.lomeli.diving.core.helper.LogHelper;
import net.lomeli.diving.lib.RenderIDs;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;
import net.lomeli.diving.tileentity.TileEntityAirCompressorRenderer;
import net.lomeli.diving.tileentity.TileEntityCoral;
import net.lomeli.diving.tileentity.TileEntityCoralRenderer;

import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void initRendering()
    {
        RenderIDs.coralRenderID = RenderingRegistry.getNextAvailableRenderId();
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoral.class,
                new TileEntityCoralRenderer());
        
        MinecraftForgeClient.registerItemRenderer(RegisterBlocks.coral.blockID,
                new ItemCoralRenderer());
        
        ClientRegistry.registerTileEntity(TileEntityCoral.class, "coral",
                new TileEntityCoralRenderer());
        ClientRegistry.registerTileEntity(TileEntityAirCompressor.class, 
        		"airCompressor", new TileEntityAirCompressorRenderer());
        
        try
        {
        	renderCapes(DivingGear.capesOn);
        }catch(Exception e)
        {
        	LogHelper.log(Level.SEVERE, "Could not load capes.");
        }
    }

    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

    public void renderCapes(boolean capes)
    {
        if (capes == true)
        {
            LogHelper.log(Level.INFO, "Loading capes.");
            try
            {
                DeveloperCapesAPI
                        .getInstance()
                        .init("https://dl.dropbox.com/u/17430088/Minecraft%20Mods/DivingGear/UserCapes.txt");
            } catch (Exception e)
            {
                LogHelper.log(Level.WARNING, "Capes failed to load!");
            }

        }
    }
}
