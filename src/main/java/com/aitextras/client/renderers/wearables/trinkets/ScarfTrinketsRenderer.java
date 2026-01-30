package com.aitextras.client.renderers.wearables.trinkets;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.ScarfModel;
import com.aitextras.core.AITExtrasItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ScarfTrinketsRenderer implements TrinketRenderer {

    private final ScarfModel scarfModel = new ScarfModel(ScarfModel.getTexturedModelData().createModel());

    private static final Identifier SCARF = AITExtras.id(
            "textures/wearables/scarf.png");
    private static final Identifier SCARF_RED = AITExtras.id(
            "textures/wearables/scarf_red.png");
    private static final Identifier SCARF_RAINBOW = AITExtras.id(
            "textures/wearables/scarf_rainbow.png");

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       LivingEntity entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        matrices.push();

        if (contextModel instanceof BipedEntityModel<?> biped) {
            biped.body.rotate(matrices);
        }
        matrices.translate(0D, 0.0D, 0.0D);
        matrices.scale(1.05F, 1.05F, 1.05F);

        Identifier texture;
        if (stack.getItem() == AITExtrasItems.SCARF_RED) {
            texture = SCARF_RED;
        } else if (stack.getItem() ==  AITExtrasItems.SCARF_RAINBOW) {
            texture = SCARF_RAINBOW;
        } else {
            texture = SCARF;
        }

        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                scarfModel.getLayer(texture),
                false,
                stack.hasGlint()
        );

        scarfModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
