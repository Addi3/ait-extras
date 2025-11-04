package com.aitextras.client.renderers.wearables;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
import com.aitextras.core.AITExtrasItems;
import dev.amble.ait.core.AITItems;
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
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
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
    private final FezHatModel model;

    public  FezHatFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.model = new FezHatModel(FezHatModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
                       float f, float g, float h, float j, float k, float l) {
        ItemStack stack = livingEntity.getEquippedStack(EquipmentSlot.HEAD);

        if (!(stack.isOf(AITExtrasItems.WHITE_FEZ_HAT) || stack.isOf(AITExtrasItems.BLACK_FEZ_HAT) || stack.isOf(AITExtrasItems.BLUE_FEZ_HAT) || stack.isOf(AITExtrasItems.BROWN_FEZ_HAT) || stack.isOf(AITExtrasItems.CYAN_FEZ_HAT) || stack.isOf(AITExtrasItems.GRAY_FEZ_HAT) || stack.isOf(AITExtrasItems.GREEN_FEZ_HAT) || stack.isOf(AITExtrasItems.LIGHT_BLUE_FEZ_HAT) || stack.isOf(AITExtrasItems.LIGHT_GRAY_FEZ_HAT) || stack.isOf(AITExtrasItems.LIME_FEZ_HAT) || stack.isOf(AITExtrasItems.MAGENTA_FEZ_HAT) || stack.isOf(AITExtrasItems.ORANGE_FEZ_HAT) || stack.isOf(AITExtrasItems.PINK_FEZ_HAT) || stack.isOf(AITExtrasItems.PURPLE_FEZ_HAT) || stack.isOf(AITExtrasItems.RED_FEZ_HAT) || stack.isOf(AITExtrasItems.YELLOW_FEZ_HAT)))
            return;


        matrixStack.push();


        if (livingEntity instanceof ArmorStandEntity) {

            matrixStack.translate(-0.05F, 0.05f, 0.0F);

        }
        this.model.hat.copyTransform(this.getContextModel().head);
        this.model.setAngles(livingEntity, f, g, j, k, l);

        matrixStack.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(-10));
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntitySmoothCutout(
                stack.getItem() == AITExtrasItems.WHITE_FEZ_HAT ? WHITE_FEZ_HAT :
            stack.getItem() == AITExtrasItems.BLACK_FEZ_HAT ? BLACK_FEZ_HAT :
                stack.getItem() == AITExtrasItems.BLUE_FEZ_HAT ? BLUE_FEZ_HAT :
                        stack.getItem() == AITExtrasItems.BROWN_FEZ_HAT ? BROWN_FEZ_HAT :
                                stack.getItem() == AITExtrasItems.CYAN_FEZ_HAT ? CYAN_FEZ_HAT :
                                        stack.getItem() == AITExtrasItems.GRAY_FEZ_HAT ? GRAY_FEZ_HAT :
                                                stack.getItem() == AITExtrasItems.GREEN_FEZ_HAT ? GREEN_FEZ_HAT :
                                                        stack.getItem() == AITExtrasItems.LIGHT_BLUE_FEZ_HAT ? LIGHT_BLUE_FEZ_HAT :
                                                                stack.getItem() == AITExtrasItems.LIGHT_GRAY_FEZ_HAT ? LIGHT_GRAY_FEZ_HAT :
                                                                        stack.getItem() == AITExtrasItems.LIME_FEZ_HAT ? LIME_FEZ_HAT :
                                                                                stack.getItem() == AITExtrasItems.MAGENTA_FEZ_HAT ? MAGENTA_FEZ_HAT :
                                                                                        stack.getItem() == AITExtrasItems.ORANGE_FEZ_HAT ? ORANGE_FEZ_HAT :
                                                                                                stack.getItem() == AITExtrasItems.PINK_FEZ_HAT ? PINK_FEZ_HAT :
                                                                                                        stack.getItem() == AITExtrasItems.PURPLE_FEZ_HAT ? PURPLE_FEZ_HAT :
                                                                                                                stack.getItem() == AITExtrasItems.RED_FEZ_HAT ? RED_FEZ_HAT :
                                                                                                                        YELLOW_FEZ_HAT));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1f);

        matrixStack.pop();
    }
}
