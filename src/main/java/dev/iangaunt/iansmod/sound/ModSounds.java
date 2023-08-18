package dev.iangaunt.iansmod.sound;

import dev.iangaunt.iansmod.IansMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(
        ForgeRegistries.SOUND_EVENTS, IansMod.MOD_ID
    );

    // Audio file for Rebound disc.
    public static final RegistryObject<SoundEvent> REBOUND_SOUND = registerSoundEvent("rebound_disc");

    // Returns the registry object.
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(IansMod.MOD_ID, name)));
    };

    // Registers the sounds to the event bus.
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
