package com.aitextras.core.item;


import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public interface DifferingHandModelItem {

    default Identifier getHandModel(ItemStack stack, boolean leftHand) {
        boolean open = stack.hasNbt() && stack.getNbt().getBoolean("Open");
        String modelName = open ? "handheld_umbrella_open" : "handheld_umbrella";
        return new Identifier("ait-extras", "item/" + modelName);
    }
}

