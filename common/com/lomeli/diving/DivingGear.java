package com.lomeli.diving;

import net.minecraft.creativetab.CreativeTabs;

import com.lomeli.diving.block.gen.CoralGen;
import com.lomeli.diving.config.ConfigMod;
import com.lomeli.diving.config.RegisterBlocks;
import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.core.CommonProxy;
import com.lomeli.diving.core.CreativeTabDiving;
import com.lomeli.diving.lib.ReferenceStrings;
import com.lomeli.diving.thaumcraft.ThaumCraftSupport;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ReferenceStrings.modID, name = ReferenceStrings.modName, version = ReferenceStrings.version)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DivingGear
{
    @SidedProxy(clientSide = ReferenceStrings.clientProxy, serverSide = ReferenceStrings.commonProxy)
    public static CommonProxy proxy;

    @Instance(ReferenceStrings.modID)
    public static DivingGear instance;

    public static CreativeTabs divingGearTab = new CreativeTabDiving(
            CreativeTabs.getNextID(), ReferenceStrings.modName);

    public static String configDir;

    public static boolean capesOn;

    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        configDir = event.getModConfigurationDirectory() + "\\DivingGearMod\\";

        // Loading Configs.
        ConfigMod.configureIDs(configDir);
        ConfigMod.airConfigure(configDir);
        ConfigMod.loadLanguages(configDir);
        ConfigMod.configureOptions(configDir);
    }

    @Init
    public void main(FMLInitializationEvent event)
    {
        // Registers mod items and blocks.
        RegisterItems.registerArmor();
        RegisterItems.registerItems();
        RegisterItems.registerTools();
        RegisterBlocks.registerBlock();

        // Register Recipes.
        RegisterItems.registerRecipes();
        RegisterBlocks.registerRecipes();

        // Checking if Thaumcraft is installed.
        ThaumCraftSupport.isThaumInstalled();

        // Starting world Gen.
        GameRegistry.registerWorldGenerator(new CoralGen());

        // Rendering stuff
        proxy.initRendering();
    }

    @PostInit
    public void postLoad(FMLPostInitializationEvent event)
    {
        // LogHelper.log(Level.INFO, "Testing 1...2...3...");
    }
}
