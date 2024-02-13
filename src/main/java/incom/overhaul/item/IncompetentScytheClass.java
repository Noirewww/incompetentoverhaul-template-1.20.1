package incom.overhaul.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class IncompetentScytheClass extends SwordItem {
    private final double pullMultiplier;
    private final StatusEffectInstance inflictEffect;
    private final int healAmount;
    private final int pullRechargeMax;
    private int pullRecharge = 0;

    public IncompetentScytheClass(ToolMaterial toolMaterial,
                                        int attackDamage,
                                        float attackSpeed,
                                        Settings settings,
                                        double pullMultiplier,
                                        StatusEffectInstance inflictEffect,
                                        int healAmount,
                                        int pullRechargeMax) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.pullMultiplier = pullMultiplier;
        this.inflictEffect = inflictEffect;
        this.healAmount = healAmount;
        this.pullRechargeMax = pullRechargeMax;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Pull enemies closer to you.").formatted(Formatting.DARK_PURPLE));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        double weaponCharge = ((double) pullRecharge / (pullRechargeMax));
        if (pullRecharge == pullRechargeMax && target.getHealth() > 0) {
            pullTarget(target, attacker.getPos().subtract(0,0.5,0),
                    pullMultiplier * (weaponCharge / 1.5));
            attacker.heal(healAmount);
        } else {
            pullTarget(target, attacker.getPos().subtract(0,0.5,0),
                    pullMultiplier * (weaponCharge));
        }
        pullRecharge = 0;
        attacker.getMainHandStack().damage(1, attacker, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        attacker.addStatusEffect(new StatusEffectInstance(inflictEffect.getEffectType(), (int)Math.round(inflictEffect.getDuration() * (weaponCharge / 2.5))));
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (pullRecharge < pullRechargeMax) {
            pullRecharge += 1;
        }
    }

    public void pullTarget(LivingEntity target, Vec3d destination, double pullMultiplier) {
        target.setVelocity(target.getVelocity().add(destination.subtract(0, 0, 0).subtract(target.getPos()).normalize().multiply(pullMultiplier)));
    }
}
