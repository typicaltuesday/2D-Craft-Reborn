package com.tuesday.tdcr.chunk;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkGeneratorOverworld;

public class ChunkGeneratorOverworld2D extends ChunkGeneratorOverworld
{
	private final World world;

	public ChunkGeneratorOverworld2D(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions)
	{
		super(worldIn, seed, mapFeaturesEnabledIn, generatorOptions);
		
		world = worldIn;
	}
	
	public Chunk generateChunk(int x, int z)
    {
		Chunk chunk = new Chunk(this.world, x, z);
		
		if (z == 0)
		{
			chunk = super.generateChunk(x, z);
			
			for (int xC = 0; xC < 16; ++xC)
			{
				for (int yC = 0; yC < 256; ++yC)
				{
					for (int zC = 4; zC < 16; ++zC)
					{
						chunk.setBlockState(new BlockPos(xC, yC, zC), Blocks.AIR.getDefaultState());
					}
					
					chunk.setBlockState(new BlockPos(xC, yC, 0), Blocks.BARRIER.getDefaultState());
					chunk.setBlockState(new BlockPos(xC, yC, 3), Blocks.BARRIER.getDefaultState());
				}
			}
		}
		
		return chunk;
    }
	
	public void populate(int x, int z)
    {
		if (z == 0)
		{
			super.populate(x, z);
		}
    }
	
	public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
		return z == 0 ? super.generateStructures(chunkIn, x, z) : false;
    }
}
