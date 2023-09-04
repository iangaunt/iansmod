package dev.iangaunt.iansmod.painting;

import dev.iangaunt.iansmod.IansMod;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Contains all of the paintings in the mod. */
public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOTIVES = DeferredRegister.create(
        ForgeRegistries.PAINTING_TYPES, IansMod.MOD_ID
    );

    // Painting file for Fantasy painting.
    public static final RegistryObject<Motive> FANTASY = PAINTING_MOTIVES.register(
        "fantasy", () -> new Motive(16, 16)
    );

    // Painting file for Yandhi painting.
    public static final RegistryObject<Motive> YANDHI = PAINTING_MOTIVES.register(
        "yandhi", () -> new Motive(16, 16)
    );

    public static void register(IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}
