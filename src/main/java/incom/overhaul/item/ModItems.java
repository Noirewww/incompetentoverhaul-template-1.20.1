package incom.overhaul.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import incom.overhaul.IncompetentOverhaul;
import incom.overhaul.item.custom.MetalDetectorItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY, 3, 1f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 0, 0f, new FabricItemSettings()));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterial.RUBY, 5, 3f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY, 2, 0f, new FabricItemSettings()));

    public static final Item SCYTHE = registerItem("scythe",
            new IncompetentWeaponScytheClass(ToolMaterials.DIAMOND, 8, -3.5f,
                    new FabricItemSettings(), 0.8,
                    new StatusEffectInstance(StatusEffects.INVISIBILITY, 100),
                    1));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {

    }

    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(IncompetentOverhaul.MOD_ID, name), item);
    }

    public static void registerModItems() {
        IncompetentOverhaul.LOGGER.info("Registering Mod Items for " + IncompetentOverhaul.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
