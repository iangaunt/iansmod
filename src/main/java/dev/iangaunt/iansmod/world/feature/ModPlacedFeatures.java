package dev.iangaunt.iansmod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> WENGEWOOD_PLACED = PlacementUtils.register(
        "wengewood_placed",
        ModConfiguredFeatures.WENGEWOOD_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.05f, 2)
        )
    );
}
