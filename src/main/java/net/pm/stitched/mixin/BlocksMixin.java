package net.pm.stitched.mixin;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.pm.stitched.StitchedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @Redirect(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=torchflower", ordinal = 0)), at = @At(value = "NEW", target = "Lnet/minecraft/block/FlowerBlock;", ordinal = 0))
    private static FlowerBlock makeNewTorchflower(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, AbstractBlock.Settings settings) {
        if (StitchedConfig.glowingTorchflower) return new FlowerBlock(stewEffect, effectLengthInSeconds, settings.luminance(state -> 15));
        return new FlowerBlock(stewEffect, effectLengthInSeconds, settings);
    }

    @Redirect(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=potted_torchflower", ordinal = 0)), at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Blocks;createFlowerPotBlock(Lnet/minecraft/block/Block;)Lnet/minecraft/block/Block;", ordinal = 0))
    private static Block makeNewTorchflower(Block flower) {
        if (StitchedConfig.glowingTorchflower) return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY).luminance(state -> 15));
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
    }

    @Redirect(method = "<clinit>", slice = @Slice(from = @At(value="CONSTANT", args="stringValue=cave_vines_plant", ordinal = 0)), at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/CaveVinesBodyBlock;", ordinal = 0))
    private static CaveVinesBodyBlock makeCaveVineTicker(AbstractBlock.Settings settings) {
        if (StitchedConfig.regrowCaveVines) return new CaveVinesBodyBlock(settings.ticksRandomly());
        return new CaveVinesBodyBlock(settings);
    }

}
