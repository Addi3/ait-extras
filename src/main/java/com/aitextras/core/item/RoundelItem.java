package com.aitextras.core.item;

import com.aitextras.client.AITExtrasEntities;
import com.aitextras.client.entities.RoundelEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class RoundelItem extends Item {
    public RoundelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        Direction side = context.getSide();
        PlayerEntity player = context.getPlayer();

        if (!world.getBlockState(blockPos).isSolidBlock(world, blockPos)) {
            return ActionResult.FAIL;
        }

        BlockPos placePos = blockPos.offset(side);
        RoundelEntity entity = new RoundelEntity(AITExtrasEntities.ROUNDEL, world, placePos, side);

        if (!world.isClient) {
            world.spawnEntity(entity);
            world.playSound(null, placePos, SoundEvents.ENTITY_ITEM_FRAME_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        if (player != null && !player.isCreative()) {
            context.getStack().decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}

