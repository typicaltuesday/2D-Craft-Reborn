package com.tuesday.tdcr.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBarrier extends Block
{

	public BlockBarrier()
	{
		
		super(Material.rock);
		
		this.setBlockUnbreakable();
		this.setHardness(-1.0F);
		this.setResistance(-1.0F);
		this.setStepSound(Block.soundTypeStone);
		this.setLightOpacity(0);
		//this.setCreativeTab(CreativeTabs.tabBlock);
		
		GameRegistry.registerBlock(this, "blockBarrier");
	}
	
	public int getRenderBlockPass()
    {
		
        return 1;
    }
	
    public boolean renderAsNormalBlock()
    {
    	
        return false;
    }
    
    public boolean isOpaqueCube()
    {
    	
        return false;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess access, int x, int y, int z, int side)
    {
    	
    	return false;
    }
    
    public int quantityDropped(Random par1Random)
    {
    	
        return 0;
    }
    
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
    	
    	return null;
    }
}