package net.kloudspace.cactus.block;

import net.kloudspace.cactus.Cactus;
import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.block.containers.FurnaceContainer;
import net.kloudspace.cactus.block.containers.HalfContainer;
import net.kloudspace.cactus.entity.HalfFurnace;
import net.kloudspace.cactus.entity.TileEntityCactusFurnace;
import net.kloudspace.cactus.handlers.GuiHandlerCrafting;
import net.kloudspace.cactus.handlers.GuiHandlers;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class KBlock {
	private static final String blocks = "Registering Mod Blocks to the Game";
	private static final String folder = Reference.MODID + ":";
	//Blocks
	/*
	 * Method to call
	 * To Register and Define Blocks in the Game
	 */
	public static void call() {
		Reference.logger.info(blocks);
		KBlocks.cactusBrick = new KBrick("brick").setCreativeTab(Reference.tabCactus).setBlockName("cactusbrick");
		KBlocks.cactusDoor = new KDoor(Material.cactus, "door").setCreativeTab(Reference.tabCactus).setBlockName("cactusdoor");
		KBlocks.cactusGlass = new KGlass("glass", false).setCreativeTab(Reference.tabCactus).setBlockName("cactusglass");
		KBlocks.cactusSlab = new CactusSlab(false).setCreativeTab(Reference.tabCactus).setBlockName("cactusslab");
		KBlocks.double_cactusslab = new CactusSlab(true).setCreativeTab(Reference.tabCactus).setBlockName("cactusdoubleslab");
		KBlocks.cactusStairs = new KCactusStairs(KBlocks.cactusBrick, 0).setCreativeTab(Reference.tabCactus).setBlockName("cactusstairs");
		KBlocks.cactusWalls = new KCactusWall(KBlocks.cactusBrick).setCreativeTab(Reference.tabCactus).setBlockName("cactuswalls");
		KBlocks.cactusPP = new KCactusPressurePlate(Reference.MODID+":cactusbrick", Material.cactus, BlockPressurePlate.Sensitivity.everything).setCreativeTab(Reference.tabCactus).setBlockName("cactuspressureplate");
		KBlocks.cactusTNT = new KCactusTNT(Material.tnt).setBlockName("cactustnt");//BlockTNT
		KBlocks.reinforcedBlock = new KReinforced().setHardness(50.0F).setResistance(2000.0F).setCreativeTab(Reference.tabCactus).setBlockTextureName(folder +"cactusbrick").setBlockName("cacReinforced");
		KBlocks.cactusFurnace = (new FurnaceContainer(false)).setCreativeTab(Reference.tabCactus).setBlockName("cactusfurnace").setHardness(10.0F);
		KBlocks.cactusFurnace_lit = (new FurnaceContainer(true)).setCreativeTab(Reference.tabCactus).setBlockName("cactusfurnace_lit");
		KBlocks.halfFurnace = (new HalfContainer(false)).setCreativeTab(Reference.tabCactus).setBlockName("halfFurnace");
		KBlocks.halfFurnace_lit = (new HalfContainer(true)).setBlockName("halfFurnace_lit");
		KBlocks.sandWorkStone = new KWorkStone("sandtablepiece").setCreativeTab(Reference.tabCactus).setHardness(10.0F).setBlockName("sandWorkStone");
		KBlocks.sandWorkTable = new SandWorkStone().setCreativeTab(Reference.tabCactus).setHardness(10.0F).setBlockName("sandWorkTable");//Blocks
	}
	public static void registry() {
		GameRegistry.registerBlock(KBlocks.cactusBrick, "cacBricks");
		GameRegistry.registerBlock(KBlocks.cactusDoor, "cacDoor");
		GameRegistry.registerBlock(KBlocks.cactusGlass, "cacGlass");
		GameRegistry.registerBlock(KBlocks.cactusSlab, "cacSlab");
		GameRegistry.registerBlock(KBlocks.double_cactusslab, "dcacSlab");
		GameRegistry.registerBlock(KBlocks.cactusStairs, "cactusStairs");
		GameRegistry.registerBlock(KBlocks.cactusWalls, "cacWalls");
		GameRegistry.registerBlock(KBlocks.cactusPP, "cactuspressureplate");
		GameRegistry.registerBlock(KBlocks.cactusTNT, "cacTNT");
		GameRegistry.registerBlock(KBlocks.reinforcedBlock, "reinforcedCactusBlock");
		GameRegistry.registerBlock(KBlocks.cactusFurnace, "cactusFurnace");
		GameRegistry.registerBlock(KBlocks.cactusFurnace_lit, "cactusFurnaceLit");
		GameRegistry.registerTileEntity(TileEntityCactusFurnace.class, "cactusFurnace");
		NetworkRegistry.INSTANCE.registerGuiHandler(Cactus.instance, new GuiHandlers());
		GameRegistry.registerBlock(KBlocks.halfFurnace, "hlafFurnace");
		GameRegistry.registerBlock(KBlocks.halfFurnace_lit, "halfFurnace_lit");
		GameRegistry.registerTileEntity(HalfFurnace.class, "cactusHalfFurnace");
		
		GameRegistry.registerBlock(KBlocks.sandWorkStone, "sandWorkStone");
		GameRegistry.registerBlock(KBlocks.sandWorkTable, "sandWorkTable");
		NetworkRegistry.INSTANCE.registerGuiHandler(Cactus.instance, new GuiHandlerCrafting());
	}

}//Block
