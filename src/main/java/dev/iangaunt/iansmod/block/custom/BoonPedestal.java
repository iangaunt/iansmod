package dev.iangaunt.iansmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * The Boon Pedestal allows for the use of boons which
 * buff activity around the world.
 */
public class BoonPedestal extends Block {
    public BoonPedestal(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = 
        Block.box(3, 0, 3, 13, 14, 13);

    @Override
    @SuppressWarnings("null")
    public VoxelShape getShape(
        BlockState state, BlockGetter getter, 
        BlockPos pos, CollisionContext context) {

        return SHAPE;
    }
}
