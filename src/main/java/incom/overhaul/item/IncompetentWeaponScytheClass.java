package incom.overhaul.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class IncompetentWeaponScytheClass extends SwordItem {
    public IncompetentWeaponScytheClass(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setVelocity(target.getVelocity().add(attacker.getPos().subtract(0,1,0).subtract(target.getPos()).normalize().multiply(1)));
        return false;
    }
}
