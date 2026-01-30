package com.aitextras.client.renderers.decor.hudolinsupport;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.hudolinsupport.HudolinSupportBaseModel;
import com.aitextras.core.blockentities.HudolinSupportBaseBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;

public class HudolinSupportBaseRenderer<T extends HudolinSupportBaseBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier SUPPORT_TEXTURE = AITExtras.id(
            "textures/blockentities/decor/hudolin_support.png");
    private final HudolinSupportBaseModel hudolinSupportBaseModel;

    public HudolinSupportBaseRenderer(BlockEntityRendererFactory.Context ctx) {
        this.hudolinSupportBaseModel = new HudolinSupportBaseModel(HudolinSupportBaseModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.8f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.scale(1f, 1f, 1f);


        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.hudolinSupportBaseModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(SUPPORT_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}