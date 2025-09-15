package com.aitextras.client;


import com.aitextras.client.renderers.decor.*;
import com.aitextras.client.renderers.decor.hudolinsupport.HudolinSupportBaseRenderer;
import com.aitextras.client.renderers.decor.hudolinsupport.HudolinSupportPillarsRenderer;
import com.aitextras.client.renderers.decor.hudolinsupport.HudolinSupportTopRenderer;
import com.aitextras.client.renderers.decor.hudolinsupport.HumanSupportPillarsRenderer;
import com.aitextras.client.renderers.monitors.ExtrasMonitorRenderer;
import com.aitextras.client.renderers.monitors.ExtrasScreenMonitorRenderer;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.AITExtrasBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import static com.aitextras.AITExtras.*;

public class AITExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        blockEntityRendererRegister();
        resourcepackRegister();
        BlockRenderLayerMapRegister();
    }


    public static void blockEntityRendererRegister() {
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_MONITOR_BLOCK_ENTITY_TYPE, ExtrasMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_SCREEN_MONITOR_BLOCK_ENTITY_TYPE, ExtrasScreenMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.SUN_DIAL_BLOCK_ENTITY_TYPE, SunDialRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_OAK_BLOCK_ENTITY_TYPE, HatStandOakRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_ACACIA_BLOCK_ENTITY_TYPE, HatStandAcaciaRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_BAMBOO_BLOCK_ENTITY_TYPE, HatStandBambooRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_BIRCH_BLOCK_ENTITY_TYPE, HatStandBirchRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_CHERRY_BLOCK_ENTITY_TYPE, HatStandCherryRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_CRIMSON_BLOCK_ENTITY_TYPE, HatStandCrimsonRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_DARK_OAK_BLOCK_ENTITY_TYPE, HatStandDarkOakRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_JUNGLE_BLOCK_ENTITY_TYPE, HatStandJungleRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_MANGROVE_BLOCK_ENTITY_TYPE, HatStandMangroveRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_SPRUCE_BLOCK_ENTITY_TYPE, HatStandSpruceRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_WARPED_BLOCK_ENTITY_TYPE, HatStandWarpedRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CRYSTAL_BLOCK_ENTITY_TYPE, CrystalRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CRYSTAL_ZEITON_BLOCK_ENTITY_TYPE, CrystalZeitonRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CRYSTAL_MASTER_BLOCK_ENTITY_TYPE, CrystalMasterRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_BASE_BLOCK_ENTITY_TYPE, HudolinSupportBaseRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_TOP_BLOCK_ENTITY_TYPE, HudolinSupportTopRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_PILLARS_BLOCK_ENTITY_TYPE, HudolinSupportPillarsRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUMAN_SUPPORT_PILLARS_BLOCK_ENTITY_TYPE, HumanSupportPillarsRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CANDLE_STAND_LARGE_BLOCK_ENTITY_TYPE, CandleStandLargeRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CANDLE_STAND_SMALL_BLOCK_ENTITY_TYPE, CandleStandSmallRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CANDLE_STAND_SINGLE_BLOCK_ENTITY_TYPE, CandleStandSingleRenderer::new);


    }

    public static void resourcepackRegister() {

        // Register builtin resourcepacks
        FabricLoader.getInstance().

                getModContainer("ait-extras").

                ifPresent(modContainer ->

                {
                    ResourceManagerHelper.registerBuiltinResourcePack(id("logo"), modContainer, ResourcePackActivationType.DEFAULT_ENABLED);
                    ResourceManagerHelper.registerBuiltinResourcePack(id("darkgui"), modContainer, ResourcePackActivationType.NORMAL);
                    ResourceManagerHelper.registerBuiltinResourcePack(id("lowresitems"), modContainer, ResourcePackActivationType.NORMAL);
                    ResourceManagerHelper.registerBuiltinResourcePack(id("controllabels"), modContainer, ResourcePackActivationType.NORMAL);
                });
    }

    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_GRATE_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_GRATE_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_GRATE_WALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_GRATE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_MESH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_MESH_SLAB, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_MESH_STAIRS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_MESH_WALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.METAL_MESH_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.SEAL_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.SEAL_SMALL_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.ARS_EGG_BLOCK, RenderLayer.getCutout());
    }
}