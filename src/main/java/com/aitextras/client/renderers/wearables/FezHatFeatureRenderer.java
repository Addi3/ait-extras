package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
import com.aitextras.core.AITExtrasItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(value = EnvType.CLIENT)
public class FezHatFeatureRenderer <T extends LivingEntity, M extends BipedEntityModel<T> & ModelWithArms>
        extends
        FeatureRenderer<T, M> {

    private static final Identifier FEZ_HAT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/fez_hat.png");
    private final FezHatModel model;

    public  FezHatFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new FezHatModel(FezHatModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);

        if (!(stack.isOf(AITExtrasItems.FEZ_HAT)))
            return;

        if (!(livingEntity instanceof AbstractClientPlayerEntity))
            return;

        matrixStack.push();

        this.model.hat.copyTransform(this.getContextModel().head);
        this.model.setAngles(livingEntity, f, g, j, k, l);

        matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(-10));

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(FEZ_HAT));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1f);

        matrixStack.pop();

    }
}
