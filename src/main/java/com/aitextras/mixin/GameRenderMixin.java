package com.aitextras.mixin;

import com.aitextras.core.AITExtrasItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
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
    protected abstract void loadPostProcessor(Identifier id);

    @Shadow
    public abstract void disablePostProcessor();

    @Final
    @Shadow
    private MinecraftClient client;

    @Unique
    private static final Identifier GLASSES_SHADER =
            new Identifier("minecraft", "shaders/post/deconverge.json");

    @Unique
    private boolean shaderActive = false;

    @Inject(method = "render", at = @At("HEAD"))
    private void aitextras$applyGlassesShader(
            float tickDelta, long startTime, boolean tick, CallbackInfo ci) {

        ClientPlayerEntity player = client.player;
        if (player == null) return;

        boolean firstPerson =
                client.options.getPerspective() == Perspective.FIRST_PERSON;

        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        boolean wearingGlasses = helmet.isOf(AITExtrasItems.THREED_GLASSES);


        if (!firstPerson) {
            shaderActive = false;
            return;
        }

        if (wearingGlasses && !shaderActive) {
            loadPostProcessor(GLASSES_SHADER);
            shaderActive = true;
            return;
        }

        if (!wearingGlasses && shaderActive) {
            disablePostProcessor();
            shaderActive = false;
        }
    }
}