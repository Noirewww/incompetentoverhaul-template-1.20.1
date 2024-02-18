package incom.overhaul.item;

import incom.overhaul.IncompetentOverhaul;
import incom.overhaul.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final Potion HERETIC_POTION = registerPotions("heretic", ModEffects.HERETIC, 3600, 0);

    public static Potion registerPotions(String name, StatusEffect statusEffect, int duration, int amplifier) {
        return Registry.register(Registries.POTION, new Identifier(IncompetentOverhaul.MOD_ID, name),
                new Potion(new StatusEffectInstance(statusEffect, duration, amplifier)));
    }

    public static void registerPotionsRecipes(){
        // BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.BLAZE_SWORD, ModPotions.HERETIC_POTION);
    }
}
