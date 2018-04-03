package com.tuesday.tdcr.provider.world;

import com.tuesday.tdcr.provider.chunk.ChunkProvider2DEnd;

import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProvider2DEnd extends WorldProviderEnd
{

	public IChunkProvider createChunkGenerator()
	{

		return new ChunkProvider2DEnd(this.worldObj, this.worldObj.getSeed());
	}
	
	public boolean canCoordinateBeSpawn(int x, int z)
    {
		
    	return z == 0;
    }
}