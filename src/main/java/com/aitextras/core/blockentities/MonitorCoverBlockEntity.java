package com.aitextras.core.blockentities;


import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.blocks.MonitorCoverBlock;
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


public class MonitorCoverBlockEntity extends BlockEntity implements AnimatedBlockEntity, BlockEntityTicker<MonitorCoverBlockEntity> {
    private static final BedrockModelReference MODEL = new BedrockModelReference(AITExtras.MOD_ID, "monitor_cover_block");

    @Getter
    private final AnimationState animationState = new AnimationState();
    @Getter
    private int age = 0;

    public MonitorCoverBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public MonitorCoverBlockEntity(BlockPos pos, BlockState state) {
        this(AITExtrasBlockEntityTypes.MONITOR_COVER_BLOCK_ENTITY_TYPE, pos, state);
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
        return false;
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state, MonitorCoverBlockEntity blockEntity) {
        age++;
    }

    public void useOn(World world, boolean sneaking, PlayerEntity player) {
        if (world.isClient) return;
        BlockState state = world.getBlockState(pos);

        if (state.get(MonitorCoverBlock.OPEN)) {
            this.playAnimation(new BedrockAnimationReference("monitor_cover_block", "open"));
        } else {
            this.playAnimation(new BedrockAnimationReference("monitor_cover_block", "close"));
        }
    }

}



