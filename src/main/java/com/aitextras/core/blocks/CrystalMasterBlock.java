package com.aitextras.core.blocks;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.blockentities.CrystalMasterBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalMasterBlock extends Block implements BlockEntityProvider {

    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public CrystalMasterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState()
                .with(POWERED, false);
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
        return true;
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return AITExtrasBlockEntityTypes.CRYSTAL_MASTER_BLOCK.instantiate(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull World world, @NotNull BlockState state,
                                                                  @NotNull BlockEntityType<T> type) {
        return (world1, blockPos, blockState, ticker) -> {
            if (ticker instanceof CrystalMasterBlockEntity be) {
                be.tick(world, blockPos, blockState, be);
            }
        };
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos,
                               Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.getBlockEntity(pos) instanceof CrystalMasterBlockEntity be) {

            if (world.isClient) return;

            boolean powered = world.isReceivingRedstonePower(pos);
            boolean open = state.get(POWERED);

            if (powered != open) {
                world.setBlockState(pos, state.with(POWERED, powered), Block.NOTIFY_ALL);


            }
        }

    }
}







