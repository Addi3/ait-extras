package com.aitextras.client.models.decor;

import java.util.function.Function;

import com.aitextras.core.blockentities.CrystalBlockEntity;
import dev.amble.ait.client.AITModClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import dev.amble.ait.AITMod;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;

public abstract class MovingCrystalModel extends SinglePartEntityModel {
    public MovingCrystalModel() {
        this(RenderLayer::getEntityCutoutNoCull);
    }

    public MovingCrystalModel(Function< Identifier, RenderLayer> function) {
        super(function);
    }

    public void animateBlockEntity(CrystalBlockEntity rotor, TravelHandlerBase.State state, boolean hasPower) {
        // fyi, this is directly referencing camel animation code, its just specific
        // according to
        // the
        // block entity that
        // is being used
        // to detect different states. - Loqor
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        if (hasPower && AITModClient.CONFIG.animateConsole) {
            this.updateAnimation(rotor.ANIM_STATE, this.getAnimationForState(state), rotor.getAge(), 1.0f);
        }
    }

    public void renderWithAnimations(CrystalBlockEntity console, ModelPart root, MatrixStack matrices,
                                     VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
        root.render(matrices, vertices, light, overlay, red, green, blue, pAlpha);
    }

    @Override
    public void setAngles(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
    float headPitch) {
    }

    public abstract Animation getAnimationForState(TravelHandlerBase.State state);
}

