package dev.iangaunt.iansmod.item;

import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** The container class with all of the items in the mod. */
public class ModItems {
    // New register to hold new items.
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, 
        IansMod.MOD_ID
    );

    // Lunarium Apple registry.
    public static final RegistryObject<Item> LUNARIUM_APPLE = ITEMS.register("lunarium_apple",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Aligned Lunarium Ingot registry.
    public static final RegistryObject<SimpleFoiledItem> ALIGNED_LUNARIUM_INGOT = ITEMS.register("aligned_lunarium_ingot",
        () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)
        .tab(IansMod.MOD_TAB)
    ));

    // Lunaric Rune registry.
    public static final RegistryObject<SimpleFoiledItem> LUNARIC_RUNE = ITEMS.register("lunaric_rune",
        () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.RARE)
        .tab(IansMod.MOD_TAB)
    ));

    // Lunarium Ingot registry.
    public static final RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register("lunarium_ingot",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunarium Nugget registry.
    public static final RegistryObject<Item> LUNARIUM_NUGGET = ITEMS.register("lunarium_nugget",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunaric Rune registry.
    public static final RegistryObject<RecordItem> REBOUND_DISC = ITEMS.register("rebound_disc",
        () -> new RecordItem(
            4, 
            ModSounds.REBOUND_SOUND, 
            new Item.Properties().rarity(Rarity.RARE).tab(IansMod.MOD_TAB).stacksTo(1)
    ));

    // Registers the items to the event bus.
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
