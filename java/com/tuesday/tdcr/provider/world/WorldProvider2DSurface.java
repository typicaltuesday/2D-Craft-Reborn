package com.tuesday.tdcr.provider.world;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.provider.chunk.ChunkProvider2DWorld;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProvider2DSurface extends WorldProviderSurface
{
	
//	@Override
//	public boolean canCoordinateBeSpawn(int x, int z)
//  {
//		
//		if(TDCR.instance.isWorld2D(this.worldObj)) return z == 0;
//		
//		return super.canCoordinateBeSpawn(x, z);
//  }
	
	@Override
	public ChunkCoordinates getRandomizedSpawnPoint()
    {
		
		if(TDCR.instance.isWorld2D(this.worldObj))
		{
			
			ChunkCoordinates spawn = new ChunkCoordinates(this.worldObj.getSpawnPoint());
			spawn.posZ = 0;
			
			return spawn;
		}
		
		return super.getRandomizedSpawnPoint();
    }
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		
		if(TDCR.instance.isWorld2D(this.worldObj)) return new ChunkProvider2DWorld(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
		
		return this.terrainType.getChunkGenerator(this.worldObj, this.field_82913_c);
	}
}