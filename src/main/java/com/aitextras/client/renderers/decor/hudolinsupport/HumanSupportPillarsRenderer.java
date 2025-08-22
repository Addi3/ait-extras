package com.aitextras.client.renderers.decor.hudolinsupport;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.hudolinsupport.HudolinSupportPillarsModel;
import com.aitextras.core.blockentities.hudolinsupport.HudolinSupportPillarsBlockEntity;
import com.aitextras.core.blockentities.hudolinsupport.HumanSupportPillarsBlockEntity;
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

public class HumanSupportPillarsRenderer<T extends HumanSupportPillarsBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier SUPPORT_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/human_support.png");
    public static final Identifier EMISSIVE_SUPPORT_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/human_support_emission.png");
    private final HudolinSupportPillarsModel hudolinSupportPillarsModel;

    public HumanSupportPillarsRenderer(BlockEntityRendererFactory.Context ctx) {
        this.hudolinSupportPillarsModel = new HudolinSupportPillarsModel(HudolinSupportPillarsModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.8f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.scale(1f, 1f, 1f);


        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.hudolinSupportPillarsModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(SUPPORT_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);
        this.hudolinSupportPillarsModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EMISSIVE_SUPPORT_TEXTURE)),
                0xFFFFFF00, overlay, 1.0F, 1.0F, 1.0F, 1.0F);


        matrices.pop();
    }
}