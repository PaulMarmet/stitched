package net.pm.stitched.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pm.stitched.Stitched;

public class StitchedParticles {
    public static final SimpleParticleType SPARK = Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Stitched.MOD_ID, "spark"), FabricParticleTypes.simple());


    public static void  registerModParticles() {

    }
}
