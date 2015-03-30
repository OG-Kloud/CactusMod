package net.kloudspace.cactus.handlers;

import net.kloudspace.cactus.block.SandWorkStone;
import net.kloudspace.cactus.block.containers.ContainerFurnace;
import net.kloudspace.cactus.block.containers.ContainerWorkTable;
import net.kloudspace.cactus.entity.TileEntityCactusFurnace;
import net.kloudspace.cactus.guis.GUICacFurn;
import net.kloudspace.cactus.guis.GUIWorkTable;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlers implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		Block block = world.getBlock(x, y, z);
		if(entity != null){
			switch (id) {
				case Reference.cacFurnId:
					if (entity instanceof TileEntityCactusFurnace) {
						return new ContainerFurnace(player.inventory, (TileEntityCactusFurnace) entity);
					}
					return null;
				default:
					return null;
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		Block block = world.getBlock(x, y, z);
		if(entity != null){
			switch (id) {
				case Reference.cacFurnId:
					if (entity instanceof TileEntityCactusFurnace) {
						return new GUICacFurn(player.inventory, (TileEntityCactusFurnace) entity);
					} 
					return null;
				default:
					return null;
			}
		}

		return null;
	}	

}
