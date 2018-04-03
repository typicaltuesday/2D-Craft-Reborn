package com.tuesday.tdcr;

import java.util.Hashtable;

import com.tuesday.tdcr.blocks.BlockBarrier;
import com.tuesday.tdcr.handlers.CameraHandler;
import com.tuesday.tdcr.handlers.TerrainHandler;
import com.tuesday.tdcr.provider.world.WorldProvider2DEnd;
import com.tuesday.tdcr.provider.world.WorldProvider2DHell;
import com.tuesday.tdcr.provider.world.WorldProvider2DSurface;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

@Mod(name = TDCR.NAME, modid = TDCR.MODID, version = TDCR.VERSION)
public class TDCR
{
	public static final String NAME = "2D Craft : Reborn";
	public static final String MODID = "tdcr";
	public static final String VERSION = "Beta";
	
	public static final String CONSOLE_HEADER = "[TSD 2D]" + "   ";
	
	@Instance(TDCR.MODID)
	public static TDCR instance;
	
	
	//CAMERA
	public static boolean doCustomRender = false;
	public static float cameraDistance = 5.0F;
	
	public static WorldType world2D;
	
	public static Block blockBarrier;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.blockBarrier = new BlockBarrier();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.world2D = new WorldType2D();
		
		Hashtable<Integer, Class<? extends WorldProvider>> providers = ReflectionHelper.getPrivateValue(DimensionManager.class, null, "providers");
        providers.put(-1, WorldProvider2DHell.class);
        providers.put( 0, WorldProvider2DSurface.class);
        providers.put( 1, WorldProvider2DEnd.class);
        
        MinecraftForge.EVENT_BUS.register(new CameraHandler());
		FMLCommonHandler.instance().bus().register(new CameraHandler());
		
		MinecraftForge.EVENT_BUS.register(new TerrainHandler());
		FMLCommonHandler.instance().bus().register(new TerrainHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
	public boolean isWorld2D(World world)
	{
		return world.getWorldInfo().getTerrainType() == this.world2D;
	}
}