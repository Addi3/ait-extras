package com.aitextras.client;


import com.aitextras.AITExtras;
import com.aitextras.client.renderers.decor.*;
import com.aitextras.client.renderers.decor.hudolinsupport.HudolinSupportBaseRenderer;
import com.aitextras.client.renderers.decor.hudolinsupport.HudolinSupportTopRenderer;
import com.aitextras.client.renderers.monitors.ExtrasMonitorRenderer;
import com.aitextras.client.renderers.monitors.ExtrasScreenMonitorRenderer;
import com.aitextras.client.renderers.wearables.trinkets.CoatTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.FezHatTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.ScarfTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.ThreeDGlassesTrinketsRenderer;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.AITExtrasBlocks;
import com.aitextras.core.AITExtrasItems;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static com.aitextras.AITExtras.*;

public class AITExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        blockEntityRendererRegister();
        resourcepackRegister();
        trinketsRegister();
        BlockRenderLayerMapRegister();

        ColorProviderRegistry.ITEM.register(new FezColorProvider(), AITExtrasItems.FEZ_ITEM);

        ModelPredicateProviderRegistry.register(
                AITExtrasItems.KEYCHAIN,
                new Identifier("filled"),
                (stack, world, entity, seed) -> {
                    int count = 0;
                    if (stack.hasNbt() && stack.getNbt().contains("Items")) {
                        count = stack.getNbt().getList("Items", 10).size();
                    }
                    return count / 3f;
                }
        );
    }


    private static final String TEXTURE_PATH = "textures/blockentities/decor/hatstand/";

    public static void blockEntityRendererRegister() {
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_MONITOR_BLOCK_ENTITY_TYPE, ExtrasMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_SCREEN_MONITOR_BLOCK_ENTITY_TYPE, ExtrasScreenMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.SUN_DIAL_BLOCK_ENTITY_TYPE, SunDialRenderer::new);

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_OAK_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "oak.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_ACACIA_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "acacia.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_BAMBOO_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "bamboo.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_BIRCH_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "birch.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_CHERRY_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "cherry.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_CRIMSON_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "crimson.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_DARK_OAK_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "dark_oak.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_JUNGLE_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "jungle.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_MANGROVE_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "mangrove.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_SPRUCE_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "spruce.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HAT_STAND_WARPED_BLOCK_ENTITY_TYPE, (ctx) ->
                new HatStandRenderer<>(ctx, AITExtras.id(TEXTURE_PATH + "warped.png")));

        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_BASE_BLOCK_ENTITY_TYPE, HudolinSupportBaseRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.HUDOLIN_SUPPORT_TOP_BLOCK_ENTITY_TYPE, HudolinSupportTopRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.TUBE_LIGHT_BLOCK_ENTITY_TYPE, TubeLightRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.MONITOR_COVER_BLOCK_ENTITY_TYPE, MonitorCoverRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CLASSIC_MONITOR_COVER_BLOCK_ENTITY_TYPE, MonitorCoverRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.ROUNDEL_DOOR_BLOCK_ENTITY_TYPE, RoundelDoorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.CLASSIC_ROUNDEL_DOOR_BLOCK_ENTITY_TYPE, ClassicRoundelDoorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.STONE_ROUNDEL_DOOR_BLOCK_ENTITY_TYPE, StoneRoundelDoorRenderer::new);

    }


    public static void trinketsRegister() {
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF_RED, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF_RAINBOW, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.FEZ_ITEM, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.TENNANT_COAT, new CoatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.THREED_GLASSES, new ThreeDGlassesTrinketsRenderer());
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
                    ResourceManagerHelper.registerBuiltinResourcePack(id("oldprotocolnames"), modContainer, ResourcePackActivationType.NORMAL);
                });
    }

    public static void BlockRenderLayerMapRegister() {
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.SEAL_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.SEAL_SMALL_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.ARS_EGG, RenderLayer.getCutout());
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
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.PILLAR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.PILLAR_BOTTOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AITExtrasBlocks.PILLAR_TOP, RenderLayer.getCutout());
    }

    public static class FezColorProvider implements ItemColorProvider {
        @Override
        public int getColor(ItemStack stack, int tintIndex) {
            return tintIndex > 0 ? -1 : ((DyeableItem) stack.getItem()).getColor(stack);
        }
    }
}