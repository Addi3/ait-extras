package com.aitextras.core;


import com.aitextras.core.item.AtomicShredderItem;
import com.aitextras.core.item.RecallDiscItem;
import com.aitextras.core.item.WhistleItem;
import com.sun.jna.platform.unix.X11;
import dev.amble.ait.core.AITItemGroups;
import dev.amble.ait.core.AITSounds;
import dev.amble.ait.core.item.RemoteItem;
import dev.amble.lib.container.impl.ItemContainer;
import dev.amble.lib.datagen.util.AutomaticModel;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Rarity;

public class AITExtrasItems extends ItemContainer {

    @AutomaticModel
    @NoEnglish
    public static final Item MERCURY_DISC = new MusicDiscItem(11, AITExtrasSounds.MERCURY_DISC,
            new AItemSettings().maxCount(1).rarity(Rarity.RARE).group(AITExtrasItemGroups.MAIN), 216);

//    @AutomaticModel
//    @NoEnglish
//    public static final Item RECALL_DISC = new RecallDiscItem(new AItemSettings().maxCount(1));

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

    @NoEnglish
    public static final Item ATOMIC_SHREDDER = new AtomicShredderItem(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item METAL_MESH_ITEM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));

    @AutomaticModel
    @NoEnglish
    public static final Item METAL_GRATE_ITEM = new Item(new AItemSettings().group(AITExtrasItemGroups.MAIN));
}
