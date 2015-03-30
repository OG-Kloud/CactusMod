package net.kloudspace.cactus.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class KWorkStone extends Block {
	@SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;

	protected KWorkStone(String texture) {
		super(Material.rock);
		setBlockName(texture);
		this.setHarvestLevel("shovel", 0);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon("sand");
        this.top = p_149651_1_.registerIcon(Reference.MODID +":sandtablepiece");
        this.front = p_149651_1_.registerIcon("sand");
    }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		 return p_149691_1_ == 1 ? this.top : (p_149691_1_ == 0 ? Blocks.sand.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : Blocks.sand.getBlockTextureFromSide(p_149691_1_)));
	 }
	 @Override
	    public int quantityDropped(Random p_149745_1_)
	    {
	        return 1;
	    }
	    @Override
	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return Item.getItemFromBlock(KBlocks.sandWorkStone);
	    }
}
