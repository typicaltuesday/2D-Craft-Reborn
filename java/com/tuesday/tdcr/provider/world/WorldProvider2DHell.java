package com.tuesday.tdcr.provider.world;

import com.tuesday.tdcr.provider.chunk.ChunkProvider2DHell;

import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProvider2DHell extends WorldProviderHell
{

	public IChunkProvider createChunkGenerator()
	{

		return new ChunkProvider2DHell(this.worldObj, this.worldObj.getSeed());
	}
	
	public boolean canCoordinateBeSpawn(int x, int z)
    {
		
    	return z == 0;
    }
}