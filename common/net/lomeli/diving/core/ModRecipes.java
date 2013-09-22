package net.lomeli.diving.core;

import net.lomeli.diving.blocks.ModBlocks;
import net.lomeli.diving.items.ModItems;

import net.lomeli.lomlib.item.ItemUtil;
import net.lomeli.lomlib.util.ModLoaded;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static int wild = OreDictionary.WILDCARD_VALUE;

    public static void loadRecipes() {
        loadBlockRecipes();
        loadItemRecipes();
    }

    public static void addonRecipes() {
        if (ModLoaded.isModInstalled("BuildCraft|Core", false)) {
            ItemStack gear = ItemUtil.getItem("woodenGearItem",
                    "buildcraft.BuildCraftCore");
            GameRegistry.addRecipe(new ItemStack(ModBlocks.waterMill),
                    new Object[] { "SIS", "G G", "ISI", 'S', Block.cobblestone,
                            'I', Item.ingotIron, 'G', gear });
            GameRegistry.addRecipe(new ItemStack(ModBlocks.airCompressor),
                    new Object[] { "III", "FGF", "CRC", 'I', Item.ingotIron,
                            'G', gear, 'F', ModItems.filter, 'C',
                            Block.cobblestone, 'R', Item.redstone });
        } else {
            GameRegistry.addRecipe(new ItemStack(ModBlocks.waterMill),
                    new Object[] { "SIS", "G G", "ISI", 'S', Block.cobblestone,
                            'I', Item.ingotIron, 'G', ModItems.simpleGear });
            GameRegistry.addRecipe(new ItemStack(ModBlocks.airCompressor),
                    new Object[] { "III", "FGF", "CRC", 'I', Item.ingotIron,
                            'G', ModItems.simpleGear, 'F', ModItems.filter,
                            'C', Block.cobblestone, 'R', Item.redstone });
            GameRegistry.addRecipe(new ItemStack(ModItems.simpleGear, 2),
                    new Object[] { " S ", "SWS", " S ", 'S', Item.stick, 'W',
                            Block.planks });
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
                    ModItems.simpleGear, 2), true, " S ", "SWS", " S ", 'S',
                    Item.stick, 'W', "plankWood"));
        }
    }

    private static void loadBlockRecipes() {
        // TODO Add recipes for other blocks
    }

    private static void loadItemRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.airTank, 1, 1),
                new Object[] { "IGI", "IGI", "LIL", 'I', Item.ingotIron, 'G',
                        Item.glassBottle, 'L',
                        new ItemStack(Item.dyePowder, 1, 4) });
        GameRegistry.addRecipe(new ItemStack(ModItems.doubleAirTank),
                new Object[] { "SIS", "TST", 'S', Item.silk, 'I',
                        Item.ingotIron, 'T', ModItems.airTank });
        GameRegistry.addRecipe(new ItemStack(ModItems.filter), new Object[] {
                "FRF", "RIR", "FRF", 'R', Item.redstone, 'F', Block.fenceIron,
                'I', Item.ingotIron });
        GameRegistry.addRecipe(new ItemStack(ModItems.snorkel), new Object[] {
                "I I", "GSG", "LTL", 'I', Item.ingotIron, 'G', Block.thinGlass,
                'S', Item.silk, 'T', Item.glassBottle, 'T',
                new ItemStack(Item.dyePowder, 1, 4) });
        GameRegistry.addRecipe(new ItemStack(ModItems.ADS), new Object[] {
                "III", "IGI", "III", 'I', Item.ingotIron, 'G', Block.glass });
        GameRegistry
                .addRecipe(new ItemStack(ModItems.scuba), new Object[] { "LIL",
                        "ITI", "RIR", 'L', new ItemStack(Item.dyePowder, 1, 4),
                        'I', Item.ingotIron, 'R', Item.leather, 'T',
                        ModItems.airTank });
        GameRegistry.addRecipe(new ItemStack(ModItems.advScuba), new Object[] {
                "LIL", "ITI", "RIR", 'L', new ItemStack(Item.dyePowder, 1, 4),
                'I', Item.ingotIron, 'R', Item.leather, 'T',
                ModItems.doubleAirTank });
    }
}
