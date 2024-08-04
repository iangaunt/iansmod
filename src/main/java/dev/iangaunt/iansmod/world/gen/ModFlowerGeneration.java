package dev.iangaunt.iansmod.world.gen;

import dev.iangaunt.iansmod.world.feature.ModPlacedFeatures;
import java.util.List;
import java.util.Set;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/** Generates custom flowers based on specific biomes. */
public class ModFlowerGeneration {
    /**
     * Generates all modded trees based on whether the current biome is
     * suitable for the given tree.
     *
     * @param event - The BiomeLoadingEvent to parse for biomes.
     */
    @SuppressWarnings({"null", "deprecation"})
    public static void generateFlowers(final BiomeLoadingEvent event) {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if (types.contains(BiomeDictionary.Type.PLAINS)) {
            List<Holder<PlacedFeature>> base = 
                event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(ModPlacedFeatures.WENGEWOOD_SPRIG_PLACED);
        }
    }
}
