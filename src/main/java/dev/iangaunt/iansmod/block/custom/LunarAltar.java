package dev.iangaunt.iansmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * The Lunar Altar is a block used to align Lunar Ingots,
 * allowing for powered-up versions of tools.
 */
public class LunarAltar extends Block {
    public LunarAltar(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = 
        Block.box(1.2, 0, 1.2, 14.8, 4.6, 14.8);

    @Override
    @SuppressWarnings("null")
    public VoxelShape getShape(
        BlockState state, BlockGetter getter, 
        BlockPos pos, CollisionContext context) {

        return SHAPE;
    }
}
