package com.tuesday.tdcr.handlers;

import org.lwjgl.input.Keyboard;

import com.tuesday.tdcr.TDCR;
import com.tuesday.tdcr.camera.EntityCamera;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.player.EntityPlayer;

public class CameraHandler
{

	private final Minecraft mc = Minecraft.getMinecraft();
	
	private boolean isDown = false;
	private int index = 0;
	
	private EntityRenderer renderer, prevRenderer;

	@SubscribeEvent
	public void onSwapEntityRenderer(TickEvent event)
	{

		if(event.phase == Phase.START)
		{

			if(TDCR.doCustomRender)
			{

				if(renderer == null) renderer = new EntityCamera(mc, mc.getResourceManager());

				if(!mc.entityRenderer.equals(renderer))
				{
					
					prevRenderer = mc.entityRenderer;
					mc.entityRenderer = renderer;
				}
			}
			
			else if(prevRenderer != null && !mc.entityRenderer.equals(prevRenderer)) mc.entityRenderer = prevRenderer;
		}
	}
	
	@SubscribeEvent
	public void onKeyDown(KeyInputEvent event)
	{
		
		boolean isPressed = Keyboard.isKeyDown(mc.gameSettings.keyBindTogglePerspective.getKeyCode());
		
		if(isPressed) isDown = true;
		
		if(!isPressed && isDown)
		{
			
			index++;
			isDown = false;
		}
		
		index = index > 3 ? 0 : index;
		
		switch(index)
		{
			
			case 0:
			case 1:
			case 2:
				TDCR.doCustomRender = false;
				this.mc.gameSettings.thirdPersonView = index;
				break;
				
			case 3:
				TDCR.doCustomRender = true;
				this.mc.gameSettings.thirdPersonView = 3;
				break;
		}
	}
}