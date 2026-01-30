package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
import com.aitextras.core.AITExtrasItems;
import com.aitextras.core.item.FezItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

@Environment(value = EnvType.CLIENT)
public class FezHatFeatureRenderer <T extends LivingEntity, M extends BipedEntityModel<T> & ModelWithArms>
        extends
        FeatureRenderer<T, M> {

    private static final Identifier WHITE_FEZ_HAT = AITExtras.id(
            "textures/wearables/white_fez.png");
    private final FezHatModel model;

    public  FezHatFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new FezHatModel(FezHatModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);

        if (!(stack.getItem() instanceof FezItem fezItem))
            return;

        int color = fezItem.getColor(stack);
        float red = ((color >> 16) & 0xFF) / 255.0f;
        float green = ((color >> 8) & 0xFF) / 255.0f;
        float blue = (color & 0xFF) / 255.0f;

        matrixStack.push();

        if (livingEntity instanceof ArmorStandEntity) {
            matrixStack.translate(-0.05F, 0.05f, 0.0F);
        }

        this.model.hat.copyTransform(this.getContextModel().head);
        this.model.setAngles(livingEntity, f, g, j, k, l);

        matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(10));
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(WHITE_FEZ_HAT));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, red, green, blue, 1f);

        matrixStack.pop();
    }
}
