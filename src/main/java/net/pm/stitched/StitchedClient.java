package net.pm.stitched;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.*;
import net.pm.stitched.particle.StitchedParticles;

public class StitchedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(StitchedParticles.SPARK, FlameParticle.Factory::new);
    }
}
