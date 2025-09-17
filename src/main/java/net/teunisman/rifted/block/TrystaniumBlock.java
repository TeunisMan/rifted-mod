package net.teunisman.rifted.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.teunisman.rifted.dimension.ModDimensions;

public class TrystaniumBlock extends Block {
    public TrystaniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state,
                         @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (!world.isClient && placer instanceof ServerPlayerEntity player) {
            if (world instanceof ServerWorld serverWorld) {
                openPortal(serverWorld, pos, player);
            }
        }
    }

    private void openPortal(ServerWorld world, BlockPos pos, ServerPlayerEntity player) {
        player.sendMessage(net.minecraft.text.Text.of("A portal opens..."), false);

        ServerWorld targetWorld = world.getServer().getWorld(ModDimensions.SHADOW_WORLD_KEY);
        if (targetWorld == null) {
            player.sendMessage(net.minecraft.text.Text.of("Shadow World not found!"), false);
            return;
        }

        // Platform bouwen
        createSpawnPlatform(targetWorld);

        // Speler teleporteren
        player.teleport(targetWorld,
                0.5, 100, 0.5,
                player.getYaw(), player.getPitch());
    }

    private void createSpawnPlatform(ServerWorld world) {
        BlockPos base = new BlockPos(0, 100, 0);
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                world.setBlockState(base.add(x, 0, z), net.minecraft.block.Blocks.STONE.getDefaultState());
            }
        }
    }
}
