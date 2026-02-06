package com.aitextras.client.models.wearables;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CoatModel extends EntityModel {
    public final ModelPart coat;
    public final ModelPart body;
    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;
    public final ModelPart RightArm;
    public final ModelPart LeftArm;
    public CoatModel(ModelPart root) {
        this.coat = root.getChild("coat");
        this.body = this.coat.getChild("body");
        this.RightArm = this.coat.getChild("RightArm");
        this.LeftArm = this.coat.getChild("LeftArm");
        this.RightLeg = this.coat.getChild("RightLeg");
        this.LeftLeg = this.coat.getChild("LeftLeg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData coat = modelPartData.addChild("coat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = coat.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.5F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.3F))
                .uv(16, 32).cuboid(-4.0F, 0.5F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.45F)), ModelTransform.pivot(0.0F, -0.5F, 0.0F));

        ModelPartData RightArm = coat.addChild("RightArm", ModelPartBuilder.create().uv(40, 32).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.45F))
                .uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        ModelPartData LeftArm = coat.addChild("LeftArm", ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.45F))
                .uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        ModelPartData RightLeg = coat.addChild("RightLeg", ModelPartBuilder.create().uv(0, 16).cuboid(-1.9F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F))
                .uv(0, 32).cuboid(-1.9F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.45F)), ModelTransform.pivot(-2.0F, 12.5F, 0.0F));

        ModelPartData LeftLeg = coat.addChild("LeftLeg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.1F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.45F))
                .uv(16, 48).cuboid(-2.1F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.3F)), ModelTransform.pivot(2.0F, 12.5F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        coat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
