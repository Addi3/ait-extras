package com.aitextras.datagen;

import com.aitextras.core.AITExtrasItems;
import com.aitextras.datagen.providers.*;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.sound.AmbleSoundProvider;
import dev.amble.lib.datagen.tag.AmbleBlockTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
        genTags(pack);
        generateSoundData(pack);
        generateItemTags(pack);
    }










    public void generateItemTags(FabricDataGenerator.Pack pack) {
        pack.addProvider(AITExtrasItemTagProvider::new);
    }

    public void generateSoundData(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleSoundProvider(output))));
    }

 private void genTags(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleBlockTagProvider(output, registriesFuture))));
    }

    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            AITExtrasRecipeProvider provider = new AITExtrasRecipeProvider(output);


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

                     provider.addTranslation("itemGroup.ait-extras.item_group_cosmetics", "Just The Clothes");


            return provider;
        })));
    }
}