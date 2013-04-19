package net.lomeli.diving.config;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.block.BlockAirCompressor;
import net.lomeli.diving.block.BlockCoral;
import net.lomeli.diving.lib.ReferenceIntegers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RegisterBlocks
{

    public static Block coral, airCompressor;

    public static String coralName, airCompressorName;

    public static void registerBlock()
    {
        coral = new BlockCoral(ReferenceIntegers.coralID, Material.glass)
                .setUnlocalizedName("Coral").setHardness(1F).setResistance(3F)
                .setStepSound(Block.soundStoneFootstep)
                .setCreativeTab(DivingGear.divingGearTab);
        airCompressor = new BlockAirCompressor(
                ReferenceIntegers.airCompressorID)
                .setUnlocalizedName("AirCompressor").setHardness(4F)
                .setResistance(5F).setStepSound(Block.soundMetalFootstep)
                .setCreativeTab(DivingGear.divingGearTab);

        GameRegistry.registerBlock(coral, coralName);
        GameRegistry.registerBlock(airCompressor, airCompressorName);

        LanguageRegistry.instance();
        LanguageRegistry.addName(coral, coralName);
        LanguageRegistry.instance();
        LanguageRegistry.addName(airCompressor, airCompressorName);

    }

    public static void registerRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(airCompressor, 1), new Object[] {
                " B ", "CIC", "PRP", 'B', Item.bucketEmpty, 'C',
                RegisterItems.coralFragment, 'I', Item.ingotIron, 'P',
                Block.pistonBase, 'R', Item.redstone });
    }

}
