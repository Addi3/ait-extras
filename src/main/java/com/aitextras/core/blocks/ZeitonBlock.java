package com.aitextras.core.blocks;

import dev.amble.ait.core.AITStatusEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ZeitonBlock extends Block {
    public ZeitonBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(AITStatusEffects.ZEITON_HIGH, 100));
        }
    }
}
