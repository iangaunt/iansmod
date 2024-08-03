package dev.iangaunt.iansmod.world.feature;

import java.util.List;

import dev.iangaunt.iansmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> WENGEWOOD_TREE = 
        FeatureUtils.register(
            "wengewood", Feature.TREE, 
            new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.WENGEWOOD_LOG.get()),
                new StraightTrunkPlacer(3, 4, 5),

                BlockStateProvider.simple(ModBlocks.WENGEWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)
            ).build()
        );

    public static final Holder<PlacedFeature> WENGEWOOD_CHECKED = 
        PlacementUtils.register(
            "wengewood_checked", WENGEWOOD_TREE, 
            PlacementUtils.filteredByBlockSurvival(ModBlocks.WENGEWOOD_SAPLING.get())
        );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> WENGEWOOD_SPAWN = 
        FeatureUtils.register(
            "wengewood_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(WENGEWOOD_CHECKED, 0.5F)), 
                WENGEWOOD_CHECKED)
            );
}
