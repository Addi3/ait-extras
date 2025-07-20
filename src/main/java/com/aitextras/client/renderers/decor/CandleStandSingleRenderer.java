package com.aitextras.client.renderers.decor;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.CandleStandSingleModel;
import com.aitextras.core.blockentities.CandleStandSingleBlockEntity;
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

public class CandleStandSingleRenderer<T extends CandleStandSingleBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier CANDLE_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/candle_stand.png");
    private final CandleStandSingleModel candlestandsingleModel;

    public CandleStandSingleRenderer(BlockEntityRendererFactory.Context ctx) {
        this.candlestandsingleModel = new CandleStandSingleModel(CandleStandSingleModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.5f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.scale(1f, 1f, 1f);


        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.candlestandsingleModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(CANDLE_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}