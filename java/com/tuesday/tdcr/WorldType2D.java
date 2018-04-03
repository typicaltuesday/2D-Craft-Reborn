package com.tuesday.tdcr;

import com.tuesday.tdcr.provider.chunk.ChunkProvider2DWorld;
import com.tuesday.tdcr.provider.world.WorldProvider2DEnd;
import com.tuesday.tdcr.provider.world.WorldProvider2DHell;
import com.tuesday.tdcr.provider.world.WorldProvider2DSurface;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldType2D extends WorldType
{

	public WorldType2D()
	{
		
		super("twod");
	}
	
	public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
		
        return new ChunkProvider2DWorld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
    }
	
	public boolean isCustomizable()
	{
		
		return false;
	}
	
	public int getSpawnFuzz()
    {
		
    	return 1;
    }
}