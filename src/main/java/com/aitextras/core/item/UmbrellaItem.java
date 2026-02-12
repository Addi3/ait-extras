package com.aitextras.core.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

import java.util.function.Supplier;

public class UmbrellaItem extends Item implements DifferingHandModelItem {

    private final Supplier<Item> swapTo;

    public UmbrellaItem(Settings settings, Supplier<Item> swapTo) {
        super(settings);
        this.swapTo = swapTo;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getBlockPos(),
                    SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
                    SoundCategory.PLAYERS, 1f, 1f);

            ItemStack newStack = new ItemStack(swapTo.get(), stack.getCount());
            if (stack.hasNbt()) newStack.setNbt(stack.getNbt());

            user.setStackInHand(hand, newStack);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
