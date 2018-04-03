package com.tuesday.tdcr;

import com.tuesday.tdcr.world.WorldProviderEnd2D;
import com.tuesday.tdcr.world.WorldProviderHell2D;
import com.tuesday.tdcr.world.WorldProviderSurface2D;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

@Mod(modid = TDCR.MODID, name = TDCR.NAME, version = TDCR.VERSION)
public class TDCR
{
	public static final String MODID = "tdcr";
    public static final String NAME = "2D Craft: Reborn";
    public static final String VERSION = "Beta";
    
    public static WorldType2D worldTDCR;
    
    public static String worldName = "twod";
    
    public static int dimOverworld2D = DimensionManager.getNextFreeDimId();
    public static int dimNether2D = DimensionManager.getNextFreeDimId();
    public static int dimEnd2D = DimensionManager.getNextFreeDimId();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	worldTDCR = new WorldType2D(worldName);
    	
    	DimensionType.register("overworld2d", "", dimOverworld2D, WorldProviderSurface2D.class, false);
    	DimensionType.register("the_nether2d", "_nether2d", dimNether2D, WorldProviderHell2D.class, false);
    	DimensionType.register("the_end2d", "_end2d", dimEnd2D, WorldProviderEnd2D.class, false);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new EventHandler2D());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
