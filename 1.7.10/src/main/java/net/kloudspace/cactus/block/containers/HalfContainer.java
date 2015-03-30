package net.kloudspace.cactus.block.containers;

import java.util.Random;

import net.kloudspace.cactus.Cactus;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.entity.HalfFurnace;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HalfContainer extends BlockContainer {
	
	public HalfContainer(boolean isActive) {
		super(Material.rock);
		this.isActive = isActive;
	}
	private final Random random = new Random();
	
	private boolean isActive;
	
	private static boolean keep;
	
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon side;
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("sand");
        this.front = p_149651_1_.registerIcon(this.isActive ? Reference.folder+"sandfurnace_lit" : Reference.folder+"sandfurnace");
        this.side = p_149651_1_.registerIcon("sand");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.side : (p_149691_1_ == 0 ? this.side : (p_149691_1_ != p_149691_2_ ? this.blockIcon : this.front));
    }
    @Override
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.setDefaultDirection(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			
			byte b0 = 3;//FurnaceContainer

			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, Cactus.instance, Reference.cacHalfSpeedId, world, x, y, z);
		}
		
		return true;
	}
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keep = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4, KBlocks.halfFurnace_lit);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, KBlocks.halfFurnace);
		}

		keep = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}
    public TileEntity createNewTileEntity(World par1World)
	{
		return new HalfFurnace();
	}
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (l == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (l == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (l == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (l == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}

		if (par6ItemStack.hasDisplayName())
		{
			((HalfFurnace)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		if (!keep)
		{
			HalfFurnace tileEntityFurnace = (HalfFurnace)par1World.getTileEntity(par2, par3, par4);

			if (tileEntityFurnace != null)
			{
				for (int j1 = 0; j1 < tileEntityFurnace.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = tileEntityFurnace.getStackInSlot(j1);

					if (itemstack != null)
					{
						float f = this.random.nextFloat() * 0.8F + 0.1F;
						float f1 = this.random.nextFloat() * 0.8F + 0.1F;
						float f2 = this.random.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0)
						{
							int k1 = this.random.nextInt(21) + 10;

							if (k1 > itemstack.stackSize)
							{
								k1 = itemstack.stackSize;
							}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
							entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
							entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}

				par1World.func_147453_f(par2, par3, par4, KBlocks.halfFurnace);
				
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
    public boolean hasComparatorInputOverride()
	{
		return true;
	}
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
	{
		return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
	}
    @SideOnly(Side.CLIENT)
    public Block idPicked(World par1World, int par2, int par3, int par4)
	{
		return KBlocks.halfFurnace;
	}
    @Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new HalfFurnace();
	}
}
