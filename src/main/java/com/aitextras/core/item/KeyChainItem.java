package com.aitextras.core.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Optional;

public class KeyChainItem extends Item {

    private static final String ITEMS_KEY = "Items";
    private static final int MAX_ITEMS = 3;

    private static final TagKey<Item> KEYCHAIN_ALLOWED_TAG = TagKey.of(
            RegistryKeys.ITEM, new Identifier("ait-extras", "keychain_items")
    );

    public KeyChainItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack keychain, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) return false;

        ItemStack slotStack = slot.getStack();

        if (slotStack.isEmpty()) {
            removeFirstItem(keychain).ifPresent(stack -> {
                slot.insertStack(stack);
                playRemoveSound(player);
                refreshClientSlot(player, slot, keychain);
            });
            return true;
        }

        if (canAddItem(keychain, slotStack)) {
            ItemStack single = slot.takeStack(1);
            addItem(keychain, single);
            playInsertSound(player);
            refreshClientSlot(player, slot, keychain);
            return true;
        }

        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack keychain = user.getStackInHand(hand);

        if (!world.isClient) {
            removeFirstItem(keychain).ifPresent(stack -> {
                user.dropItem(stack, true);
                playDropSound(user);
                refreshHeldStack(user, hand, keychain);
            });
        }

        return TypedActionResult.success(keychain, world.isClient);
    }

    private static boolean canAddItem(ItemStack keychain, ItemStack stack) {
        return !stack.isEmpty() && getItemCount(keychain) < MAX_ITEMS && stack.isIn(KEYCHAIN_ALLOWED_TAG);
    }

    private static int getItemCount(ItemStack keychain) {
        NbtCompound nbt = keychain.getNbt();
        if (nbt == null || !nbt.contains(ITEMS_KEY)) return 0;
        return nbt.getList(ITEMS_KEY, 10).size();
    }

    private static void addItem(ItemStack keychain, ItemStack stack) {
        NbtCompound nbt = keychain.getOrCreateNbt();
        NbtList list = nbt.getList(ITEMS_KEY, 10);

        NbtCompound entry = new NbtCompound();
        stack.writeNbt(entry);
        entry.putInt("Count", 1);

        list.add(entry);
        nbt.put(ITEMS_KEY, list);
    }

    private static Optional<ItemStack> removeFirstItem(ItemStack keychain) {
        NbtCompound nbt = keychain.getNbt();
        if (nbt == null || !nbt.contains(ITEMS_KEY)) return Optional.empty();

        NbtList list = nbt.getList(ITEMS_KEY, 10);
        if (list.isEmpty()) return Optional.empty();

        ItemStack stack = ItemStack.fromNbt(list.getCompound(0));
        list.remove(0);

        if (list.isEmpty()) {
            keychain.removeSubNbt(ITEMS_KEY);
        }

        return Optional.of(stack);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BLOCK_CHAIN_PLACE, 1F,
                0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playRemoveSound(Entity entity) {
        entity.playSound(SoundEvents.BLOCK_CHAIN_BREAK, 1F,
                0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playDropSound(Entity entity) {
        entity.playSound(SoundEvents.BLOCK_CHAIN_BREAK, 1F,
                0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private static void refreshClientSlot(PlayerEntity player, Slot slot, ItemStack stack) {
        if (player.getWorld().isClient) {
            slot.setStack(slot.getStack());
        } else {
            player.currentScreenHandler.sendContentUpdates();
        }
    }

    private static void refreshHeldStack(PlayerEntity player, Hand hand, ItemStack stack) {
        if (player.getWorld().isClient) {
            player.setStackInHand(hand, stack);
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }

    public static float getFillLevel(ItemStack stack) {
        return getItemCount(stack);
    }
}

