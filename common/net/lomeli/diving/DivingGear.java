package net.lomeli.diving;

import net.lomeli.diving.core.CommonProxy;
import net.lomeli.diving.items.ModItems;
import net.lomeli.diving.lib.ModInts;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.blocks.ModBlocks;
import net.lomeli.diving.blocks.world.WorldGenDiving;
import net.lomeli.diving.core.Config;
import net.lomeli.diving.core.CreativeTabDG;
import net.lomeli.diving.core.ModRecipes;
import net.lomeli.diving.core.handler.GuiHandler;
import net.lomeli.lomlib.util.UpdateHelper;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModStrings.MOD_ID, name = ModStrings.MOD_NAME, version = ModStrings.VERSION, dependencies = "required-after:LomLib@[1.0.2,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DivingGear {
    public static boolean checkForUpdates;

    @Mod.Instance(ModStrings.MOD_ID)
    public static DivingGear instance;

    @SidedProxy(clientSide = ModStrings.CLIENT, serverSide = ModStrings.COMMON)
    public static CommonProxy proxy;

    public static CreativeTabs modTab = new CreativeTabDG(
            CreativeTabs.getNextID(), ModStrings.MOD_NAME);

    public static UpdateHelper updater = new UpdateHelper();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.configureMod(event.getSuggestedConfigurationFile());

        try {
            if (checkForUpdates)
                updater.check(ModStrings.MOD_NAME, ModStrings.UPDATE_URL,
                        ModInts.MAJOR, ModInts.MINOR, ModInts.REVISION);
        } catch (Exception e) {
        }

        ModItems.loadItems();
        ModBlocks.loadBlocks();

        ModRecipes.loadRecipes();

        proxy.registerTickHandler();

        // proxy.registerKeyHandler();
    }

    @Mod.EventHandler
    public void main(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGenDiving());
        NetworkRegistry.instance().registerGuiHandler(instance,
                new GuiHandler());

        proxy.registerTileEntities();
    }

    @Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent event) {
        ModRecipes.addonRecipes();
    }
}
