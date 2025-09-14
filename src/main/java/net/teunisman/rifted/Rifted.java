package net.teunisman.rifted;

import net.fabricmc.api.ModInitializer;

import net.teunisman.rifted.item.ModdedItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rifted implements ModInitializer {
	public static final String MOD_ID = "rifted";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModdedItems.registerModdedItems();

		LOGGER.info("Hello Fabric world!");
	}
}