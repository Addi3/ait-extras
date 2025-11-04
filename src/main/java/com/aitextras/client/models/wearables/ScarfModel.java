package com.aitextras.client.models.wearables;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ScarfModel extends EntityModel {
    public final ModelPart scarf;
    public ScarfModel(ModelPart root) {
        this.scarf = root.getChild("scarf");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData scarf = modelPartData.addChild("scarf", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 17.0F, 4.0F, new Dilation(0.2F))
                .uv(0, 21).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 17.0F, 4.0F, new Dilation(0.35F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = scarf.addChild("cube_r1", ModelPartBuilder.create().uv(28, 11).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.8F, 6.0F, -2.3F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData cube_r2 = scarf.addChild("cube_r2", ModelPartBuilder.create().uv(28, 14).mirrored().cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.1836F, 6.9615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r3 = scarf.addChild("cube_r3", ModelPartBuilder.create().uv(28, 8).mirrored().cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.4F, 6.0F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r4 = scarf.addChild("cube_r4", ModelPartBuilder.create().uv(28, 11).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 5.0F, -2.3F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData cube_r5 = scarf.addChild("cube_r5", ModelPartBuilder.create().uv(28, 14).mirrored().cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.1164F, 5.9615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r6 = scarf.addChild("cube_r6", ModelPartBuilder.create().uv(28, 8).mirrored().cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.9F, 5.0F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r7 = scarf.addChild("cube_r7", ModelPartBuilder.create().uv(28, 17).mirrored().cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.1836F, 17.9615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r8 = scarf.addChild("cube_r8", ModelPartBuilder.create().uv(28, 17).mirrored().cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.4F, 17.0F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r9 = scarf.addChild("cube_r9", ModelPartBuilder.create().uv(28, 17).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.8F, 17.0F, -2.3F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData cube_r10 = scarf.addChild("cube_r10", ModelPartBuilder.create().uv(28, 17).mirrored().cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.1164F, 16.9615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r11 = scarf.addChild("cube_r11", ModelPartBuilder.create().uv(28, 17).mirrored().cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.9F, 16.0F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r12 = scarf.addChild("cube_r12", ModelPartBuilder.create().uv(28, 17).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 16.0F, -2.3F, -0.1705F, 0.0376F, 0.215F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        scarf.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
