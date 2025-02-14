//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aitextras.client.models.doors;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.link.v2.block.AbstractLinkableBlockEntity;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.Animation.Builder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class EctoDoorModel extends DoorModel {
    private final ModelPart TARDIS;

    public EctoDoorModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);
        this.TARDIS = root.getChild("TARDIS");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData TARDIS = modelPartData.addChild("TARDIS", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData Posts = TARDIS.addChild("Posts", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -32.0F));
        Posts.addChild("cube_r1", ModelPartBuilder.create().uv(68, 227).cuboid(-18.0F, -65.0F, -18.0F, 4.0F, 61.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 10.0F, 0.0F, 3.1416F, 0.0F));
        Posts.addChild("cube_r2", ModelPartBuilder.create().uv(85, 227).cuboid(-18.0F, -65.0F, -18.0F, 4.0F, 61.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 10.0F, 0.0F, 1.5708F, 0.0F));
        ModelPartData Doors = TARDIS.addChild("Doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        Doors.addChild("right_door", ModelPartBuilder.create().uv(181, 177).cuboid(0.5F, -25.5F, -0.5F, 13.0F, 55.0F, 1.0F, new Dilation(0.0F)).uv(102, 228).cuboid(1.5F, -10.5F, 0.5F, 10.0F, 12.0F, 3.0F, new Dilation(0.0F)).uv(0, 198).cuboid(0.5F, -25.5F, -1.0F, 14.0F, 55.0F, 0.0F, new Dilation(0.0F)).uv(0, 10).cuboid(9.5F, -5.5F, -1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-13.5F, -29.5F, -5.5F));
        Doors.addChild("left_door", ModelPartBuilder.create().uv(189, 41).cuboid(-13.5F, -25.5F, -0.5F, 13.0F, 55.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-12.5F, -6.5F, -1.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(13.5F, -29.5F, -5.5F));
        TARDIS.addChild("Walls", ModelPartBuilder.create().uv(63, 227).cuboid(-14.0F, -56.0F, -6.0F, 1.0F, 56.0F, 1.0F, new Dilation(0.0F)).uv(116, 170).cuboid(13.0F, -56.0F, -6.0F, 1.0F, 56.0F, 1.0F, new Dilation(0.0F)).uv(115, 0).cuboid(-13.0F, -56.0F, -6.0F, 26.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(59, 113).cuboid(13.0F, -56.0F, -6.5F, 1.0F, 56.0F, 0.0F, new Dilation(0.0F)).uv(115, 3).cuboid(-13.0F, -56.0F, -6.5F, 26.0F, 1.0F, 0.0F, new Dilation(0.0F)).uv(62, 113).cuboid(-14.0F, -56.0F, -6.5F, 1.0F, 56.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData PCB = TARDIS.addChild("PCB", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 0.0F));
        PCB.addChild("cube_r3", ModelPartBuilder.create().uv(160, 9).cuboid(-17.0F, -61.0F, 13.0F, 34.0F, 5.0F, 6.0F, new Dilation(0.001F)), ModelTransform.of(0.0F, 1.0F, 10.0F, 0.0F, 3.1416F, 0.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        this.TARDIS.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    public void renderWithAnimations(AbstractLinkableBlockEntity doorEntity, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
        if (!AITMod.CONFIG.CLIENT.ANIMATE_DOORS) {
            DoorHandler door = doorEntity.tardis().get().door();
            this.TARDIS.getChild("Doors").getChild("left_door").yaw = !door.isLeftOpen() && !door.isOpen() ? 0.0F : 5.0F;
            this.TARDIS.getChild("Doors").getChild("right_door").yaw = !door.isRightOpen() && !door.areBothOpen() ? 0.0F : -5.0F;
        } else {
            float maxRot = 90.0F;
            this.TARDIS.getChild("Doors").getChild("left_door").yaw = (float)-Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getLeftRot()));
            this.TARDIS.getChild("Doors").getChild("right_door").yaw = (float)(Math.toRadians((double)(maxRot * doorEntity.tardis().get().door().getRightRot())));
        }

        matrices.push();
        matrices.scale(0.63F, 0.63F, 0.63F);
        matrices.translate((double)0.0F, (double)-1.5F, 0.35);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(180.0F));
        super.renderWithAnimations(doorEntity, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
        matrices.pop();
    }

    public Animation getAnimationForDoorState(DoorHandler.AnimationDoorState state) {
        return Builder.create(0.0F).build();
    }

    public ModelPart getPart() {
        return this.TARDIS;
    }
}
