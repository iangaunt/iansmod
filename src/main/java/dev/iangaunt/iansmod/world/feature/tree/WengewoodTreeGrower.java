package dev.iangaunt.iansmod.world.feature.tree;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import dev.iangaunt.iansmod.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class WengewoodTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@Nonnull Random r, boolean bool) {
        return ModConfiguredFeatures.WENGEWOOD_TREE;
    }
}
