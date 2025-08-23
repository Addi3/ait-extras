package com.aitextras.client.models.wearables;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class FezHatModel extends EntityModel {
    public final ModelPart hat;

    public FezHatModel(ModelPart root) {
        this.hat = root.getChild("hat");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.15F)), ModelTransform.of(2.2F, -9.7F, 0.4F, 0.0F, 0.0F, 0.2182F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
                          float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
                       float blue, float alpha) {
        hat.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
