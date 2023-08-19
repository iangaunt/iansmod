package dev.iangaunt.iansmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

/** The Lunar Sensor tracks any Lunarium Ore
 * which exists in a certain radius of the 
 * player, alerting them in chat.
 */
public class LunarSensor extends Item {
    // Instantiates a new Lunar Sensor item with passed-in Item properties.
    public LunarSensor(Properties props) {
        super(props);
    }

    @Override
    /**
     * When the Lunar Sensor is activated, it will tell the player
     * if there is a block in a certain range of the player.
     */
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide()) {
            // Get the player of the interaction.
            Player player = context.getPlayer();
            if (player == null) return null;
        
            BlockPos position = player.blockPosition();

            // Checks if a Lunarium Ore is found in a 10 x 10 x 10 range.
            boolean found = findLunariumOre(
                context, 
                position.getX(), position.getY(), position.getZ(), 
                15
            );

            // Based on the found value, stitch a new message to send
            // to the player's chatbar.
            String message = "item.iansmod.lunar_sensor." + (found ? "lunarium_found" : "no_lunarium_found");
            player.sendMessage(
                new TranslatableComponent(message),
                player.getUUID()
            );

            if (found) {
                context.getLevel().playSound(
                    player, position, SoundEvents.EXPERIENCE_ORB_PICKUP,
                    SoundSource.BLOCKS, 0.5f, 1f
                );
            }
        }

        // Update the durability of the item.
        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
            (player) -> player.broadcastBreakEvent(player.getUsedItemHand())
        );

        // Return the interaction event.
        return super.useOn(context);
    }

    /**
     * Checks in a cube of edge length {@code range} of the midpoint at 
     * global position {@code x, y, z} and searches each block
     * in order to see if a Lunarium Ore exists in the given radius. If it does,
     * it will return {@code true}.
     * 
     * @param context - The interaction context.
     * @param x - The {@code x} coordinate of the midpoint of the cube.
     * @param y - The {@code y} coordinate of the midpoint of the cube.
     * @param z - The {@code z} coordinate of the midpoint of the cube.
     * @param range - The edge length of the cubic space to find ores.
     *
     * @return - The existence of an ore in the given range.
     */
    private boolean findLunariumOre(UseOnContext context, int x, int y, int z, int range) {
        // Create a new value to determine the
        // bounds of the cube.
        int offset = range / 2;

        for (int i = x - offset; i <= x + offset; i++) {
            for (int j = y - offset; j <= y + offset; j++) {
                for (int k = z - offset; k <= z + offset; k++) {
                    // Compares the block's registry name to the registry
                    // name of the Lunarium Ore.
                    BlockState b = context.getLevel().getBlockState(new BlockPos(i, j, k));
                    ResourceLocation register = b.getBlock().getRegistryName();

                    // If the block matches the Lunarium Ore id, return true.
                    if (register != null && register.toString().equals("iansmod:lunarium_ore")) {
                        return true;
                    }
                }
            }
        }  

        // If no block was found, return false.
        return false;
    }
}
