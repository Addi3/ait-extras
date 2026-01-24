package com.aitextras.core.blocks;

import com.aitextras.core.AITExtrasBlocks;
import dev.amble.ait.AITMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.List;

public class ElevatorBlock extends Block {

    public ElevatorBlock(Settings settings) {
        super(settings);
    }

    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

  protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
      return floor.isOf(AITExtrasBlocks.ELEVATOR) || floor.isOf(AITExtrasBlocks.ELEVATOR_BASE);
  }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

        double centerX = pos.getX() + 0.5;
        double centerZ = pos.getZ() + 0.5;

        int outerAmount = 3;
        double outerSpread = 0.5;

        for (int i = 0; i < outerAmount; i++) {
            double yOffset = (double) i / outerAmount;
            double y = pos.getY() + yOffset;

            double x = centerX + (random.nextDouble() - 0.5) * outerSpread;
            double z = centerZ + (random.nextDouble() - 0.5) * outerSpread;

            world.addParticle(
                    ParticleTypes.END_ROD,
                    x, y, z,
                    0.0, 0.0, 0.0
            );
        }

        int innerAmount = 1;
        double innerSpread = 1;

        for (int i = 0; i < innerAmount; i++) {
            double y = pos.getY() + random.nextDouble();

            double x = centerX + (random.nextDouble() - 0.5) * innerSpread;
            double z = centerZ + (random.nextDouble() - 0.5) * innerSpread;

            world.addParticle(
                    AITMod.CORAL_PARTICLE,
                    x, y, z,
                    0.0, 0.0, 0.0
            );
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    BlockPos blockPos = pos.down();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }


    protected void appendTooltip(ItemStack stack, List<Text> tooltip) {
        tooltip.add(
                Text.translatable("block.tooltip.elevatorplaceable")
                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xffffff)))
                        .append(Text.literal(" "))
                        .append(
                                Text.translatable("block.tooltip.elevatorinteract")
                                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xffffff)))
                        )
        );
    }

}
