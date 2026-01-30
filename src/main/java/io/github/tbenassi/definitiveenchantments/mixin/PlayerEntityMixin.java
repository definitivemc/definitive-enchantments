package io.github.tbenassi.definitiveenchantments.mixin;

import io.github.tbenassi.definitiveenchantments.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "getProjectileType", at = @At("RETURN"), cancellable = true)
    private void definitiveEnchantments_endlessQuiver(ItemStack weapon, CallbackInfoReturnable<ItemStack> cir) {
        if (!cir.getReturnValue().isEmpty()) {
            return;
        }

        PlayerEntity self = (PlayerEntity) (Object) this;
        boolean hasEnchant = self.getEntityWorld().getRegistryManager()
                .getOptional(RegistryKeys.ENCHANTMENT)
                .flatMap(registry -> registry.getOptional(ModEnchantments.ENDLESS_QUIVER))
                .map(entry -> EnchantmentHelper.getLevel(entry, weapon) > 0)
                .orElse(false);

        if (hasEnchant) {
            cir.setReturnValue(new ItemStack(Items.ARROW));
        }
    }
}
