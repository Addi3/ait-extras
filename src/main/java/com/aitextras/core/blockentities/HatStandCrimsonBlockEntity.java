package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class HatStandCrimsonBlockEntity extends AbstractHatStandBlockEntity {

    public HatStandCrimsonBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HAT_STAND_CRIMSON_BLOCK_ENTITY_TYPE, pos, state);
    }
}

