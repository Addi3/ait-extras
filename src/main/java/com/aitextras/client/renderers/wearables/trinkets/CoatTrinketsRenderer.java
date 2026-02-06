package com.aitextras.client.renderers.wearables.trinkets;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.CoatModel;
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

public class CoatTrinketsRenderer implements TrinketRenderer {

    private final CoatModel coatModel = new CoatModel(CoatModel.getTexturedModelData().createModel());

    private static final Identifier TENNANT = AITExtras.id(
            "textures/wearables/tennant_coat.png");

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       LivingEntity entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        matrices.push();

        if (contextModel instanceof BipedEntityModel<?> biped) {
            this.coatModel.body.copyTransform(biped.body);
            this.coatModel.LeftArm.copyTransform(biped.leftArm);
            this.coatModel.RightArm.copyTransform(biped.rightArm);
            this.coatModel.LeftLeg.copyTransform(biped.leftLeg);
            this.coatModel.RightLeg.copyTransform(biped.rightLeg);
        }
        matrices.translate(0D, 0.0D, 0.0D);
        matrices.scale(1.15f, 1.1f, 1.1f);

        Identifier texture;
        texture = TENNANT;



        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                coatModel.getLayer(texture),
                false,
                stack.hasGlint()
        );

        coatModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
