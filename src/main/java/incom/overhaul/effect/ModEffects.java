package incom.overhaul.effect;

import incom.overhaul.IncompetentOverhaul;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect HERETIC = registerEffect("heretic", new Heretic());

    public static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(IncompetentOverhaul.MOD_ID, name), effect);
    }
}
