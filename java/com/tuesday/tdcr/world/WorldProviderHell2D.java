package com.tuesday.tdcr.world;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.chunk.ChunkGeneratorHell2D;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderHell2D extends WorldProviderHell
{
	public WorldProviderHell2D()
	{
		setDimension(TDCR.dimNether2D);
	}
	
	public DimensionType getDimensionType()
    {
        return DimensionType.getById(getDimension());
    }
	
	public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorHell2D(this.world, this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getSeed());
    }
}
