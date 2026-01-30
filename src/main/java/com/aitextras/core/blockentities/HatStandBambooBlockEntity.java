package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class HatStandBambooBlockEntity extends AbstractHatStandBlockEntity {

    public HatStandBambooBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HAT_STAND_BAMBOO_BLOCK_ENTITY_TYPE, pos, state);
    }
}

