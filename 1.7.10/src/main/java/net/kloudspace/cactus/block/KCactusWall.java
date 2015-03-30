package net.kloudspace.cactus.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class KCactusWall extends BlockWall {

	public KCactusWall(Block block) {
		super(block);
	}
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    	return KBlocks.cactusBrick.getBlockTextureFromSide(p_149691_1_);
    }

}