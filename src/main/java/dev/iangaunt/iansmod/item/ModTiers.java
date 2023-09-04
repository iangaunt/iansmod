package dev.iangaunt.iansmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

/** Contains all of the tiers of the mod. */
public class ModTiers {
    @SuppressWarnings("null")
    
    public static final ForgeTier LUNARIS = new ForgeTier(
        5, 4500, 6.5f, 
        3f, 25, BlockTags.NEEDS_DIAMOND_TOOL, 
        () -> Ingredient.of(ModItems.LUNARIUM_INGOT.get())
    );
}
