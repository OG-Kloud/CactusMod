package net.kloudspace.cactus.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Local {
	LanguageRegistry LR;
	/*
	 * Method to call
	 * Add Localizations to the Language Registry
	 */
	public void call() {
		LR = LanguageRegistry.instance();
		
	}
}
