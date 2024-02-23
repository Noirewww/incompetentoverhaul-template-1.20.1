package incom.overhaul;

import incom.overhaul.block.ModBlocks;
import incom.overhaul.enchantment.ModEnchantment;
import incom.overhaul.item.ModItemGroups;
import incom.overhaul.item.ModItems;
import incom.overhaul.item.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncompetentOverhaul implements ModInitializer {
	public static final String MOD_ID = "incompetentoverhaul";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemsGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModPotions.registerPotionsRecipes();

		ModEnchantment.registerModEnchantments();
	}
}