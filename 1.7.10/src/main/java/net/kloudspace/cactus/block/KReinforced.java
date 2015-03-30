package net.kloudspace.cactus.block;

import java.util.Random;

import net.kloudspace.cactus.block.blocks.KBlocks;
import net.minecraft.block.BlockStone;
import net.minecraft.item.Item;

public class KReinforced extends BlockStone {
	
	 public int quantityDropped(Random p_149745_1_)
	    {
	        return 1;
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return Item.getItemFromBlock(KBlocks.reinforcedBlock);
	    }

}
