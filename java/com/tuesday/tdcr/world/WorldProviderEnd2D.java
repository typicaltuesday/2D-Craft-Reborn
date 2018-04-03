package com.tuesday.tdcr.world;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.chunk.ChunkGeneratorEnd2D;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderEnd2D extends WorldProviderEnd
{
	public WorldProviderEnd2D()
	{
		setDimension(TDCR.dimEnd2D);
	}
	
	public DimensionType getDimensionType()
    {
        return DimensionType.getById(getDimension());
    }
	
	public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorEnd2D(this.world, this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getSeed(), this.getSpawnCoordinate());
    }
}
