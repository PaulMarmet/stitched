package net.pm.stitched.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.pm.stitched.StitchedConfig;
import net.pm.stitched.enchantment.StitchedEnchantTags;
import net.pm.stitched.item.StitchedItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemFireproofMixin {

	@Shadow public abstract ItemStack getStack();

	@Inject(method = "isFireImmune()Z", at = @At(value="RETURN"), cancellable = true)
	public void isImmuneToFire(CallbackInfoReturnable<Boolean> cir) {
		if (StitchedConfig.fireProofItems == StitchedConfig.SelectionType.ALL) {
			cir.setReturnValue(true);
		} else if (StitchedConfig.fireProofItems == StitchedConfig.SelectionType.SOME) {
			boolean hasTag = this.getStack().isIn(StitchedItemTags.FIREPROOF);
			boolean isProtected = EnchantmentHelper.hasAnyEnchantmentsIn(this.getStack(), StitchedEnchantTags.FIRE_RELATED);
			cir.setReturnValue(cir.getReturnValue() || hasTag || (isProtected && StitchedConfig.fireProofFireProt));
		} else {
			boolean isProtected = EnchantmentHelper.hasAnyEnchantmentsIn(this.getStack(), StitchedEnchantTags.FIRE_RELATED);
			cir.setReturnValue(cir.getReturnValue() || (isProtected && StitchedConfig.fireProofFireProt));
		}
	}

}