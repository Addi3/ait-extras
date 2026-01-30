package com.aitextras.core.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public abstract class AbstractHatStandBlockEntity extends BlockEntity {
    public AbstractHatStandBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public float getScale() {
        return 1.2f; // Replace with logic to dynamically determine the scale if needed
    }
}
