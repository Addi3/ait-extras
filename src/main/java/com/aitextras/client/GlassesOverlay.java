package com.aitextras.client;

import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasItems;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;


public class GlassesOverlay implements HudRenderCallback {

    private static final Identifier OVERLAY = new Identifier (AITExtras.MOD_ID, "textures/gui/overlays/glasses.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        boolean hasGlassesOn = client.player.getEquippedStack(EquipmentSlot.HEAD).getItem() == AITExtrasItems.THREED_GLASSES;
        if (hasGlassesOn && client.options.getPerspective().isFirstPerson()) {
            RenderSystem.depthMask(false);
            drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0f);
            drawContext.drawTexture(OVERLAY, 0, 0, -200, 0, 0, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight(), drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
            RenderSystem.depthMask(true);
            drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}