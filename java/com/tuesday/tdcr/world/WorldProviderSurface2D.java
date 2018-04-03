package com.tuesday.tdcr.world;

import com.tuesday.tdcr.TDCR;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.GameType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldServer;

public class WorldProviderSurface2D extends WorldProviderSurface
{
	public WorldProviderSurface2D()
	{
		setDimension(TDCR.dimOverworld2D);
	}
	
	public DimensionType getDimensionType()
    {
        return DimensionType.getById(getDimension());
    }
	
	public BlockPos getRandomizedSpawnPoint()
    {
        int x = super.getRandomizedSpawnPoint().getX();

        return world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, 0));
    }
}
