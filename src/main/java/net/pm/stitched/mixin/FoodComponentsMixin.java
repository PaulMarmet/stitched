package net.pm.stitched.mixin;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.pm.stitched.StitchedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(FoodComponents.class)
public abstract class FoodComponentsMixin {
    @Shadow
    public static final FoodComponent GLOW_BERRIES = makeNewGlowBerry();

    @Unique
    private static FoodComponent makeNewGlowBerry() {
        FoodComponent.Builder glowBerry = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.1F);
        if (StitchedConfig.glowBerriesGiveGlowing)  glowBerry = glowBerry.statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 1.0F);
        return glowBerry.build();
    }

}
