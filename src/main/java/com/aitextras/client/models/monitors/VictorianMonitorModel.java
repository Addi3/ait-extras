package com.aitextras.client.models.monitors;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RotationAxis;

public class VictorianMonitorModel extends SinglePartEntityModel {
    private final ModelPart victorian;
    public VictorianMonitorModel(ModelPart root) {
        this.victorian = root.getChild("victorian");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData victorian = modelPartData.addChild("victorian", ModelPartBuilder.create().uv(42, 15).cuboid(3.472F, -2.9849F, -3.9344F, 1.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.028F, -4.4849F, -3.7344F, 10.0F, 13.0F, 9.0F, new Dilation(0.0F))
                .uv(38, 29).cuboid(-5.028F, -4.4849F, -4.1344F, 1.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(40, 29).cuboid(3.972F, -4.4849F, -4.1344F, 1.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 12).cuboid(-4.028F, -4.4849F, -4.1344F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 13).cuboid(-4.028F, 7.5151F, -4.1344F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 28).cuboid(-4.028F, -3.9849F, -3.9344F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 14).cuboid(-4.028F, 7.0151F, -3.9344F, 8.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-5.028F, -3.4849F, -3.8344F, 10.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(42, 29).cuboid(-4.528F, -2.9849F, -3.9344F, 1.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(42, 25).cuboid(1.972F, 5.5151F, -4.0344F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(31, 51).cuboid(-2.528F, -18.4849F, 0.7656F, 5.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 26).cuboid(-1.528F, 9.5151F, 1.2656F, 3.0F, 7.0F, 0.0F, new Dilation(0.0F))
                .uv(48, 27).cuboid(0.972F, 4.0151F, -3.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(-6.028F, -5.4849F, -2.7344F, 12.0F, 15.0F, 7.0F, new Dilation(0.0F))
                .uv(48, 27).cuboid(0.472F, 5.5151F, -3.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(48, 27).cuboid(-0.528F, 4.0151F, -3.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(48, 27).cuboid(-1.528F, 5.5151F, -3.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(42, 25).cuboid(-3.028F, 5.5151F, -4.0344F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 27).cuboid(-2.028F, 4.0151F, -3.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(1, 51).cuboid(-5.028F, -4.4849F, 5.3656F, 10.0F, 13.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, 5.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, -2.4849F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, 1.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, 5.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, -2.4849F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, 1.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-5.028F, 8.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(3.972F, 8.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, 8.5151F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(3.972F, -5.4849F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -5.4849F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-5.028F, -5.4849F, -2.9344F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, -2.4849F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, 1.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-6.028F, 5.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-5.028F, 8.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, 8.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(3.972F, 8.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, 5.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, 1.5151F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(4.972F, -2.4849F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(3.972F, -5.4849F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -5.4849F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-5.028F, -5.4849F, 4.4656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -8.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -14.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -11.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -11.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -16.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -16.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -6.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -6.9849F, 0.5656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -16.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -16.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -11.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -14.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -11.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.528F, -8.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.372F, -6.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.328F, -6.9849F, 0.8656F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.028F, 10.4849F, -0.2656F, 0.0F, 3.1416F, 0.0F));

        ModelPartData cube_r1 = victorian.addChild("cube_r1", ModelPartBuilder.create().uv(51, 27).cuboid(-2.35F, -0.55F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.25F, 4.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.45F, 2.45F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, 4.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, -0.55F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.45F, -3.55F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.25F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.072F, 9.5651F, 0.7156F, 0.0F, -1.5708F, 1.5708F));

        ModelPartData cube_r2 = victorian.addChild("cube_r2", ModelPartBuilder.create().uv(51, 27).cuboid(-2.35F, -0.45F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.25F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.45F, -3.45F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, -0.45F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.45F, 2.55F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-2.25F, 4.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(1.35F, 4.25F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.072F, -5.5349F, 0.7156F, 0.0F, -1.5708F, -1.5708F));

        ModelPartData cube_r3 = victorian.addChild("cube_r3", ModelPartBuilder.create().uv(51, 27).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(51, 27).mirrored().cuboid(-0.5F, 9.0F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(51, 27).mirrored().cuboid(-0.5F, 4.3F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.128F, -2.2849F, 2.5656F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r4 = victorian.addChild("cube_r4", ModelPartBuilder.create().uv(51, 27).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(51, 27).mirrored().cuboid(-0.5F, 9.0F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.128F, -2.2849F, -1.0344F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r5 = victorian.addChild("cube_r5", ModelPartBuilder.create().uv(51, 27).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(51, 27).mirrored().cuboid(-0.5F, -6.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.128F, 5.5151F, 0.7656F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r6 = victorian.addChild("cube_r6", ModelPartBuilder.create().uv(51, 27).mirrored().cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-6.128F, 2.5151F, -1.1344F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r7 = victorian.addChild("cube_r7", ModelPartBuilder.create().uv(51, 27).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.5F, 4.3F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.5F, 9.0F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.072F, -2.2849F, 2.5656F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r8 = victorian.addChild("cube_r8", ModelPartBuilder.create().uv(51, 27).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.5F, 9.0F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.072F, -2.2849F, -1.0344F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r9 = victorian.addChild("cube_r9", ModelPartBuilder.create().uv(51, 27).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(51, 27).cuboid(-0.5F, 5.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.072F, -0.4849F, 0.7656F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r10 = victorian.addChild("cube_r10", ModelPartBuilder.create().uv(51, 27).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.072F, 2.5151F, -1.1344F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
                       float green, float blue, float alpha) {
        matrices.push();
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(0));

        victorian.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

        matrices.pop();
    }

    @Override
    public ModelPart getPart() {
        return victorian;
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
                          float headPitch) {
    }
}
