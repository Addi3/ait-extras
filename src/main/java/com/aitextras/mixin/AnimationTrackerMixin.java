package com.aitextras.mixin;

import dev.amble.lib.animation.AnimationTracker;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import dev.amble.lib.util.ServerLifecycleHooks;

@Mixin(AnimationTracker.class)
public class AnimationTrackerMixin {

    @Inject(method = "sync(Lnet/minecraft/network/PacketByteBuf;)V", at = @At("HEAD"), cancellable = true)
    private void onSync(PacketByteBuf buf, CallbackInfo ci) {
        if (ServerLifecycleHooks.get() == null) {
            ci.cancel();
        }
    }
}
