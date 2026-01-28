package com.aitextras.core.blocks;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmitterBlock extends Block {

    public static final BooleanProperty ON = BooleanProperty.of("on");

    public EmitterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(ON)) {
            double centerX = pos.getX() + 0.5;
            double centerZ = pos.getZ() + 0.5;

            int outerAmount = 3;
            double outerSpread = 0.5;

            for (int i = 0; i < outerAmount; i++) {
                double y = pos.getY() + 1;

                double x = centerX + (random.nextDouble() - 0.5) * outerSpread;
                double z = centerZ + (random.nextDouble() - 0.5) * outerSpread;


                double yVelocity = 0.1 + random.nextDouble() * 0.1;

                world.addParticle(
                        ParticleTypes.CLOUD,
                        x, y, z,
                        0.0, yVelocity, 0.0
                );
            }
        }
    }


    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos,
                               Block sourceBlock, BlockPos sourcePos, boolean notify) {

        if (world.isClient) return;

        boolean powered = world.isReceivingRedstonePower(pos);
        boolean open = state.get(ON);

        if (powered != open) {
            world.setBlockState(pos, state.with(ON, powered), Block.NOTIFY_ALL);


        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("block.tooltip.emitter").formatted(Formatting.GOLD));

    }
}
