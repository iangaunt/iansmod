package dev.iangaunt.iansmod;

import com.mojang.logging.LogUtils;
import dev.iangaunt.iansmod.block.ModBlocks;
import dev.iangaunt.iansmod.item.ModItems;
import dev.iangaunt.iansmod.item.ModTab;
import dev.iangaunt.iansmod.painting.ModPaintings;
import dev.iangaunt.iansmod.sound.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
/** Initializes all of the mod registries and runs the mod. */
@Mod("iansmod")

public class IansMod {
    // Tag for the mod id.
    public static final String MOD_ID = "iansmod";

    // Creative mode tab for all items and blocks.
    public static CreativeModeTab MOD_TAB = ModTab.IANSMOD_TAB;

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    /** Initializes all of the registries. */
    public IansMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registers all of the item busses to the registery.
        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModPaintings.register(eventBus);
        ModSounds.register(eventBus);

        // Register the setup method for modloading.
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the
    //  contained class (this is subscribing to the MOD Event bus for receiving Registry Events)
    /** Outputs when a block is registered. */
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(
            final RegistryEvent.Register<Block> blockRegistryEvent) {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
