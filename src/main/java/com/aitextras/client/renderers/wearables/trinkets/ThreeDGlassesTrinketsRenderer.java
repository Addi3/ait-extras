package com.aitextras.client.renderers.wearables.trinkets;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.ThreeDGlassesModel;
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

public class ThreeDGlassesTrinketsRenderer implements TrinketRenderer {

    private final ThreeDGlassesModel threeDGlassesModel = new ThreeDGlassesModel(ThreeDGlassesModel.getTexturedModelData().createModel());

    private static final Identifier GLASSES = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/3d_glasses.png");

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       LivingEntity entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        matrices.push();

        if (contextModel instanceof BipedEntityModel<?> biped) {
            biped.head.rotate(matrices);
        }
        matrices.translate(0.0D, 0.05D, 0.D);


        matrices.translate(0D, 0.0D, 0.0D);

        Identifier texture;
        texture = GLASSES;



        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                threeDGlassesModel.getLayer(texture),
                false,
                stack.hasGlint()
        );

        threeDGlassesModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
