package com.aitextras.core.blocks;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.AITExtrasSounds;
import com.aitextras.core.blockentities.ClassicMonitorCoverBlockEntity;
import com.aitextras.core.blockentities.ClassicRoundelDoorBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClassicMonitorCoverBlock extends Block implements BlockEntityProvider {

    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
    public static final IntProperty ROTATION = Properties.ROTATION;
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    public ClassicMonitorCoverBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ROTATION, 0));
    }


    protected static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 32, 16);


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(OPEN, false);
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
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return AITExtrasBlockEntityTypes.CLASSIC_MONITOR_COVER_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull World world, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return (world1, blockPos, blockState, ticker) -> {
            if (ticker instanceof ClassicMonitorCoverBlockEntity be) {
                be.tick(world, blockPos, blockState, be);
            }
        };
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), MAX_ROTATIONS));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, mirror.mirror(state.get(ROTATION), MAX_ROTATIONS));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, OPEN);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof ClassicMonitorCoverBlockEntity be) {

            if (!world.isClient) {
                boolean isOpen = state.get(ClassicMonitorCoverBlock.OPEN);
                world.setBlockState(pos, state.with(ClassicMonitorCoverBlock.OPEN, !isOpen), Block.NOTIFY_ALL);

                world.playSound(
                        null,
                        pos,
                        AITExtrasSounds.ROUNDEL_DOOR,
                        SoundCategory.BLOCKS,
                        3.0f,
                        1.0f
                );
            }

            be.useOn(world, player.isSneaking(), player);
            return ActionResult.SUCCESS;
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos,
                               Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.getBlockEntity(pos) instanceof ClassicMonitorCoverBlockEntity be) {

            if (world.isClient) return;

            boolean powered = world.isReceivingRedstonePower(pos);
            boolean open = state.get(OPEN);

            if (powered != open) {
                world.setBlockState(pos, state.with(OPEN, powered), Block.NOTIFY_ALL);

                world.playSound(
                        null,
                        pos,
                        AITExtrasSounds.ROUNDEL_DOOR,
                        SoundCategory.BLOCKS,
                        3.0f,
                        1.0f
                );
                be.onOpenStateChanged(powered);
            }
        }
    }

    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(
                Text.translatable("block.tooltip.roundeldoorinteract")
                        .formatted(Formatting.GOLD));

        tooltip.add(
                Text.translatable("block.tooltip.roundeldoorredstone")
                        .formatted(Formatting.GOLD));
    }
}



