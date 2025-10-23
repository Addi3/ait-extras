package com.aitextras.core;

import com.aitextras.AITExtras;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class AITExtrasSounds {

    // Music
    public static final SoundEvent MERCURY_DISC = register("music/mercury_disc");


    // Misc
    public static final SoundEvent FAST_MAT = register("tardis/travel/fast_mat");
    public static final SoundEvent FAST_DEMAT = register("tardis/travel/fast_demat");
    public static final SoundEvent CLASSIC_ALT_DEMAT = register("tardis/travel/type70_demat");
    public static final SoundEvent CLASSIC_ALT_MAT = register("tardis/travel/type70_mat");
    public static final SoundEvent MINECART_DEMAT = register("tardis/travel/minecart_demat");
    public static final SoundEvent MINECART_FLIGHT = register("tardis/travel/minecart_flight");
    public static final SoundEvent MINECART_MAT = register("tardis/travel/minecart_mat");
    public static final SoundEvent CLASSIC_DEMAT = register("tardis/travel/classic_demat");
    public static final SoundEvent CLASSIC_MAT = register("tardis/travel/classic_mat");
    public static final SoundEvent DRUMLESS_DEMAT = register("tardis/travel/drumless_demat");
    public static final SoundEvent REGEN_DEMAT = register("tardis/travel/regen_demat");
    public static final SoundEvent XMAS_DEMAT = register("tardis/travel/xmas_demat");
    public static final SoundEvent CLASSIC_BOX_DOOR_OPEN = register("tardis/classic_box_door_open");
    public static final SoundEvent CLASSIC_BOX_DOOR_CLOSE = register("tardis/classic_box_door_close");
    public static final SoundEvent SHIELD_HUM = register("tardis/shield_hum");
    public static final SoundEvent WHISTLE = register("tools/whistle");
    public static final SoundEvent RETEP = register("music/retep");

    // Register a SoundEvent
    private static SoundEvent register(String name) {
        Identifier id = AITExtras.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    // Initialize all sounds
    public static void init() {
        // This ensures the static fields are loaded and registered
    }
}