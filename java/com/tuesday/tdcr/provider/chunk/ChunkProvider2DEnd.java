
package com.tuesday.tdcr.provider.chunk;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.WorldType2D;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;

public class ChunkProvider2DEnd extends ChunkProviderEnd
{
	
	private World endWorld;

	public ChunkProvider2DEnd(World world, long seed)
	{

		super(world, seed);
		
		this.endWorld = world;
	}
	
	public void replaceBiomeBlocks(int x, int z, Block[] blocks, BiomeGenBase[] biomes, byte[] meta)
    {
		
        super.replaceBiomeBlocks(x, z, blocks, biomes, meta);
        
        blockBarrier(x, z, blocks);
    }
	
	private void blockBarrier(int x, int z, Block[] blocks)
	{
		
		for(int k = 0; k < 16; ++k)
        {
        	
            for(int l = 0; l < 16; ++l)
            {
                
                for(int height = 127; height >= 0; --height)
                {
                	
                	int b = (l * 16 + k) * 128 + height;
                	
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