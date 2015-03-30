package net.kloudspace.cactus.client;

import net.kloudspace.cactus.Common;
import net.kloudspace.cactus.entity.EntityCactusTNT;
import net.kloudspace.cactus.entity.renderers.RenderCactusTNT;
import net.kloudspace.cactus.utils.Reference;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class Client extends Common{
	
	@EventHandler
	public static void post(FMLPostInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCactusTNT.class, new RenderCactusTNT());

	}
	
	
	public void register() {
		
	}
	
	public void registerRenderer() {
		Reference.logger.info("RegisterRenderers called in client proxy");
		
	}
	
	

}
