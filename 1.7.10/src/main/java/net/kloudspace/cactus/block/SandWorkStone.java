package net.kloudspace.cactus.block;

import java.util.Random;

import net.kloudspace.cactus.Cactus;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SandWorkStone extends Block {
	
	@SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    
    protected SandWorkStone()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.top : (p_149691_1_ == 0 ? Blocks.sand.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : Blocks.sand.getBlockTextureFromSide(p_149691_1_)));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("sand");
        this.top = p_149651_1_.registerIcon(Reference.MODID +":sand" + "_top");
        this.front = p_149651_1_.registerIcon("sand");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float f, float f1, float f2)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
			FMLNetworkHandler.openGui(player, Cactus.instance, Reference.cacWorkTableId, world, x, y, z);
            return true;
        }
    }
    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(KBlocks.sandWorkTable);
    }

}