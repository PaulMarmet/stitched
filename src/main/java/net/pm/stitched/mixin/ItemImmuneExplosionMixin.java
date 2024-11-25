package net.pm.stitched.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.pm.stitched.StitchedConfig;
import net.pm.stitched.enchantment.StitchedEnchantTags;
import net.pm.stitched.item.StitchedItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemImmuneExplosionMixin extends EntityMixin{

	@Shadow public abstract ItemStack getStack();

	@Override
	public void isImmuneToExplosion(CallbackInfoReturnable<Boolean> cir) {
		if (StitchedConfig.explosionProofItems == StitchedConfig.SelectionType.ALL) {
			cir.setReturnValue(true);
		} else if (StitchedConfig.explosionProofItems == StitchedConfig.SelectionType.SOME) {
			boolean hasTag = this.getStack().isIn(StitchedItemTags.EXPLOSION_PROOF);
			boolean isProtected = EnchantmentHelper.hasEnchantments(this.getStack()) && EnchantmentHelper.hasAnyEnchantmentsIn(this.getStack(), StitchedEnchantTags.EXPLOSION_RELATED);
			cir.setReturnValue(cir.getReturnValue() || hasTag || (isProtected && StitchedConfig.explosionProofBlastProt));
		} else {
			boolean isProtected = EnchantmentHelper.hasEnchantments(this.getStack()) && EnchantmentHelper.hasAnyEnchantmentsIn(this.getStack(), StitchedEnchantTags.EXPLOSION_RELATED);
			cir.setReturnValue(cir.getReturnValue() || (isProtected && StitchedConfig.explosionProofBlastProt));
		}
	}

}