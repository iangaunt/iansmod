package dev.iangaunt.iansmod.block;

import com.google.common.base.Supplier;

import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // New register to hold new items.
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, 
        IansMod.MOD_ID
    );

    // Lunarium Block registry.
    public static final RegistryObject<Block> LUNARIUM_BLOCK = registerBlock("lunarium_block",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL)
            .strength(2f).requiresCorrectToolForDrops()
            .lightLevel(state -> 10)
        ), IansMod.MOD_TAB
    );

    // Lunarium Ore registry.
    public static final RegistryObject<Block> LUNARIUM_ORE = registerBlock("lunarium_ore",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE)
            .strength(1.6f).requiresCorrectToolForDrops()
            .lightLevel(state -> 4)
        ), IansMod.MOD_TAB
    );

    // Wengewood Fence registry.
    public static final RegistryObject<Block> WENGEWOOD_FENCE = registerBlock("wengewood_fence",
        () -> new FenceBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Fence registry.
    public static final RegistryObject<Block> WENGEWOOD_FENCE_GATE = registerBlock("wengewood_fence_gate",
        () -> new FenceGateBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Log registry.
    public static final RegistryObject<Block> WENGEWOOD_LOG = registerBlock("wengewood_log",
        () -> new RotatedPillarBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );


    // Wengewood Planks registry.
    public static final RegistryObject<Block> WENGEWOOD_PLANKS = registerBlock("wengewood_planks",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Slab registry.
    public static final RegistryObject<Block> WENGEWOOD_SLAB = registerBlock("wengewood_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Stairs registry.
    public static final RegistryObject<Block> WENGEWOOD_STAIRS = registerBlock("wengewood_stairs",
        () -> new StairBlock(
            () -> ModBlocks.WENGEWOOD_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    /** Registers the block in the block form to the event bus. */
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    /** Registers the block in item form to the event bus. */
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(
            block.get(),
            new Item.Properties().tab(tab)
        ));
    }

    // Registers the items to the event bus.
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
