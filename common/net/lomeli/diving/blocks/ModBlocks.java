package net.lomeli.diving.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.lomeli.diving.blocks.coral.BlockCoral;
import net.lomeli.diving.blocks.coral.ItemCoral;
import net.lomeli.diving.lib.ItemIDs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlocks {
    public static String[] coralColors = { "Red", "Blue", "Orange", "Green",
            "Pink" };

    // Coral
    public static Block coral;
    public static ItemStack redCoral, blueCoral, orangeCoral, greenCoral,
            pinkCoral;

    // Machines
    public static Block waterMill, airCompressor;

    public static void loadBlocks() {
        waterMill = new BlockWaterMill(ItemIDs.waterMillID)
                .setUnlocalizedName("watermill");
        airCompressor = new BlockAirCompressor(ItemIDs.airCompressorID)
                .setUnlocalizedName("airCompressor");

        GameRegistry.registerBlock(waterMill, "Water Mill");
        GameRegistry.registerBlock(airCompressor, "Air Compressor");

        LanguageRegistry.addName(waterMill, "Water Mill");
        LanguageRegistry.addName(airCompressor, "Air Compressor");

        coral = new BlockCoral(ItemIDs.coralID, "coral");

        GameRegistry.registerBlock(coral, ItemCoral.class, "Coral");
        for (int i = 0; i < 5; i++) {
            LanguageRegistry.addName(new ItemStack(coral, 1, i), coralColors[i]
                    + " Coral");
        }
        redCoral = new ItemStack(coral, 1, 0);
        blueCoral = new ItemStack(coral, 1, 1);
        orangeCoral = new ItemStack(coral, 1, 2);
        greenCoral = new ItemStack(coral, 1, 3);
        pinkCoral = new ItemStack(coral, 1, 4);
    }
}
