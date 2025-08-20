package com.aitextras.client.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class RoofCrystalAnimation{


    public static final Animation FLIGHT =  Animation.Builder.create(4.5F).looping()
        .addBoneAnimation("rotor_jodie", new Transformation(Transformation.Targets.TRANSLATE,
                new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -12.0F, 0.0F), Transformation.Interpolations.LINEAR),
                new Keyframe(4.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
        ))
        .build();
}
