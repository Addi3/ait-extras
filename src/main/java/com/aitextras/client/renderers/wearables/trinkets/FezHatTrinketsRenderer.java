package com.aitextras.client.renderers.wearables.trinkets;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
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
import net.minecraft.util.math.RotationAxis;

public class FezHatTrinketsRenderer implements TrinketRenderer {

    private final FezHatModel fezhatModel = new FezHatModel(FezHatModel.getTexturedModelData().createModel());

    private static final Identifier WHITE_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/white_fez.png");
    private static final Identifier BLACK_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/black_fez.png");
    private static final Identifier BLUE_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/blue_fez.png");
    private static final Identifier BROWN_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/brown_fez.png");
    private static final Identifier CYAN_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/cyan_fez.png");
    private static final Identifier GRAY_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/gray_fez.png");
    private static final Identifier GREEN_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/green_fez.png");
    private static final Identifier LIGHT_BLUE_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/light_blue_fez.png");
    private static final Identifier LIGHT_GRAY_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/light_gray_fez.png");
    private static final Identifier LIME_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/lime_fez.png");
    private static final Identifier MAGENTA_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/magenta_fez.png");
    private static final Identifier ORANGE_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/orange_fez.png");
    private static final Identifier PINK_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/pink_fez.png");
    private static final Identifier PURPLE_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/purple_fez.png");
    private static final Identifier RED_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/red_fez.png");
    private static final Identifier YELLOW_FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/yellow_fez.png");

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       LivingEntity entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        matrices.push();

        if (contextModel instanceof BipedEntityModel<?> biped) {
            biped.head.rotate(matrices);
        }
        matrices.translate(-0.1D, 0.55D, 0.D);
        matrices.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(-10));

        Identifier texture;
        if (stack.getItem() == AITExtrasItems.BLACK_FEZ_HAT) {
            texture = BLACK_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.BLUE_FEZ_HAT) {
            texture = BLUE_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.BROWN_FEZ_HAT) {
            texture = BROWN_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.CYAN_FEZ_HAT) {
            texture = CYAN_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.GRAY_FEZ_HAT) {
            texture = GRAY_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.GREEN_FEZ_HAT) {
            texture = GREEN_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.LIGHT_BLUE_FEZ_HAT) {
            texture = LIGHT_BLUE_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.LIGHT_GRAY_FEZ_HAT) {
            texture = LIGHT_GRAY_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.LIME_FEZ_HAT) {
            texture = LIME_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.MAGENTA_FEZ_HAT) {
            texture = MAGENTA_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.ORANGE_FEZ_HAT) {
            texture = ORANGE_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.PINK_FEZ_HAT) {
            texture = PINK_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.PURPLE_FEZ_HAT) {
            texture = PURPLE_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.RED_FEZ_HAT) {
            texture = RED_FEZ_HAT;
        } else if (stack.getItem() == AITExtrasItems.YELLOW_FEZ_HAT) {
            texture = YELLOW_FEZ_HAT;
        } else {
            texture = WHITE_FEZ_HAT;
        }

        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                fezhatModel.getLayer(texture),
                false,
                stack.hasGlint()
        );

        fezhatModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
