package dev.iangaunt.iansmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/** Contains the creative mod tab for all of the custom items. */
public class ModTab {
    public static final CreativeModeTab IANSMOD_TAB = new CreativeModeTab("iansmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LUNARIUM_INGOT.get());
        }
    };
}
