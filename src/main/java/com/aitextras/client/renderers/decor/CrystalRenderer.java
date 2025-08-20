package com.aitextras.client.renderers.decor;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.CrystalModel;
import com.aitextras.client.models.decor.SunDialModel;
import com.aitextras.core.blockentities.CrystalBlockEntity;
import com.aitextras.core.blockentities.SunDialBlockEntity;
import dev.amble.ait.core.tardis.Tardis;
import dev.amble.ait.core.tardis.handler.travel.TravelHandler;
import dev.amble.ait.core.world.TardisServerWorld;
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
            "textures/blockentities/decor/crystal/crystalline.png");
    public static final Identifier EMISSIVE_CRYSTAL_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/crystal/crystalline_emission.png");
    private final CrystalModel crystalModel;

    public CrystalRenderer(BlockEntityRendererFactory.Context ctx) {
        this.crystalModel = new CrystalModel(CrystalModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(CrystalBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (!entity.isLinked() && TardisServerWorld.isTardisDimension(entity.getWorld())) return;
        CrystalModel model = new CrystalModel(CrystalModel.getTexturedModelData().createModel());
        Tardis tardis = entity.tardis().get();
        TravelHandler travel = tardis.travel();
        boolean hasPower = tardis.fuel().hasPower();
        model.animateBlockEntity(entity, travel.getState(), hasPower);
        matrices.push();
        matrices.scale(1f, 1f, 1f);
        matrices.translate(0.5f, 1.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));

        model.renderWithAnimations(entity, model.getPart(), matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(CRYSTAL_TEXTURE)),
                light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        model.renderWithAnimations(entity, model.getPart(), matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCullZOffset(EMISSIVE_CRYSTAL_TEXTURE)),
                0xf000f0, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();

    }
}