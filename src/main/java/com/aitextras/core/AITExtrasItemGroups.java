package com.aitextras.core;

import com.aitextras.AITExtras;
import dev.amble.lib.container.impl.ItemGroupContainer;
import dev.amble.lib.itemgroup.AItemGroup;
import net.minecraft.item.ItemStack;

public final class AITExtrasItemGroups implements ItemGroupContainer {


    public static final AItemGroup COSMETICS = AItemGroup.builder(AITExtras.id("item_group_cosmetics"))
            .icon(() -> new ItemStack(AITExtrasItems.RED_FEZ_HAT.asItem()))
            .build();
}