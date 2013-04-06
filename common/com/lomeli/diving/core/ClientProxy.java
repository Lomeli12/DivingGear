package com.lomeli.diving.core;

import java.util.logging.Level;

import net.minecraftforge.client.MinecraftForgeClient;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.client.render.item.ItemCoralRenderer;
import com.lomeli.diving.config.RegisterBlocks;
import com.lomeli.diving.core.capes.DeveloperCapesAPI;
import com.lomeli.diving.core.helper.LogHelper;
import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.TileEntityCoral;
import com.lomeli.diving.tileentity.TileEntityCoralRenderer;

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
        ClientRegistry.registerTileEntity(TileEntityCoral.class, "coral",
                new TileEntityCoralRenderer());
        MinecraftForgeClient.registerItemRenderer(RegisterBlocks.coral.blockID,
                new ItemCoralRenderer());
        renderCapes(DivingGear.capesOn);
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

        } else
        {
        }
    }
}
