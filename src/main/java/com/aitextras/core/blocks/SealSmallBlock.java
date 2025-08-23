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
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.aitextras.core.blocks.SealBlock.CENTERED;

public class SealSmallBlock extends HorizontalFacingBlock {
    public static final BooleanProperty CENTERED = BooleanProperty.of("centered");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    protected static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(
            0, 0, 0, 16, 16, 2
    );

    protected static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(
            0, 0, 14, 16, 16, 16
    );

    protected static final VoxelShape SHAPE_EAST = Block.createCuboidShape(
            14, 0, 0, 16, 16, 16
    );

    protected static final VoxelShape SHAPE_WEST = Block.createCuboidShape(
            0, 0, 0, 2, 16, 16
    );


    public SealSmallBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(CENTERED, false));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getCollisionShape(state, world, pos, context);
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        boolean isSneaking = ctx.getPlayer() != null && ctx.getPlayer().isSneaking();

        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing())
                .with(CENTERED, isSneaking);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, CENTERED);
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              net.minecraft.entity.player.PlayerEntity player,
                              Hand hand, BlockHitResult hit) {

        if (!world.isClient) {
            boolean current = state.get(CENTERED);
            world.setBlockState(pos, state.with(CENTERED, !current));

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        super.appendTooltip(stack, world, tooltip, options);
        tooltip.add(Text.translatable("block.tooltip.seal").formatted(Formatting.GOLD));

    }
}
