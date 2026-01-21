package com.aitextras.datagen;

import com.aitextras.core.AITExtrasBlocks;
import com.aitextras.core.AITExtrasItemGroups;
import com.aitextras.core.AITExtrasItems;
import com.aitextras.datagen.providers.*;
import com.aitextras.world.AITExtrasConfiguredFeature;
import com.aitextras.world.AITExtrasPlacedFeatures;
import dev.amble.ait.core.AITBlocks;
import dev.amble.ait.core.AITItems;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.loot.AmbleBlockLootTable;
import dev.amble.lib.datagen.sound.AmbleSoundProvider;
import dev.amble.lib.datagen.tag.AmbleBlockTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class AITExtrasDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        genLang(pack);
        generateRecipes(pack);
        genLoot(pack);
        genTags(pack);
        genModels(pack);
        generateSoundData(pack);
        generateItemTags(pack);
        generateachivement(pack);
        pack.addProvider(AITExtrasWorldGenerator::new);
    }


    private void genModels(FabricDataGenerator.Pack pack) {
        pack.addProvider(((output, registriesFuture) -> {
            AITExtrasModelGen provider = new AITExtrasModelGen(output);
            provider.withBlocks(AITExtrasBlocks.class);
            provider.withItems(AITExtrasItems.class);
            return provider;
        }));

    }

    @Override


    public void buildRegistry(RegistryBuilder registryBuilder) {


        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, AITExtrasConfiguredFeature::bootstrap);


        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, AITExtrasPlacedFeatures::bootstrap);


    }

    private void generateachivement(FabricDataGenerator.Pack pack) {
        pack.addProvider(AITExtrasAchievementProvider::new);
    }

    public void generateItemTags(FabricDataGenerator.Pack pack) {
        pack.addProvider(AITExtrasItemTagProvider::new);
    }

    public void generateSoundData(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleSoundProvider(output))));
    }

 private void genTags(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleBlockTagProvider(output, registriesFuture).withBlocks(AITExtrasBlocks.class))));
    }

    private void genLoot(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleBlockLootTable(output).withBlocks(AITExtrasBlocks.class))));
    }
    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            AITExtrasRecipeProvider provider = new AITExtrasRecipeProvider(output);


            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, 1)
                            .group("monitor")
                    .pattern("DDD")
                    .pattern("DED")
                    .pattern("DCD")
                    .input('D', Items.DARK_OAK_PLANKS)
                    .input('C', Items.CHAIN)
                    .input('E', Items.ENDER_EYE)
                    .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                    .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                    .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE)));

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.EXTRAS_SCREEN_MONITOR_BLOCK, 1)
                    .group("monitor")
                    .pattern("BBB")
                    .pattern("BEB")
                    .pattern("BBB")
                    .input('B', Items.BLACK_CONCRETE)
                    .input('E', Items.ENDER_EYE)
                    .criterion(hasItem(Items.BLACK_CONCRETE), conditionsFromItem(Items.BLACK_CONCRETE))
                    .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.SUN_DIAL_BLOCK, 1)
                    .pattern("NGN")
                    .pattern("GAG")
                    .pattern("NGN")
                    .input('G', Items.GOLD_INGOT)
                    .input('A', Items.SPECTRAL_ARROW)
                    .input('N', Items.GOLD_NUGGET)
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .criterion(hasItem(Items.SPECTRAL_ARROW), conditionsFromItem(Items.SPECTRAL_ARROW))
                    .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, AITExtrasItems.JELLY_BABIES, 1);
            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.FOOD, AITExtrasItems.JELLY_BABIES, 4)
                    .input(Items.PAPER)
                    .input(Items.SUGAR)
                    .input(Items.RED_DYE)
                    .input(Items.GREEN_DYE)
                    .input(Items.MAGENTA_DYE)
                    .input(Items.YELLOW_DYE)
                    .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                    .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR)));

            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.FOOD, AITExtrasItems.CUSTARD_CREAM, 4)
                    .input(Items.MILK_BUCKET)
                    .input(Items.SUGAR)
                    .input(Items.EGG)
                    .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                    .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                    .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG)));

            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.FOOD, AITExtrasItems.RICE_PUDDING, 1)
                    .input(Items.MILK_BUCKET)
                    .input(Items.SUGAR)
                    .input(Items.WHEAT)
                    .input(Items.BOWL)
                    .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                    .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                    .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                    .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_OAK_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.OAK_FENCE)
                    .criterion(hasItem(Items.OAK_FENCE), conditionsFromItem(Items.OAK_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_ACACIA_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.ACACIA_FENCE)
                    .criterion(hasItem(Items.ACACIA_FENCE), conditionsFromItem(Items.ACACIA_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_BAMBOO_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.BAMBOO_FENCE)
                    .criterion(hasItem(Items.BAMBOO_FENCE), conditionsFromItem(Items.BAMBOO_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_BIRCH_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.BIRCH_FENCE)
                    .criterion(hasItem(Items.BIRCH_FENCE), conditionsFromItem(Items.BIRCH_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_CHERRY_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.CHERRY_FENCE)
                    .criterion(hasItem(Items.CHERRY_FENCE), conditionsFromItem(Items.CHERRY_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_CRIMSON_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.CRIMSON_FENCE)
                    .criterion(hasItem(Items.CRIMSON_FENCE), conditionsFromItem(Items.CRIMSON_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_DARK_OAK_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.DARK_OAK_FENCE)
                    .criterion(hasItem(Items.DARK_OAK_FENCE), conditionsFromItem(Items.DARK_OAK_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_JUNGLE_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.JUNGLE_FENCE)
                    .criterion(hasItem(Items.JUNGLE_FENCE), conditionsFromItem(Items.JUNGLE_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_MANGROVE_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.MANGROVE_FENCE)
                    .criterion(hasItem(Items.MANGROVE_FENCE), conditionsFromItem(Items.MANGROVE_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_SPRUCE_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.SPRUCE_FENCE)
                    .criterion(hasItem(Items.SPRUCE_FENCE), conditionsFromItem(Items.SPRUCE_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HAT_STAND_WARPED_BLOCK, 1)
                    .group("hat_stand")
                    .pattern("FFF")
                    .pattern(" F ")
                    .pattern(" F ")
                    .input('F',Items.WARPED_FENCE)
                    .criterion(hasItem(Items.WARPED_FENCE), conditionsFromItem(Items.WARPED_FENCE)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CRYSTAL_ZEITON_BLOCK, 1)
                    .group("crystal")
                    .pattern(" Z ")
                    .pattern(" B ")
                    .pattern(" Z ")
                    .input('B',AITBlocks.ZEITON_BLOCK)
                    .input('Z',AITItems.ZEITON_SHARD)
                    .criterion(hasItem(AITBlocks.ZEITON_BLOCK), conditionsFromItem(AITBlocks.ZEITON_BLOCK)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CRYSTAL_MASTER_BLOCK, 1)
                    .group("crystal")
                    .pattern(" A ")
                    .pattern(" B ")
                    .pattern(" Z ")
                    .input('B',AITBlocks.ZEITON_BLOCK)
                    .input('Z',AITItems.ZEITON_SHARD)
                    .input('A',Items.AMETHYST_SHARD)
                    .criterion(hasItem(Blocks.AMETHYST_BLOCK), conditionsFromItem(Blocks.AMETHYST_BLOCK)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CRYSTAL_BLOCK, 1)
                    .group("crystal")
                    .pattern(" C ")
                    .pattern(" B ")
                    .pattern(" C ")
                    .input('B',AITExtrasBlocks.CRYSTALLINE_SHARD_BLOCK)
                    .input('C',AITExtrasItems.CRYSTALLINE_SHARD)
                    .criterion(hasItem(AITExtrasBlocks.CRYSTALLINE_SHARD_BLOCK), conditionsFromItem(AITExtrasBlocks.CRYSTALLINE_SHARD_BLOCK)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AITExtrasBlocks.CRYSTALLINE_SHARD_BLOCK, 1)
                    .pattern("CCC")
                    .pattern("CCC")
                    .pattern("CCC")
                    .input('C',AITExtrasItems.CRYSTALLINE_SHARD)
                    .criterion(hasItem(AITExtrasItems.CRYSTALLINE_SHARD), conditionsFromItem(AITExtrasItems.CRYSTALLINE_SHARD)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AITExtrasItems.WHISTLE, 1)
                    .pattern("AAA")
                    .pattern(" BA")
                    .pattern("   ")
                    .input('A',Items.IRON_INGOT)
                    .input('B',Items.ENDER_EYE)
                    .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.ENDER_EYE)));

            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.MISC, AITExtrasItems.ZIRCONIUM_INGOT, 4)
                    .group("zirconium")
                    .input(Items.IRON_INGOT)
                    .input(AITExtrasItems.RAW_ZIRCONIUM)
                    .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                    .criterion(hasItem(AITExtrasItems.RAW_ZIRCONIUM), conditionsFromItem(AITExtrasItems.RAW_ZIRCONIUM)));

            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.MISC, AITExtrasItems.MERCURY_DISC, 1)
                    .group("zirconium")
                    .input(ItemTags.MUSIC_DISCS)
                    .input(AITExtrasItems.RAW_ZIRCONIUM)
                    .criterion(hasItem(AITExtrasItems.RAW_ZIRCONIUM), conditionsFromItem(AITExtrasItems.RAW_ZIRCONIUM)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HUDOLIN_SUPPORT_BASE_BLOCK, 1)
                    .group("hudolin")
                    .pattern("III")
                    .pattern(" IA")
                    .pattern("   ")
                    .input('A',AITExtrasItems.RAW_ZIRCONIUM)
                    .input('I',AITExtrasItems.ZIRCONIUM_INGOT)
                    .criterion(hasItem(AITExtrasItems.RAW_ZIRCONIUM), conditionsFromItem(AITExtrasItems.RAW_ZIRCONIUM)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.HUDOLIN_SUPPORT_TOP_BLOCK, 1)
                    .group("hudolin")
                    .pattern("AI ")
                    .pattern(" II")
                    .pattern(" IA")
                    .input('A',AITExtrasItems.RAW_ZIRCONIUM)
                    .input('I',AITExtrasItems.ZIRCONIUM_INGOT)
                    .criterion(hasItem(AITExtrasItems.RAW_ZIRCONIUM), conditionsFromItem(AITExtrasItems.RAW_ZIRCONIUM)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.POLISHED_COMPACT_ZEITON, 4)
                    .group("polished_compact_zeiton")
                    .pattern("ZZ")
                    .pattern("ZZ")
                    .input('Z',AITBlocks.COMPACT_ZEITON)
                    .criterion(hasItem(AITBlocks.COMPACT_ZEITON), conditionsFromItem(AITBlocks.COMPACT_ZEITON)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_STAIRS, 4)
                            .group("polished_compact_zeiton")
                            .pattern("  X")
                            .pattern(" XX")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.POLISHED_COMPACT_ZEITON)
                            .criterion(hasItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON), conditionsFromItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_SLAB, 6)
                            .group("polished_compact_zeiton")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.POLISHED_COMPACT_ZEITON)
                            .criterion(hasItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON), conditionsFromItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_WALL, 6)
                            .group("polished_compact_zeiton")
                            .pattern("XXX")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.POLISHED_COMPACT_ZEITON)
                            .criterion(hasItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON), conditionsFromItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.COMPACT_ZEITON_BRICKS, 4)
                    .group("compact_zeiton_bricks")
                    .pattern("PP")
                    .pattern("PP")
                    .input('P',AITExtrasBlocks.POLISHED_COMPACT_ZEITON)
                    .criterion(hasItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON), conditionsFromItem(AITExtrasBlocks.POLISHED_COMPACT_ZEITON)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_STAIRS, 4)
                            .group("compact_zeiton_bricks")
                            .pattern("  X")
                            .pattern(" XX")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.COMPACT_ZEITON_BRICKS)
                            .criterion(hasItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS), conditionsFromItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_SLAB, 6)
                            .group("compact_zeiton_bricks")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.COMPACT_ZEITON_BRICKS)
                            .criterion(hasItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS), conditionsFromItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_WALL, 6)
                            .group("compact_zeiton_bricks")
                            .pattern("XXX")
                            .pattern("XXX")
                            .input('X', AITExtrasBlocks.COMPACT_ZEITON_BRICKS)
                            .criterion(hasItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS), conditionsFromItem(AITExtrasBlocks.COMPACT_ZEITON_BRICKS)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.SEAL_BLOCK , 1)
                            .group("seal")
                            .pattern("NIN")
                            .pattern("I I")
                            .pattern("NIN")
                            .input('I', Items.GOLD_INGOT)
                            .input('N', Items.GOLD_NUGGET)
                            .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                            .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET)));

            provider.addShapelessRecipe(ShapelessRecipeJsonBuilder
                    .create(RecipeCategory.DECORATIONS, AITExtrasBlocks.SEAL_SMALL_BLOCK, 1)
                    .group("seal")
                    .input(AITExtrasBlocks.SEAL_BLOCK)
                    .criterion(hasItem(AITExtrasBlocks.SEAL_BLOCK), conditionsFromItem(AITExtrasBlocks.SEAL_BLOCK)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK , 2)
                            .group("candle_stand")
                            .pattern(" C ")
                            .pattern(" Z ")
                            .pattern(" Z ")
                            .input('C', Items.CANDLE)
                            .input('Z', AITExtrasItems.ZIRCONIUM_INGOT)
                            .criterion(hasItem(Items.CANDLE), conditionsFromItem(Items.CANDLE))
                            .criterion(hasItem(AITExtrasItems.ZIRCONIUM_INGOT), conditionsFromItem(AITExtrasItems.ZIRCONIUM_INGOT)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK , 2)
                            .group("candle_stand")
                            .pattern("CSC")
                            .pattern("Z Z")
                            .input('C', Items.CANDLE)
                            .input('Z', AITExtrasItems.ZIRCONIUM_INGOT)
                            .input('S', AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK)
                            .criterion(hasItem(Items.CANDLE), conditionsFromItem(Items.CANDLE))
                            .criterion(hasItem(AITExtrasItems.ZIRCONIUM_INGOT), conditionsFromItem(AITExtrasItems.ZIRCONIUM_INGOT))
                            .criterion(hasItem(AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK), conditionsFromItem(AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasBlocks.CANDLE_STAND_LARGE_BLOCK , 2)
                            .group("candle_stand")
                            .pattern("CSC")
                            .pattern("Z Z")
                            .input('C', Items.CANDLE)
                            .input('Z', AITExtrasItems.ZIRCONIUM_INGOT)
                            .input('S', AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK)
                            .criterion(hasItem(Items.CANDLE), conditionsFromItem(Items.CANDLE))
                            .criterion(hasItem(AITExtrasItems.ZIRCONIUM_INGOT), conditionsFromItem(AITExtrasItems.ZIRCONIUM_INGOT))
                            .criterion(hasItem(AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK), conditionsFromItem(AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK)));


            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.ATOMIC_SHREDDER , 1)
                            .pattern("  I")
                            .pattern("ZAZ")
                            .pattern("Z  ")
                            .input('I', Items.IRON_INGOT)
                            .input('Z', AITExtrasItems.ZIRCONIUM_INGOT)
                            .input('A', AITItems.ARTRON_COLLECTOR)
                            .criterion(hasItem(Items.CANDLE), conditionsFromItem(Items.CANDLE))
                            .criterion(hasItem(AITExtrasItems.ZIRCONIUM_INGOT), conditionsFromItem(AITExtrasItems.ZIRCONIUM_INGOT))
                            .criterion(hasItem(AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK), conditionsFromItem(AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasItems.METAL_MESH_ITEM, 6)
                            .group("metal_mesh")
                            .pattern("Z Z")
                            .pattern(" Z ")
                            .pattern("Z Z")
                            .input('Z', AITExtrasItems.ZIRCONIUM_INGOT)
                            .criterion(hasItem(AITExtrasItems.ZIRCONIUM_INGOT), conditionsFromItem(AITExtrasItems.ZIRCONIUM_INGOT)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_MESH, 4)
                            .group("metal_mesh")
                            .pattern("MMM")
                            .pattern("MMM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_MESH_STAIRS, 4)
                            .group("metal_mesh")
                            .pattern("  M")
                            .pattern(" MM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_MESH_SLAB, 6)
                            .group("metal_mesh")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_MESH_WALL, 4)
                            .group("metal_mesh")
                            .pattern("MMM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_MESH_TRAPDOOR, 2)
                            .group("metal_mesh")
                            .pattern("MM")
                            .pattern("MM")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasItems.METAL_GRATE_ITEM, 6)
                            .group("metal_grate")
                            .pattern("M M")
                            .pattern(" M ")
                            .pattern("M M")
                            .input('M', AITExtrasItems.METAL_MESH_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_MESH_ITEM), conditionsFromItem(AITExtrasItems.METAL_MESH_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_GRATE, 4)
                            .group("metal_grate")
                            .pattern("MMM")
                            .pattern("MMM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_GRATE_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_GRATE_ITEM), conditionsFromItem(AITExtrasItems.METAL_GRATE_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_GRATE_STAIRS, 4)
                            .group("metal_grate")
                            .pattern("  M")
                            .pattern(" MM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_GRATE_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_GRATE_ITEM), conditionsFromItem(AITExtrasItems.METAL_GRATE_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_GRATE_SLAB, 6)
                            .group("metal_grate")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_GRATE_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_GRATE_ITEM), conditionsFromItem(AITExtrasItems.METAL_GRATE_ITEM)));

            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_GRATE_WALL, 4)
                            .group("metal_grate")
                            .pattern("MMM")
                            .pattern("MMM")
                            .input('M', AITExtrasItems.METAL_GRATE_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_GRATE_ITEM), conditionsFromItem(AITExtrasItems.METAL_GRATE_ITEM)));


            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.METAL_GRATE_TRAPDOOR, 2)
                            .group("metal_grate")
                            .pattern("MM")
                            .pattern("MM")
                            .input('M', AITExtrasItems.METAL_GRATE_ITEM)
                            .criterion(hasItem(AITExtrasItems.METAL_GRATE_ITEM), conditionsFromItem(AITExtrasItems.METAL_GRATE_ITEM)));


            provider.addShapedRecipe(
                    ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.ARS_EGG_BLOCK, 2)
                            .pattern(" I ")
                            .pattern("SES")
                            .pattern("ISI")
                            .input('I', Items.IRON_INGOT)
                            .input('E', Items.EGG)
                            .input('S', Blocks.SEA_LANTERN)
                            .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                            .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                            .criterion(hasItem(Blocks.SEA_LANTERN), conditionsFromItem(Blocks.SEA_LANTERN)));


            provider.addStonecutting(AITBlocks.COMPACT_ZEITON, AITExtrasBlocks.POLISHED_COMPACT_ZEITON,1);

            provider.addStonecutting(AITExtrasBlocks.POLISHED_COMPACT_ZEITON, AITExtrasBlocks.COMPACT_ZEITON_BRICKS, 1);

            provider.addStonecutting(AITExtrasBlocks.POLISHED_COMPACT_ZEITON, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_SLAB, 2);

            provider.addStonecutting(AITExtrasBlocks.POLISHED_COMPACT_ZEITON, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_STAIRS, 1);

            provider.addStonecutting(AITExtrasBlocks.POLISHED_COMPACT_ZEITON, AITExtrasBlocks.POLISHED_COMPACT_ZEITON_WALL, 1);

            provider.addStonecutting(AITExtrasBlocks.COMPACT_ZEITON_BRICKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_SLAB,2);

            provider.addStonecutting(AITExtrasBlocks.COMPACT_ZEITON_BRICKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_STAIRS,1);

            provider.addStonecutting(AITExtrasBlocks.COMPACT_ZEITON_BRICKS, AITExtrasBlocks.COMPACT_ZEITON_BRICK_WALL,1);

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.WHITE_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WWW")
                    .pattern("W W")
                    .input('W',Blocks.WHITE_WOOL)
                    .criterion(hasItem(Blocks.WHITE_WOOL), conditionsFromItem(Blocks.WHITE_WOOL)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.BLACK_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.BLACK_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.BLUE_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.BLUE_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.BROWN_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.BROWN_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.CYAN_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.CYAN_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.GRAY_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.GRAY_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.GREEN_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.GREEN_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.LIGHT_BLUE_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.LIGHT_BLUE_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.LIGHT_GRAY_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.LIGHT_GRAY_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.LIME_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.LIME_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.MAGENTA_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.MAGENTA_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.ORANGE_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.ORANGE_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.PINK_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.PINK_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.PURPLE_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.PURPLE_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.RED_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.RED_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.YELLOW_FEZ_HAT, 1)
                    .group("fez")
                    .pattern("WD")
                    .input('W',AITExtrasItems.WHITE_FEZ_HAT)
                    .input('D',Items.YELLOW_DYE)
                    .criterion(hasItem(AITExtrasItems.WHITE_FEZ_HAT), conditionsFromItem(AITExtrasItems.WHITE_FEZ_HAT)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.SCARF, 1)
                    .group("scarf")
                    .pattern("SSS")
                    .pattern("S S")
                    .input('S',Items.STRING)
                    .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.SCARF_RED, 1)
                    .group("scarf")
                    .pattern("SD")
                    .input('S',AITExtrasItems.SCARF)
                    .input('D',Items.RED_DYE)
                    .criterion(hasItem(AITExtrasItems.SCARF), conditionsFromItem(AITExtrasItems.SCARF)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.SCARF_RAINBOW, 1)
                    .group("scarf")
                    .pattern("SRB")
                    .pattern("PYG")
                    .input('S',AITExtrasItems.SCARF)
                    .input('R',Items.RED_DYE)
                    .input('B',Items.BLUE_DYE)
                    .input('P',Items.PURPLE_DYE)
                    .input('Y',Items.YELLOW_DYE)
                    .input('G',Items.GREEN_DYE)
                    .criterion(hasItem(AITExtrasItems.SCARF), conditionsFromItem(AITExtrasItems.SCARF)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.TENNANT_COAT, 1)
                    .pattern("L L")
                    .pattern("LLL")
                    .input('L',Items.LEATHER)
                    .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER)));


            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, AITExtrasItems.THREED_GLASSES, 1)
                    .pattern("  R")
                    .pattern(" W ")
                    .pattern("B  ")
                    .input('W',Items.WHITE_WOOL)
                    .input('B',Blocks.BLUE_STAINED_GLASS)
                    .input('R',Blocks.RED_STAINED_GLASS)
                    .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                    .criterion(hasItem(Blocks.BLUE_STAINED_GLASS), conditionsFromItem(Blocks.BLUE_STAINED_GLASS))
                    .criterion(hasItem(Blocks.RED_STAINED_GLASS), conditionsFromItem(Blocks.RED_STAINED_GLASS)));

            return provider;

        })));
    }

    private void genLang(FabricDataGenerator.Pack pack) {
        genEnglish(pack);
    }

    private void genEnglish(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
                    AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);
                    

                    //desktops
                    provider.addTranslation("desktop.ait-extras.axos", "Axos");
                    provider.addTranslation("desktop.ait-extras.cherryblossom", "CherryBlossom");
                    provider.addTranslation("desktop.ait-extras.definitive", "Definitive");
                    provider.addTranslation("desktop.ait-extras.exile", "Exile");
                    provider.addTranslation("desktop.ait-extras.industrial", "Industrial");
                    provider.addTranslation("desktop.ait-extras.tron", "Tron");
                    provider.addTranslation("desktop.ait-extras.war_games", "War Games");
                    provider.addTranslation("desktop.ait-extras.academic", "Academic");
                    provider.addTranslation("desktop.ait-extras.rebel", "Rebel");
                    provider.addTranslation("desktop.ait-extras.undercroft", "Undercroft");
                    provider.addTranslation("desktop.ait-extras.tardim", "Tardim");
                    provider.addTranslation("desktop.ait-extras.type_85", "Type 85");
                    provider.addTranslation("desktop.ait-extras.type_89", "Type 89");
                    provider.addTranslation("desktop.ait-extras.wooden", "Wooden");
                    provider.addTranslation("desktop.ait-extras.human_nature", "Human Nature Remixed");

                    //exteriors

                        //bookshelf
                    provider.addTranslation("exterior.ait-extras.bookshelf_birch", "Bookshelf (Birch)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_cherry", "Bookshelf (Cherry)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_dark_oak", "Bookshelf (Dark Oak)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_jungle", "Bookshelf (Jungle)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_mangrove", "Bookshelf (Mangrove)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_oak", "Bookshelf (Oak)");
                    provider.addTranslation("exterior.ait-extras.bookshelf_spruce", "Bookshelf (Spruce)");

                        //modern box
                    provider.addTranslation("exterior.ait-extras.aperture_science", "Aperture");
                    provider.addTranslation("exterior.ait-extras.black_mesa", "Mesa");
                    provider.addTranslation("exterior.ait-extras.copper", "Copper");
                    provider.addTranslation("exterior.ait-extras.eleven_toyota", "Copper Toyota");
                    provider.addTranslation("exterior.ait-extras.eleven_toyota_alternate", "Copper Toyota (ALT)");
                    provider.addTranslation("exterior.ait-extras.coral_alternate", "Coral (ALT)");
                    provider.addTranslation("exterior.ait-extras.tokamak_eotd", "Tokamak (EOTD)");
                    provider.addTranslation("exterior.ait-extras.toyota_alternate", "Toyota (ALT)");
                    provider.addTranslation("exterior.ait-extras.tokamak", "Crystalline");
                    provider.addTranslation("exterior.ait-extras.yard", "73 Yards");
                    provider.addTranslation("exterior.ait-extras.60thmc", "60th Musical Celebration");

                        //classic box
                    provider.addTranslation("exterior.ait-extras.tango", "Tango");
                    provider.addTranslation("exterior.ait-extras.classic_cricketer", "Cricketer");
                    provider.addTranslation("exterior.ait-extras.classic_cricketer2", "Cricketer (ALT)");
                    provider.addTranslation("exterior.ait-extras.classic_happiness", "Happiness");
                    provider.addTranslation("exterior.ait-extras.classic_pilot", "Pilot");
                    provider.addTranslation("exterior.ait-extras.classic_precedent", "Precedent");
                    provider.addTranslation("exterior.ait-extras.classic_snowman", "Snowman");
                    provider.addTranslation("exterior.ait-extras.classic_victorian", "Victorian");
                    provider.addTranslation("exterior.ait-extras.classic_wanderlust", "Wanderlust");

                        //booth
                    provider.addTranslation("exterior.ait-extras.tinylink", "Tiny Link");

                        //ecto
                    provider.addTranslation("exterior.ait-extras.ecto", "Ecto");

                        //post box
                    provider.addTranslation("exterior.ait-extras.post_box", "Post Box");

                        //vanilla
                    provider.addTranslation("exterior.ait-extras.vanilla", "Vanilla");
                    provider.addTranslation("exterior.ait-extras.vanilla_red", "Vanilla (Glasgow)");
                    provider.addTranslation("exterior.ait-extras.vanilla_beacon", "Vanilla (Beacon)");
                    provider.addTranslation("exterior.ait-extras.vanilla_wooden", "Vanilla (Wooden)");
                    provider.addTranslation("exterior.ait-extras.vanilla_classic", "Vanilla (Classic)");
                    provider.addTranslation("exterior.ait-extras.vanilla_classic_wooden", "Vanilla (Classic Wooden)");

                        //clock
                    provider.addTranslation("exterior.ait-extras.clock", "Clock");
                    provider.addTranslation("exterior.ait-extras.clock_master", "Clock (Master)");

                        //origin
                    provider.addTranslation("exterior.ait-extras.origin", "Origin");
                    provider.addTranslation("exterior.ait-extras.origin_red", "Origin (Ruin)");
                    provider.addTranslation("exterior.ait-extras.origin_soul", "Origin (Soul)");
                    provider.addTranslation("exterior.ait-extras.origin_fire", "Origin (Fire)");



                    //sonics
                    provider.addTranslation("sonic.ait-extras.cane", "Cane");
                    provider.addTranslation("sonic.ait-extras.fob_pink", "Fob (Pink)");
                    provider.addTranslation("sonic.ait-extras.fob_red", "Fob (Red)");
                    provider.addTranslation("sonic.ait-extras.fob_yellow", "Fob (Yellow)");
                    provider.addTranslation("sonic.ait-extras.pertwee", "Pertwee");
                    provider.addTranslation("sonic.ait-extras.baker", "Baker");
                    provider.addTranslation("sonic.ait-extras.retro", "Retro");
                    provider.addTranslation("sonic.ait-extras.mcgann", "McGann");
                    provider.addTranslation("sonic.ait-extras.troughton", "Troughton");

                    // Blocks
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, "Victorian Monitor");
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_SCREEN_MONITOR_BLOCK, "Screen (3x2)");
                    provider.addTranslation(AITExtrasBlocks.CRYSTALLINE_SHARD_BLOCK, "Crystalline Shard Block");
                    provider.addTranslation(AITExtrasBlocks.CRYSTALLINE_ORE, "Crystalline Ore");
                    provider.addTranslation(AITExtrasBlocks.SUN_DIAL_BLOCK, "Armillary Sphere");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_ACACIA_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_BAMBOO_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_BIRCH_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_CHERRY_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_CRIMSON_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_DARK_OAK_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_JUNGLE_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_MANGROVE_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_OAK_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_SPRUCE_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.HAT_STAND_WARPED_BLOCK, "Hat Stand");
                    provider.addTranslation(AITExtrasBlocks.CRYSTAL_BLOCK, "Roof Crystal");
                    provider.addTranslation(AITExtrasBlocks.CRYSTAL_ZEITON_BLOCK, "Roof Crystal (Zeiton)");
                    provider.addTranslation(AITExtrasBlocks.CRYSTAL_MASTER_BLOCK, "Roof Crystal (Master)");
                    provider.addTranslation(AITExtrasBlocks.HUDOLIN_SUPPORT_BASE_BLOCK, "Hudolin Support (Base)");
                    provider.addTranslation(AITExtrasBlocks.HUDOLIN_SUPPORT_TOP_BLOCK, "Hudolin Support (Top)");
                    provider.addTranslation(AITExtrasBlocks.POLISHED_COMPACT_ZEITON, "Polished Compact Zeiton");
                    provider.addTranslation(AITExtrasBlocks.POLISHED_COMPACT_ZEITON_SLAB, "Polished Compact Zeiton Slab");
                    provider.addTranslation(AITExtrasBlocks.POLISHED_COMPACT_ZEITON_STAIRS, "Polished Compact Zeiton Stairs");
                    provider.addTranslation(AITExtrasBlocks.POLISHED_COMPACT_ZEITON_WALL, "Polished Compact Zeiton Wall");
                    provider.addTranslation(AITExtrasBlocks.COMPACT_ZEITON_BRICKS, "Compact Zeiton Bricks");
                    provider.addTranslation(AITExtrasBlocks.COMPACT_ZEITON_BRICK_WALL, "Compact Zeiton Brick Wall");
                    provider.addTranslation(AITExtrasBlocks.COMPACT_ZEITON_BRICK_STAIRS, "Compact Zeiton Brick Stairs");
                    provider.addTranslation(AITExtrasBlocks.COMPACT_ZEITON_BRICK_SLAB, "Compact Zeiton Brick Slab");
                    provider.addTranslation(AITExtrasBlocks.ZIRCONIUM_ORE, "Zirconium Ore");
                    provider.addTranslation(AITExtrasBlocks.SEAL_BLOCK, "Seal Of Rassilon");
                    provider.addTranslation(AITExtrasBlocks.SEAL_SMALL_BLOCK, "Seal Of Rassilon (Small)");
                    provider.addTranslation(AITExtrasBlocks.CANDLE_STAND_LARGE_BLOCK, "Candle Stand (Large)");
                    provider.addTranslation(AITExtrasBlocks.CANDLE_STAND_SINGLE_BLOCK, "Candle Stand (Single)");
                    provider.addTranslation(AITExtrasBlocks.CANDLE_STAND_SMALL_BLOCK, "Candle Stand (Small)");

                    provider.addTranslation(AITExtrasBlocks.METAL_GRATE, "Metal Grate");
                    provider.addTranslation(AITExtrasBlocks.METAL_GRATE_SLAB, "Metal Grate Slab");
                    provider.addTranslation(AITExtrasBlocks.METAL_GRATE_STAIRS, "Metal Grate Stairs");
                    provider.addTranslation(AITExtrasBlocks.METAL_GRATE_WALL, "Metal Grate Wall");
                    provider.addTranslation(AITExtrasBlocks.METAL_GRATE_TRAPDOOR, "Metal Grate Trapdoor");
                    provider.addTranslation(AITExtrasBlocks.METAL_MESH, "Metal Mesh");
                    provider.addTranslation(AITExtrasBlocks.METAL_MESH_SLAB, "Metal Mesh Slab");
                    provider.addTranslation(AITExtrasBlocks.METAL_MESH_STAIRS, "Metal Mesh Stairs");
                    provider.addTranslation(AITExtrasBlocks.METAL_MESH_WALL, "Metal Mesh Wall");
                    provider.addTranslation(AITExtrasBlocks.METAL_MESH_TRAPDOOR, "Metal Mesh Trapdoor");
                    provider.addTranslation(AITExtrasBlocks.ARS_EGG_BLOCK, "ARS Egg");


                    // Items
                    provider.addTranslation(AITExtrasItems.MERCURY_DISC.getTranslationKey() + ".desc", "Nitrogenez - Mercury");
                    provider.addTranslation(AITExtrasItems.MERCURY_DISC, "Music Disc");
                    provider.addTranslation(AITExtrasItems.JELLY_BABIES, "Jelly Babies");
                    provider.addTranslation(AITExtrasItems.CUSTARD_CREAM, "Custard Cream");
                    provider.addTranslation(AITExtrasItems.RICE_PUDDING, "Rice Pudding");
                    provider.addTranslation(AITExtrasItems.CRYSTALLINE_SHARD, "Crystalline Shard");
                    provider.addTranslation(AITExtrasItems.RAW_ZIRCONIUM, "Raw Zirconium");
                    provider.addTranslation(AITExtrasItems.ZIRCONIUM_INGOT, "Zirconium Ingot");
                    provider.addTranslation(AITExtrasItems.WHISTLE, "Summon Whistle");
                    provider.addTranslation(AITExtrasItems.ATOMIC_SHREDDER, "Atomic Shredder");
                    provider.addTranslation(AITExtrasItems.METAL_MESH_ITEM, "Metal Mesh");
                    provider.addTranslation(AITExtrasItems.METAL_GRATE_ITEM, "Metal Grate");
                    provider.addTranslation(AITExtrasItems.JELLY_BABIES, "Jelly Babies");
                    provider.addTranslation(AITExtrasItems.CUSTARD_CREAM, "Custard Cream");
                    provider.addTranslation(AITExtrasItems.RICE_PUDDING, "Rice Pudding");
                    provider.addTranslation(AITExtrasItems.CRYSTALLINE_SHARD, "Crystalline Shard");
                    provider.addTranslation(AITExtrasItems.RAW_ZIRCONIUM, "Raw Zirconium");
                    provider.addTranslation(AITExtrasItems.ZIRCONIUM_INGOT, "Zirconium Ingot");
                    provider.addTranslation(AITExtrasItems.WHISTLE, "Summon Whistle");
                    provider.addTranslation(AITExtrasItems.ATOMIC_SHREDDER, "Atomic Shredder");
                    provider.addTranslation(AITExtrasItems.METAL_GRATE_ITEM, "Metal Grate");
                    provider.addTranslation(AITExtrasItems.METAL_MESH_ITEM, "Metal Mesh");
                    provider.addTranslation(AITExtrasItems.WHITE_FEZ_HAT, "White Fez");
                    provider.addTranslation(AITExtrasItems.BLACK_FEZ_HAT, "Black Fez");
                    provider.addTranslation(AITExtrasItems.BLUE_FEZ_HAT, "Blue Fez");
                    provider.addTranslation(AITExtrasItems.BROWN_FEZ_HAT, "Brown Fez");
                    provider.addTranslation(AITExtrasItems.CYAN_FEZ_HAT, "Cyan Fez");
                    provider.addTranslation(AITExtrasItems.GRAY_FEZ_HAT, "Gray Fez");
                    provider.addTranslation(AITExtrasItems.GREEN_FEZ_HAT, "Green Fez");
                    provider.addTranslation(AITExtrasItems.LIGHT_BLUE_FEZ_HAT, "Light Blue Fez");
                    provider.addTranslation(AITExtrasItems.LIGHT_GRAY_FEZ_HAT, "Light Gray Fez");
                    provider.addTranslation(AITExtrasItems.LIME_FEZ_HAT, "Lime Fez");
                    provider.addTranslation(AITExtrasItems.MAGENTA_FEZ_HAT, "Magenta Fez");
                    provider.addTranslation(AITExtrasItems.ORANGE_FEZ_HAT, "Orange Fez");
                    provider.addTranslation(AITExtrasItems.PINK_FEZ_HAT, "Pink Fez");
                    provider.addTranslation(AITExtrasItems.PURPLE_FEZ_HAT, "Purple Fez");
                    provider.addTranslation(AITExtrasItems.RED_FEZ_HAT, "Red Fez");
                    provider.addTranslation(AITExtrasItems.YELLOW_FEZ_HAT, "Yellow Fez");
                    provider.addTranslation(AITExtrasItems.SCARF, "Scarf");
                    provider.addTranslation(AITExtrasItems.SCARF_RED, "Red Scarf");
                    provider.addTranslation(AITExtrasItems.SCARF_RAINBOW, "Rainbow Scarf");
                    provider.addTranslation(AITExtrasItems.TENNANT_COAT, "Tennant Coat");
                    provider.addTranslation(AITExtrasItems.THREED_GLASSES, "3D Glasses");

                    // Tabs / ToolTips
                     provider.addTranslation(AITExtrasItemGroups.MAIN, "AIT Extras");
                     provider.addTranslation("itemGroup.ait-extras.item_group_cosmetics", "AIT Extras: Cosmetics");
                     provider.addTranslation("message.ait-extras.noretep", "No Retep For you!");
                     provider.addTranslation("block.tooltip.seal", "If you SHIFT when placing this, it will become a CENTERED version!!");
                     provider.addTranslation("block.tooltip.ars_egg", "If you RIGHT CLICK the block, it will turn ON and OFF!!");
                     provider.addTranslation("block.tooltip.hatstandacacia", "Variant: Acacia");
                     provider.addTranslation("block.tooltip.hatstandbamboo", "Variant: Bamboo");
                     provider.addTranslation("block.tooltip.hatstandbirch", "Variant: Birch");
                     provider.addTranslation("block.tooltip.hatstandcherry", "Variant: Cherry");
                     provider.addTranslation("block.tooltip.hatstandcrimson", "Variant: Crimson");
                     provider.addTranslation("block.tooltip.hatstanddarkoak", "Variant: Dark Oak");
                     provider.addTranslation("block.tooltip.hatstandjungle", "Variant: Jungle");
                     provider.addTranslation("block.tooltip.hatstandmangrove", "Variant: Mangrove");
                     provider.addTranslation("block.tooltip.hatstandoak", "Variant: Oak");
                     provider.addTranslation("block.tooltip.hatstandspruce", "Variant: Spruce");
                     provider.addTranslation("block.tooltip.hatstandwarped", "Variant: Warped");

                    //SFXS
                    provider.addTranslation("animation.ait-extras.classic_mat", "Classic (Alt)");
                    provider.addTranslation("animation.ait-extras.classic_demat", "Classic (Alt)");
                    provider.addTranslation("animation.ait-extras.drumless_demat", "Drumless");
                    provider.addTranslation("animation.ait-extras.fast_mat", "Fast");
                    provider.addTranslation("animation.ait-extras.fast_demat", "Fast");
                    provider.addTranslation("animation.ait-extras.minecart_mat", "Minecart");
                    provider.addTranslation("animation.ait-extras.minecart_demat", "Minecart");
                    provider.addTranslation("animation.ait-extras.regen_demat", "Regen");
                    provider.addTranslation("animation.ait-extras.type70_mat", "Type 70");
                    provider.addTranslation("animation.ait-extras.type70_demat", "Type 70");
                    provider.addTranslation("animation.ait-extras.xmas_demat", "Xmas");

                    //Achievements
                    provider.addTranslation("achievement.ait-extras.title.root", "AIT Extras");
                    provider.addTranslation("achievement.ait-extras.description.root", "Like AIT, but more!");
                    provider.addTranslation("achievement.ait-extras.title.obtain_jelly_babies", "Would you like a Jelly Baby?");
                    provider.addTranslation("achievement.ait-extras.description.obtain_jelly_babies", "Craft Jelly Babies");
                    provider.addTranslation("achievement.ait-extras.title.obtain_extras_monitor_block", "Critical Timing Malfunction!");
                    provider.addTranslation("achievement.ait-extras.description.obtain_extras_monitor_block", "Craft The Victorian Monitor");
                    provider.addTranslation("achievement.ait-extras.title.obtain_custard_cream", "Yum, Yum, Yum!");
                    provider.addTranslation("achievement.ait-extras.description.obtain_custard_cream", "funfact: Custard Creams are one of the best biscuits in the world!");
                    provider.addTranslation("achievement.ait-extras.title.obtain_rice_pudding", "UNLIMITED RICE PUDDING!!!");
                    provider.addTranslation("achievement.ait-extras.description.obtain_rice_pudding", "Powerful. Crush the lesser races. Conquer the galaxy. Unimaginable power. Unlimited rice pudding, et cetera, et cetera.");
                    provider.addTranslation("achievement.ait-extras.title.obtain_seal_block", "The Seal of Rassilon!");
                    provider.addTranslation("achievement.ait-extras.description.obtain_seal_block", "Craft the Seal of Rassilon");
                    provider.addTranslation("achievement.ait-extras.title.obtain_ars_egg_block", "Architectural Reconfiguration System");
                    provider.addTranslation("achievement.ait-extras.description.obtain_ars_egg_block", "Craft an ARS Egg");


            return provider;
        })));
    }
}
