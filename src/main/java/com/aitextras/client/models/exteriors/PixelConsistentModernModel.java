package com.aitextras.client.models.exteriors;

import dev.amble.ait.AITMod;
import dev.amble.ait.api.tardis.link.v2.Linkable;
import dev.amble.ait.client.models.exteriors.ExteriorModel;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.blockentities.ExteriorBlockEntity;
import dev.amble.ait.core.tardis.handler.DoorHandler;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;


public class PixelConsistentModernModel extends ExteriorModel {
	private final ModelPart root;

	public PixelConsistentModernModel() {
		super();
		this.root = getTexturedModelData().createModel().getChild("bone");
	}

	public void renderWithAnimations(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		// Apply any transformations if needed
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData TARDIS = bone.addChild("TARDIS", ModelPartBuilder.create().uv(83, 150).cuboid(-12.0F, -35.3F, -8.0F, 24.0F, 0.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData base = TARDIS.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(-13.0F, -4.0F, -13.0F, 26.0F, 2.0F, 26.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 0.0F));

		ModelPartData lip_all = TARDIS.addChild("lip_all", ModelPartBuilder.create().uv(118, 108).cuboid(-8.0F, -40.0F, -11.0F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.0F, -0.5F));

		ModelPartData cube_r1 = lip_all.addChild("cube_r1", ModelPartBuilder.create().uv(222, 2).cuboid(-8.0F, -3.19F, 0.4F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(222, 0).cuboid(-8.0F, -3.99F, 0.4F, 16.0F, 0.0F, 2.0F, new Dilation(0.0F))
				.uv(118, 108).cuboid(-8.0F, 2.5F, 0.6F, 16.0F, 0.0F, 1.0F, new Dilation(0.0F))
				.uv(8, 77).cuboid(-8.0F, 0.49F, 0.0F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -40.5F, -8.7F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r2 = lip_all.addChild("cube_r2", ModelPartBuilder.create().uv(118, 108).cuboid(-8.0F, -1.0F, -0.5F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -39.0F, 0.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r3 = lip_all.addChild("cube_r3", ModelPartBuilder.create().uv(118, 108).cuboid(-8.0F, -1.0F, -0.5F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -39.0F, 11.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r4 = lip_all.addChild("cube_r4", ModelPartBuilder.create().uv(118, 108).cuboid(-8.0F, -1.0F, -11.5F, 16.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -39.0F, 0.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData posts = TARDIS.addChild("posts", ModelPartBuilder.create().uv(88, 28).cuboid(8.0F, -44.0F, -12.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r5 = posts.addChild("cube_r5", ModelPartBuilder.create().uv(88, 28).cuboid(-2.0F, -21.0F, -2.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -23.0F, 10.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r6 = posts.addChild("cube_r6", ModelPartBuilder.create().uv(88, 28).cuboid(-2.0F, -21.0F, -2.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -23.0F, 10.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r7 = posts.addChild("cube_r7", ModelPartBuilder.create().uv(88, 28).cuboid(-2.0F, -21.0F, -2.0F, 4.0F, 42.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -23.0F, -10.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData walls = TARDIS.addChild("walls", ModelPartBuilder.create().uv(34, 77).mirrored().cuboid(-11.0F, -16.5F, -8.0F, 1.0F, 33.0F, 16.0F, new Dilation(0.0F)).mirrored(false)
				.uv(33, 92).cuboid(-8.0F, -16.5F, 10.0F, 16.0F, 33.0F, 1.0F, new Dilation(0.0F))
				.uv(102, 111).cuboid(-10.0F, -22.5F, 5.0F, 20.0F, 39.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 77).cuboid(-1.0F, -16.5F, 11.3F, 2.0F, 33.0F, 0.0F, new Dilation(0.0F))
				.uv(34, 77).cuboid(10.0F, -16.5F, -8.0F, 1.0F, 33.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.5F, 0.0F));

		ModelPartData cube_r8 = walls.addChild("cube_r8", ModelPartBuilder.create().uv(0, 77).cuboid(-1.0F, -16.5F, -11.3F, 2.0F, 33.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 77).cuboid(-1.0F, -16.5F, 11.3F, 2.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData firstdoctor = TARDIS.addChild("firstdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData sign1 = firstdoctor.addChild("sign1", ModelPartBuilder.create().uv(118, 80).cuboid(2.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -39.0F, 0.0F));

		ModelPartData cube_r9 = sign1.addChild("cube_r9", ModelPartBuilder.create().uv(118, 80).cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r10 = sign1.addChild("cube_r10", ModelPartBuilder.create().uv(118, 80).mirrored().cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(12.0F, 0.0F, 12.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r11 = sign1.addChild("cube_r11", ModelPartBuilder.create().uv(118, 80).cuboid(-10.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData roof1 = firstdoctor.addChild("roof1", ModelPartBuilder.create().uv(0, 28).cuboid(-11.0F, -2.5F, -11.0F, 22.0F, 6.0F, 22.0F, new Dilation(0.0F))
				.uv(0, 56).cuboid(-10.0F, -3.0F, -10.0F, 20.0F, 1.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

		ModelPartData lamp1 = firstdoctor.addChild("lamp1", ModelPartBuilder.create().uv(120, 7).cuboid(-4.6464F, -1.5F, -4.6464F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(120, 0).cuboid(-5.6464F, -2.5F, -5.6464F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.6465F, -50.0F, 2.6465F));

		ModelPartData cube_r12 = lamp1.addChild("cube_r12", ModelPartBuilder.create().uv(80, 56).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r13 = lamp1.addChild("cube_r13", ModelPartBuilder.create().uv(80, 56).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r14 = lamp1.addChild("cube_r14", ModelPartBuilder.create().uv(80, 56).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, -5.2929F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r15 = lamp1.addChild("cube_r15", ModelPartBuilder.create().uv(80, 56).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -5.2929F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r16 = lamp1.addChild("cube_r16", ModelPartBuilder.create().uv(120, 16).cuboid(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.6465F, -3.0F, -2.6465F, 0.0F, -0.7854F, 0.0F));

		ModelPartData secondanthirddoctor = TARDIS.addChild("secondanthirddoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData sign2 = secondanthirddoctor.addChild("sign2", ModelPartBuilder.create().uv(212, 200).cuboid(2.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -39.0F, 0.0F));

		ModelPartData cube_r17 = sign2.addChild("cube_r17", ModelPartBuilder.create().uv(212, 200).cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r18 = sign2.addChild("cube_r18", ModelPartBuilder.create().uv(212, 200).mirrored().cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(12.0F, 0.0F, 12.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r19 = sign2.addChild("cube_r19", ModelPartBuilder.create().uv(212, 200).cuboid(-10.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r20 = sign2.addChild("cube_r20", ModelPartBuilder.create().uv(52, 77).cuboid(-10.0F, -4.0F, -1.5F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 1.5F, -9.2F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData roof = secondanthirddoctor.addChild("roof", ModelPartBuilder.create().uv(168, 231).cuboid(-11.0F, 0.5F, -11.0F, 22.0F, 3.0F, 22.0F, new Dilation(-0.1F))
				.uv(168, 208).cuboid(-11.0F, 0.0F, -11.0F, 22.0F, 1.0F, 22.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

		ModelPartData lamp2 = secondanthirddoctor.addChild("lamp2", ModelPartBuilder.create().uv(232, 184).cuboid(-4.6464F, -2.2F, -4.6464F, 4.0F, 5.0F, 4.0F, new Dilation(-0.2F))
				.uv(232, 177).cuboid(-5.6464F, -2.5F, -5.6464F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.6465F, -47.0F, 2.6465F));

		ModelPartData cube_r21 = lamp2.addChild("cube_r21", ModelPartBuilder.create().uv(227, 193).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r22 = lamp2.addChild("cube_r22", ModelPartBuilder.create().uv(227, 193).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r23 = lamp2.addChild("cube_r23", ModelPartBuilder.create().uv(227, 193).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, -5.2929F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r24 = lamp2.addChild("cube_r24", ModelPartBuilder.create().uv(227, 193).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -5.2929F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r25 = lamp2.addChild("cube_r25", ModelPartBuilder.create().uv(232, 193).cuboid(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.6465F, -3.0F, -2.6465F, 0.0F, -0.7854F, 0.0F));

		ModelPartData forthdoctor = TARDIS.addChild("forthdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData sign4 = forthdoctor.addChild("sign4", ModelPartBuilder.create().uv(4, 164).cuboid(2.0F, -2.5F, -14.0F, 20.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-12.0F, -38.2F, 0.0F));

		ModelPartData cube_r26 = sign4.addChild("cube_r26", ModelPartBuilder.create().uv(4, 164).cuboid(-10.0F, -2.5F, -2.0F, 20.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r27 = sign4.addChild("cube_r27", ModelPartBuilder.create().uv(4, 164).mirrored().cuboid(-10.0F, -2.5F, -2.0F, 20.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(12.0F, 0.0F, 12.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r28 = sign4.addChild("cube_r28", ModelPartBuilder.create().uv(4, 164).cuboid(-10.0F, -2.5F, -14.0F, 20.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData roof2 = forthdoctor.addChild("roof2", ModelPartBuilder.create().uv(108, 170).cuboid(-11.0F, 2.0F, -11.0F, 22.0F, 4.0F, 22.0F, new Dilation(0.0F))
				.uv(0, 143).cuboid(-10.0F, 1.5F, -10.0F, 20.0F, 1.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

		ModelPartData lamp = forthdoctor.addChild("lamp", ModelPartBuilder.create().uv(120, 97).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -42.5F, 0.0F));

		ModelPartData pillartop4 = forthdoctor.addChild("pillartop4", ModelPartBuilder.create().uv(0, 4).mirrored().cuboid(-11.0F, -42.0F, 9.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(0, 4).cuboid(9.0F, -42.0F, 9.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 4).cuboid(9.0F, -42.0F, -11.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(0, 4).mirrored().cuboid(-11.0F, -42.0F, -11.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

		ModelPartData fifthdoctor = TARDIS.addChild("fifthdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData roof5 = fifthdoctor.addChild("roof5", ModelPartBuilder.create().uv(30, 229).cuboid(-11.0F, 0.4F, -11.0F, 22.0F, 5.0F, 22.0F, new Dilation(0.0F))
				.uv(0, 202).cuboid(-10.0F, -1.1F, -10.0F, 20.0F, 2.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -44.7F, 0.0F));

		ModelPartData sign5 = fifthdoctor.addChild("sign5", ModelPartBuilder.create().uv(5, 224).cuboid(-10.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -38.2F, 0.0F));

		ModelPartData cube_r29 = sign5.addChild("cube_r29", ModelPartBuilder.create().uv(5, 224).cuboid(-10.0F, -2.5F, -13.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r30 = sign5.addChild("cube_r30", ModelPartBuilder.create().uv(5, 224).mirrored().cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 12.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r31 = sign5.addChild("cube_r31", ModelPartBuilder.create().uv(5, 224).cuboid(-10.0F, -2.5F, -1.0F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r32 = sign5.addChild("cube_r32", ModelPartBuilder.create().uv(52, 84).cuboid(-10.0F, -3.6F, -1.5F, 20.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.1F, -9.2F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData lamp5 = fifthdoctor.addChild("lamp5", ModelPartBuilder.create().uv(81, 211).cuboid(-4.6464F, -2.2F, -4.6464F, 4.0F, 5.0F, 4.0F, new Dilation(-0.2F))
				.uv(81, 204).cuboid(-5.6464F, -2.5F, -5.6464F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.6465F, -48.2F, 2.6465F));

		ModelPartData cube_r33 = lamp5.addChild("cube_r33", ModelPartBuilder.create().uv(46, 244).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r34 = lamp5.addChild("cube_r34", ModelPartBuilder.create().uv(46, 244).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r35 = lamp5.addChild("cube_r35", ModelPartBuilder.create().uv(46, 244).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-5.2929F, 0.0F, -5.2929F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r36 = lamp5.addChild("cube_r36", ModelPartBuilder.create().uv(46, 244).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -5.2929F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r37 = lamp5.addChild("cube_r37", ModelPartBuilder.create().uv(81, 220).cuboid(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.6465F, -3.0F, -2.6465F, 0.0F, -0.7854F, 0.0F));

		ModelPartData pillartop5 = fifthdoctor.addChild("pillartop5", ModelPartBuilder.create().uv(-4, 0).mirrored().cuboid(-11.0F, -43.0F, 9.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(-4, 0).cuboid(9.0F, -43.0F, 9.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(-4, 0).cuboid(9.0F, -43.0F, -11.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F))
				.uv(-4, 0).mirrored().cuboid(-11.0F, -43.0F, -11.0F, 4.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

		ModelPartData seventhdoctor = TARDIS.addChild("seventhdoctor", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData roof7 = seventhdoctor.addChild("roof7", ModelPartBuilder.create().uv(168, 93).cuboid(-11.0F, 1.2F, -11.0F, 22.0F, 4.0F, 22.0F, new Dilation(0.0F))
				.uv(176, 36).cuboid(-10.0F, -0.4F, -10.0F, 20.0F, 2.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -44.5F, 0.0F));

		ModelPartData lamp7 = seventhdoctor.addChild("lamp7", ModelPartBuilder.create().uv(200, 0).cuboid(-2.0F, -6.9F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F))
				.uv(232, 83).cuboid(-3.0F, -7.9F, -3.0F, 6.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -42.5F, 0.0F));

		ModelPartData cube_r38 = lamp7.addChild("cube_r38", ModelPartBuilder.create().uv(238, 89).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.6465F, -4.4F, 2.6465F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r39 = lamp7.addChild("cube_r39", ModelPartBuilder.create().uv(238, 89).mirrored().cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.6465F, -4.4F, 2.6465F, 0.0F, -0.7854F, 0.0F));

		ModelPartData cube_r40 = lamp7.addChild("cube_r40", ModelPartBuilder.create().uv(238, 89).mirrored().cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.6465F, -4.4F, -2.6465F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r41 = lamp7.addChild("cube_r41", ModelPartBuilder.create().uv(238, 89).cuboid(-0.5F, -2.5F, 0.0F, 1.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.6465F, -4.4F, -2.6465F, 0.0F, -0.7854F, 0.0F));

		ModelPartData Doors = bone.addChild("Doors", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_door = Doors.addChild("right_door", ModelPartBuilder.create().uv(84, 111).cuboid(0.0F, -16.0F, -1.0F, 8.0F, 33.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 77).cuboid(7.0F, -16.0F, -1.3F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F))
				.uv(10, 11).cuboid(5.0F, -4.0F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(1.0F, -4.0F, -1.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -19.0F, -10.0F));

		ModelPartData cube_r42 = right_door.addChild("cube_r42", ModelPartBuilder.create().uv(6, 77).cuboid(0.0F, -16.5F, 0.0F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.5F, 0.3F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData phone = right_door.addChild("phone", ModelPartBuilder.create().uv(0, 12).cuboid(-0.5F, 0.3F, -0.8F, 2.0F, 2.0F, 1.0F, new Dilation(-0.1F))
				.uv(0, 8).cuboid(0.5F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(6, 8).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F)), ModelTransform.pivot(2.5F, -4.0F, 0.5F));

		ModelPartData left_door = Doors.addChild("left_door", ModelPartBuilder.create().uv(118, 46).cuboid(-8.0F, -16.0F, -1.0F, 8.0F, 33.0F, 1.0F, new Dilation(0.0F))
				.uv(1, 77).cuboid(-8.0F, -16.0F, -1.3F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F))
				.uv(10, 8).cuboid(-4.0F, -3.7F, -0.3F, 2.0F, 2.0F, 1.0F, new Dilation(-0.1F))
				.uv(8, 0).cuboid(-5.0F, -5.0F, 0.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(6, 11).cuboid(-3.0F, -5.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(-0.1F))
				.uv(0, 4).cuboid(-6.9F, -4.0F, -1.6F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, -19.0F, -10.0F));

		ModelPartData cube_r43 = left_door.addChild("cube_r43", ModelPartBuilder.create().uv(4, 77).cuboid(-1.0F, -16.5F, 0.0F, 1.0F, 33.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.5F, 0.3F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r44 = left_door.addChild("cube_r44", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-6.4F, -3.0F, -0.1F, 0.0F, 3.1416F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
					   float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}

	@Override
	public void renderWithAnimations(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices,
									 VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
		matrices.push();
		matrices.scale(1F, 1F, 1F);
		matrices.translate(0, -1.5f, 0);

		this.renderDoors(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha, false);

		super.renderWithAnimations(tardis, exterior, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
		matrices.pop();
	}

	@Override
	public <T extends Entity & Linkable> void renderEntity(T falling, ModelPart root, MatrixStack matrices,
														   VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		if (!falling.isLinked())
			return;

		matrices.push();
		matrices.scale(0.63F, 0.63F, 0.63F);
		matrices.translate(0, -1.5f, 0);

		DoorHandler door = falling.tardis().get().door();

		if (!AITMod.CONFIG.CLIENT.ANIMATE_DOORS) {
			this.root.getChild("Doors").getChild("left_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5F : 0.0F;
			this.root.getChild("Doors").getChild("right_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5F
					: 0.0F;
		} else {
			float maxRot = 90f;
			this.root.getChild("Doors").getChild("left_door").yaw =(float) Math.toRadians(maxRot*door.getLeftRot());
			this.root.getChild("Doors").getChild("right_door").yaw =(float) -Math.toRadians(maxRot*door.getRightRot());
		}

		super.renderEntity(falling, root, matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}

	@Override
	public Animation getAnimationForDoorState(DoorHandler.AnimationDoorState state) {
		return Animation.Builder.create(0).build();
	}

	@Override
	public void renderDoors(ClientTardis tardis, ExteriorBlockEntity exterior, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha, boolean isBOTI) {
		DoorHandler door = tardis.door();

		if (!AITMod.CONFIG.CLIENT.ANIMATE_DOORS) {
			this.root.getChild("Doors").getChild("left_door").yaw = (door.isLeftOpen() || door.isOpen()) ? -5F : 0.0F;
			this.root.getChild("Doors").getChild("right_door").yaw = (door.isRightOpen() || door.areBothOpen())
					? 5F
					: 0.0F;
		} else {
			float maxRot = 90f;
			this.root.getChild("Doors").getChild("left_door").yaw =(float) Math.toRadians(maxRot*door.getLeftRot());
			this.root.getChild("Doors").getChild("right_door").yaw =(float) -Math.toRadians(maxRot*door.getRightRot());
		}

		if (isBOTI) {
			matrices.push();
			matrices.scale(1F, 1F, 1F);
			matrices.translate(0, 0f, 0f);
			this.root.getChild("Doors").render(matrices, vertices, light, overlay, red, green, blue, pAlpha);
			matrices.pop();
		}
	}
}
