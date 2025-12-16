package com.aitextras;

import com.aitextras.core.*;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;


public class AITExtras implements ModInitializer {

    public static final String MOD_ID = "ait-extras";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        RegistryContainer.register(AITExtrasItems.class, MOD_ID);
        RegistryContainer.register(AITExtrasItemGroups.class, MOD_ID);
    }
}