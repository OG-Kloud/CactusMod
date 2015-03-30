package net.kloudspace.cactus.item.items;

import net.kloudspace.cactus.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CactusItem extends Item {
	
	public CactusItem(String type) {
		this.setCreativeTab(CreativeTabs.tabMaterials);
//		this.setUnlocalizedName("cacDrop");
		this.setTextureName(Reference.MODID + ":" +type);
	}

}
