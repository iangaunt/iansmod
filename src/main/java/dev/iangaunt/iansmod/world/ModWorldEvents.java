package dev.iangaunt.iansmod.world;

import dev.iangaunt.iansmod.IansMod;
import dev.iangaunt.iansmod.world.gen.ModFlowerGeneration;
import dev.iangaunt.iansmod.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Loads world generation events for modded objects and structures. */
@Mod.EventBusSubscriber(modid = IansMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);
    }
}
