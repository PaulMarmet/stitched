package net.pm.stitched;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.pm.stitched.item.StitchedItemTags;
import net.pm.stitched.particle.StitchedParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stitched implements ModInitializer {
	public static final String MOD_ID = "stitched";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		MidnightConfig.init("stitched", StitchedConfig.class);
		StitchedParticles.registerModParticles();
		StitchedItemTags.registerModTags();
	}
}