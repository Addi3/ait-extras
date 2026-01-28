package com.aitextras.core.blocks;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.AITExtrasSounds;
import com.aitextras.core.blockentities.RoundelDoorBlockEntity;
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
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RoundelDoorBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public RoundelDoorBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(OPEN, false));
    }


    protected static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(-16, 0, 0, 16, 32, 8);
    protected static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(0, 0, 8, 32, 32, 16);
    protected static final VoxelShape SHAPE_WEST  = Block.createCuboidShape(0, 0, 0, 8, 32, 32);
    protected static final VoxelShape SHAPE_EAST  = Block.createCuboidShape(8, 0, -16, 16, 32, 16);


    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState()
                .with(FACING, context.getHorizontalPlayerFacing().getOpposite())
                .with(OPEN, false);
    }

    private static VoxelShape getShapeForDirection(Direction direction) {
        return switch (direction) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST  -> SHAPE_EAST;
            case WEST  -> SHAPE_WEST;
            default    -> SHAPE_NORTH;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(OPEN) ? VoxelShapes.empty() : getShapeForDirection(state.get(FACING));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForDirection(state.get(FACING));
    }

    @Override
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return AITExtrasBlockEntityTypes.ROUNDEL_DOOR_BLOCK_ENTITY_TYPE.instantiate(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull World world, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return (world1, blockPos, blockState, ticker) -> {
            if (ticker instanceof RoundelDoorBlockEntity be) {
                be.tick(world, blockPos, blockState, be);
            }
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof RoundelDoorBlockEntity be) {

            if (!world.isClient) {
                boolean isOpen = state.get(RoundelDoorBlock.OPEN);
                world.setBlockState(pos, state.with(RoundelDoorBlock.OPEN, !isOpen), Block.NOTIFY_ALL);

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
        if (world.getBlockEntity(pos) instanceof RoundelDoorBlockEntity be) {

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