package com.aitextras.client.renderers.decor;


import dev.amble.lib.animation.AnimatedBlockEntity;
import dev.amble.lib.animation.client.BedrockBlockEntityRenderer;
import dev.amble.lib.client.bedrock.BedrockEntityModel;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;

public class TubeLightRenderer<T extends BlockEntity & AnimatedBlockEntity> extends BedrockBlockEntityRenderer<T>{
    protected BedrockEntityModel model;

    public TubeLightRenderer() {}

    public TubeLightRenderer(BlockEntityRendererFactory.Context context) {
        this();
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();
        if (this.model == null) this.refreshModel(entity);

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.5f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));


        matrices.pop();
    }


}