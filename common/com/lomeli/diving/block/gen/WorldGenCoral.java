package com.lomeli.diving.block.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.lomeli.diving.config.RegisterBlocks;

public class WorldGenCoral extends WorldGenerator
{
    /** The block ID for coral. */
    private int coralID;

    /** The number of blocks to generate. */
    private int numberOfBlocks;

    public WorldGenCoral(int amount)
    {
        coralID = RegisterBlocks.coral.blockID;
        numberOfBlocks = amount;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3,
            int par4, int par5)
    {
        if (par1World.getBlockMaterial(par3, par4, par5) != Material.water)
            return false;
        else
        {
            int var6 = par2Random.nextInt(numberOfBlocks) + 2;
            byte var7 = 1;

            for (int var8 = par3 - var6; var8 <= par3 + var6; ++var8)
            {
                for (int var9 = par5 - var6; var9 <= par5 + var6; ++var9)
                {
                    int var10 = var8 - par3;
                    int var11 = var9 - par5;

                    if (var10 * var10 + var11 * var11 <= var6 * var6)
                    {
                        for (int var12 = par4 - var7; var12 <= par4 + var7; ++var12)
                        {
                            int var13 = par1World.getBlockId(var8, var12, var9);

                            if (var13 == Block.dirt.blockID
                                    || var13 == Block.sand.blockID
                                    || var13 == Block.blockClay.blockID
                                    || var13 == Block.stone.blockID)
                            {
                                par1World.setBlock(var8, var12, var9, coralID);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}