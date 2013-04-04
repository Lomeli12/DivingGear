package com.lomeli.diving.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceIntegers;
import com.lomeli.diving.thaumcraft.config.RegisterThaum;

public class ConfigMod
{
    public static boolean hardcore;

    /**
     * Registered all the id(s) for all the items and other variables
     */
    public static void configureIDs(String Loc)
    {
        Configuration config = new Configuration(new File(Loc,
                "DivingGearIDs.cfg"));

        config.load();

        ReferenceIntegers.SnorkelID = config.get("Gear", "Snorkel", 6050)
                .getInt(6050);
        ReferenceIntegers.ADS_TID = config.get("Gear", "ADS-T", 6051).getInt(
                6051);
        ReferenceIntegers.Scuba1ID = config.get("Gear", "Scuba1", 6052).getInt(
                6052);
        ReferenceIntegers.Scuba2ID = config.get("Gear", "Scuba2", 6053).getInt(
                6053);

        ReferenceIntegers.airTankID = config.get("Item", "AirTank", 6060)
                .getInt(6060);
        ReferenceIntegers.doubleTankID = config.get("Item", "DoubleTank", 6061)
                .getInt(6061);
        ReferenceIntegers.coralFragmentID = config.get("Item", "CoralFragment",
                6062).getInt(6062);

        ReferenceIntegers.pickaxeCoralID = config.get("Tools", "CoralPick",
                6070).getInt(6070);
        ReferenceIntegers.shovelCoralID = config.get("Tools", "CoralSpade",
                6071).getInt(6071);
        ReferenceIntegers.swordCoralID = config
                .get("Tools", "CoralSword", 6072).getInt(6072);

        ReferenceIntegers.thaumADS_ID = config.get("ThaumGear", "AqualisH",
                6080).getInt(6080);
        ReferenceIntegers.thaumTankID = config
                .get("ThaumGear", "VisTank", 6081).getInt(6081);

        ReferenceIntegers.coralID = config.get("Blocks", "Coral1", 600).getInt(
                600);
        ReferenceIntegers.airCompressorID = config.get("Blocks",
                "AirCompressor", 601).getInt(601);

        config.save();
    }

    /**
     * Allows users to modify the amount of air the helms give and how many
     * times they do.
     */
    public static void airConfigure(String Loc)
    {
        Configuration config = new Configuration(new File(Loc,
                "DivingGearAirDuration.cfg"));

        config.load();

        ReferenceIntegers.snorkelUses = config.get("Uses", "Snorkel-Uses", 1)
                .getInt(1);
        ReferenceIntegers.snorkelAmount = config.get("Air",
                "Snorkel-AirAmount", 150).getInt(150);

        ReferenceIntegers.adsUses = config.get("Uses", "ADS-Tritonia-Uses", 1)
                .getInt(1);
        ReferenceIntegers.adsAmount = config.get("Air",
                "ADS-Tritonia-AirAmount", 300).getInt(300);

        ReferenceIntegers.scuba1Uses = config.get("Uses", "Scuba1-Uses", 3)
                .getInt(3);
        ReferenceIntegers.scuba1Amount = config.get("Air", "Scuba1-AirAmount",
                300).getInt(300);

        ReferenceIntegers.scuba2Uses = config.get("Uses", "Scuba2-Uses", 6)
                .getInt(6);
        ReferenceIntegers.scuba2Amount = config.get("Air", "Scuba2-AirAmount",
                300).getInt(300);

        ReferenceIntegers.coralToolUsage = config
                .get("Uses", "CoralTools", 500).getInt(500);

        // Thaumcraft
        ReferenceIntegers.thaumAmount = config.get("Air", "Aqualis-AirAmount",
                300).getInt(300);
        ReferenceIntegers.fluxAmount = config.get("Flux", "Aqualis-FluxAmount",
                2).getInt(2);
        ReferenceIntegers.visArea = config.get("FluxRange",
                "Aqualis-FluxRange", 300).getInt(300);

        config.save();
    }

    /**
     * Saves item names to a config file that allows the community to translate
     * it into other languages.
     */
    public static void loadLanguages(String Loc)
    {
        Configuration config = new Configuration(new File(Loc,
                "DivingGearLang.cfg"));

        config.load();

        RegisterItems.SnorkelName = config.get("Gear", "Snorkel", "Snorkel")
                .getString();
        RegisterItems.ADS_TName = config
                .get("Gear", "ADS-T", "ADS: 'Tritonia'").getString();
        RegisterItems.Scuba1Name = config.get("Gear", "Scuba1",
                "Scuba: Single Air Tank").getString();
        RegisterItems.Scuba2Name = config.get("Gear", "Scuba2",
                "Scuba: Double Air Tank").getString();

        RegisterItems.airTankName = config.get("Item", "AirTank", "Air Tank")
                .getString();
        RegisterItems.doubleTankName = config.get("Item", "DoubleTank",
                "Double Air Tank").getString();
        RegisterItems.coralFragmentName = config.get("Item", "CoralFragment",
                "Coral Fragment").getString();

        RegisterItems.coralPickName = config.get("Tools", "CoralPick",
                "Coral Pickaxe").getString();
        RegisterItems.coralShovelName = config.get("Tools", "CoralSpade",
                "Coral Shovel").getString();
        RegisterItems.coralSwordName = config.get("Tools", "CoralSword",
                "Coral Sword").getString();

        RegisterThaum.thaumADS_Name = config.get("ThaumGear", "AqualisH",
                "Aqualis Helm").getString();
        RegisterThaum.thaumTankName = config.get("ThaumGear", "VisTank",
                "Vis Tank").getString();

        RegisterBlocks.coralName = config.get("Blocks", "Coral1", "Coral")
                .getString();
        RegisterBlocks.airCompressorName = config.get("Blocks",
                "AirCompressor", "Air Compressor").getString();

        config.save();
    }

    /**
     * Get/Sets the options for certain options.
     */
    public static void configureOptions(String Loc)
    {
        Configuration config = new Configuration(new File(Loc,
                "DivingGearOptions.cfg"));

        config.load();

        hardcore = config.get("Options", "hardmode", false).getBoolean(false);

        DivingGear.capesOn = config.get("Options", "enable-capes", true)
                .getBoolean(true);

        ReferenceIntegers.coralGenerationRate = config.get("Options",
                "CoralGenRate", 6).getInt(6);

        config.save();
    }
}
