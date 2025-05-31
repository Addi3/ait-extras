package com.aitextras.client.renderers.decor;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.CrystalModel;
import com.aitextras.client.models.decor.SunDialModel;
import com.aitextras.core.blockentities.CrystalBlockEntity;
import com.aitextras.core.blockentities.SunDialBlockEntity;
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

public class CrystalRenderer<T extends CrystalBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier CRYSTAL_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/crystal/crystalline.png");
    public static final Identifier EMISSIVE_CRYSTAL_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/crystal/crystalline_emission.png");
    private final CrystalModel crystalModel;

    public CrystalRenderer(BlockEntityRendererFactory.Context ctx) {
        this.crystalModel = new CrystalModel(CrystalModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {


        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.crystalModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(CRYSTAL_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);
        this.crystalModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EMISSIVE_CRYSTAL_TEXTURE)),
                0xF000F00, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}