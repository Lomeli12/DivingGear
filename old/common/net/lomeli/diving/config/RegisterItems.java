package net.lomeli.diving.config;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.armor.ItemGear;
import net.lomeli.diving.item.ItemAirTank;
import net.lomeli.diving.item.ItemDiving;
import net.lomeli.diving.item.tools.ItemCoralPickaxe;
import net.lomeli.diving.item.tools.ItemCoralShovel;
import net.lomeli.diving.item.tools.ItemCoralSword;
import net.lomeli.diving.lib.ReferenceIntegers;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterItems
{

    public static Item Snorkel, ADS_T, Scuba1, Scuba2;

    public static Item airTank, doubleTank, coralFragment;

    public static Item coralPick, coralShovel, coralSword;

    public static String SnorkelName, ADS_TName, Scuba1Name, Scuba2Name;

    public static String airTankName, doubleTankName, coralFragmentName;

    public static String coralPickName, coralShovelName, coralSwordName;

    public static void registerArmor()
    {
        Snorkel = new ItemGear(ReferenceIntegers.SnorkelID,
                EnumArmorMaterial.CHAIN, DivingGear.proxy.addArmor("Snorkel"),
                0, ReferenceIntegers.snorkelUses,
                ReferenceIntegers.snorkelAmount, "snorkel", "snorkelModel")
                .setUnlocalizedName("Snorkel").setCreativeTab(
                DivingGear.divingGearTab);
        ADS_T = new ItemGear(ReferenceIntegers.ADS_TID, EnumArmorMaterial.IRON,
                DivingGear.proxy.addArmor("Snorkel"), 0,
                ReferenceIntegers.adsUses, ReferenceIntegers.adsAmount, "ads",
                "ADSModel").setUnlocalizedName("ADS-T").setCreativeTab(
                DivingGear.divingGearTab);
        Scuba1 = new ItemGear(ReferenceIntegers.Scuba1ID,
                EnumArmorMaterial.DIAMOND,
                DivingGear.proxy.addArmor("Snorkel"), 0,
                ReferenceIntegers.scuba1Uses, ReferenceIntegers.scuba1Amount,
                "scuba", "scubahelmModel").setUnlocalizedName("Scuba1")
                .setCreativeTab(DivingGear.divingGearTab);
        Scuba2 = new ItemGear(ReferenceIntegers.Scuba2ID,
                EnumArmorMaterial.DIAMOND,
                DivingGear.proxy.addArmor("Snorkel"), 0,
                ReferenceIntegers.scuba2Uses, ReferenceIntegers.scuba2Amount,
                "scuba2", "scuba2helmModel").setUnlocalizedName("Scuba2")
                .setCreativeTab(DivingGear.divingGearTab);

        LanguageRegistry.addName(Snorkel, SnorkelName);
        LanguageRegistry.addName(ADS_T, ADS_TName);
        LanguageRegistry.addName(Scuba1, Scuba1Name);
        LanguageRegistry.addName(Scuba2, Scuba2Name);
    }

    public static void registerItems()
    {
        airTank = new ItemAirTank(ReferenceIntegers.airTankID, "airtank", 150)
                .setUnlocalizedName("AirTank").setCreativeTab(
                        DivingGear.divingGearTab);
        doubleTank = new ItemAirTank(ReferenceIntegers.doubleTankID, "double", 300)
                .setUnlocalizedName("DoubleTank").setCreativeTab(
                        DivingGear.divingGearTab);
        coralFragment = new ItemDiving(ReferenceIntegers.coralFragmentID,
                "coralshard").setUnlocalizedName("CoralShard").setCreativeTab(
                DivingGear.divingGearTab);

        LanguageRegistry.addName(airTank, airTankName);
        LanguageRegistry.addName(doubleTank, doubleTankName);
        LanguageRegistry.addName(coralFragment, coralFragmentName);
    }

    public static void registerTools()
    {
        coralPick = new ItemCoralPickaxe(ReferenceIntegers.pickaxeCoralID)
                .setUnlocalizedName("coralpick").setCreativeTab(
                        DivingGear.divingGearTab);
        coralShovel = new ItemCoralShovel(ReferenceIntegers.shovelCoralID)
                .setUnlocalizedName("coralspade").setCreativeTab(
                        DivingGear.divingGearTab);
        coralSword = new ItemCoralSword(ReferenceIntegers.swordCoralID)
                .setUnlocalizedName("coralsword").setCreativeTab(
                        DivingGear.divingGearTab);

        LanguageRegistry.addName(coralPick, coralPickName);
        LanguageRegistry.addName(coralShovel, coralShovelName);
        LanguageRegistry.addName(coralSword, coralSwordName);
    }

    public static void registerRecipes()
    {
        // Items
        GameRegistry.addRecipe(new ItemStack(airTank, 1), new Object[] { "IGI",
                "IGI", "LIL", 'I', Item.ingotIron, 'G', Item.glassBottle, 'L',
                new ItemStack(Item.dyePowder, 1, 4) });
        GameRegistry.addRecipe(new ItemStack(doubleTank, 1),
                new Object[] { "SIS", "TST", 'I', Item.ingotIron, 'S',
                        Item.silk, 'T', airTank });

        // Diving Gear
        GameRegistry.addRecipe(new ItemStack(Snorkel, 1), new Object[] { "I I",
                "GSG", "LTL", 'L', new ItemStack(Item.dyePowder, 1, 4), 'I',
                Item.ingotIron, 'S', Item.silk, 'G', Block.thinGlass, 'T',
                Item.glassBottle });
        GameRegistry.addRecipe(new ItemStack(ADS_T, 1), new Object[] { "IVI",
                "IGI", "III", 'I', Item.ingotIron, 'V', Block.vine, 'G',
                Block.glass });
        GameRegistry.addRecipe(new ItemStack(Scuba1, 1), new Object[] { "LIL",
                "ITI", "RIR", 'L', new ItemStack(Item.dyePowder, 1, 4), 'I',
                Item.ingotIron, 'R', Item.leather, 'T', airTank });
        GameRegistry.addRecipe(new ItemStack(Scuba2, 1), new Object[] { "LIL",
                "ITI", "RIR", 'L', new ItemStack(Item.dyePowder, 1, 4), 'I',
                Item.ingotIron, 'R', Item.leather, 'T', doubleTank });

        // Tools
        GameRegistry.addRecipe(new ItemStack(coralPick, 1), new Object[] {
                "CCC", " S ", " S ", 'C', coralFragment, 'S', Item.stick });
        GameRegistry.addRecipe(new ItemStack(coralShovel, 1), new Object[] {
                "C", "S", "S", 'C', coralFragment, 'S', Item.stick });
        GameRegistry.addRecipe(new ItemStack(coralSword, 1), new Object[] {
                "C", "C", "S", 'C', coralFragment, 'S', Item.stick });
    }
}
