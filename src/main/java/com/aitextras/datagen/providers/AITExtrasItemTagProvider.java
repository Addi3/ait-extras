package com.aitextras.datagen.providers;

import java.util.concurrent.CompletableFuture;

import com.aitextras.AITExtras;
import com.aitextras.core.AITExtrasItems;
import dev.amble.ait.core.AITItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class AITExtrasItemTagProvider extends FabricTagProvider<Item> {

    public AITExtrasItemTagProvider(FabricDataOutput output,
                                    @Nullable CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, RegistryKeys.ITEM, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(AITExtrasItems.MERCURY_DISC);



        getOrCreateTagBuilder(AITExtrasTags.Items.FEZ_HATS)
                .add(AITExtrasItems.BLACK_FEZ_HAT)
                .add(AITExtrasItems.BLUE_FEZ_HAT)
                .add(AITExtrasItems.BROWN_FEZ_HAT)
                .add(AITExtrasItems.CYAN_FEZ_HAT)
                .add(AITExtrasItems.GRAY_FEZ_HAT)
                .add(AITExtrasItems.GREEN_FEZ_HAT)
                .add(AITExtrasItems.LIGHT_BLUE_FEZ_HAT)
                .add(AITExtrasItems.LIGHT_GRAY_FEZ_HAT)
                .add(AITExtrasItems.LIME_FEZ_HAT)
                .add(AITExtrasItems.MAGENTA_FEZ_HAT)
                .add(AITExtrasItems.ORANGE_FEZ_HAT)
                .add(AITExtrasItems.PINK_FEZ_HAT)
                .add(AITExtrasItems.PURPLE_FEZ_HAT)
                .add(AITExtrasItems.RED_FEZ_HAT)
                .add(AITExtrasItems.WHITE_FEZ_HAT)
                .add(AITExtrasItems.YELLOW_FEZ_HAT);

        getOrCreateTagBuilder(AITExtrasTags.Items.SCARFS)
                .add(AITExtrasItems.SCARF)
                .add(AITExtrasItems.SCARF_RED)
                .add(AITExtrasItems.SCARF_RAINBOW);

        getOrCreateTagBuilder(AITExtrasTags.Items.KEYCHAIN_ITEMS)
                .add(AITItems.CLASSIC_KEY)
                .add(AITItems.GOLD_KEY)
                .add(AITItems.IRON_KEY)
                .add(AITItems.NETHERITE_KEY)
                .add(AITItems.SKELETON_KEY);
    }

    public static class AITExtrasTags {
        public static class Items {
            public static final TagKey<Item> FEZ_HATS = TagKey.of(
                    RegistryKeys.ITEM,
                    id("fez_hats")
            );
            public static final TagKey<Item> SCARFS = TagKey.of(
                    RegistryKeys.ITEM,
                    id("scarfs")
            );
            public static final TagKey<Item> KEYCHAIN_ITEMS = TagKey.of(
                    RegistryKeys.ITEM,
                    id("keychain_items")
            );
        }
    }

    public static Identifier id(String path) {
        return new Identifier(AITExtras.MOD_ID, path);
    }
}
