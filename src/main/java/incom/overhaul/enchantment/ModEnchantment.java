package incom.overhaul.enchantment;

import incom.overhaul.IncompetentOverhaul;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantment {
    public static Enchantment WITHERING = registerEnchantment("withering",
            new WitheringEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(IncompetentOverhaul.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        IncompetentOverhaul.LOGGER.info("Registering Mod Enchantments for " + IncompetentOverhaul.MOD_ID);
    }
}
