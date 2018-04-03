package com.tuesday.tdcr.handlers;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.provider.chunk.ChunkProvider2DHell;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

public class TerrainHandler
{

	private final Minecraft mc = Minecraft.getMinecraft();
	
	@SubscribeEvent
	public void onSaplingGrowth(SaplingGrowTreeEvent event)
	{
		if(TDCR.instance.isWorld2D(event.world))
		{
			
			for(int x = event.x - 8; x < event.x + 8; x++)
			{
				
				for(int y = event.y - 8; y < 256; y++)
				{
					
					if(!mc.theWorld.getBlock(x, y, -1).equals(TDCR.blockBarrier)) mc.theWorld.setBlock(x, y, -1, TDCR.blockBarrier);
					if(!mc.theWorld.getBlock(x, y,  2).equals(TDCR.blockBarrier)) mc.theWorld.setBlock(x, y,  2, TDCR.blockBarrier);
				}
			}
		}
	}
}