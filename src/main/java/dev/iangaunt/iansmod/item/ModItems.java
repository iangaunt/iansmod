package dev.iangaunt.iansmod.item;

import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.item.custom.LunarSensor;
import dev.iangaunt.iansmod.item.custom.LunariumCoalCoke;
import dev.iangaunt.iansmod.item.custom.LunariumSludge;
import dev.iangaunt.iansmod.sound.ModSounds;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraft.world.item.SwordItem;
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

    // Aligned Lunarium Ingot registry.
    public static final RegistryObject<SimpleFoiledItem> ALIGNED_LUNARIUM_INGOT = ITEMS.register(
        "aligned_lunarium_ingot",
        () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.UNCOMMON)
        .tab(IansMod.MOD_TAB)
    ));

    // Fortified Lunar Stick registry.
    public static final RegistryObject<Item> FORTIFIED_LUNAR_ROD = ITEMS.register(
        "fortified_lunar_rod",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunar Sensor registry.
    public static final RegistryObject<Item> LUNAR_SENSOR = ITEMS.register(
        "lunar_sensor",
        () -> new LunarSensor(new Item.Properties().tab(IansMod.MOD_TAB).durability(25)
    ));

    // Lunaric Rune registry.
    public static final RegistryObject<SimpleFoiledItem> LUNARIC_RUNE = ITEMS.register(
        "lunaric_rune",
        () -> new SimpleFoiledItem(new Item.Properties().rarity(Rarity.RARE)
        .tab(IansMod.MOD_TAB)
    ));

    // Lunaris Axe registry.
    public static final RegistryObject<Item> LUNARIS_AXE = ITEMS.register(
        "lunaris_axe",
        () -> new AxeItem(
            ModTiers.LUNARIS, 9, -1.5f,
            new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunaris Pickaxe registry.
    public static final RegistryObject<Item> LUNARIS_PICKAXE = ITEMS.register(
        "lunaris_pickaxe",
        () -> new PickaxeItem(
            ModTiers.LUNARIS, 5, 1.5f,
            new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunaris Sword registry.
    public static final RegistryObject<Item> LUNARIS_SWORD = ITEMS.register(
        "lunaris_sword",
        () -> new SwordItem(
            ModTiers.LUNARIS, 7, 0.5f,
            new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunarium Apple registry.
    public static final RegistryObject<Item> LUNARIUM_APPLE = ITEMS.register(
        "lunarium_apple",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB).food(
            new FoodProperties.Builder().nutrition(12).saturationMod(2.6f).build()
        )
    ));

    // Lunarium Carrot registry.
    public static final RegistryObject<Item> LUNARIUM_CARROT = ITEMS.register(
        "lunarium_carrot",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB).food(
            new FoodProperties.Builder().nutrition(18).saturationMod(3.6f).build()
        )
    ));
    
    // Lunarium Coal Coke registry.
    public static final RegistryObject<Item> LUNARIUM_COAL_COKE = ITEMS.register(
        "lunarium_coal_coke",
        () -> new LunariumCoalCoke(new Item.Properties().tab(IansMod.MOD_TAB)
    ));
 
    // Lunarium Ingot registry.
    public static final RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register(
        "lunarium_ingot",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunarium Nugget registry.
    public static final RegistryObject<Item> LUNARIUM_NUGGET = ITEMS.register(
        "lunarium_nugget",
        () -> new Item(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Lunarium Sludge registry.
    public static final RegistryObject<Item> LUNARIUM_SLUDGE = ITEMS.register(
        "lunarium_sludge",
        () -> new LunariumSludge(new Item.Properties().tab(IansMod.MOD_TAB)
    ));

    // Rebound Disc registry.
    public static final RegistryObject<RecordItem> REBOUND_DISC = ITEMS.register(
        "rebound_disc",
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
