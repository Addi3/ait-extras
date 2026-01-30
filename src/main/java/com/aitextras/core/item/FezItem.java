package com.aitextras.core.item;

import dev.amble.ait.core.item.RenderableArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class FezItem extends RenderableArmorItem implements DyeableItem {

    public static final int DEFAULT_COLOR = 0xffffff;

    public FezItem(ArmorMaterial material, Type type, Settings settings, boolean hasCustomRendering) {
        super(material, type, settings, hasCustomRendering);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt(DISPLAY_KEY);
        if (nbtCompound != null && nbtCompound.contains(COLOR_KEY, NbtElement.NUMBER_TYPE)) {
            return nbtCompound.getInt(COLOR_KEY);
        }
        return DEFAULT_COLOR;
    }
}
