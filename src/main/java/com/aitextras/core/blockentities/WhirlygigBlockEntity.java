package com.aitextras.core.blockentities;


import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.blocks.CrystalBlock;
import com.aitextras.core.blocks.WhirlygigBlock;
import dev.amble.lib.animation.AnimatedBlockEntity;
import dev.amble.lib.client.bedrock.BedrockAnimationReference;
import dev.amble.lib.client.bedrock.BedrockModelReference;
import dev.amble.lib.util.ServerLifecycleHooks;
import lombok.Getter;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.AnimationState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class WhirlygigBlockEntity extends BlockEntity implements AnimatedBlockEntity, BlockEntityTicker<WhirlygigBlockEntity> {
    private static final BedrockModelReference MODEL = new BedrockModelReference(AITExtras.MOD_ID, "whirlygig");

    @Getter
    private final AnimationState animationState = new AnimationState();
    @Getter
    private int age = 0;

    public WhirlygigBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public WhirlygigBlockEntity(BlockPos pos, BlockState state) {
        this(AITExtrasBlockEntityTypes.WHIRLYGIG_BLOCK, pos, state);
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
    public void tick(World world, BlockPos pos, BlockState state, WhirlygigBlockEntity blockEntity) {

        if (!world.isClient) return;
        boolean powered = state.get(WhirlygigBlock.POWERED);

        if (powered) {
            if (age == 0) {
                this.playAnimation(new BedrockAnimationReference("whirlygig", "flight"));
            }
            if (age == 90) {
                this.playAnimation(new BedrockAnimationReference("whirlygig", "flight"));
            }
            age++;
        }
        else {
            if (age != 0) {
                this.playAnimation(
                        new BedrockAnimationReference("whirlygig", "idle")
                );
            }
            age = 0;
        }
    }
}



