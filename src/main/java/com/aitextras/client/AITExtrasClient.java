package com.aitextras.client;

import com.aitextras.client.models.doors.*;
import com.aitextras.client.models.exteriors.*;
import com.aitextras.client.renderers.decor.SunDialRenderer;
import com.aitextras.client.renderers.monitors.ExtrasMonitorRenderer;
import com.aitextras.client.renderers.monitors.ExtrasScreenMonitorRenderer;
import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.joml.Vector3f;

import static com.aitextras.AITExtras.*;

public class AITExtrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerClientAddonExteriors();
        blockEntityRendererRegister();
    }

    private void registerClientAddonExteriors() {
        ECTO.setModel(new EctoExteriorModel()).toClient().register();
        ECTO.setPortalWidth(1.15f);
        ECTO.setPortalHeight(2.28f);
        ECTO.toDoor().setModel(new EctoDoorModel(EctoDoorModel.getTexturedModelData().createModel())).toClient().register();


        POSTBOX.setModel(new PostBoxExteriorModel()).toClient().register();
        POSTBOX.setSonicItemTranslations(new Vector3f(0.15f, 1.122f, 0.94f));
        POSTBOX.setPortalWidth(0.9f);
        POSTBOX.setPortalHeight(2f);
        POSTBOX.toDoor().setModel(new PostBoxDoorModel(PostBoxDoorModel.getTexturedModelData().createModel())).toClient().register();

        VANILLA.setModel(new VanillaExteriorModel<>()).toClient().register();
        VANILLA.setSonicItemTranslations(new Vector3f(0.7f, 1f, 3f));
        VANILLA.setPortalWidth(1f);
        VANILLA.setPortalHeight(2.5f);
        VANILLA.toDoor().setModel(new VanillaDoorModel(VanillaDoorModel.getTexturedModelData().createModel())).toClient().register();
        VANILLA.toClient().hasTransparentDoors();

        CLOCK.setModel(new ClockExteriorModel<>()).toClient().register();
        CLOCK.setSonicItemTranslations(new Vector3f(0.7f, 1f, 2f));
        CLOCK.setPortalWidth(1f);
        CLOCK.setPortalHeight(2f);
        CLOCK.toDoor().setModel(new ClockDoorModel(ClockDoorModel.getTexturedModelData().createModel())).toClient().register();

        PIXELCONSISTENT.setModel(new PixelConsistentClassicModel()).toClient().register();
        PIXELCONSISTENT.setSonicItemTranslations(new Vector3f(0.7f, 1f, 2f));
        PIXELCONSISTENT.setPortalWidth(1.2f);
        PIXELCONSISTENT.setPortalHeight(2.2f);
        PIXELCONSISTENT.toDoor().setModel(new PixelConsistentClassicDoorModel(PixelConsistentClassicDoorModel.getTexturedModelData().createModel())).toClient().register();

        PIXELCONSISTENTMODERN.setModel(new PixelConsistentModernModel()).toClient().register();
        PIXELCONSISTENTMODERN.setSonicItemTranslations(new Vector3f(0.7f, 1f, 2f));
        PIXELCONSISTENTMODERN.setPortalWidth(1.2f);
        PIXELCONSISTENTMODERN.setPortalHeight(2.2f);
        PIXELCONSISTENTMODERN.toDoor().setModel(new PixelConsistentModernDoorModel(PixelConsistentModernDoorModel.getTexturedModelData().createModel())).toClient().register();

        PIXELCONSISTENTCRYSTALLINE.setModel(new PixelConsistentCrystallineModel()).toClient().register();
        PIXELCONSISTENTCRYSTALLINE.setSonicItemTranslations(new Vector3f(0.7f, 1f, 2f));
        PIXELCONSISTENTCRYSTALLINE.setPortalWidth(1.2f);
        PIXELCONSISTENTCRYSTALLINE.setPortalHeight(2.2f);
        PIXELCONSISTENTCRYSTALLINE.toDoor().setModel(new PixelConsistentCrystallineDoorModel(PixelConsistentCrystallineDoorModel.getTexturedModelData().createModel())).toClient().register();
    };
    public static void blockEntityRendererRegister() {
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_MONITOR_BLOCK_ENTITY_TYPE, ExtrasMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.EXTRAS_SCREEN_MONITOR_BLOCK_ENTITY_TYPE, ExtrasScreenMonitorRenderer::new);
        BlockEntityRendererFactories.register(AITExtrasBlockEntityTypes.SUN_DIAL_BLOCK_ENTITY_TYPE, SunDialRenderer::new);
    }
}
