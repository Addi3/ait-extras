package com.aitextras.world;

import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class AITExtrasConfiguredFeature {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTALLINE_ORE_KEY = registerKey("crystalline_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ZIRCONIUM_ORE_KEY = registerKey("zirconium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreFeatureConfig.Target> overworldCrystallineOre = List.of(
                OreFeatureConfig.createTarget(deepslateReplaceables, AITExtrasBlocks.CRYSTALLINE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> overworldZirconiumOre = List.of(
                OreFeatureConfig.createTarget(deepslateReplaceables, AITExtrasBlocks.ZIRCONIUM_ORE.getDefaultState())
        );


        register(context, CRYSTALLINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCrystallineOre, 5, 0.0f));
        register(context, ZIRCONIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldZirconiumOre, 5, 0.0f));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, AITExtras.id(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}