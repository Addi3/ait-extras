package com.aitextras.core;

import com.aitextras.AITExtras;
import com.aitextras.core.item.FezItem;
import dev.amble.lib.container.impl.ItemGroupContainer;
import dev.amble.lib.itemgroup.AItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DyeColor;

public final class AITExtrasItemGroups implements ItemGroupContainer {

    public static final AItemGroup MAIN = AItemGroup.builder(AITExtras.id("item_group"))
            .icon(() -> new ItemStack(AITExtrasBlocks.EXTRAS_MONITOR_BLOCK.asItem()))
            .build();

    public static final AItemGroup COSMETICS = AItemGroup.builder(AITExtras.id("item_group_cosmetics"))
            .icon(() -> {
                if (AITExtrasItems.FEZ_ITEM instanceof FezItem item) {
                    ItemStack stack = new ItemStack(item);
                    item.setColor(stack, 11546150); // 11546150 is DyeColor.RED - Loqor
                    return stack;
                }
                return new ItemStack(AITExtrasItems.FEZ_ITEM);
            })
            .build();
}