package net.kloudspace.cactus.stuff;

import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.item.items.KItems;
import net.kloudspace.cactus.utils.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Craft {
	
	private static final String craft = "Registering Crafting Recipes";
	private static final String smelt = "Registering Smelting Recipes";
	
	private static ItemStack cactusStuff = new ItemStack(KItems.cactusDrop);
	private static ItemStack sands = new ItemStack(Item.getItemFromBlock(Blocks.sand));
	private static ItemStack needles = new ItemStack(KItems.cactusNeddles);
	private static ItemStack bricks = new ItemStack(Item.getItemFromBlock(KBlocks.cactusBrick));
	private static ItemStack cookedCactus = new ItemStack(KItems.cookedCactus);
	private static ItemStack stairs = new ItemStack(KBlocks.cactusStairs);
	private static ItemStack pp = new ItemStack(KBlocks.cactusPP);
	private static ItemStack tnt= new ItemStack(KBlocks.cactusTNT);
	private static ItemStack slab = new ItemStack(KBlocks.cactusSlab);
	private static ItemStack walls = new ItemStack(KBlocks.cactusWalls);
	private static ItemStack cacSand = new ItemStack(KItems.cacMix);
	private static ItemStack glass = new ItemStack(KBlocks.cactusGlass);
	private static ItemStack reinforced = new ItemStack(KBlocks.reinforcedBlock);
	private static ItemStack brickStack = new ItemStack(KBlocks.cactusBrick, 4);
	private static ItemStack stonePiece = new ItemStack(KBlocks.sandWorkStone);
	private static ItemStack stoneTable = new ItemStack(KBlocks.sandWorkTable);
	private static ItemStack oven = new ItemStack(KBlocks.cactusFurnace);
	private static ItemStack sandOven = new ItemStack(KBlocks.halfFurnace);
	/*
	 * Method to call
	 * Registers Crafting Recipes to the Game
	 */
	public static void callCrafting() {
		Reference.logger.info(craft);
		GameRegistry.addRecipe(bricks, new Object[]{"AA", "AA", 'A', cookedCactus});
		GameRegistry.addRecipe(new ItemStack(KItems.cactusDoor), new Object[] {"AA", "AA", "AA", 'A', bricks});
		GameRegistry.addRecipe(stairs, new Object[]{"  A", " AA", "AAA", 'A', bricks});
		GameRegistry.addRecipe(stairs, new Object[]{"A  ", "AA ", "AAA", 'A', bricks});
		GameRegistry.addRecipe(pp, new Object[]{"AA", 'A', bricks});
		GameRegistry.addRecipe(tnt, new Object[]{"ABA", "BAB", "ABA", 'A', cookedCactus, 'B', Items.gunpowder});
		GameRegistry.addRecipe(slab, new Object[]{"AAA", 'A', bricks});
		GameRegistry.addRecipe(walls, new Object[]{"AAA", "AAA", 'A', bricks});
		GameRegistry.addRecipe(cacSand, new Object[]{"ABA", "BBB", "ABA", 'A', cookedCactus, 'B', sands});
		GameRegistry.addRecipe(reinforced, new Object[]{"AA", "AA", 'A', bricks});
		GameRegistry.addRecipe(stonePiece, new Object[]{"A", 'A', sands});
		GameRegistry.addRecipe(stoneTable, new Object[]{ "AA", "AA", 'A', stonePiece});
		GameRegistry.addRecipe(oven, new Object[]{ "AAA", "A A", "AAA", 'A', reinforced});
		GameRegistry.addRecipe(sandOven, new Object[]{"AAA", "A A", "AAA", 'A', Blocks.sand});
	}

	/*
	 * Method to call
	 * Registers Smelting Recipes to the Game
	 */
	public static void callSmelting() {
		Reference.logger.info(smelt);
		GameRegistry.addSmelting(cactusStuff, cookedCactus, 5.0F);
		GameRegistry.addSmelting(cacSand, glass, 1.0F);
		GameRegistry.addSmelting(reinforced, brickStack, 5.0F);
	}
	
	

}
