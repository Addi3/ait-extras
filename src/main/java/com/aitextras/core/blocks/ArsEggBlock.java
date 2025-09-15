package com.aitextras.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArsEggBlock extends HorizontalFacingBlock {
    public static final BooleanProperty ON = BooleanProperty.of("on");

    protected static final VoxelShape SHAPE= Block.createCuboidShape(
            3.8, -0.2, 3.8, 12.2, 12.2, 12.2
    );

    public ArsEggBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(ON, false));
    }



    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        boolean isSneaking = ctx.getPlayer() != null && ctx.getPlayer().isSneaking();

        return this.getDefaultState()
                .with(ON, isSneaking);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ON);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              net.minecraft.entity.player.PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        if (!world.isClient) {
            if (!state.get(ON)) {
                world.setBlockState(pos, state.with(ON, true), 3);
            }
            if (state.get(ON)) {
                world.setBlockState(pos, state.with(ON, false), 3);
            }
        }
        return ActionResult.SUCCESS;
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("block.tooltip.ars_egg").formatted(Formatting.GOLD));

    }
}
