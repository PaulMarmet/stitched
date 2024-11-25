package net.pm.stitched.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.GrateBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.pm.stitched.StitchedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GrateBlock.class)
public abstract class GrateBlockMixin extends AbstractBlockMixin{

    public void modifyShape(CallbackInfoReturnable<VoxelShape> cir, @Local ShapeContext context) {
        if (!StitchedConfig.copperGrateFallthrough) return;
        if (context instanceof EntityShapeContext && ((EntityShapeContext)context).getEntity() != null && ((EntityShapeContext)context).getEntity().getBoundingBox() != null && (((EntityShapeContext)context).getEntity().getBoundingBox().getAverageSideLength() <= StitchedConfig.copperGrateFallthroughSize)) {
            cir.setReturnValue(VoxelShapes.empty());
            return;
        }
        cir.setReturnValue(cir.getReturnValue());
    }

}
