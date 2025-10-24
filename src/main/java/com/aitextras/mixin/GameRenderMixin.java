package com.aitextras.mixin;

import com.aitextras.core.AITExtrasItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRenderMixin {
    @Shadow
    abstract void loadPostProcessor(Identifier id);

    @Shadow
    abstract void disablePostProcessor();

    @Shadow
    MinecraftClient client;

    private static final Identifier GLASSES_SHADER =
            new Identifier("minecraft", "shaders/post/deconverge.json");

    private boolean shaderActive = false;
    private ClientPlayerEntity lastCameraPlayer = null;
    private int lastPerspective = -1;

    @Inject(method = "render", at = @At("HEAD"))
    private void applyShader(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        // Current perspective
        int currentPerspective = client.options.getPerspective().ordinal();

        // Current camera entity
        ClientPlayerEntity cameraPlayer = null;
        if (client.cameraEntity instanceof ClientPlayerEntity player) {
            cameraPlayer = player;
        }

        boolean wearing = false;
        if (cameraPlayer != null) {
            ItemStack head = cameraPlayer.getEquippedStack(EquipmentSlot.HEAD);
            wearing = head.isOf(AITExtrasItems.THREED_GLASSES);
        }

        // Only update shader if camera player or perspective changed
        boolean needsUpdate = cameraPlayer != lastCameraPlayer || currentPerspective != lastPerspective;

        lastCameraPlayer = cameraPlayer;
        lastPerspective = currentPerspective;

        if (needsUpdate) {
            // Disable shader if it was active
            if (shaderActive) {
                disablePostProcessor();
                shaderActive = false;
            }
        }

        // Enable shader if the camera player is wearing glasses
        if (wearing && !shaderActive) {
            loadPostProcessor(GLASSES_SHADER);
            shaderActive = true;
        }
    }
}
