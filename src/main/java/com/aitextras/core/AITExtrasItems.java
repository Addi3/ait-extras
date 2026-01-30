package com.aitextras.core;


import com.aitextras.core.item.AtomicShredderItem;
import com.aitextras.core.item.FezItem;
import com.aitextras.core.item.KeyChainItem;
import com.aitextras.core.item.WhistleItem;
import dev.amble.ait.core.item.RenderableArmorItem;
import dev.amble.lib.container.impl.ItemContainer;
import dev.amble.lib.datagen.util.AutomaticModel;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Rarity;

public class AITExtrasItems extends ItemContainer {

    @AutomaticModel
    @NoEnglish
    public static final Item MERCURY_DISC = new MusicDiscItem(11, AITExtrasSounds.MERCURY_DISC,
            new AItemSettings().maxCount(1).rarity(Rarity.RARE).group(AITExtrasItemGroups.MAIN), 216);

    @AutomaticModel
   @NoEnglish
    public static final Item JELLY_BABIES = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN).food(AITExtrasFoodComponenets.JELLY_BABIES));

    @AutomaticModel
    @NoEnglish
    public static final Item CUSTARD_CREAM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN).food(AITExtrasFoodComponenets.CUSTARD_CREAM));

    @AutomaticModel
    @NoEnglish
    public static final Item RICE_PUDDING = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN).food(AITExtrasFoodComponenets.RICE_PUDDING));

    @AutomaticModel
    @NoEnglish
    public static final Item CRYSTALLINE_SHARD = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item RAW_ZIRCONIUM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item ZIRCONIUM_INGOT = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @NoEnglish
    public static final Item WHISTLE = new WhistleItem(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item METAL_GRATE_ITEM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item METAL_MESH_ITEM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @NoEnglish
    public static final Item ATOMIC_SHREDDER = new AtomicShredderItem(new AItemSettings().group(AITExtrasItemGroups.MAIN));


    @AutomaticModel
    @NoEnglish
    public static final Item FEZ_ITEM = new FezItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);

    @AutomaticModel
    @NoEnglish
    public static final Item SCARF = new RenderableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);
    @AutomaticModel
    @NoEnglish
    public static final Item SCARF_RED = new RenderableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);
    @AutomaticModel
    @NoEnglish
    public static final Item SCARF_RAINBOW = new RenderableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);

    @AutomaticModel
    @NoEnglish
    public static final Item TENNANT_COAT = new RenderableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);

    @AutomaticModel
    @NoEnglish
    public static final Item THREED_GLASSES = new RenderableArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET,
            new AItemSettings().group(AITExtrasItemGroups.COSMETICS).maxCount(1), true);

    @NoEnglish
    public static final Item KEYCHAIN = new KeyChainItem(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @NoEnglish
    @AutomaticModel
    public static final Item ROUNDEL_MOULD = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));
}
