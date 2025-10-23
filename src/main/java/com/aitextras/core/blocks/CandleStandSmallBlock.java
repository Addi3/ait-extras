package com.aitextras.core.blocks;


import com.aitextras.core.blockentities.CandleStandSmallBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import net.minecraft.util.math.random.Random;

public class CandleStandSmallBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
    public static final IntProperty ROTATION = Properties.ROTATION;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 26.0, 12.0);

    public CandleStandSmallBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(ROTATION, 0));
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int rotation = state.get(ROTATION);
        double angle = Math.toRadians((360.0 / MAX_ROTATIONS) * rotation);
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        class ParticleSpec {
            final ParticleEffect type;
            final double offsetX, offsetY, offsetZ;

            ParticleSpec(ParticleEffect type, double offsetX, double offsetY, double offsetZ) {
                this.type = type;
                this.offsetX = offsetX;
                this.offsetY = offsetY;
                this.offsetZ = offsetZ;
            }
        }

        ParticleSpec[] specs = new ParticleSpec[] {
                new ParticleSpec(ParticleTypes.FLAME,  0.0, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, -0.4, 1.5,  0.0),
                new ParticleSpec(ParticleTypes.FLAME, 0.4, 1.5,  0.0),
        };

        for (ParticleSpec spec : specs) {
            double rotatedX = spec.offsetX * cos - spec.offsetZ * sin;
            double rotatedZ = spec.offsetX * sin + spec.offsetZ * cos;

            double worldX = pos.getX() + 0.5 + rotatedX;
            double worldY = pos.getY() + 0.2 + spec.offsetY;
            double worldZ = pos.getZ() + 0.5 + rotatedZ;

            world.addParticle(spec.type, worldX, worldY, worldZ, 0.0, 0.0, 0.0);
        }
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


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CandleStandSmallBlockEntity(pos, state);
    }


    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()));
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
        builder.add(ROTATION);
    }


}
