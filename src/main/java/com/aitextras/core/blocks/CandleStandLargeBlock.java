package com.aitextras.core.blocks;

import com.aitextras.core.blockentities.CandleStandLargeBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.util.math.random.Random;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class CandleStandLargeBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;

    public static final IntProperty ROTATION = Properties.ROTATION;
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 26.0, 12.0);

    public CandleStandLargeBlock(Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 10 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(ROTATION, 0)
                .with(LIT, false));
    }

    private static class ParticleSpec {
        final ParticleEffect type;
        final double offsetX, offsetY, offsetZ;

        ParticleSpec(ParticleEffect type, double offsetX, double offsetY, double offsetZ) {
            this.type = type;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) return;

        ParticleSpec[] specs = new ParticleSpec[]{
                new ParticleSpec(ParticleTypes.FLAME, 0.0, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, -0.3, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, -0.5, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, 0.3, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, 0.5, 1.5, 0.0),
        };

        for (ParticleSpec spec : specs) {
            world.addParticle(spec.type,
                    pos.getX() + 0.5 + spec.offsetX,
                    pos.getY() + 0.2 + spec.offsetY,
                    pos.getZ() + 0.5 + spec.offsetZ,
                    0, 0, 0);
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
        return new CandleStandLargeBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()))
                .with(LIT, false);
    }

    public BlockState rotate(BlockState state, int rotationSteps) {
        int newRotation = (state.get(ROTATION) + rotationSteps) % MAX_ROTATIONS;
        return state.with(ROTATION, newRotation);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(ROTATION, rotation.rotate(state.get(ROTATION), MAX_ROTATIONS));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(ROTATION, mirror.mirror(state.get(ROTATION), MAX_ROTATIONS));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, LIT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);

        ParticleSpec[] specs = new ParticleSpec[]{
                new ParticleSpec(ParticleTypes.FLAME, 0.0, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, -0.3, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, -0.5, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, 0.3, 1.5, 0.0),
                new ParticleSpec(ParticleTypes.FLAME, 0.5, 1.5, 0.0),
        };

        if (heldItem.getItem() == Items.FLINT_AND_STEEL) {
            if (!state.get(LIT)) {
                world.setBlockState(pos, state.with(LIT, true), 3);
                world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                        SoundCategory.BLOCKS, 1.0f, 1.0f);

                if (!player.isCreative()) {
                    heldItem.damage(1, player, p -> p.sendToolBreakStatus(hand));
                }
            }
            return ActionResult.SUCCESS;
        } else {
            if (state.get(LIT)) {
                world.setBlockState(pos, state.with(LIT, false), 3);
                world.playSound(null, pos, SoundEvents.BLOCK_CANDLE_EXTINGUISH,
                        SoundCategory.BLOCKS, 1.0f, 1.0f);

                if (world.isClient) {
                    for (ParticleSpec spec : specs) {
                        world.addParticle(spec.type,
                                pos.getX() + 0.5 + spec.offsetX,
                                pos.getY() + 0.2 + spec.offsetY,
                                pos.getZ() + 0.5 + spec.offsetZ,
                                0, 0,0 );
                    }
                }
            }
            return ActionResult.SUCCESS;
        }
    }
}
