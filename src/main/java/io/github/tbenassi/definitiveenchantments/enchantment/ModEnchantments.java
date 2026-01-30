package io.github.tbenassi.definitiveenchantments.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModEnchantments {
    public static final RegistryKey<Enchantment> ENDLESS_QUIVER =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("definitive-enchantments", "endless_quiver"));

    private ModEnchantments() {}
}
