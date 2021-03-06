package net.lomeli.diving.block.gen;

import java.util.Random;

import net.lomeli.diving.lib.ReferenceIntegers;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;


import cpw.mods.fml.common.IWorldGenerator;

public class CoralGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }

    }

    private void generateSurface(World world, Random random, int blockX,
            int blockZ)
    {
        int Xcoord = blockX + random.nextInt(16);
        int Ycoord = random.nextInt(80);
        int Zcoord = blockZ + random.nextInt(16);
        new WorldGenCoral(ReferenceIntegers.coralGenerationRate).generate(
                world, random, Xcoord, Ycoord, Zcoord);
    }
}
