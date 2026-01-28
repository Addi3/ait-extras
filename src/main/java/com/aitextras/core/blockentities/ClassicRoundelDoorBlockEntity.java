package com.aitextras.core.blockentities;


import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.blocks.ClassicRoundelDoorBlock;
import dev.amble.lib.animation.AnimatedBlockEntity;
import dev.amble.lib.client.bedrock.BedrockAnimationReference;
import dev.amble.lib.client.bedrock.BedrockModelReference;
import lombok.Getter;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class ClassicRoundelDoorBlockEntity extends BlockEntity implements AnimatedBlockEntity, BlockEntityTicker<ClassicRoundelDoorBlockEntity> {
    private static final BedrockModelReference MODEL = new BedrockModelReference(AITExtras.MOD_ID, "classic_roundel_door_block");

    @Getter
    private final AnimationState animationState = new AnimationState();
    @Getter
    private int age = 0;


    public ClassicRoundelDoorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ClassicRoundelDoorBlockEntity(BlockPos pos, BlockState state) {
        this(AITExtrasBlockEntityTypes.CLASSIC_ROUNDEL_DOOR_BLOCK_ENTITY_TYPE, pos, state);
    }

    @Override
    public String getModId() {
        return AITExtras.MOD_ID;
    }

    @Override
    public String getTexturePrefix() {
        return "block";
    }

    @Override
    public @Nullable BedrockModelReference getModel() {
        return MODEL;
    }

    @Override
    public boolean hasEmission() {
        return true;
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state, ClassicRoundelDoorBlockEntity blockEntity) {
        age++;
    }

    public void useOn(World world, boolean sneaking, PlayerEntity player) {
        if (world.isClient) return;
        BlockState state = world.getBlockState(pos);

        if (state.get(ClassicRoundelDoorBlock.OPEN)) {
            this.playAnimation(new BedrockAnimationReference("classic_roundel_door_block", "open"));
        } else {
            this.playAnimation(new BedrockAnimationReference("classic_roundel_door_block", "close"));
        }
    }

    public void onOpenStateChanged(boolean open) {
        if (world == null || world.isClient) return;

        if (open) {
            playAnimation(new BedrockAnimationReference(
                    "classic_roundel_door_block", "open"
            ));
        } else {
            playAnimation(new BedrockAnimationReference(
                    "classic_roundel_door_block", "close"
            ));
        }
    }
}



