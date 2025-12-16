package com.aitextras.client;


import com.aitextras.client.renderers.wearables.trinkets.CoatTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.FezHatTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.ScarfTrinketsRenderer;
import com.aitextras.client.renderers.wearables.trinkets.ThreeDGlassesTrinketsRenderer;
import com.aitextras.core.AITExtrasItems;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

import static com.aitextras.AITExtras.*;

public class AITExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        trinketsRegister();
    }




    public static void trinketsRegister() {
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF_RED, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.SCARF_RAINBOW, new ScarfTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.WHITE_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.BLACK_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.BROWN_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.CYAN_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.GRAY_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.GREEN_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.LIGHT_BLUE_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.LIGHT_GRAY_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.LIME_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.MAGENTA_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.ORANGE_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.PINK_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.PURPLE_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.RED_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.YELLOW_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.BLUE_FEZ_HAT, new FezHatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.TENNANT_COAT, new CoatTrinketsRenderer());
        TrinketRendererRegistry.registerRenderer(AITExtrasItems.THREED_GLASSES, new ThreeDGlassesTrinketsRenderer());
    }



}