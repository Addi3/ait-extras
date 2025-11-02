package com.aitextras.client.renderers.roundel;

import com.aitextras.AITExtras;
import com.aitextras.client.entities.RoundelEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

@Environment(EnvType.CLIENT)
public class RoundelRenderer extends EntityRenderer<RoundelEntity> {

    private static final Identifier TEXTURE = new Identifier(AITExtras.MOD_ID, "textures/roundels/hexagon.png");

    public RoundelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public void render(RoundelEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();

        matrices.translate(entity.getX(), entity.getY(), entity.getZ());

        float offset = 0.001f;

        Direction facing = entity.getFacing();
        switch (facing) {
            case NORTH -> {
                matrices.translate(0, 0, -0.5 + offset);
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(0f));
            }
            case SOUTH -> {
                matrices.translate(0, 0, 0.5 - offset);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180f));
            }
            case WEST -> {
                matrices.translate(-0.5 + offset, 0, 0);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90f));
            }
            case EAST -> {
                matrices.translate(0.5 - offset, 0, 0);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90f));
            }
            case UP -> {
                matrices.translate(0, 0.5 - offset, 0);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));
            }
            case DOWN -> {
                matrices.translate(0, -0.5 + offset, 0);
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90f));
            }
        }

        float halfSize = 0.25f;
        DyeColor color = entity.getColor();
        float[] rgb = color.getColorComponents();

        VertexConsumer buffer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        Matrix4f matrix = matrices.peek().getPositionMatrix();

        float u1 = 0f, v1 = 0f;
        float u2 = 1f, v2 = 1f;

        buffer.vertex(matrix, -halfSize, -halfSize, 0f).color(rgb[0], rgb[1], rgb[2], 1f)
                .texture(u1, v1).overlay(OverlayTexture.DEFAULT_UV)
                .light(light).normal(0f, 0f, 1f).next();
        buffer.vertex(matrix, halfSize, -halfSize, 0f).color(rgb[0], rgb[1], rgb[2], 1f)
                .texture(u2, v1).overlay(OverlayTexture.DEFAULT_UV)
                .light(light).normal(0f, 0f, 1f).next();
        buffer.vertex(matrix, halfSize, halfSize, 0f).color(rgb[0], rgb[1], rgb[2], 1f)
                .texture(u2, v2).overlay(OverlayTexture.DEFAULT_UV)
                .light(light).normal(0f, 0f, 1f).next();
        buffer.vertex(matrix, -halfSize, halfSize, 0f).color(rgb[0], rgb[1], rgb[2], 1f)
                .texture(u1, v2).overlay(OverlayTexture.DEFAULT_UV)
                .light(light).normal(0f, 0f, 1f).next();

        matrices.pop();

        if (entity.isCustomGlowing()) {
            super.render(entity, yaw, tickDelta, matrices, vertexConsumers, 0xF000F0);
        }
    }

    @Override
    public Identifier getTexture(RoundelEntity entity) {
        return TEXTURE;
    }
}
