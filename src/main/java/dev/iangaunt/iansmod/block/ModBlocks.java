package dev.iangaunt.iansmod.block;

import com.google.common.base.Supplier;

import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
            .strength(9f).requiresCorrectToolForDrops()
            .lightLevel(state -> 10)
        ), IansMod.MOD_TAB
    );

    // Lunarium Ore registry.
    public static final RegistryObject<Block> LUNARIUM_ORE = registerBlock("lunarium_ore",
        () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL)
            .strength(9f).requiresCorrectToolForDrops()
            .lightLevel(state -> 4)
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
