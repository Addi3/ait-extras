package com.aitextras.core.blockentities;


import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.blocks.CrystalBlock;
import com.aitextras.core.blocks.CrystalMasterBlock;
import dev.amble.ait.core.tardis.Tardis;
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


public class CrystalMasterBlockEntity extends BlockEntity implements AnimatedBlockEntity, BlockEntityTicker<CrystalMasterBlockEntity> {
    private static final BedrockModelReference MODEL = new BedrockModelReference(AITExtras.MOD_ID, "master_crystal_block");

    @Getter
    private final AnimationState animationState = new AnimationState();
    @Getter
    private int age = 0;

    public CrystalMasterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public CrystalMasterBlockEntity(BlockPos pos, BlockState state) {
        this(AITExtrasBlockEntityTypes.CRYSTAL_MASTER_BLOCK, pos, state);
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
    public void tick(World world, BlockPos pos, BlockState state, CrystalMasterBlockEntity blockEntity) {

        if (!world.isClient) return;
        boolean powered = state.get(CrystalMasterBlock.POWERED);

        if (powered) {
            if (age == 0 || age >= 90) {
                this.playAnimation(
                        new BedrockAnimationReference("master_crystal_block", "flight")
                );
                age = 0;
            }
            age++;
        } else {
            if (age != 0) {
                this.playAnimation(
                        new BedrockAnimationReference("master_crystal_block", "idle")
                );
            }
            age = 0;
        }
    }
}
