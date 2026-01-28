package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class HudolinSupportBaseBlockEntity extends BlockEntity {

    public HudolinSupportBaseBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_BASE_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }
}

