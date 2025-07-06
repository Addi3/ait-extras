package com.aitextras.client.renderers.decor.hudolinsupport;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.hudolinsupport.HudolinSupportTopModel;
import com.aitextras.core.blockentities.hudolinsupport.HudolinSupportTopBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;

public class HudolinSupportTopRenderer<T extends HudolinSupportTopBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier SUPPORT_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/hudolin_support.png");
    private final HudolinSupportTopModel hudolinSupportTopModel;

    public HudolinSupportTopRenderer(BlockEntityRendererFactory.Context ctx) {
        this.hudolinSupportTopModel = new HudolinSupportTopModel(HudolinSupportTopModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.scale(1f, 1f, 1f);


        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.hudolinSupportTopModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(SUPPORT_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}