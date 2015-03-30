package net.kloudspace.cactus.block;

import java.util.Random;

import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KBrick extends Block {

	public KBrick(String name) {
		super(Material.ground);
		setBlockName("cactus" +name);
		setBlockTextureName(Reference.MODID +":cactus" +name);
		setHardness(10.0F);
		setHarvestLevel("axe", 0);
		setTickRandomly(true);
	}
	/**
     * Ticks the block if it's been scheduled
     */
	@Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (world.isAirBlock(x, y + 1, z))
        {
            int l;

            for (l = 1; world.getBlock(x, y - l, z) == this; ++l)
            {
                ;
            }

            if (l < 3)
            {
                int i1 = world.getBlockMetadata(x, y, z);

                if (i1 == 15)
                {
                    world.setBlock(x, y + 1, z, this);
                    world.setBlockMetadataWithNotify(x, y, z, 0, 4);
                    this.onNeighborBlockChange(world, x, y + 1, z, this);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
                }
            }
        }
    }
	
	/**
     * Returns the bounding box of the wired rectangular prism to render.
     */
	@Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)(y + 1), (double)((float)(z + 1) - f));
    }
	
	/**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
	
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
	@Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if(entity instanceof EntityLiving) {
//		Reference.logger.info("Colided");
		entity.attackEntityFrom(DamageSource.cactus, 1.0F);
		}
	}

}
