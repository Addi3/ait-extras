package com.aitextras.client.renderers.decor;


import dev.amble.lib.animation.AnimatedBlockEntity;
import dev.amble.lib.client.bedrock.BedrockEntityModel;
import dev.amble.lib.client.bedrock.BedrockModel;
import dev.amble.lib.client.bedrock.BedrockModelReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.world.LightType;

public class TubeLightRenderer<T extends BlockEntity & AnimatedBlockEntity> implements BlockEntityRenderer<T> {
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
        matrices.translate(0.5f, 0f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

        light = entity.getWorld().getLightLevel(LightType.SKY, entity.getPos().up().up());
        light = LightmapTextureManager.pack(10, 15);

        this.model.setAngles(entity, entity.getAge() + tickDelta);
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(this.getTexture(entity))), light, overlay, 1.0f, 1.0f, 1.0f, 1.0f);

        Identifier emission = entity.getEmissionTexture();
        if (emission != null) {
            this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCullZOffset(emission)), LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
        }

        matrices.pop();
    }

    public Identifier getTexture(T entity) {
        return entity.getTexture();
    }

    protected BedrockEntityModel refreshModel(T entity) {
        BedrockModelReference ref = entity.getModel();
        if (ref == null) throw new IllegalStateException("BlockEntity " + entity + " does not have a BedrockModelReference");
        BedrockModel bedrock = ref.get().orElseThrow(() -> new IllegalStateException("BedrockModel " + ref.id() + " not found for block entity " + entity));

        this.model = new BedrockEntityModel<>(bedrock);
        return this.model;
    }

}