package com.aitextras.core.item;

import dev.amble.ait.core.AITSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public class UmbrellaItem extends Item implements DifferingHandModelItem {

    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        world.playSound(null, user.getBlockPos(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, SoundCategory.PLAYERS, 1f, 1f);
        if (!world.isClient) {
            NbtCompound nbt = stack.getOrCreateNbt();
            boolean open = nbt.getBoolean("Open");
            nbt.putBoolean("Open", !open);
        }

        return TypedActionResult.success(stack, world.isClient());
    }


}
