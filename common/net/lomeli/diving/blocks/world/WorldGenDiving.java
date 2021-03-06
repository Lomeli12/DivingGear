package net.lomeli.diving.blocks.world;

import java.util.Random;

import net.lomeli.diving.blocks.ModBlocks;

import net.lomeli.lomlib.worldgen.WorldGenCoral;
//import net.lomeli.lomlib.worldgen.WorldGenSubmergedOre;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenDiving implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
        case 0:
            generateSurface(world, random, chunkX, chunkZ);
        }
    }

    private void generateSurface(World world, Random random, int chunkX,
            int chunkZ) {
        int xCoord = chunkX + random.nextInt(16);
        int zCoord = chunkZ + random.nextInt(16);
        new WorldGenCoral(ModBlocks.coral.blockID, 0, 15).generate(world,
                random, xCoord, random.nextInt(190), zCoord);
        new WorldGenCoral(ModBlocks.coral.blockID, 1, 15).generate(world,
                random, xCoord, random.nextInt(190), zCoord);
        new WorldGenCoral(ModBlocks.coral.blockID, 2, 15).generate(world,
                random, xCoord, random.nextInt(190), zCoord);
        new WorldGenCoral(ModBlocks.coral.blockID, 3, 15).generate(world,
                random, xCoord, random.nextInt(190), zCoord);
        new WorldGenCoral(ModBlocks.coral.blockID, 4, 15).generate(world,
                random, xCoord, random.nextInt(190), zCoord);

    }
}
