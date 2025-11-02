package com.aitextras.client;

import com.aitextras.client.entities.RoundelEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AITExtrasEntities {
    public static final EntityType<RoundelEntity> ROUNDEL = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("ait-extras", "roundel"),
            FabricEntityTypeBuilder.<RoundelEntity>create(SpawnGroup.MISC, RoundelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(10)
                    .build()
    );

    public static void init() {}
}
