package net.kloudspace.cactus;

import net.kloudspace.cactus.block.KBlock;
import net.kloudspace.cactus.client.Client;
import net.kloudspace.cactus.event.CactusBlockEvent;
import net.kloudspace.cactus.item.items.KItems;
import net.kloudspace.cactus.stuff.Craft;
import net.kloudspace.cactus.utils.Reference;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Cactus {
	
	@SidedProxy(clientSide="net.kloudspace.cactus.client.Client", serverSide="net.kloudspace.cactus.Common")
	public static Common proxy;
	
	@Instance(Reference.MODID)
	public static Cactus instance;
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		KBlock.call();
		KBlock.registry();
		KItems.call();
		Craft.callCrafting();
		Craft.callSmelting();
	}
	@EventHandler
	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new CactusBlockEvent());

	}
	@EventHandler
	public void post(FMLPostInitializationEvent event) {
		Common.post(event);
		Client.post(event);
	}

}
