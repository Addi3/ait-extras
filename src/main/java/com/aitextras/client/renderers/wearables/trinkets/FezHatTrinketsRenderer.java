package com.aitextras.client.renderers.wearables.trinkets;

import com.aitextras.AITExtras;
import com.aitextras.client.models.wearables.FezHatModel;
import com.aitextras.client.models.wearables.ScarfModel;
import com.aitextras.core.AITExtrasItems;
import com.aitextras.core.item.FezItem;
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

    private static final Identifier WHITE_FEZ_HAT = AITExtras.id(
            "textures/wearables/white_fez.png");

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       LivingEntity entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        if (!(stack.getItem() instanceof FezItem fezItem)) {
            return;
        }

        int color = fezItem.getColor(stack);
        float red = ((color >> 16) & 0xFF) / 255.0f;
        float green = ((color >> 8) & 0xFF) / 255.0f;
        float blue = (color & 0xFF) / 255.0f;

        matrices.push();

        if (contextModel instanceof BipedEntityModel<?> biped) {
            biped.head.rotate(matrices);
        }
        matrices.translate(0.1, 0.55D, 0.D);
        matrices.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(10));

        VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
                vertexConsumers,
                fezhatModel.getLayer(WHITE_FEZ_HAT),
                false,
                stack.hasGlint()
        );

        fezhatModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, red, green, blue, 1.0F);
        matrices.pop();
    }
}
