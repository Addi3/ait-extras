package com.aitextras.client.renderers.decor;

import com.aitextras.client.models.decor.HatStandModel;
import com.aitextras.core.blockentities.AbstractHatStandBlockEntity;
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

public class HatStandRenderer<T extends AbstractHatStandBlockEntity> implements BlockEntityRenderer<T> {
    private final HatStandModel hatStandModel;
    private final Identifier texture;

    public HatStandRenderer(BlockEntityRendererFactory.Context ctx, Identifier texture) {
        this.hatStandModel = new HatStandModel(HatStandModel.getTexturedModelData().createModel());
        this.texture = texture;
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.85f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.hatStandModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(this.texture)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}