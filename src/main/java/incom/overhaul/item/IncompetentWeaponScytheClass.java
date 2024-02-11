package incom.overhaul.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class IncompetentWeaponScytheClass extends SwordItem {
    private final double pullMultiplier;
    private final StatusEffectInstance inflictEffect;
    private final int healAmount;

    public IncompetentWeaponScytheClass(ToolMaterial toolMaterial,
                                        int attackDamage,
                                        float attackSpeed,
                                        Settings settings,
                                        double pullMultiplier,
                                        StatusEffectInstance inflictEffect,
                                        int healAmount) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.pullMultiplier = pullMultiplier;
        this.inflictEffect = inflictEffect;
        this.healAmount = healAmount;
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setVelocity(target.getVelocity().add(attacker.getPos().subtract(0,0.5,0).subtract(target.getPos()).normalize().multiply(pullMultiplier)));
        attacker.getMainHandStack().damage(1,attacker,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        attacker.addStatusEffect(inflictEffect);
        attacker.heal(healAmount);
        return true;
    }
}
