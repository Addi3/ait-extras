package com.aitextras.mixin;

import com.aitextras.core.AITExtrasItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRenderMixin {
    @Shadow
    abstract void loadPostProcessor(Identifier id);

    @Shadow
    public abstract void disablePostProcessor();

    @Final
    @Shadow
    MinecraftClient client;

    @Unique
    private static final Identifier GLASSES_SHADER =
            new Identifier("minecraft", "shaders/post/deconverge.json");

    @Unique
    private boolean shaderActive = false;
    @Unique
    private ClientPlayerEntity lastCameraPlayer = null;
    @Unique
    private int lastPerspective = -1;

    @Inject(method = "render", at = @At("HEAD"))
    private void applyShader(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        int currentPerspective = client.options.getPerspective().ordinal();

        ClientPlayerEntity cameraPlayer = null;
        if (client.cameraEntity instanceof ClientPlayerEntity player) {
            cameraPlayer = player;
        }

        boolean wearing = false;
        if (cameraPlayer != null) {
            ItemStack head = cameraPlayer.getEquippedStack(EquipmentSlot.HEAD);
            wearing = head.isOf(AITExtrasItems.THREED_GLASSES);
        }

        boolean needsUpdate = cameraPlayer != lastCameraPlayer || currentPerspective != lastPerspective;
        lastCameraPlayer = cameraPlayer;
        lastPerspective = currentPerspective;

        if (shaderActive && !wearing) {
            disablePostProcessor();
            shaderActive = false;
        }

        if (wearing && !shaderActive) {
            loadPostProcessor(GLASSES_SHADER);
            shaderActive = true;
        }
    }
}