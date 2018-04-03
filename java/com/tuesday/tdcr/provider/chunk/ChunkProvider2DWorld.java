
package com.tuesday.tdcr.provider.chunk;

import java.util.Random;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.WorldType2D;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;

public class ChunkProvider2DWorld extends ChunkProviderGenerate
{

	private Random rand;
	private double[] stoneNoise = new double[256];
	private NoiseGeneratorPerlin noiseGenPerl;
	private World worldObj;

	public ChunkProvider2DWorld(World world, long seed, boolean mapFeatures)
	{

		super(world, seed, mapFeatures);

		this.rand = new Random(seed);
		this.noiseGenPerl = new NoiseGeneratorPerlin(this.rand, 4);
	}
	
	public void replaceBlocksForBiome(int x, int z, Block[] blocks, byte[] meta, BiomeGenBase[] biomes)
	{
		
		super.replaceBlocksForBiome(x, z, blocks, meta, biomes);
		
		blockBarrier(x, z, blocks);
	}
	
	private void blockBarrier(int x, int z, Block[] blocks)
	{
		
		for(int k = 0; k < 16; ++k)
		{
			
			for(int l = 0; l < 16; ++l)
			{
				
				int xk = x * 16 + k;
				int zl = z * 16 + l;
				int hb = blocks.length / 256;
				
				int xkb = xk & 15;
				int zlb = zl & 15;

				for(int height = 255; height >= 0; --height)
				{

					int b = (zlb * 16 + xkb) * hb + height;
					
					boolean isInPChunk = z == 0 && (k == 2 || k == 3);
					boolean isInNChunk = z == -1 && (k == 14 || k == 15);

					if(k > 1) blocks[b] = null;
					if(isInPChunk || isInNChunk) blocks[b] = TDCR.blockBarrier;
					if(z != 0 && !isInNChunk) blocks[b] = null;
				}
			}
		}
	}
}