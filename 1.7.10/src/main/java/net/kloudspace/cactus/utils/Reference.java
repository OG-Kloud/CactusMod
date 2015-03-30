
package net.kloudspace.cactus.utils;

import net.kloudspace.cactus.stuff.Creative;
import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {
	
	public static final String MODID = "kloudcactusmod";
	public static final String NAME = "Cactus Mod";
	public static final String VERSION = "1.7.10";
	public static final String folder = MODID + ":";
	
	public static Logger logger = LogManager.getLogger(MODID.toUpperCase());
	
	public static final int cacFurnId = 8;
	public static final int cacWorkTableId = 9;
	public static final int cacHalfSpeedId = 10;
	
	public static final CreativeTabs tabCactus = new Creative();

}//net.minecraft.block.blocks.BlockFurnace
