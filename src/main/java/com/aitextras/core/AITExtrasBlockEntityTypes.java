package com.aitextras.core;


import com.aitextras.core.blockentities.*;
import com.aitextras.core.blockentities.HudolinSupportBaseBlockEntity;
import com.aitextras.core.blockentities.HudolinSupportTopBlockEntity;
import dev.amble.lib.animation.HasBedrockModel;
import dev.amble.lib.container.impl.BlockEntityContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;


public class AITExtrasBlockEntityTypes implements BlockEntityContainer{

    public static BlockEntityType<ExtrasMonitorBlockEntity> EXTRAS_MONITOR_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(ExtrasMonitorBlockEntity::new, AITExtrasBlocks.EXTRAS_MONITOR_BLOCK).build();

    public static BlockEntityType<ExtrasScreenMonitorBlockEntity> EXTRAS_SCREEN_MONITOR_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(ExtrasScreenMonitorBlockEntity::new, AITExtrasBlocks.EXTRAS_SCREEN_MONITOR_BLOCK).build();

    public static BlockEntityType<SunDialBlockEntity> SUN_DIAL_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(SunDialBlockEntity::new, AITExtrasBlocks.SUN_DIAL_BLOCK).build();

    public static BlockEntityType<HatStandOakBlockEntity> HAT_STAND_OAK_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandOakBlockEntity::new, AITExtrasBlocks.HAT_STAND_OAK_BLOCK).build();

    public static BlockEntityType<HatStandAcaciaBlockEntity> HAT_STAND_ACACIA_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandAcaciaBlockEntity::new, AITExtrasBlocks.HAT_STAND_ACACIA_BLOCK).build();

    public static BlockEntityType<HatStandBambooBlockEntity> HAT_STAND_BAMBOO_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandBambooBlockEntity::new, AITExtrasBlocks.HAT_STAND_BAMBOO_BLOCK).build();

    public static BlockEntityType<HatStandBirchBlockEntity> HAT_STAND_BIRCH_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandBirchBlockEntity::new, AITExtrasBlocks.HAT_STAND_BIRCH_BLOCK).build();

    public static BlockEntityType<HatStandCherryBlockEntity> HAT_STAND_CHERRY_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandCherryBlockEntity::new, AITExtrasBlocks.HAT_STAND_CHERRY_BLOCK).build();

    public static BlockEntityType<HatStandCrimsonBlockEntity> HAT_STAND_CRIMSON_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandCrimsonBlockEntity::new, AITExtrasBlocks.HAT_STAND_CRIMSON_BLOCK).build();

    public static BlockEntityType<HatStandDarkOakBlockEntity> HAT_STAND_DARK_OAK_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandDarkOakBlockEntity::new, AITExtrasBlocks.HAT_STAND_DARK_OAK_BLOCK).build();

    public static BlockEntityType<HatStandJungleBlockEntity> HAT_STAND_JUNGLE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandJungleBlockEntity::new, AITExtrasBlocks.HAT_STAND_JUNGLE_BLOCK).build();

    public static BlockEntityType<HatStandMangroveBlockEntity> HAT_STAND_MANGROVE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandMangroveBlockEntity::new, AITExtrasBlocks.HAT_STAND_MANGROVE_BLOCK).build();

    public static BlockEntityType<HatStandSpruceBlockEntity> HAT_STAND_SPRUCE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandSpruceBlockEntity::new, AITExtrasBlocks.HAT_STAND_SPRUCE_BLOCK).build();

    public static BlockEntityType<HatStandWarpedBlockEntity> HAT_STAND_WARPED_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HatStandWarpedBlockEntity::new, AITExtrasBlocks.HAT_STAND_WARPED_BLOCK).build();

    public static BlockEntityType<HudolinSupportBaseBlockEntity> HUDOLIN_SUPPORT_BASE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HudolinSupportBaseBlockEntity::new, AITExtrasBlocks.HUDOLIN_SUPPORT_BASE_BLOCK).build();

    public static BlockEntityType<HudolinSupportTopBlockEntity> HUDOLIN_SUPPORT_TOP_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(HudolinSupportTopBlockEntity::new, AITExtrasBlocks.HUDOLIN_SUPPORT_TOP_BLOCK).build();

    public static BlockEntityType<CandleStandSingleBlockEntity> CANDLE_STAND_SINGLE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(CandleStandSingleBlockEntity::new, AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK).build();

    public static BlockEntityType<CandleStandSmallBlockEntity> CANDLE_STAND_SMALL_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(CandleStandSmallBlockEntity::new, AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK).build();

    public static BlockEntityType<CandleStandLargeBlockEntity> CANDLE_STAND_LARGE_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(CandleStandLargeBlockEntity::new, AITExtrasBlocks.CANDLE_STAND_LARGE_BLOCK).build();

    public static BlockEntityType<TubeLightBlockEntity> TUBE_LIGHT_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(TubeLightBlockEntity::new, AITExtrasBlocks.TUBE_LIGHT_BLOCK).build();

    public static BlockEntityType<MonitorCoverBlockEntity> MONITOR_COVER_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(MonitorCoverBlockEntity::new, AITExtrasBlocks.MONITOR_COVER_BLOCK).build();

    public static BlockEntityType<ClassicMonitorCoverBlockEntity> CLASSIC_MONITOR_COVER_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(ClassicMonitorCoverBlockEntity::new, AITExtrasBlocks.CLASSIC_MONITOR_COVER_BLOCK).build();

    public static BlockEntityType<RoundelDoorBlockEntity> ROUNDEL_DOOR_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(RoundelDoorBlockEntity::new, AITExtrasBlocks.ROUNDEL_DOOR_BLOCK).build();

    public static BlockEntityType<ClassicRoundelDoorBlockEntity> CLASSIC_ROUNDEL_DOOR_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(ClassicRoundelDoorBlockEntity::new, AITExtrasBlocks.CLASSIC_ROUNDEL_DOOR_BLOCK).build();

    public static BlockEntityType<StoneRoundelDoorBlockEntity> STONE_ROUNDEL_DOOR_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
            .create(StoneRoundelDoorBlockEntity::new, AITExtrasBlocks.STONE_ROUNDEL_DOOR_BLOCK).build();


    @HasBedrockModel
    public static BlockEntityType<CrystalBlockEntity> CRYSTAL_BLOCK = FabricBlockEntityTypeBuilder.create(CrystalBlockEntity::new, AITExtrasBlocks.CRYSTAL_BLOCK).build();

    @HasBedrockModel
    public static BlockEntityType<CrystalMasterBlockEntity> CRYSTAL_MASTER_BLOCK = FabricBlockEntityTypeBuilder.create(CrystalMasterBlockEntity::new, AITExtrasBlocks.CRYSTAL_MASTER_BLOCK).build();

    @HasBedrockModel
    public static BlockEntityType<CrystalZeitonBlockEntity> CRYSTAL_ZEITON_BLOCK = FabricBlockEntityTypeBuilder.create(CrystalZeitonBlockEntity::new, AITExtrasBlocks.CRYSTAL_ZEITON_BLOCK).build();


}
