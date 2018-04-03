package com.tuesday.tdcr;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler2D
{
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
		if (event.player.world.getWorldType().getName().equals(TDCR.worldName))
		{
			NBTTagCompound playerData = event.player.getEntityData();
			NBTTagCompound data = playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
			
			if (!data.getBoolean("init_spawn"))
			{
				event.player.changeDimension(TDCR.dimOverworld2D);
				data.setBoolean("init_spawn", true);
				playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
				
				System.out.print("SPAWNED\t**********\tSPAWNED");
			}
		}
	}
}
