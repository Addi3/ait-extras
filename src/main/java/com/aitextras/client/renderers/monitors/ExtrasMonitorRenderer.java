package com.aitextras.client.renderers.monitors;

import com.aitextras.AITExtras;
import com.aitextras.client.models.monitors.VictorianMonitorModel;
import com.aitextras.core.blockentities.ExtrasMonitorBlockEntity;
import dev.amble.lib.data.CachedDirectedGlobalPos;

import net.minecraft.block.BlockState;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.RotationPropertyHelper;

import dev.amble.ait.AITMod;
import dev.amble.ait.core.tardis.Tardis;
import dev.amble.ait.core.tardis.handler.travel.TravelHandler;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import dev.amble.ait.core.util.WorldUtil;

public class ExtrasMonitorRenderer<T extends ExtrasMonitorBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier MONITOR_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/monitors/victorian_monitor.png");
    public static final Identifier EMISSIVE_MONITOR_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/monitors/victorian_monitor_emission.png");
    private final TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
    private final VictorianMonitorModel victorianMonitorModel;

    public ExtrasMonitorRenderer(BlockEntityRendererFactory.Context ctx) {
        this.victorianMonitorModel = new VictorianMonitorModel(VictorianMonitorModel.getTexturedModelData().createModel());
    }

    private String truncateDimensionName(String name, int maxLength) {
        if (name.length() > maxLength) {
            return name.substring(0, maxLength) + "...";
        }
        return name;
    }

    @Override
    public void render(ExtrasMonitorBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState blockState = entity.getCachedState();

        int k = blockState.get(SkullBlock.ROTATION);
        float h = RotationPropertyHelper.toDegrees(k);

        matrices.push();
        matrices.translate(0.5f, 1.5f, 0.5f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(h));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
        matrices.translate(0, 0, 0.09375); // this moves it forward by 1.5 pixels - Loqor

        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.victorianMonitorModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(MONITOR_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);
        this.victorianMonitorModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EMISSIVE_MONITOR_TEXTURE)),
                0xF000F00, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();

        if (!entity.isLinked())
            return;

        Tardis tardis = entity.tardis().get();

        if (!tardis.fuel().hasPower())
            return;

        matrices.push();
        matrices.translate(0.5, 0.75, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180f));
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(180 - h)); // Apply block rotation here
        matrices.scale(0.004f * scale, 0.004f * scale, 0.004f * scale);
        matrices.translate(-55f, 0, -55);

// Render text
        TravelHandler travel = tardis.travel();
        CachedDirectedGlobalPos abpp = travel.isLanded() || travel.getState() == TravelHandlerBase.State.MAT
                ? travel.position()
                : travel.getProgress();

        BlockPos abppPos = abpp.getPos();

        CachedDirectedGlobalPos abpd = tardis.travel().destination();
        BlockPos abpdPos = abpd.getPos();

        String destinationPosText = " " + abpdPos.getX() + ", " + abpdPos.getY() + ", " + abpdPos.getZ();
        Text destinationDimensionText = Text.of(truncateDimensionName(WorldUtil.worldText(abpd.getDimension()).getString(), 20));

        this.textRenderer.drawWithOutline(Text.of("✛").asOrderedText(), 22, -2, 0x00F0FF, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);
        this.textRenderer.drawWithOutline(Text.of(destinationPosText).asOrderedText(), 21, 5, 0xFFFFFF, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);
        this.textRenderer.drawWithOutline(destinationDimensionText.asOrderedText(), 22, 15, 0xFFFFFF, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);
        this.textRenderer.drawWithOutline(WorldUtil.rot2Text(abpd.getRotation()).asOrderedText(), 22, 24, 0xFFFFFF, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);

        String flightTimeText = tardis.travel().getState() == TravelHandlerBase.State.LANDED
                ? "0%"
                : tardis.travel().getDurationAsPercentage() + "%";
        this.textRenderer.drawWithOutline(Text.of("⏳").asOrderedText(), 60, 35, 0x00FF0F, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);
        this.textRenderer.drawWithOutline(Text.of(flightTimeText).asOrderedText(), 70, 35, 0xFFFFFF, 0x000000,
                matrices.peek().getPositionMatrix(), vertexConsumers, 0xF000F0);

        matrices.pop();
    }
}