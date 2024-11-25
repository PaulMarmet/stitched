package net.pm.stitched.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pm.stitched.StitchedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import static net.minecraft.block.FarmlandBlock.MOISTURE;

@Mixin(FarmlandBlock.class)
public class FarmlandMixin {
    @Redirect(method = "onLandedUpon(Lnet/minecraft/world/World;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/Entity;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/entity/Entity;Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"))
    private void ifWatered(Entity entity, BlockState state, World world, BlockPos pos) {
        if (state.get(MOISTURE) <= 0 || !StitchedConfig.untramplableWetFarmland) {
            FarmlandBlock.setToDirt(entity, state, world, pos);
        }
    }

    @ModifyArg(method = "isWaterNearby(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/BlockPos;add(III)Lnet/minecraft/util/math/BlockPos;", ordinal = 0), index = 1)
    private static int extendRegion(int y) {
        return StitchedConfig.extendWaterRegion ? -1 : y;
    }

}
