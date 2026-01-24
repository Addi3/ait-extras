package com.aitextras.mixin.client.rendering;

import com.aitextras.core.AITExtrasBlocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

/// Thx maketendo for telling me about this

@Mixin(ClientWorld.class)
public abstract class ElevatorBlockRendererMixin {

    @Shadow
    @Final
    @Mutable
    private static Set<Item> BLOCK_MARKER_ITEMS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addCustomBlockMarkerItem(CallbackInfo ci) {
        Set<Item> newSet = new HashSet<>(BLOCK_MARKER_ITEMS);
        newSet.add(AITExtrasBlocks.ELEVATOR.asItem());
        BLOCK_MARKER_ITEMS = Set.copyOf(newSet);
    }
}
