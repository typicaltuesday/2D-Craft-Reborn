package com.tuesday.tdcr;

import com.tuesday.tdcr.chunk.ChunkGeneratorOverworld2D;

import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;

public class WorldType2D extends WorldType
{
	public WorldType2D(String name)
	{
		super(name);
	}
	
	public net.minecraft.world.gen.IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
		return new ChunkGeneratorOverworld2D(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }
}
