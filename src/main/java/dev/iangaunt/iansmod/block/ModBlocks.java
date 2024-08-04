package dev.iangaunt.iansmod.block;

import com.google.common.base.Supplier;
import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.block.custom.BoonPedestal;
import dev.iangaunt.iansmod.block.custom.LunarAltar;
import dev.iangaunt.iansmod.item.ModItems;
import dev.iangaunt.iansmod.world.feature.tree.WengewoodTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Container class to hold all of the blocks in the mod. */
public class ModBlocks {
    // New register to hold new items.
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, 
        IansMod.MOD_ID
    );

    // Boon Pedestal registry.
    public static final RegistryObject<Block> BOON_PEDESTAL = registerBlock(
        "boon_pedestal",
        () -> new BoonPedestal(
            BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
            .noOcclusion().requiresCorrectToolForDrops()
        ), IansMod.MOD_TAB
    );
        
    // Lunar Altar registry.
    public static final RegistryObject<Block> LUNAR_ALTAR = registerBlock(
        "lunar_altar",
        () -> new LunarAltar(
            BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).noOcclusion()
            .strength(2f).requiresCorrectToolForDrops()
            .lightLevel(state -> 10)
        ), IansMod.MOD_TAB
    );
    
    // Lunarium Block registry.
    public static final RegistryObject<Block> LUNARIUM_BLOCK = registerBlock(
        "lunarium_block",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL)
            .strength(2f).requiresCorrectToolForDrops()
            .lightLevel(state -> 10)
        ), IansMod.MOD_TAB
    );

    // Lunarium Ore registry.
    public static final RegistryObject<Block> LUNARIUM_ORE = registerBlock(
        "lunarium_ore",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE)
            .strength(1.6f).requiresCorrectToolForDrops()
            .lightLevel(state -> 4)
        ), IansMod.MOD_TAB
    );

    // Wengewood Fence registry.
    public static final RegistryObject<Block> WENGEWOOD_FENCE = registerBlock(
        "wengewood_fence",
        () -> new FenceBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Fence Gate registry.
    public static final RegistryObject<Block> WENGEWOOD_FENCE_GATE = registerBlock(
        "wengewood_fence_gate",
        () -> new FenceGateBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Leaves registry.
    public static final RegistryObject<Block> WENGEWOOD_LEAVES = registerBlock(
        "wengewood_leaves",
        () -> new LeavesBlock(
            BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
        ) {
            @Override
            public boolean isFlammable(
                BlockState state, BlockGetter world, 
                BlockPos pos, Direction face) { 
                
                return true; 
            }

            @Override
            public int getFlammability(
                BlockState state, BlockGetter world, 
                BlockPos pos, Direction face) { 
                    
                return 60; 
            }

            @Override
            public int getFireSpreadSpeed(
                BlockState state, BlockGetter world, 
                BlockPos pos, Direction face) { 
                    
                return 30; 
            }
        }, IansMod.MOD_TAB
    );

    // Wengewood Log registry.
    public static final RegistryObject<Block> WENGEWOOD_LOG = registerBlock(
        "wengewood_log",
        () -> new RotatedPillarBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Planks registry.
    public static final RegistryObject<Block> WENGEWOOD_PLANKS = registerBlock(
        "wengewood_planks",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // Wengewood Sapling registry.
    public static final RegistryObject<Block> WENGEWOOD_SAPLING = registerBlock(
        "wengewood_sapling",
        () -> new SaplingBlock(
            new WengewoodTreeGrower(),
            BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
        ), IansMod.MOD_TAB
    );

    // Wengewood Slab registry.
    public static final RegistryObject<Block> WENGEWOOD_SLAB = registerBlock(
        "wengewood_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );
    
    // Wengewood Sprig registry.
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> WENGEWOOD_SPRIG = registerBlock(
        "wengewood_sprig",
        () -> new FlowerBlock(
            MobEffects.BLINDNESS, 1, 
            BlockBehaviour.Properties.copy(Blocks.POPPY).noOcclusion()
        ), IansMod.MOD_TAB
    );

    // Wengewood Stairs registry.
    public static final RegistryObject<Block> WENGEWOOD_STAIRS = registerBlock(
        "wengewood_stairs",
        () -> new StairBlock(
            () -> ModBlocks.WENGEWOOD_PLANKS.get().defaultBlockState(),
            BlockBehaviour.Properties.of(Material.WOOD)
            .strength(0.5f)
        ), IansMod.MOD_TAB
    );

    // -- Non-registered blocks -- //
    // Potted Wengewood Sapling registry.
    public static final RegistryObject<Block> POTTED_WENGEWOOD_SAPLING = registerBlockWithoutItem(
        "potted_wengewood_sapling",
        () -> new FlowerPotBlock(
            null, ModBlocks.WENGEWOOD_SAPLING,
            BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion()
        )
    );

    // Potted Wengewood Sprig registry.
    public static final RegistryObject<Block> POTTED_WENGEWOOD_SPRIG = registerBlockWithoutItem(
        "potted_wengewood_sprig",
        () -> new FlowerPotBlock(
            null, ModBlocks.WENGEWOOD_SPRIG,
            BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY).noOcclusion()
        )
    );
    
    /** Registers the block in the block form to the event bus. */
    private static <T extends Block> RegistryObject<T> registerBlock(
        String name, Supplier<T> block, CreativeModeTab tab) {

        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    /** Registers the block without an item form to the event bus. */
    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(
        String name, Supplier<T> block) {

        return BLOCKS.register(name, block);
    }
    
    /** Registers the block in item form to the event bus. */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(
        String name, RegistryObject<T> block, CreativeModeTab tab) {

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
