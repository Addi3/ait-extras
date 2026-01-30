package com.aitextras.core.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CandleStandDoubleBlock extends Block {

    public static final BooleanProperty LIT = BooleanProperty.of("lit");
    public static final IntProperty CANDLE = IntProperty.of("candle", 0, 17);

    protected static final VoxelShape SHAPE =
            Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 26.0, 12.0);

    private static final Item[] CANDLES = new Item[]{
            Items.CANDLE,           // 1
            Items.WHITE_CANDLE,     // 2
            Items.ORANGE_CANDLE,    // 3
            Items.MAGENTA_CANDLE,   // 4
            Items.LIGHT_BLUE_CANDLE,// 5
            Items.YELLOW_CANDLE,    // 6
            Items.LIME_CANDLE,      // 7
            Items.PINK_CANDLE,      // 8
            Items.GRAY_CANDLE,      // 9
            Items.LIGHT_GRAY_CANDLE,// 10
            Items.CYAN_CANDLE,      // 11
            Items.PURPLE_CANDLE,    // 12
            Items.BLUE_CANDLE,      // 13
            Items.BROWN_CANDLE,     // 14
            Items.GREEN_CANDLE,     // 15
            Items.RED_CANDLE,       // 16
            Items.BLACK_CANDLE      // 17
    };

    public CandleStandDoubleBlock(Settings settings) {
        super(settings.luminance(state -> state.get(LIT) ? 10 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(LIT, false)
                .with(CANDLE, 0));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT) || state.get(CANDLE) == 0) return;

        double[][] offsets = {
                {0.5, 1.7, 0.5},
                {0.9, 1.7, 0.5},
                {0.5, 1.7, 0.9},
                {0.1, 1.7, 0.5},
                {0.5, 1.7, 0.1}
        };

        for (double[] offset : offsets) {
            world.addParticle(
                    ParticleTypes.FLAME,
                    pos.getX() + offset[0],
                    pos.getY() + offset[1],
                    pos.getZ() + offset[2],
                    0, 0, 0
            );
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

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, CANDLE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack stack = player.getStackInHand(hand);
        Item item = stack.getItem();

        if (item == Items.FLINT_AND_STEEL) {
            if (!state.get(LIT) && state.get(CANDLE) != 0) {
                world.setBlockState(pos, state.with(LIT, true), 3);
                world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE,
                        SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.isCreative()) stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
            }
            return ActionResult.SUCCESS;
        }

        int candleIndex = getCandleIndex(item);
        if (candleIndex != -1 && state.get(CANDLE) == 0) {
            world.setBlockState(pos, state.with(CANDLE, candleIndex), 3);
            world.playSound(null, pos, SoundEvents.BLOCK_CANDLE_PLACE,
                    SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!player.isCreative()) stack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, false), 3);
            world.playSound(null, pos, SoundEvents.BLOCK_CANDLE_EXTINGUISH,
                    SoundCategory.BLOCKS, 1.0f, 1.0f);
        }

        return ActionResult.SUCCESS;
    }

    private static int getCandleIndex(Item item) {
        for (int i = 0; i < CANDLES.length; i++) {
            if (CANDLES[i] == item) return i + 1;
        }
        return -1;
    }
}
