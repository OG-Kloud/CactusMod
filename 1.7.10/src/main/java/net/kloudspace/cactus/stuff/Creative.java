package net.kloudspace.cactus.stuff;

import net.kloudspace.cactus.item.items.KItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Creative extends CreativeTabs {

	public Creative() {
		super("cactus");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return KItems.cactusDoor;
	}

}