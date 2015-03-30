package net.kloudspace.cactus.handlers;

import net.kloudspace.cactus.block.containers.ContainerFurnace;
import net.kloudspace.cactus.block.containers.ContainerHalf;
import net.kloudspace.cactus.block.containers.ContainerWorkTable;
import net.kloudspace.cactus.entity.HalfFurnace;
import net.kloudspace.cactus.entity.TileEntityCactusFurnace;
import net.kloudspace.cactus.guis.GUICacFurn;
import net.kloudspace.cactus.guis.GUIWorkTable;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerCrafting implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch(ID) {
		case Reference.cacWorkTableId:
			return new ContainerWorkTable(player.inventory, world, x, y, z);
		case Reference.cacFurnId:
			return new ContainerFurnace(player.inventory, (TileEntityCactusFurnace) entity);
		case Reference.cacHalfSpeedId:
			return new ContainerHalf(player.inventory, (HalfFurnace) entity);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		switch(ID) {
		case Reference.cacWorkTableId:
			return new GUIWorkTable(player.inventory, world, x, y, z);
		case Reference.cacFurnId:
			return new GUICacFurn(player.inventory, (TileEntityCactusFurnace) entity);
		case Reference.cacHalfSpeedId:
			return new GUICacFurn(player.inventory, (HalfFurnace) entity);
		default:
			return null;
		}
		
	}

}
