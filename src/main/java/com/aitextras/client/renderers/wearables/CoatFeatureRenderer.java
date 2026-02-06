package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.CoatModel;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(value = EnvType.CLIENT)
public class CoatFeatureRenderer<T extends LivingEntity, M extends BipedEntityModel<T> & ModelWithArms>
        extends
        FeatureRenderer<T, M>{

    private static final Identifier TENNANT = new Identifier(AITExtras.MOD_ID,
            "textures/wearables/tennant_coat.png");
    private final CoatModel model;

    public CoatFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new CoatModel(CoatModel.getTexturedModelData().createModel());
    }



    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);

        if (!(stack.isOf(AITExtrasItems.TENNANT_COAT)))
        return;

        matrixStack.push();

        this.model.body.copyTransform(this.getContextModel().body);
        this.model.LeftArm.copyTransform(this.getContextModel().leftArm);
        this.model.RightArm.copyTransform(this.getContextModel().rightArm);
        this.model.LeftLeg.copyTransform(this.getContextModel().leftLeg);
        this.model.RightLeg.copyTransform(this.getContextModel().rightLeg);
        matrixStack.scale(1.15f, 1.1f, 1.1f);

        this.model.setAngles(livingEntity, f, g, j, k, l);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(
                TENNANT));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1f);

        matrixStack.pop();
    }
}
