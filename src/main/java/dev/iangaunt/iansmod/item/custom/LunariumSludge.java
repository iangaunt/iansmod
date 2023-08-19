package dev.iangaunt.iansmod.item.custom;

import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

/** Lunarium Sludge is a more advanced
 * version of lava which burns at 5 times the normal
 * rate of lava.
 */
public class LunariumSludge extends Item {
    public LunariumSludge(Properties props) {
        super(props);
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return 100000;
    }
}
