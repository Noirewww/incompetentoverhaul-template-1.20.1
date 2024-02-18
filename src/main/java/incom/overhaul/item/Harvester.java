package incom.overhaul.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Harvester extends SwordItem {
    public static int tick = 0;

    public Harvester(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.getNbt().getInt("soulPoints") > 0) {
            tooltip.add(Text.literal("Souls collected: " + stack.getNbt().getInt("soulPoints")).formatted(Formatting.DARK_PURPLE));
        }
        if(stack.getNbt().getInt("soulTimer") > 0) {
            tooltip.add(Text.literal("Time until expiration: " + stack.getNbt().getInt("soulTimer") + "s").formatted(Formatting.DARK_PURPLE));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        tick++;
        if(!stack.hasNbt()) {
            NbtCompound nbtData = new NbtCompound();
            nbtData.putInt("soulPoints", 0);
            nbtData.putInt("soulTimer", 0);
            stack.setNbt(nbtData);
        } else {
            if(tick >= 40) {
                tick -= 40;
                if(stack.getNbt().getInt("soulPoints")>0 && stack.getNbt().getInt("soulTimer")>0) {
                    stack.getNbt().putInt("soulTimer", stack.getNbt().getInt("soulTimer")-1);
                } else if (stack.getNbt().getInt("soulPoints")==0 && stack.getNbt().getInt("soulTimer")>0) {
                    stack.getNbt().putInt("soulTimer", 0);
                }
            }
        }
        if(stack.getNbt().getInt("soulTimer")==0) {
            stack.getNbt().putInt("soulPoints", 0);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int soulPoints = stack.getNbt().getInt("soulPoint");
        if(target.isDead()) {
            soulPoints++;
            stack.getNbt().putInt("soulTimer", 300);
        } else if (attacker.isSneaking() && soulPoints > 0) {
            soulPoints -= 1;
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5));
        }
        stack.getNbt().putInt("soulPoints", soulPoints);
        return true;
    }
}
