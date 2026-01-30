package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;


public class HatStandAcaciaBlockEntity extends AbstractHatStandBlockEntity {
    public HatStandAcaciaBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HAT_STAND_ACACIA_BLOCK_ENTITY_TYPE, pos, state);
    }
}

