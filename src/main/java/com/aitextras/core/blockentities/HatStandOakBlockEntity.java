package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class HatStandOakBlockEntity extends BlockEntity {

    public HatStandOakBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HAT_STAND_OAK_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }
}

