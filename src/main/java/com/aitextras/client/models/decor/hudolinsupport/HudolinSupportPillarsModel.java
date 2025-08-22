package com.aitextras.client.models.decor.hudolinsupport;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class HudolinSupportPillarsModel extends SinglePartEntityModel {
    private final ModelPart root;
    public HudolinSupportPillarsModel(ModelPart root) {
        this.root = root.getChild("root");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 108.0F, 0.0F));

        ModelPartData beam1 = root.addChild("beam1", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, 0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r1 = beam1.addChild("cube_r1", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r2 = beam1.addChild("cube_r2", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r3 = beam1.addChild("cube_r3", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r4 = beam1.addChild("cube_r4", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r5 = beam1.addChild("cube_r5", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F))
                .uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x12 = beam1.addChild("x12", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone158 = x12.addChild("bone158", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r6 = bone158.addChild("cube_r6", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r7 = bone158.addChild("cube_r7", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone159 = x12.addChild("bone159", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r8 = bone159.addChild("cube_r8", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r9 = bone159.addChild("cube_r9", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone160 = x12.addChild("bone160", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r10 = bone160.addChild("cube_r10", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r11 = bone160.addChild("cube_r11", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone161 = x12.addChild("bone161", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r12 = bone161.addChild("cube_r12", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r13 = bone161.addChild("cube_r13", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone162 = x12.addChild("bone162", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r14 = bone162.addChild("cube_r14", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r15 = bone162.addChild("cube_r15", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone163 = x12.addChild("bone163", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r16 = bone163.addChild("cube_r16", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r17 = bone163.addChild("cube_r17", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone164 = x12.addChild("bone164", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r18 = bone164.addChild("cube_r18", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r19 = bone164.addChild("cube_r19", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone165 = x12.addChild("bone165", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r20 = bone165.addChild("cube_r20", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r21 = bone165.addChild("cube_r21", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone166 = x12.addChild("bone166", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r22 = bone166.addChild("cube_r22", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r23 = bone166.addChild("cube_r23", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone167 = x12.addChild("bone167", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r24 = bone167.addChild("cube_r24", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r25 = bone167.addChild("cube_r25", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone168 = x12.addChild("bone168", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r26 = bone168.addChild("cube_r26", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r27 = bone168.addChild("cube_r27", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone169 = x12.addChild("bone169", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r28 = bone169.addChild("cube_r28", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r29 = bone169.addChild("cube_r29", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone170 = x12.addChild("bone170", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r30 = bone170.addChild("cube_r30", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r31 = bone170.addChild("cube_r31", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone171 = x12.addChild("bone171", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r32 = bone171.addChild("cube_r32", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x13 = beam1.addChild("x13", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone172 = x13.addChild("bone172", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r33 = bone172.addChild("cube_r33", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r34 = bone172.addChild("cube_r34", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone173 = x13.addChild("bone173", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r35 = bone173.addChild("cube_r35", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r36 = bone173.addChild("cube_r36", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone174 = x13.addChild("bone174", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r37 = bone174.addChild("cube_r37", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r38 = bone174.addChild("cube_r38", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone175 = x13.addChild("bone175", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r39 = bone175.addChild("cube_r39", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r40 = bone175.addChild("cube_r40", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone176 = x13.addChild("bone176", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r41 = bone176.addChild("cube_r41", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r42 = bone176.addChild("cube_r42", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone177 = x13.addChild("bone177", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r43 = bone177.addChild("cube_r43", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r44 = bone177.addChild("cube_r44", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone178 = x13.addChild("bone178", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r45 = bone178.addChild("cube_r45", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r46 = bone178.addChild("cube_r46", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone179 = x13.addChild("bone179", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r47 = bone179.addChild("cube_r47", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r48 = bone179.addChild("cube_r48", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone180 = x13.addChild("bone180", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r49 = bone180.addChild("cube_r49", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r50 = bone180.addChild("cube_r50", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone181 = x13.addChild("bone181", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r51 = bone181.addChild("cube_r51", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r52 = bone181.addChild("cube_r52", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone182 = x13.addChild("bone182", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r53 = bone182.addChild("cube_r53", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r54 = bone182.addChild("cube_r54", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone183 = x13.addChild("bone183", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r55 = bone183.addChild("cube_r55", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r56 = bone183.addChild("cube_r56", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone184 = x13.addChild("bone184", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r57 = bone184.addChild("cube_r57", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r58 = bone184.addChild("cube_r58", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone185 = x13.addChild("bone185", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r59 = bone185.addChild("cube_r59", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root7 = beam1.addChild("root7", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r60 = root7.addChild("cube_r60", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData beam2 = root.addChild("beam2", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, 0.1047F, 1.0472F, 0.0F));

        ModelPartData cube_r61 = beam2.addChild("cube_r61", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r62 = beam2.addChild("cube_r62", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r63 = beam2.addChild("cube_r63", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r64 = beam2.addChild("cube_r64", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r65 = beam2.addChild("cube_r65", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F))
                .uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x2 = beam2.addChild("x2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone16 = x2.addChild("bone16", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r66 = bone16.addChild("cube_r66", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r67 = bone16.addChild("cube_r67", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone17 = x2.addChild("bone17", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r68 = bone17.addChild("cube_r68", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r69 = bone17.addChild("cube_r69", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone18 = x2.addChild("bone18", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r70 = bone18.addChild("cube_r70", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r71 = bone18.addChild("cube_r71", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone19 = x2.addChild("bone19", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r72 = bone19.addChild("cube_r72", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r73 = bone19.addChild("cube_r73", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone20 = x2.addChild("bone20", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r74 = bone20.addChild("cube_r74", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r75 = bone20.addChild("cube_r75", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone21 = x2.addChild("bone21", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r76 = bone21.addChild("cube_r76", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r77 = bone21.addChild("cube_r77", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone22 = x2.addChild("bone22", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r78 = bone22.addChild("cube_r78", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r79 = bone22.addChild("cube_r79", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone23 = x2.addChild("bone23", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r80 = bone23.addChild("cube_r80", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r81 = bone23.addChild("cube_r81", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone24 = x2.addChild("bone24", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r82 = bone24.addChild("cube_r82", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r83 = bone24.addChild("cube_r83", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone25 = x2.addChild("bone25", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r84 = bone25.addChild("cube_r84", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r85 = bone25.addChild("cube_r85", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone26 = x2.addChild("bone26", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r86 = bone26.addChild("cube_r86", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r87 = bone26.addChild("cube_r87", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone27 = x2.addChild("bone27", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r88 = bone27.addChild("cube_r88", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r89 = bone27.addChild("cube_r89", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone28 = x2.addChild("bone28", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r90 = bone28.addChild("cube_r90", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r91 = bone28.addChild("cube_r91", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone29 = x2.addChild("bone29", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r92 = bone29.addChild("cube_r92", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x3 = beam2.addChild("x3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone30 = x3.addChild("bone30", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r93 = bone30.addChild("cube_r93", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r94 = bone30.addChild("cube_r94", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone31 = x3.addChild("bone31", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r95 = bone31.addChild("cube_r95", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r96 = bone31.addChild("cube_r96", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone32 = x3.addChild("bone32", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r97 = bone32.addChild("cube_r97", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r98 = bone32.addChild("cube_r98", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone33 = x3.addChild("bone33", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r99 = bone33.addChild("cube_r99", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r100 = bone33.addChild("cube_r100", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone34 = x3.addChild("bone34", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r101 = bone34.addChild("cube_r101", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r102 = bone34.addChild("cube_r102", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone35 = x3.addChild("bone35", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r103 = bone35.addChild("cube_r103", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r104 = bone35.addChild("cube_r104", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone36 = x3.addChild("bone36", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r105 = bone36.addChild("cube_r105", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r106 = bone36.addChild("cube_r106", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone37 = x3.addChild("bone37", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r107 = bone37.addChild("cube_r107", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r108 = bone37.addChild("cube_r108", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone38 = x3.addChild("bone38", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r109 = bone38.addChild("cube_r109", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r110 = bone38.addChild("cube_r110", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone39 = x3.addChild("bone39", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r111 = bone39.addChild("cube_r111", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r112 = bone39.addChild("cube_r112", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone40 = x3.addChild("bone40", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r113 = bone40.addChild("cube_r113", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r114 = bone40.addChild("cube_r114", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone41 = x3.addChild("bone41", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r115 = bone41.addChild("cube_r115", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r116 = bone41.addChild("cube_r116", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone42 = x3.addChild("bone42", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r117 = bone42.addChild("cube_r117", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r118 = bone42.addChild("cube_r118", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone43 = x3.addChild("bone43", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r119 = bone43.addChild("cube_r119", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root2 = beam2.addChild("root2", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r120 = root2.addChild("cube_r120", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData beam3 = root.addChild("beam3", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, -3.0369F, 1.0472F, 3.1416F));

        ModelPartData cube_r121 = beam3.addChild("cube_r121", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r122 = beam3.addChild("cube_r122", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r123 = beam3.addChild("cube_r123", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r124 = beam3.addChild("cube_r124", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r125 = beam3.addChild("cube_r125", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F))
                .uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x4 = beam3.addChild("x4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone44 = x4.addChild("bone44", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r126 = bone44.addChild("cube_r126", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r127 = bone44.addChild("cube_r127", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone45 = x4.addChild("bone45", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r128 = bone45.addChild("cube_r128", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r129 = bone45.addChild("cube_r129", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone46 = x4.addChild("bone46", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r130 = bone46.addChild("cube_r130", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r131 = bone46.addChild("cube_r131", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone47 = x4.addChild("bone47", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r132 = bone47.addChild("cube_r132", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r133 = bone47.addChild("cube_r133", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone48 = x4.addChild("bone48", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r134 = bone48.addChild("cube_r134", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r135 = bone48.addChild("cube_r135", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone49 = x4.addChild("bone49", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r136 = bone49.addChild("cube_r136", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r137 = bone49.addChild("cube_r137", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone50 = x4.addChild("bone50", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r138 = bone50.addChild("cube_r138", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r139 = bone50.addChild("cube_r139", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone51 = x4.addChild("bone51", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r140 = bone51.addChild("cube_r140", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r141 = bone51.addChild("cube_r141", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone52 = x4.addChild("bone52", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r142 = bone52.addChild("cube_r142", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r143 = bone52.addChild("cube_r143", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone53 = x4.addChild("bone53", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r144 = bone53.addChild("cube_r144", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r145 = bone53.addChild("cube_r145", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone54 = x4.addChild("bone54", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r146 = bone54.addChild("cube_r146", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r147 = bone54.addChild("cube_r147", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone55 = x4.addChild("bone55", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r148 = bone55.addChild("cube_r148", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r149 = bone55.addChild("cube_r149", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone56 = x4.addChild("bone56", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r150 = bone56.addChild("cube_r150", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r151 = bone56.addChild("cube_r151", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone57 = x4.addChild("bone57", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r152 = bone57.addChild("cube_r152", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x5 = beam3.addChild("x5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone58 = x5.addChild("bone58", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r153 = bone58.addChild("cube_r153", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r154 = bone58.addChild("cube_r154", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone59 = x5.addChild("bone59", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r155 = bone59.addChild("cube_r155", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r156 = bone59.addChild("cube_r156", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone60 = x5.addChild("bone60", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r157 = bone60.addChild("cube_r157", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r158 = bone60.addChild("cube_r158", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone61 = x5.addChild("bone61", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r159 = bone61.addChild("cube_r159", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r160 = bone61.addChild("cube_r160", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone62 = x5.addChild("bone62", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r161 = bone62.addChild("cube_r161", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r162 = bone62.addChild("cube_r162", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone63 = x5.addChild("bone63", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r163 = bone63.addChild("cube_r163", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r164 = bone63.addChild("cube_r164", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone64 = x5.addChild("bone64", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r165 = bone64.addChild("cube_r165", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r166 = bone64.addChild("cube_r166", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone65 = x5.addChild("bone65", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r167 = bone65.addChild("cube_r167", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r168 = bone65.addChild("cube_r168", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone66 = x5.addChild("bone66", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r169 = bone66.addChild("cube_r169", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r170 = bone66.addChild("cube_r170", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone67 = x5.addChild("bone67", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r171 = bone67.addChild("cube_r171", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r172 = bone67.addChild("cube_r172", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone68 = x5.addChild("bone68", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r173 = bone68.addChild("cube_r173", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r174 = bone68.addChild("cube_r174", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone69 = x5.addChild("bone69", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r175 = bone69.addChild("cube_r175", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r176 = bone69.addChild("cube_r176", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone70 = x5.addChild("bone70", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r177 = bone70.addChild("cube_r177", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r178 = bone70.addChild("cube_r178", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone71 = x5.addChild("bone71", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r179 = bone71.addChild("cube_r179", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root3 = beam3.addChild("root3", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r180 = root3.addChild("cube_r180", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData beam4 = root.addChild("beam4", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, -3.0369F, 0.0F, 3.1416F));

        ModelPartData cube_r181 = beam4.addChild("cube_r181", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r182 = beam4.addChild("cube_r182", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r183 = beam4.addChild("cube_r183", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r184 = beam4.addChild("cube_r184", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r185 = beam4.addChild("cube_r185", ModelPartBuilder.create().uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x6 = beam4.addChild("x6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone72 = x6.addChild("bone72", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r186 = bone72.addChild("cube_r186", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r187 = bone72.addChild("cube_r187", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone73 = x6.addChild("bone73", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r188 = bone73.addChild("cube_r188", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r189 = bone73.addChild("cube_r189", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone74 = x6.addChild("bone74", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r190 = bone74.addChild("cube_r190", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r191 = bone74.addChild("cube_r191", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone75 = x6.addChild("bone75", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r192 = bone75.addChild("cube_r192", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r193 = bone75.addChild("cube_r193", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone76 = x6.addChild("bone76", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r194 = bone76.addChild("cube_r194", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r195 = bone76.addChild("cube_r195", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone77 = x6.addChild("bone77", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r196 = bone77.addChild("cube_r196", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r197 = bone77.addChild("cube_r197", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone78 = x6.addChild("bone78", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r198 = bone78.addChild("cube_r198", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r199 = bone78.addChild("cube_r199", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone79 = x6.addChild("bone79", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r200 = bone79.addChild("cube_r200", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r201 = bone79.addChild("cube_r201", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone80 = x6.addChild("bone80", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r202 = bone80.addChild("cube_r202", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r203 = bone80.addChild("cube_r203", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone81 = x6.addChild("bone81", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r204 = bone81.addChild("cube_r204", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r205 = bone81.addChild("cube_r205", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone82 = x6.addChild("bone82", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r206 = bone82.addChild("cube_r206", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r207 = bone82.addChild("cube_r207", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone83 = x6.addChild("bone83", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r208 = bone83.addChild("cube_r208", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r209 = bone83.addChild("cube_r209", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone84 = x6.addChild("bone84", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r210 = bone84.addChild("cube_r210", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r211 = bone84.addChild("cube_r211", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone85 = x6.addChild("bone85", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r212 = bone85.addChild("cube_r212", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x7 = beam4.addChild("x7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone86 = x7.addChild("bone86", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r213 = bone86.addChild("cube_r213", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r214 = bone86.addChild("cube_r214", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone87 = x7.addChild("bone87", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r215 = bone87.addChild("cube_r215", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r216 = bone87.addChild("cube_r216", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone88 = x7.addChild("bone88", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r217 = bone88.addChild("cube_r217", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r218 = bone88.addChild("cube_r218", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone89 = x7.addChild("bone89", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r219 = bone89.addChild("cube_r219", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r220 = bone89.addChild("cube_r220", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone90 = x7.addChild("bone90", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r221 = bone90.addChild("cube_r221", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r222 = bone90.addChild("cube_r222", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone91 = x7.addChild("bone91", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r223 = bone91.addChild("cube_r223", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r224 = bone91.addChild("cube_r224", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone92 = x7.addChild("bone92", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r225 = bone92.addChild("cube_r225", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r226 = bone92.addChild("cube_r226", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone93 = x7.addChild("bone93", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r227 = bone93.addChild("cube_r227", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r228 = bone93.addChild("cube_r228", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone94 = x7.addChild("bone94", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r229 = bone94.addChild("cube_r229", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r230 = bone94.addChild("cube_r230", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone95 = x7.addChild("bone95", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r231 = bone95.addChild("cube_r231", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r232 = bone95.addChild("cube_r232", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone96 = x7.addChild("bone96", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r233 = bone96.addChild("cube_r233", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r234 = bone96.addChild("cube_r234", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone97 = x7.addChild("bone97", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r235 = bone97.addChild("cube_r235", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r236 = bone97.addChild("cube_r236", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone98 = x7.addChild("bone98", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r237 = bone98.addChild("cube_r237", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r238 = bone98.addChild("cube_r238", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone99 = x7.addChild("bone99", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r239 = bone99.addChild("cube_r239", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root4 = beam4.addChild("root4", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r240 = root4.addChild("cube_r240", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData beam5 = root.addChild("beam5", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, -3.0369F, -1.0472F, 3.1416F));

        ModelPartData cube_r241 = beam5.addChild("cube_r241", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r242 = beam5.addChild("cube_r242", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r243 = beam5.addChild("cube_r243", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r244 = beam5.addChild("cube_r244", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r245 = beam5.addChild("cube_r245", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F))
                .uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x8 = beam5.addChild("x8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone100 = x8.addChild("bone100", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r246 = bone100.addChild("cube_r246", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r247 = bone100.addChild("cube_r247", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone101 = x8.addChild("bone101", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r248 = bone101.addChild("cube_r248", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r249 = bone101.addChild("cube_r249", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone102 = x8.addChild("bone102", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r250 = bone102.addChild("cube_r250", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r251 = bone102.addChild("cube_r251", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone103 = x8.addChild("bone103", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r252 = bone103.addChild("cube_r252", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r253 = bone103.addChild("cube_r253", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone104 = x8.addChild("bone104", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r254 = bone104.addChild("cube_r254", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r255 = bone104.addChild("cube_r255", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone105 = x8.addChild("bone105", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r256 = bone105.addChild("cube_r256", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r257 = bone105.addChild("cube_r257", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone106 = x8.addChild("bone106", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r258 = bone106.addChild("cube_r258", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r259 = bone106.addChild("cube_r259", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone107 = x8.addChild("bone107", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r260 = bone107.addChild("cube_r260", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r261 = bone107.addChild("cube_r261", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone108 = x8.addChild("bone108", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r262 = bone108.addChild("cube_r262", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r263 = bone108.addChild("cube_r263", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone109 = x8.addChild("bone109", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r264 = bone109.addChild("cube_r264", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r265 = bone109.addChild("cube_r265", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone110 = x8.addChild("bone110", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r266 = bone110.addChild("cube_r266", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r267 = bone110.addChild("cube_r267", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone111 = x8.addChild("bone111", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r268 = bone111.addChild("cube_r268", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r269 = bone111.addChild("cube_r269", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone112 = x8.addChild("bone112", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r270 = bone112.addChild("cube_r270", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r271 = bone112.addChild("cube_r271", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone113 = x8.addChild("bone113", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r272 = bone113.addChild("cube_r272", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x9 = beam5.addChild("x9", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone114 = x9.addChild("bone114", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r273 = bone114.addChild("cube_r273", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r274 = bone114.addChild("cube_r274", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone115 = x9.addChild("bone115", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r275 = bone115.addChild("cube_r275", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r276 = bone115.addChild("cube_r276", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone116 = x9.addChild("bone116", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r277 = bone116.addChild("cube_r277", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r278 = bone116.addChild("cube_r278", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone117 = x9.addChild("bone117", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r279 = bone117.addChild("cube_r279", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r280 = bone117.addChild("cube_r280", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone118 = x9.addChild("bone118", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r281 = bone118.addChild("cube_r281", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r282 = bone118.addChild("cube_r282", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone119 = x9.addChild("bone119", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r283 = bone119.addChild("cube_r283", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r284 = bone119.addChild("cube_r284", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone120 = x9.addChild("bone120", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r285 = bone120.addChild("cube_r285", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r286 = bone120.addChild("cube_r286", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone121 = x9.addChild("bone121", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r287 = bone121.addChild("cube_r287", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r288 = bone121.addChild("cube_r288", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone122 = x9.addChild("bone122", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r289 = bone122.addChild("cube_r289", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r290 = bone122.addChild("cube_r290", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone123 = x9.addChild("bone123", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r291 = bone123.addChild("cube_r291", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r292 = bone123.addChild("cube_r292", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone124 = x9.addChild("bone124", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r293 = bone124.addChild("cube_r293", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r294 = bone124.addChild("cube_r294", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone125 = x9.addChild("bone125", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r295 = bone125.addChild("cube_r295", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r296 = bone125.addChild("cube_r296", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone126 = x9.addChild("bone126", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r297 = bone126.addChild("cube_r297", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r298 = bone126.addChild("cube_r298", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone127 = x9.addChild("bone127", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r299 = bone127.addChild("cube_r299", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root5 = beam5.addChild("root5", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r300 = root5.addChild("cube_r300", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));

        ModelPartData beam6 = root.addChild("beam6", ModelPartBuilder.create(), ModelTransform.of(0.0F, -80.6242F, -0.0589F, 0.1047F, -1.0472F, 0.0F));

        ModelPartData cube_r301 = beam6.addChild("cube_r301", ModelPartBuilder.create().uv(111, 88).cuboid(-2.0F, -13.3F, -1.65F, 6.0F, 20.0F, -1.0F, new Dilation(1.0F)), ModelTransform.of(1.0F, 1.5826F, 3.7251F, -3.0369F, 0.0F, -3.1416F));

        ModelPartData cube_r302 = beam6.addChild("cube_r302", ModelPartBuilder.create().uv(72, 0).cuboid(-4.0F, 7.9995F, -32.5413F, 6.0F, 22.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -16.9171F, 41.1553F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r303 = beam6.addChild("cube_r303", ModelPartBuilder.create().uv(43, 77).cuboid(-4.5F, 3.138F, -7.4494F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, 0.2443F, 0.0F, 0.0F));

        ModelPartData cube_r304 = beam6.addChild("cube_r304", ModelPartBuilder.create().uv(48, 91).cuboid(-3.0F, 5.1997F, -32.7802F, 6.0F, 5.0F, 32.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -19.1839F, 40.5276F, -0.1047F, 0.0F, 0.0F));

        ModelPartData cube_r305 = beam6.addChild("cube_r305", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -97.0823F, -0.9903F, 8.0F, 91.0F, 11.0F, new Dilation(0.0F))
                .uv(97, 60).cuboid(-4.0F, -58.0823F, -1.3903F, 8.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 88.0885F, 52.5521F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x10 = beam6.addChild("x10", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone128 = x10.addChild("bone128", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 62.1597F));

        ModelPartData cube_r306 = bone128.addChild("cube_r306", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r307 = bone128.addChild("cube_r307", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone129 = x10.addChild("bone129", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 61.1597F));

        ModelPartData cube_r308 = bone129.addChild("cube_r308", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r309 = bone129.addChild("cube_r309", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone130 = x10.addChild("bone130", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 59.9597F));

        ModelPartData cube_r310 = bone130.addChild("cube_r310", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r311 = bone130.addChild("cube_r311", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone131 = x10.addChild("bone131", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 58.9597F));

        ModelPartData cube_r312 = bone131.addChild("cube_r312", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r313 = bone131.addChild("cube_r313", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone132 = x10.addChild("bone132", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 57.9597F));

        ModelPartData cube_r314 = bone132.addChild("cube_r314", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r315 = bone132.addChild("cube_r315", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone133 = x10.addChild("bone133", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 56.8597F));

        ModelPartData cube_r316 = bone133.addChild("cube_r316", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r317 = bone133.addChild("cube_r317", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone134 = x10.addChild("bone134", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 54.7597F));

        ModelPartData cube_r318 = bone134.addChild("cube_r318", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r319 = bone134.addChild("cube_r319", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone135 = x10.addChild("bone135", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 53.6597F));

        ModelPartData cube_r320 = bone135.addChild("cube_r320", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r321 = bone135.addChild("cube_r321", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone136 = x10.addChild("bone136", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 52.6597F));

        ModelPartData cube_r322 = bone136.addChild("cube_r322", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r323 = bone136.addChild("cube_r323", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone137 = x10.addChild("bone137", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 51.5597F));

        ModelPartData cube_r324 = bone137.addChild("cube_r324", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r325 = bone137.addChild("cube_r325", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone138 = x10.addChild("bone138", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 50.4597F));

        ModelPartData cube_r326 = bone138.addChild("cube_r326", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r327 = bone138.addChild("cube_r327", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone139 = x10.addChild("bone139", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 49.4597F));

        ModelPartData cube_r328 = bone139.addChild("cube_r328", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r329 = bone139.addChild("cube_r329", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone140 = x10.addChild("bone140", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 48.4597F));

        ModelPartData cube_r330 = bone140.addChild("cube_r330", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r331 = bone140.addChild("cube_r331", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone141 = x10.addChild("bone141", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 55.8597F));

        ModelPartData cube_r332 = bone141.addChild("cube_r332", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData x11 = beam6.addChild("x11", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 83.6741F, -1.1316F));

        ModelPartData bone142 = x11.addChild("bone142", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.9092F, 51.1597F));

        ModelPartData cube_r333 = bone142.addChild("cube_r333", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r334 = bone142.addChild("cube_r334", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone143 = x11.addChild("bone143", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -15.9092F, 50.1597F));

        ModelPartData cube_r335 = bone143.addChild("cube_r335", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r336 = bone143.addChild("cube_r336", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone144 = x11.addChild("bone144", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -21.9092F, 48.9597F));

        ModelPartData cube_r337 = bone144.addChild("cube_r337", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r338 = bone144.addChild("cube_r338", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone145 = x11.addChild("bone145", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.9092F, 47.9597F));

        ModelPartData cube_r339 = bone145.addChild("cube_r339", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r340 = bone145.addChild("cube_r340", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone146 = x11.addChild("bone146", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -33.9092F, 46.9597F));

        ModelPartData cube_r341 = bone146.addChild("cube_r341", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r342 = bone146.addChild("cube_r342", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone147 = x11.addChild("bone147", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -39.9092F, 45.8597F));

        ModelPartData cube_r343 = bone147.addChild("cube_r343", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r344 = bone147.addChild("cube_r344", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone148 = x11.addChild("bone148", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -51.9092F, 43.7597F));

        ModelPartData cube_r345 = bone148.addChild("cube_r345", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r346 = bone148.addChild("cube_r346", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone149 = x11.addChild("bone149", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -57.9092F, 42.6597F));

        ModelPartData cube_r347 = bone149.addChild("cube_r347", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r348 = bone149.addChild("cube_r348", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone150 = x11.addChild("bone150", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -63.9092F, 41.6597F));

        ModelPartData cube_r349 = bone150.addChild("cube_r349", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r350 = bone150.addChild("cube_r350", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone151 = x11.addChild("bone151", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -69.9092F, 40.5597F));

        ModelPartData cube_r351 = bone151.addChild("cube_r351", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r352 = bone151.addChild("cube_r352", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone152 = x11.addChild("bone152", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -75.9092F, 39.4597F));

        ModelPartData cube_r353 = bone152.addChild("cube_r353", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r354 = bone152.addChild("cube_r354", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone153 = x11.addChild("bone153", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -81.9092F, 38.4597F));

        ModelPartData cube_r355 = bone153.addChild("cube_r355", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r356 = bone153.addChild("cube_r356", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone154 = x11.addChild("bone154", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -87.9092F, 37.4597F));

        ModelPartData cube_r357 = bone154.addChild("cube_r357", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, -5.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, -0.1343F, 0.1119F, -2.451F));

        ModelPartData cube_r358 = bone154.addChild("cube_r358", ModelPartBuilder.create().uv(110, 48).cuboid(-8.3038F, 4.0332F, -0.9903F, 9.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.083F, -2.2283F, -0.2959F, 0.1343F, 0.1119F, -0.6906F));

        ModelPartData bone155 = x11.addChild("bone155", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -45.9092F, 44.8597F));

        ModelPartData cube_r359 = bone155.addChild("cube_r359", ModelPartBuilder.create().uv(111, 34).cuboid(-5.5F, 5.4177F, -0.9903F, 8.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(1.483F, -2.2283F, -0.2959F, 0.1745F, 0.0F, 0.0F));

        ModelPartData root6 = beam6.addChild("root6", ModelPartBuilder.create().uv(38, 30).cuboid(-4.5F, -4.75F, -4.0F, 9.0F, 9.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 84.8385F, 60.6743F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData cube_r360 = root6.addChild("cube_r360", ModelPartBuilder.create().uv(38, 55).cuboid(-8.0F, -4.0F, -4.0F, 16.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.25F, -4.0F, -0.3054F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }


    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
