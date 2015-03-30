package net.kloudspace.cactus.event;

import java.util.Random;

import net.kloudspace.cactus.block.blocks.KBlocks;
import net.kloudspace.cactus.item.items.KItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CactusBlockEvent {
	
	@SubscribeEvent
	public void cactus(HarvestDropsEvent event) {
		Block block = event.block;
		Random random = new Random();
		
		if(block == Blocks.cactus) {
			event.drops.clear();
			event.drops.add(new ItemStack(KItems.cactusDrop,1 +random.nextInt(4)));
		}
//		else if(block == KBlocks.sandWorkStone) {
//			event.drops.add(new ItemStack(Item.getItemFromBlock(KBlocks.sandWorkStone)));
//		}
//		else if(block == KBlocks.sandWorkTable) {
//			event.drops.add(new ItemStack(Item.getItemFromBlock(KBlocks.sandWorkTable)));
//		}
	}

}
