package dev.iangaunt.iansmod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

/** Custom placed features for the mod. */
public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> WENGEWOOD_PLACED = PlacementUtils.register(
        "wengewood_placed",
        ModConfiguredFeatures.WENGEWOOD_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.05f, 2)
        )
    );

    public static final Holder<PlacedFeature> WENGEWOOD_SPRIG_PLACED = PlacementUtils.register(
        "wengewood_sprig_placed", 
        ModConfiguredFeatures.WENGEWOOD_SPRIG, RarityFilter.onAverageOnceEvery(8),
        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
    );
}
