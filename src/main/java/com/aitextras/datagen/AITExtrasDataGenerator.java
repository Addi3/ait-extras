package com.aitextras.datagen;

import com.aitextras.core.AITExtrasBlocks;
import com.aitextras.core.AITExtrasItemGroups;
import com.aitextras.core.AITExtrasItems;
import dev.amble.ait.core.AITBlocks;
import dev.amble.ait.core.AITItems;
import dev.amble.ait.datagen.datagen_providers.AITAchievementProvider;
import dev.amble.ait.datagen.datagen_providers.AITRecipeProvider;
import dev.amble.ait.module.ModuleRegistry;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.loot.AmbleBlockLootTable;
import dev.amble.lib.datagen.model.AmbleModelProvider;
import dev.amble.lib.datagen.sound.AmbleSoundProvider;
import dev.amble.lib.datagen.tag.AmbleBlockTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

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
    }

    private void genModels(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            AmbleModelProvider provider = new AmbleModelProvider(output);

            provider.withBlocks(AITExtrasBlocks.class);
            provider.withItems(AITExtrasItems.class);

            return provider;
        })));
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
            AITRecipeProvider provider = new AITRecipeProvider(output);

            ModuleRegistry.instance().iterator().forEachRemaining(module -> module.getDataGenerator().ifPresent(dataGenerator -> {
                dataGenerator.recipes(provider);
            }));


            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, 1)
                    .pattern("DDD")
                    .pattern("DED")
                    .pattern("DCD")
                    .input('D', Items.DARK_OAK_PLANKS)
                    .input('C', Items.CHAIN)
                    .input('E', Items.ENDER_EYE)
                    .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                    .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                    .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE)));

            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.EXTRAS_SCREEN_MONITOR_BLOCK, 1)
                    .pattern("BBB")
                    .pattern("BEB")
                    .pattern("BBB")
                    .input('B', Items.BLACK_CONCRETE)
                    .input('E', Items.ENDER_EYE)
                    .criterion(hasItem(Items.BLACK_CONCRETE), conditionsFromItem(Items.BLACK_CONCRETE))
                    .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE)))

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, AITExtrasBlocks.SUN_DIAL_BLOCK, 1)
                    .pattern("NGN")
                    .pattern("GAG")
                    .pattern("NGN")
                    .input('G', Items.GOLD_INGOT)
                    .input('A', Items.SPECTRAL_ARROW)
                    .input('N', Items.GOLD_NUGGET)
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .criterion(hasItem(Items.SPECTRAL_ARROW), conditionsFromItem(Items.SPECTRAL_ARROW))
                    .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET)));

            ;provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AITExtrasItems.RECALL_DISC, 1)
                    .pattern("SSS")
                    .pattern("PWP")
                    .pattern("SSS")
                    .input('S', AITItems.SUPERHEATED_ZEITON)
                    .input('W', AITItems.WAYPOINT_CARTRIDGE)
                    .input('P', AITItems.PLASMIC_MATERIAL)
                    .criterion(hasItem(AITItems.SUPERHEATED_ZEITON), conditionsFromItem(AITItems.SUPERHEATED_ZEITON))
                    .criterion(hasItem(AITItems.WAYPOINT_CARTRIDGE), conditionsFromItem(AITItems.WAYPOINT_CARTRIDGE))
                    .criterion(hasItem(AITItems.PLASMIC_MATERIAL), conditionsFromItem(AITItems.PLASMIC_MATERIAL)));

            ;
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

            return provider;

        })));
    }

    private void genLang(FabricDataGenerator.Pack pack) {
        genEnglish(pack);
    }

    private void genEnglish(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
                    AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);

            provider.translateBlocks(AITBlocks.class);

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

                        //clock
                    provider.addTranslation("exterior.ait-extras.clock", "Clock");
                    provider.addTranslation("exterior.ait-extras.clock_oak", "Clock (Oak)");
                    provider.addTranslation("exterior.ait-extras.clock_spruce", "Clock (Spruce)");
                    provider.addTranslation("exterior.ait-extras.clock_birch", "Clock (Birch)");
                    provider.addTranslation("exterior.ait-extras.clock_jungle", "Clock (Jungle)");

                        //pixel consistent
                    provider.addTranslation("exterior.ait-extras.pixel_consistent", "Pixel Consistent");
                            //classic
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_classic", "Prime");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_definitive", "Definitive");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_exile", "Exile");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_hudolin", "Hudolin");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_retro", "Retro");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_yeti", "Yeti");
                            //modern
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_modern", "Coral");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_copper", "Copper");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_toyota", "Toyota");
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_renaissance", "Renaissance");
                            //Crystalline
                    provider.addTranslation("exterior.ait-extras.pixel_consistent_crystalline", "Crystalline");

                    //sonics
                    provider.addTranslation("sonic.ait-extras.cane", "Cane");
                    provider.addTranslation("sonic.ait-extras.fob_pink", "Fob (Pink)");
                    provider.addTranslation("sonic.ait-extras.fob_red", "Fob (Red)");
                    provider.addTranslation("sonic.ait-extras.fob_yellow", "Fob (Yellow)");

                    // Blocks
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, "Victorian Monitor");
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_SCREEN_MONITOR_BLOCK, "Screen (3x2)");
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_CRYSTALLINE_BLOCK, "Crystalline Block");
                    provider.addTranslation(AITExtrasBlocks.SUN_DIAL_BLOCK, "Armillary Sphere");

                    // Items
                    provider.addTranslation(AITExtrasItems.MERCURY_DISC.getTranslationKey() + ".desc", "Nitrogenez - Mercury");
                    provider.addTranslation(AITExtrasItems.MERCURY_DISC, "Music Disc");
                    provider.addTranslation(AITExtrasItems.RECALL_DISC.getTranslationKey() + ".desc", "Valid Trips: 1");
                    provider.addTranslation(AITExtrasItems.RECALL_DISC, "Emergency Recall Disc");
                    provider.addTranslation(AITExtrasItems.JELLY_BABIES, "Jelly Babies");

                    // Tabs
                     provider.addTranslation(AITExtrasItemGroups.MAIN, "AIT Extras");

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
                    provider.addTranslation("advancements.ait-extras.root.title", "AIT Extras");
                    provider.addTranslation("advancements.ait-extras.root.description", "Like AIT, but more!");
                    provider.addTranslation("advancements.ait-extras.obtain_jelly_babies.title", "Would you like a Jelly Baby?");
                    provider.addTranslation("advancements.ait-extras.obtain_jelly_babies.description", "Craft Jelly Babies");


            return provider;
        })));
    }
}