package dev.iangaunt.iansmod.item.custom;

import javax.annotation.Nullable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

/** Lunarium Coal Coke is a more advanced
 * version of coal which burns at 10 times the normal
 * rate of coal.
 */
public class LunariumCoalCoke extends Item {
    public LunariumCoalCoke(Properties props) {
        super(props);
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return 16000;
    }
}
