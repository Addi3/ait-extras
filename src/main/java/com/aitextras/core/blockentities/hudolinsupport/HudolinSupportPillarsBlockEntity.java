package com.aitextras.core.blockentities.hudolinsupport;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class HudolinSupportPillarsBlockEntity extends BlockEntity {

    public HudolinSupportPillarsBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_PILLARS_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }
}

