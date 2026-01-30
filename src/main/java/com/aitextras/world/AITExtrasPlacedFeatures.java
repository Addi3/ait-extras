package com.aitextras.world;

import com.aitextras.AITExtras;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class AITExtrasPlacedFeatures {
    public static final RegistryKey<PlacedFeature> CRYSTALLINE_ORE_PLACED_KEY = registerKey("crystalline_ore_placed");
    public static final RegistryKey<PlacedFeature> ZIRCONIUM_ORE_PLACED_KEY = registerKey("zirconium_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(
                context,
                CRYSTALLINE_ORE_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(AITExtrasConfiguredFeature.CRYSTALLINE_ORE_KEY),
                AITExtrasOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(0)))
        );

        register(
                context,
                ZIRCONIUM_ORE_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(AITExtrasConfiguredFeature.ZIRCONIUM_ORE_KEY),
                AITExtrasOrePlacement.modifiersWithCount(1,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(0)))
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, AITExtras.id(name));
    }

    private static void register(
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void registerPlacedFeatures() {
    }
}