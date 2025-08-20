package com.aitextras.client.models.decor;

import com.aitextras.client.animation.RoofCrystalAnimation;
import com.aitextras.core.blockentities.CrystalBlockEntity;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CrystalModel extends MovingCrystalModel {
    private final ModelPart root;
    public CrystalModel(ModelPart root) {
        this.root = root.getChild("rotor_jodie");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData rotor_jodie = modelPartData.addChild("rotor_jodie", ModelPartBuilder.create().uv(110, 2).cuboid(-4.5847F, -10.9613F, 6.514F, 9.0F, 23.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-4.5847F, -10.9613F, 7.714F, 9.0F, 23.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-4.5847F, -10.9613F, 8.014F, 9.0F, 23.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-4.5847F, -10.9613F, 8.214F, 9.0F, 23.0F, 0.0F, new Dilation(0.0F))
                .uv(108, 26).cuboid(-4.5847F, -10.9613F, 8.414F, 9.0F, 23.0F, 0.0F, new Dilation(0.0F))
                .uv(119, 69).cuboid(-4.0847F, -18.9613F, 6.148F, 8.0F, 12.0F, 1.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0847F, -18.9613F, 7.248F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0847F, -18.9613F, 7.348F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-4.0847F, -18.9613F, 7.448F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(100, 98).cuboid(-3.5847F, -22.9613F, 5.982F, 7.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(94, 0).cuboid(-3.5847F, -22.9613F, 7.082F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 48).cuboid(-5.0847F, -24.9593F, -3.8778F, 10.0F, 0.0F, 10.0F, new Dilation(0.001F))
                .uv(62, 126).cuboid(-3.0847F, -24.9613F, 5.316F, 6.0F, 5.0F, 1.0F, new Dilation(0.002F))
                .uv(87, 61).cuboid(-3.0847F, -24.9613F, 6.516F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(74, 102).cuboid(-3.0847F, -24.9613F, 6.716F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0452F, -0.4603F, 0.2309F, 0.0F, 0.0F, -3.1416F));

        ModelPartData cube_r1 = rotor_jodie.addChild("cube_r1", ModelPartBuilder.create().uv(74, 102).cuboid(-3.0F, -7.001F, 6.6469F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.0F, -7.001F, 6.4469F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(94, 0).cuboid(-3.5F, -5.001F, 7.0129F, 7.0F, 7.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-4.0F, -1.001F, 7.3789F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0F, -1.001F, 7.2789F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, -1.001F, 7.1789F, 8.0F, 12.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 48).cuboid(-5.0F, -6.999F, -3.9469F, 10.0F, 0.0F, 10.0F, new Dilation(0.001F))
                .uv(62, 126).cuboid(-3.0F, -7.001F, 5.2469F, 6.0F, 5.0F, 1.0F, new Dilation(0.002F))
                .uv(100, 98).cuboid(-3.5F, -5.001F, 5.9129F, 7.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(119, 69).cuboid(-4.0F, -1.001F, 6.0789F, 8.0F, 12.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, -3.1416F, 0.0F, 0.0F));

        ModelPartData cube_r2 = rotor_jodie.addChild("cube_r2", ModelPartBuilder.create().uv(132, 32).mirrored().cuboid(-3.8701F, -0.001F, 7.6039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(132, 21).mirrored().cuboid(-3.8701F, -0.001F, 7.4039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(130, 58).mirrored().cuboid(-3.8701F, -0.001F, 7.2039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(67, 132).cuboid(-2.7639F, -4.001F, 6.8879F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-2.7639F, -4.001F, 6.6879F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(74, 102).cuboid(-2.0907F, -7.001F, 6.1219F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-2.0907F, -7.001F, 5.9219F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-2.0907F, -7.001F, 4.7219F, 6.0F, 5.0F, 1.0F, new Dilation(0.001F))
                .uv(100, 98).cuboid(-2.7639F, -4.001F, 5.4879F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(119, 69).mirrored().cuboid(-3.8701F, -0.001F, 6.0039F, 8.0F, 11.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, 3.1416F, 1.0472F, 0.0F));

        ModelPartData cube_r3 = rotor_jodie.addChild("cube_r3", ModelPartBuilder.create().uv(74, 102).cuboid(-2.0907F, -7.001F, 5.0719F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-2.0907F, -7.001F, 4.8719F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(67, 132).cuboid(-2.7639F, -3.001F, 6.0379F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-2.7639F, -3.001F, 5.8379F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-3.8701F, 1.999F, 7.4539F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-3.8701F, 1.999F, 7.2539F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-3.8701F, 1.999F, 7.0539F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-2.0907F, -7.001F, 3.6719F, 6.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(99, 97).cuboid(-2.7639F, -3.001F, 3.6379F, 7.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(62, 113).cuboid(-3.8701F, 1.999F, 3.8539F, 8.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, 0.0F, 1.0472F, -3.1416F));

        ModelPartData cube_r4 = rotor_jodie.addChild("cube_r4", ModelPartBuilder.create().uv(74, 102).cuboid(-3.0F, -7.001F, 4.5469F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.0F, -7.001F, 4.3469F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(67, 132).cuboid(-3.5F, -1.001F, 5.6129F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-3.5F, -1.001F, 5.4129F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-4.0F, 2.999F, 7.3789F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0F, 2.999F, 7.1789F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, 2.999F, 6.9789F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(99, 84).cuboid(-3.0F, -7.001F, 3.1469F, 6.0F, 6.0F, 1.0F, new Dilation(0.002F))
                .uv(123, 119).cuboid(-3.5F, -1.001F, 3.2129F, 7.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(63, 114).cuboid(-4.0F, 2.999F, 4.7789F, 8.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, 0.0F, 0.0F, 3.1416F));

        ModelPartData cube_r5 = rotor_jodie.addChild("cube_r5", ModelPartBuilder.create().uv(130, 58).cuboid(-4.1299F, 0.999F, 7.0539F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(74, 102).cuboid(-3.9093F, -7.001F, 5.0719F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.9093F, -7.001F, 4.8719F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(67, 132).cuboid(-4.2361F, -2.001F, 6.0379F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-4.2361F, -2.001F, 5.8379F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-4.1299F, 0.999F, 7.4539F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.1299F, 0.999F, 7.2539F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.1299F, 0.999F, 7.0539F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-3.9093F, -7.001F, 3.6719F, 6.0F, 5.0F, 1.0F, new Dilation(0.001F))
                .uv(123, 119).cuboid(-4.2361F, -2.001F, 3.6379F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(62, 113).cuboid(-4.1299F, 0.999F, 3.8539F, 8.0F, 10.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, 0.0F, -1.0472F, 3.1416F));

        ModelPartData cube_r6 = rotor_jodie.addChild("cube_r6", ModelPartBuilder.create().uv(74, 102).cuboid(-3.9093F, -7.001F, 6.1219F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.9093F, -7.001F, 5.9219F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(67, 132).cuboid(-4.2361F, -4.001F, 6.8879F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-4.2361F, -4.001F, 6.6879F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 32).cuboid(-4.1299F, -0.001F, 7.6039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.1299F, -0.001F, 7.4039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.1299F, -0.001F, 7.2039F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-3.9093F, -7.001F, 4.7219F, 6.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(124, 120).cuboid(-4.2361F, -4.001F, 5.4879F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F))
                .uv(119, 69).cuboid(-4.1299F, -0.001F, 6.0039F, 8.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 17.0397F, 0.0691F, 3.1416F, -1.0472F, 0.0F));

        ModelPartData cube_r7 = rotor_jodie.addChild("cube_r7", ModelPartBuilder.create().uv(74, 102).cuboid(-3.0F, -2.5F, 0.9F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.0F, -2.5F, 0.7F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.983F, -22.4613F, -1.2294F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r8 = rotor_jodie.addChild("cube_r8", ModelPartBuilder.create().uv(62, 126).cuboid(-3.0F, -2.5F, 4.1969F, 6.0F, 5.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-0.0847F, -22.4613F, 1.1191F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r9 = rotor_jodie.addChild("cube_r9", ModelPartBuilder.create().uv(74, 102).cuboid(-4.0F, 10.5F, 0.9F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-4.0F, 10.5F, 0.7F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-4.0F, 10.5F, -0.5F, 6.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.483F, -35.4613F, 2.6015F, 0.0F, 1.0472F, 0.0F));

        ModelPartData cube_r10 = rotor_jodie.addChild("cube_r10", ModelPartBuilder.create().uv(74, 102).cuboid(-4.0F, 10.5F, 0.9F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-4.0F, 10.5F, 0.7F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-3.6523F, -35.4613F, 4.3335F, 0.0F, -1.0472F, 0.0F));

        ModelPartData cube_r11 = rotor_jodie.addChild("cube_r11", ModelPartBuilder.create().uv(62, 126).cuboid(-3.0F, -2.5F, 4.1969F, 6.0F, 5.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-0.0847F, -22.4613F, 1.1191F, 0.0F, -1.0472F, 0.0F));

        ModelPartData cube_r12 = rotor_jodie.addChild("cube_r12", ModelPartBuilder.create().uv(74, 102).cuboid(-3.0F, -2.5F, 0.9F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.0F, -2.5F, 0.7F, 6.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 126).cuboid(-3.0F, -2.5F, -0.5F, 6.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1523F, -22.4613F, -1.2294F, 0.0F, -2.0944F, 0.0F));

        ModelPartData cube_r13 = rotor_jodie.addChild("cube_r13", ModelPartBuilder.create().uv(74, 102).cuboid(-3.0F, -3.0F, 1.3F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(87, 61).cuboid(-3.0F, -3.0F, 0.9F, 6.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, -21.9613F, -3.5778F, 0.0F, -3.1416F, 0.0F));

        ModelPartData cube_r14 = rotor_jodie.addChild("cube_r14", ModelPartBuilder.create().uv(99, 84).cuboid(-3.0F, -2.75F, 4.1969F, 6.0F, 6.0F, 1.0F, new Dilation(0.002F)), ModelTransform.of(-0.0847F, -22.2113F, 1.1191F, 0.0F, -3.1416F, 0.0F));

        ModelPartData cube_r15 = rotor_jodie.addChild("cube_r15", ModelPartBuilder.create().uv(67, 132).cuboid(-3.5F, -2.0F, 1.4F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-3.5F, -2.0F, 1.2F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F))
                .uv(123, 119).cuboid(-3.5F, -2.0F, -1.0F, 7.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.3F, -17.9613F, -1.6124F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r16 = rotor_jodie.addChild("cube_r16", ModelPartBuilder.create().uv(67, 132).cuboid(-3.5F, -2.5F, 1.4F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-3.5F, -2.5F, 1.2F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(123, 119).cuboid(-3.5F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, -16.4613F, -4.1438F, 0.0F, -3.1416F, 0.0F));

        ModelPartData cube_r17 = rotor_jodie.addChild("cube_r17", ModelPartBuilder.create().uv(67, 132).cuboid(-3.5F, -2.5F, 1.4F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-3.5F, -2.5F, 1.2F, 7.0F, 5.0F, 0.0F, new Dilation(0.0F))
                .uv(99, 97).cuboid(-3.5F, -2.5F, -1.0F, 7.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.4693F, -18.4613F, -1.6124F, 0.0F, -2.0944F, 0.0F));

        ModelPartData cube_r18 = rotor_jodie.addChild("cube_r18", ModelPartBuilder.create().uv(67, 132).cuboid(-5.0F, 5.5F, 0.9F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-5.0F, 5.5F, 0.7F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(100, 98).cuboid(-5.0F, 5.5F, -0.5F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.1523F, -27.4613F, 4.9996F, 0.0F, -1.0472F, 0.0F));

        ModelPartData cube_r19 = rotor_jodie.addChild("cube_r19", ModelPartBuilder.create().uv(67, 132).cuboid(-5.0F, 5.5F, 0.9F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(53, 132).cuboid(-5.0F, 5.5F, 0.7F, 7.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(124, 120).cuboid(-5.0F, 5.5F, -0.5F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.483F, -27.4613F, 2.4015F, 0.0F, 1.0472F, 0.0F));

        ModelPartData cube_r20 = rotor_jodie.addChild("cube_r20", ModelPartBuilder.create().uv(132, 32).cuboid(-4.0F, -5.0F, 2.1F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0F, -5.0F, 1.9F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, -5.0F, 1.7F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 113).cuboid(-4.0F, -5.0F, -1.5F, 8.0F, 10.0F, 3.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, -5.0F, 1.7F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.6169F, -11.9613F, -2.4954F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r21 = rotor_jodie.addChild("cube_r21", ModelPartBuilder.create().uv(132, 32).cuboid(-4.0F, -4.0F, 1.6F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0F, -4.0F, 1.4F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, -4.0F, 1.2F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F))
                .uv(63, 114).cuboid(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, -10.9613F, -5.7099F, 0.0F, -3.1416F, 0.0F));

        ModelPartData cube_r22 = rotor_jodie.addChild("cube_r22", ModelPartBuilder.create().uv(132, 32).cuboid(-4.0F, -4.5F, 2.1F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-4.0F, -4.5F, 1.9F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-4.0F, -4.5F, 1.7F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 113).cuboid(-4.0F, -4.5F, -1.5F, 8.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.7863F, -11.4613F, -2.4954F, 0.0F, -2.0944F, 0.0F));

        ModelPartData cube_r23 = rotor_jodie.addChild("cube_r23", ModelPartBuilder.create().uv(132, 32).mirrored().cuboid(-5.0F, 0.5F, 1.1F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(132, 21).mirrored().cuboid(-5.0F, 0.5F, 0.9F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(130, 58).mirrored().cuboid(-5.0F, 0.5F, 0.7F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(119, 69).mirrored().cuboid(-5.0F, 0.5F, -0.5F, 8.0F, 11.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.1523F, -18.4613F, 4.2996F, 0.0F, -1.0472F, 0.0F));

        ModelPartData cube_r24 = rotor_jodie.addChild("cube_r24", ModelPartBuilder.create().uv(132, 32).cuboid(-5.0F, 0.5F, 1.1F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 21).cuboid(-5.0F, 0.5F, 0.9F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 58).cuboid(-5.0F, 0.5F, 0.7F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(119, 69).cuboid(-5.0F, 0.5F, -0.5F, 8.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.983F, -18.4613F, 2.5675F, 0.0F, 1.0472F, 0.0F));

        ModelPartData cube_r25 = rotor_jodie.addChild("cube_r25", ModelPartBuilder.create().uv(132, 0).cuboid(-4.5F, -9.5F, 1.8F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-4.5F, -9.5F, 1.6F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-4.5F, -9.5F, 1.4F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-4.5F, -9.5F, 1.2F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.9693F, 2.5387F, -3.6784F, 0.0F, -2.0944F, 0.0F));

        ModelPartData cube_r26 = rotor_jodie.addChild("cube_r26", ModelPartBuilder.create().uv(109, 1).cuboid(-1.5577F, -9.5F, 4.0962F, 9.0F, 19.0F, 2.0F, new Dilation(0.001F)), ModelTransform.of(-0.0847F, 2.5387F, -3.6784F, 0.0F, -2.0944F, 0.0F));

        ModelPartData cube_r27 = rotor_jodie.addChild("cube_r27", ModelPartBuilder.create().uv(132, 0).cuboid(-4.5F, -9.5F, 1.8F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-4.5F, -9.5F, 1.6F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-4.5F, -9.5F, 1.4F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-4.5F, -9.5F, 1.2F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(109, 1).cuboid(-4.5F, -9.5F, -1.0F, 9.0F, 19.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.0847F, 2.5387F, -7.0759F, 0.0F, -3.1416F, 0.0F));

        ModelPartData cube_r28 = rotor_jodie.addChild("cube_r28", ModelPartBuilder.create().uv(132, 0).cuboid(-4.5F, -9.5F, 0.6F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-4.5F, -9.5F, 0.4F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-4.5F, -9.5F, 0.2F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-4.5F, -9.5F, 0.0F, 9.0F, 19.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.8392F, 2.5387F, -4.2784F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r29 = rotor_jodie.addChild("cube_r29", ModelPartBuilder.create().uv(109, 1).cuboid(-7.4423F, -9.5F, 4.0962F, 9.0F, 19.0F, 2.0F, new Dilation(0.001F)), ModelTransform.of(-0.0847F, 2.5387F, -3.6784F, 0.0F, 2.0944F, 0.0F));

        ModelPartData cube_r30 = rotor_jodie.addChild("cube_r30", ModelPartBuilder.create().uv(132, 0).cuboid(-5.0F, -9.5F, 1.3F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-5.0F, -9.5F, 1.1F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-5.0F, -9.5F, 0.9F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-5.0F, -9.5F, 0.7F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(108, 0).cuboid(-5.0F, -9.5F, -2.5F, 9.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-6.1523F, 0.5387F, 3.7996F, 0.0F, -1.0472F, 0.0F));

        ModelPartData cube_r31 = rotor_jodie.addChild("cube_r31", ModelPartBuilder.create().uv(132, 0).cuboid(-5.0F, -9.5F, 1.6F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(130, 91).cuboid(-5.0F, -9.5F, 1.3F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(35, 128).cuboid(-5.0F, -9.5F, 1.0F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 128).cuboid(-5.0F, -9.5F, 0.7F, 9.0F, 21.0F, 0.0F, new Dilation(0.0F))
                .uv(108, 0).cuboid(-5.0F, -9.5F, -2.5F, 9.0F, 21.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(6.483F, 0.5387F, 2.9335F, 0.0F, 1.0472F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }


    @Override
    public Animation getAnimationForState(TravelHandlerBase.State state) {
        return switch(state) {
            case DEMAT -> RoofCrystalAnimation.FLIGHT;
            case MAT -> RoofCrystalAnimation.FLIGHT;
            case FLIGHT -> RoofCrystalAnimation.FLIGHT;
            default -> Animation.Builder.create(0).build();
        };
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);

    }

    @Override
    public void renderWithAnimations(CrystalBlockEntity console, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
        super.renderWithAnimations(console, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

}
