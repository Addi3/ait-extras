package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.ThreeDGlassesModel;
import com.aitextras.core.AITExtrasItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class ThreeDGlassesFeatureRenderer<T extends LivingEntity, M extends BipedEntityModel<T> & ModelWithArms>
        extends
        FeatureRenderer<T, M>{

    private static final Identifier GLASSES = AITExtras.id(
            "textures/wearables/3d_glasses.png");
    private final ThreeDGlassesModel model;

    public ThreeDGlassesFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new ThreeDGlassesModel(ThreeDGlassesModel.getTexturedModelData().createModel());
    }



    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);

        if (!(stack.isOf(AITExtrasItems.THREED_GLASSES)))
        return;

        matrixStack.push();

        if (livingEntity instanceof ArmorStandEntity) {

            matrixStack.translate(0.0F, 0.0f, 0.0F);

        }
        this.model.glasses.copyTransform(this.getContextModel().head);
        this.model.setAngles(livingEntity, f, g, j, k, l);

        this.model.setAngles(livingEntity, f, g, j, k, l);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(
                GLASSES));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1f);

        matrixStack.pop();
    }
}
