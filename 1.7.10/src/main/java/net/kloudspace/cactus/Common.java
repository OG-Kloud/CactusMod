package net.kloudspace.cactus;

import net.kloudspace.cactus.entity.EntityCactusTNT;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Common {
	
	public Common() {
		
	}
	@EventHandler
	public static void post(FMLPostInitializationEvent event) {
		EntityRegistry.registerModEntity(EntityCactusTNT.class, "cactusTNT", 0, Cactus.instance, 0, 10, false);
	}
	public void register() {
	}
	
	public void registerRenderer() {
		
	}

}
