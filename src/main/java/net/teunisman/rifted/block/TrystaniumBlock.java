package net.teunisman.rifted.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class TrystaniumBlock extends Block {
    public TrystaniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state,
                         @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);

        if (!world.isClient && placer instanceof PlayerEntity player) {
            if (world instanceof ServerWorld serverWorld) {
                openPortal(serverWorld, pos, player);
            }
        }
    }

    private void openPortal(ServerWorld world, BlockPos pos, PlayerEntity player) {
        player.sendMessage(net.minecraft.text.Text.of("A portal opens..."), false);
        // TODO portal logic
    }
}
