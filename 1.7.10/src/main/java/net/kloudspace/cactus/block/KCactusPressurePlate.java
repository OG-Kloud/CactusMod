package net.kloudspace.cactus.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class KCactusPressurePlate extends BlockPressurePlate {

	protected KCactusPressurePlate(String p_i45418_1_, Material p_i45418_2_, Sensitivity p_i45418_3_) {
		super(p_i45418_1_, p_i45418_2_, p_i45418_3_);
	}
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    	return KBlocks.cactusBrick.getBlockTextureFromSide(p_149691_1_);
    }
}
