package incom.overhaul.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class Heretic extends StatusEffect {
    public Heretic() {
        super(StatusEffectCategory.HARMFUL,
                (int) 6220E5);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isUndead()) {
            entity.setOnFireFor(1);
        }
        addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "6da369b0-5b9c-4a4d-a371-879b023e81c3", -0.5f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
