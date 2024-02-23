package incom.overhaul.item;

import incom.overhaul.IncompetentOverhaul;
import incom.overhaul.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(IncompetentOverhaul.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                    }).build());

    public static void registerItemsGroups() {
        IncompetentOverhaul.LOGGER.info("Registering Item Groups for " + IncompetentOverhaul.MOD_ID);
    }

    public static final ItemGroup MAIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(IncompetentOverhaul.MOD_ID, "arbitrarium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.arbitrarium"))
                    .icon(() -> new ItemStack(ModItems.SCYTHE)).entries((displayContext, entries) -> {
                    entries.add(ModItems.SCYTHE);
                    entries.add(ModItems.BOW);
                    entries.add(ModItems.BLAZE_SWORD);
                    entries.add(ModItems.HARVESTER);
                    entries.add(ModItems.BROADSWORD);
                    }).build());
}
