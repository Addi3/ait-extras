package com.aitextras.client.models.wearables;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class ScarfModel extends EntityModel {
    public final ModelPart scarf;
    public final ModelPart RightLeg;
    public final ModelPart LeftLeg;
    public ScarfModel(ModelPart root) {
        this.scarf = root.getChild("scarf");
        this.RightLeg = this.scarf.getChild("RightLeg");
        this.LeftLeg = this.scarf.getChild("LeftLeg");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData scarf = modelPartData.addChild("scarf", ModelPartBuilder.create().uv(0, 16).cuboid(-4.019F, -0.467F, -1.8833F, 8.0F, 12.0F, 4.0F, new Dilation(0.2F))
                .uv(0, 0).cuboid(-4.019F, -0.467F, -1.8833F, 8.0F, 12.0F, 4.0F, new Dilation(0.35F)), ModelTransform.pivot(0.019F, 0.467F, -0.1167F));

        ModelPartData cube_r1 = scarf.addChild("cube_r1", ModelPartBuilder.create().uv(33, 36).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.819F, 5.533F, -2.1833F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData cube_r2 = scarf.addChild("cube_r2", ModelPartBuilder.create().uv(36, 36).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.2026F, 6.4945F, -2.3528F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r3 = scarf.addChild("cube_r3", ModelPartBuilder.create().uv(39, 36).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.419F, 5.533F, -2.1833F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r4 = scarf.addChild("cube_r4", ModelPartBuilder.create().uv(33, 36).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.481F, 4.533F, -2.1833F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData cube_r5 = scarf.addChild("cube_r5", ModelPartBuilder.create().uv(39, 36).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.881F, 4.533F, -2.1833F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r6 = scarf.addChild("cube_r6", ModelPartBuilder.create().uv(36, 36).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0974F, 5.4945F, -2.3528F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData RightLeg = scarf.addChild("RightLeg", ModelPartBuilder.create().uv(0, 32).cuboid(-1.9F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F))
                .uv(16, 32).cuboid(-1.9F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.35F)), ModelTransform.pivot(-2.019F, 12.033F, 0.1167F));

        ModelPartData cube_r7 = RightLeg.addChild("cube_r7", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.4F, 4.5F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r8 = RightLeg.addChild("cube_r8", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.1836F, 5.4615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r9 = RightLeg.addChild("cube_r9", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.8F, 4.5F, -2.3F, -0.1705F, 0.0376F, 0.215F));

        ModelPartData LeftLeg = scarf.addChild("LeftLeg", ModelPartBuilder.create().uv(24, 0).cuboid(-2.1F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.2F))
                .uv(24, 16).cuboid(-2.1F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.35F)), ModelTransform.pivot(1.981F, 12.033F, 0.1167F));

        ModelPartData cube_r10 = LeftLeg.addChild("cube_r10", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.9F, 3.5F, -2.3F, -0.1705F, -0.0376F, -0.215F));

        ModelPartData cube_r11 = LeftLeg.addChild("cube_r11", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.1164F, 4.4615F, -2.4695F, 0.1309F, 0.0F, -3.1416F));

        ModelPartData cube_r12 = LeftLeg.addChild("cube_r12", ModelPartBuilder.create().uv(34, 38).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 3.5F, -2.3F, -0.1705F, 0.0376F, 0.215F));
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
