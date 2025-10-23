package com.aitextras.core.blockentities;


import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlockEntityTypes;
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



public class CrystalBlockEntity extends BlockEntity implements AnimatedBlockEntity, BlockEntityTicker<CrystalBlockEntity> {
    private static final BedrockModelReference MODEL = new BedrockModelReference(AITExtras.MOD_ID, "crystal_block");

    @Getter
    private final AnimationState animationState = new AnimationState();
    @Getter
    private int age = 0;

    public CrystalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public CrystalBlockEntity(BlockPos pos, BlockState state) {
        this(AITExtrasBlockEntityTypes.CRYSTAL_BLOCK, pos, state);
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
    public void tick(World world, BlockPos pos, BlockState state, CrystalBlockEntity blockEntity) {
        age++;
    }


    public void useOn(World world, boolean sneaking, PlayerEntity player,Tardis tardis) {
        if (tardis.travel().inFlight()) return;
            this.playAnimation(new BedrockAnimationReference("crystal_block", "flight"));
        }



}



