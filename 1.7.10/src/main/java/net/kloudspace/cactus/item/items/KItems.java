package net.kloudspace.cactus.item.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;

public class KItems {
	private static final String item = "Registering Mod Items to Game";
	
	public static Item cactusDrop;//Mushy
	public static Item cookedCactus;//Cooked Cactus
	public static Item cactusDoor;
	public static Item cactusNeddles;
	public static Item cacMix;
	
	/*
	 * Method to Call
	 * Register's Items to the Game
	 */
	public static void call() {
		Reference.logger.info(item);
		cactusDoor = new KItemDoor(Material.cactus).setCreativeTab(Reference.tabCactus);
		GameRegistry.registerItem(cactusDoor, "cactusDoorItem");
		cactusDrop = new CactusItem("mushy").setUnlocalizedName("cacDrop").setCreativeTab(Reference.tabCactus);
		GameRegistry.registerItem(cactusDrop, "cacDrop");
		cookedCactus = new CactusItem("cooked").setUnlocalizedName("cookedCactus").setCreativeTab(Reference.tabCactus);
		GameRegistry.registerItem(cookedCactus, "cookedCactus");
		cacMix = new CactusItem("cacsand").setUnlocalizedName("cacSand").setCreativeTab(Reference.tabCactus);
		GameRegistry.registerItem(cacMix, "cacSand");
	}

}
