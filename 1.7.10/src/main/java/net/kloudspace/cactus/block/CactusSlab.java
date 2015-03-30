package net.kloudspace.cactus.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class CactusSlab extends BlockSlab{
//Block
	private IIcon field_150007_M;
	
	public CactusSlab(boolean p_i45410_1_) {
		super(p_i45410_1_, Material.cactus);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	/**
     * Gets the block's texture. Args: side, meta
     */
    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.field_150007_M;
    }
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(Reference.MODID + ":" +"cactusbrick");
        this.field_150007_M = p_149651_1_.registerIcon(Reference.MODID + ":" +"cactusbrick");
    }
	

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(KBlocks.cactusSlab);
    }
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(KBlocks.cactusSlab), 2);
    }

	@Override
	public String func_150002_b(int p_150002_1_) {
		return null;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if (p_149666_1_ != Item.getItemFromBlock(KBlocks.double_cactusslab))
        {
            for (int i = 0; i <= 7; ++i)
            {
                if (i != 2)
                {
                    p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
                }
            }
        }
    }

}
