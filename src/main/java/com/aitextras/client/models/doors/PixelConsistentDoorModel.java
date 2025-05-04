//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aitextras.client.models.doors;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.tardis.link.v2.block.AbstractLinkableBlockEntity;
import dev.amble.ait.client.models.doors.DoorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.Animation.Builder;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class PixelConsistentDoorModel extends DoorModel {
    private final ModelPart bone;

    public PixelConsistentDoorModel(ModelPart root) {
        super(RenderLayer::getEntityCutoutNoCull);
        this.bone = root.getChild("bone");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 6.0F));

        ModelPartData TARDIS = bone.addChild("TARDIS", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData base = TARDIS.addChild("base", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

        ModelPartData lip_all = TARDIS.addChild("lip_all", ModelPartBuilder.create().uv(118, 108).cuboid(-8.0F, -38.0F, -8.0F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -0.5F));

        ModelPartData cube_r1 = lip_all.addChild("cube_r1", ModelPartBuilder.create().uv(222, 2).cuboid(-8.0F, -3.19F, 0.4F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
                .uv(222, 0).cuboid(-8.0F, -3.99F, 0.4F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
                .uv(118, 108).cuboid(-8.0F, 2.5F, 0.6F, 16.0F, 0.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 77).cuboid(-8.0F, 0.5F, 0.0F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -38.5F, -5.7F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData posts = TARDIS.addChild("posts", ModelPartBuilder.create().uv(88, 28).cuboid(8.0F, -42.0F, -9.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r2 = posts.addChild("cube_r2", ModelPartBuilder.create().uv(88, 28).cuboid(-2.0F, -21.0F, -2.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -21.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData walls = TARDIS.addChild("walls", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -18.5F, 0.0F));

        ModelPartData firstdoctor = TARDIS.addChild("firstdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData sign1 = firstdoctor.addChild("sign1", ModelPartBuilder.create().uv(118, 80).cuboid(2.0F, -0.5F, -10.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -39.0F, 0.0F));

        ModelPartData roof1 = firstdoctor.addChild("roof1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

        ModelPartData lamp1 = firstdoctor.addChild("lamp1", ModelPartBuilder.create(), ModelTransform.pivot(2.6465F, -50.0F, 2.6464F));

        ModelPartData secondandthirddoctor = TARDIS.addChild("secondandthirddoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData sign2 = secondandthirddoctor.addChild("sign2", ModelPartBuilder.create().uv(212, 200).cuboid(2.0F, -0.5F, -10.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -39.0F, 0.0F));

        ModelPartData cube_r3 = sign2.addChild("cube_r3", ModelPartBuilder.create().uv(52, 77).cuboid(-10.0F, -4.0F, -1.5F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 3.5F, -6.2F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData roof = secondandthirddoctor.addChild("roof", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

        ModelPartData lamp2 = secondandthirddoctor.addChild("lamp2", ModelPartBuilder.create(), ModelTransform.pivot(2.6465F, -47.0F, 2.6464F));

        ModelPartData forthdoctor = TARDIS.addChild("forthdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData sign4 = forthdoctor.addChild("sign4", ModelPartBuilder.create().uv(4, 164).cuboid(2.0F, -0.5F, -11.0F, 20.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -38.2F, 0.0F));

        ModelPartData roof2 = forthdoctor.addChild("roof2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

        ModelPartData lamp = forthdoctor.addChild("lamp", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -42.5F, 0.0F));

        ModelPartData pillartop4 = forthdoctor.addChild("pillartop4", ModelPartBuilder.create().uv(0, 4).cuboid(9.0F, -40.0F, -8.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 4).mirrored().cuboid(-11.0F, -40.0F, -8.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

        ModelPartData fifthdoctor = TARDIS.addChild("fifthdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData roof5 = fifthdoctor.addChild("roof5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -44.7F, 0.0F));

        ModelPartData sign5 = fifthdoctor.addChild("sign5", ModelPartBuilder.create().uv(5, 224).cuboid(-10.0F, -0.5F, -10.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -38.2F, 0.0F));

        ModelPartData cube_r4 = sign5.addChild("cube_r4", ModelPartBuilder.create().uv(52, 84).cuboid(-10.0F, -3.6F, -1.5F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.1F, -6.2F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData lamp5 = fifthdoctor.addChild("lamp5", ModelPartBuilder.create(), ModelTransform.pivot(2.6465F, -48.2F, 2.6464F));

        ModelPartData pillartop5 = fifthdoctor.addChild("pillartop5", ModelPartBuilder.create().uv(-4, 0).cuboid(9.0F, -41.0F, -8.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(-4, 0).mirrored().cuboid(-11.0F, -41.0F, -8.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

        ModelPartData Doors = bone.addChild("Doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_door = Doors.addChild("left_door", ModelPartBuilder.create().uv(118, 46).cuboid(-8.0F, -15.0F, -1.0F, 8.0F, 33.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 77).cuboid(-8.0F, -15.0F, -1.3F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F))
                .uv(10, 8).cuboid(-4.0F, -2.7F, -0.3F, 2.0F, 2.0F, 1.0F, new Dilation(-0.1F))
                .uv(8, 0).cuboid(-5.0F, -4.0F, 0.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 11).cuboid(-3.0F, -4.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F))
                .uv(0, 4).cuboid(-6.9F, -3.0F, -1.6F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -18.0F, -7.0F));

        ModelPartData cube_r5 = left_door.addChild("cube_r5", ModelPartBuilder.create().uv(4, 77).cuboid(-1.0F, -16.5F, 0.0F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 1.5F, 0.3F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData cube_r6 = left_door.addChild("cube_r6", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.4F, -2.0F, -0.1F, 0.0F, 3.1416F, 0.0F));

        ModelPartData right_door = Doors.addChild("right_door", ModelPartBuilder.create().uv(84, 111).cuboid(0.0F, -15.0F, -1.0F, 8.0F, 33.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 77).cuboid(7.0F, -15.0F, -1.3F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 4).cuboid(5.0F, -3.0F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -18.0F, -7.0F));

        ModelPartData cube_r7 = right_door.addChild("cube_r7", ModelPartBuilder.create().uv(6, 77).cuboid(0.0F, -16.5F, 0.0F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 1.5F, 0.3F, -3.1416F, 0.0F, 3.1416F));

        ModelPartData phone = right_door.addChild("phone", ModelPartBuilder.create().uv(0, 12).cuboid(-0.5F, 2.3F, 2.2F, 2.0F, 2.0F, 1.0F, new Dilation(-0.1F))
                .uv(0, 8).cuboid(0.5F, 1.0F, 2.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 8).cuboid(-0.5F, 1.0F, 2.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.pivot(2.5F, -5.0F, -2.5F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
                       float green, float blue, float alpha) {
        bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public void renderWithAnimations(ClientTardis tardis, AbstractLinkableBlockEntity doorEntity, ModelPart root, MatrixStack matrices,
                                     VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
        DoorHandler door = tardis.door();

        if (!AITMod.CONFIG.CLIENT.ANIMATE_DOORS) {
            this.bone.getChild("Doors").getChild("left_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5F : 0.0F;
            this.bone.getChild("Doors").getChild("right_door").yaw = (door.isRightOpen() || door.areBothOpen())
                    ? 5F
                    : 0.0F;
        } else {
            float maxRot = 90f;
            this.bone.getChild("Doors").getChild("left_door").yaw = (float) Math.toRadians(maxRot*door.getLeftRot());
            this.bone.getChild("Doors").getChild("right_door").yaw = (float) -Math.toRadians(maxRot*door.getRightRot());
        }

        matrices.push();
        matrices.scale(1F, 1F, 1F);
        matrices.translate(0, -1.5, 0.35);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(180));

        super.renderWithAnimations(tardis, doorEntity, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
        matrices.pop();
    }

    @Override
    public Animation getAnimationForDoorState(DoorHandler.AnimationDoorState state) {
        return Builder.create(0).build();/*return switch (state) {
            case CLOSED -> DoorAnimations.INTERIOR_BOTH_CLOSE_ANIMATION;
            case FIRST -> DoorAnimations.INTERIOR_FIRST_OPEN_ANIMATION;
            case SECOND -> DoorAnimations.INTERIOR_SECOND_OPEN_ANIMATION;
            case BOTH -> DoorAnimations.INTERIOR_BOTH_OPEN_ANIMATION;
        };*/
    }

    @Override
    public ModelPart getPart() {
        return bone;
    }
}

