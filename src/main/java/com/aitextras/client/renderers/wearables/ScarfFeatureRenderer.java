package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
import com.aitextras.client.models.wearables.ScarfModel;
import com.aitextras.core.AITExtrasItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(value = EnvType.CLIENT)
public class ScarfFeatureRenderer<T extends LivingEntity, M extends BipedEntityModel<T> & ModelWithArms>
        extends
        FeatureRenderer<T, M> {

    private static final Identifier SCARF = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/scarf.png");
    private static final Identifier SCARF_RED = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/scarf_red.png");
    private static final Identifier SCARF_RAINBOW = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/scarf_rainbow.png");
    private final ScarfModel model;

    public ScarfFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new ScarfModel(ScarfModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);

        if (!(stack.isOf(AITExtrasItems.SCARF)|| stack.isOf(AITExtrasItems.SCARF_RED) || stack.isOf(AITExtrasItems.SCARF_RAINBOW)))
        return;

        if (!(livingEntity instanceof AbstractClientPlayerEntity))
            return;

        matrixStack.push();

        this.model.scarf.copyTransform(this.getContextModel().body);
        this.model.setAngles(livingEntity, f, g, j, k, l);

        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(
                stack.getItem() == AITExtrasItems.SCARF ? SCARF :
                        stack.getItem() == AITExtrasItems.SCARF_RED ? SCARF_RED :
                                SCARF_RAINBOW));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1f);

        matrixStack.pop();
    }
}
