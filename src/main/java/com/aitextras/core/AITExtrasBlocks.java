package com.aitextras.core;

import com.aitextras.core.blocks.*;
import com.aitextras.core.blocks.hudolinsupport.HudolinSupportBaseBlock;
import com.aitextras.core.blocks.hudolinsupport.HudolinSupportTopBlock;
import dev.amble.lib.block.ABlockSettings;
import dev.amble.lib.container.impl.BlockContainer;
import dev.amble.lib.datagen.util.AutomaticModel;
import dev.amble.lib.datagen.util.NoBlockDrop;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.datagen.util.PickaxeMineable;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

public class AITExtrasBlocks extends BlockContainer {

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block EXTRAS_MONITOR_BLOCK = new ExtrasMonitorBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .instrument(Instrument.COW_BELL).strength(1.5F, 6.0F).pistonBehavior(PistonBehavior.NORMAL));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block EXTRAS_SCREEN_MONITOR_BLOCK = new ExtrasScreenMonitorBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .instrument(Instrument.COW_BELL).strength(1.5F, 6.0F).pistonBehavior(PistonBehavior.NORMAL));

   @AutomaticModel
   @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
   @NoEnglish
    public static final Block EXTRAS_CRYSTALLINE_BLOCK = new ExtrasCrystallineBlock(
            ABlockSettings.create().itemSettings(new AItemSettings()).nonOpaque().strength(0.01F, 0.01F).pistonBehavior(PistonBehavior.NORMAL));

   @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
   @NoEnglish
    public static final Block SUN_DIAL_BLOCK = new SunDialBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(1.5F, 6.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.METAL));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block HUDOLIN_SUPPORT_BASE_BLOCK = new HudolinSupportBaseBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(1.5F, 6.0F).pistonBehavior(PistonBehavior.IGNORE).sounds(BlockSoundGroup.METAL));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block HUDOLIN_SUPPORT_TOP_BLOCK = new HudolinSupportTopBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(1.5F, 6.0F).pistonBehavior(PistonBehavior.IGNORE).sounds(BlockSoundGroup.METAL));

    @NoEnglish
    public static final Block HAT_STAND_OAK_BLOCK = new HatStandOakBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_ACACIA_BLOCK = new HatStandAcaciaBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_BAMBOO_BLOCK = new HatStandBambooBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_BIRCH_BLOCK = new HatStandBirchBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_CHERRY_BLOCK = new HatStandCherryBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_CRIMSON_BLOCK = new HatStandCrimsonBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_DARK_OAK_BLOCK = new HatStandDarkOakBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_JUNGLE_BLOCK = new HatStandJungleBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_MANGROVE_BLOCK = new HatStandMangroveBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_SPRUCE_BLOCK = new HatStandSpruceBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @NoEnglish
    public static final Block HAT_STAND_WARPED_BLOCK = new HatStandWarpedBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.WOOD));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block CRYSTAL_BLOCK = new CrystalBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block CRYSTAL_ZEITON_BLOCK = new CrystalZeitonBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block CRYSTAL_MASTER_BLOCK = new CrystalMasterBlock(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    @AutomaticModel
    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoEnglish
    public static final Block CRYSTALLINE_SHARD_BLOCK = new Block(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    @AutomaticModel
    @NoEnglish
    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoBlockDrop
    public static final Block CRYSTALLINE_ORE = new Block(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));

    @AutomaticModel
    @NoEnglish
    @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
    @NoBlockDrop
    public static final Block ZIRCONIUM_ORE = new Block(ABlockSettings.create()
            .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
            .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.DEEPSLATE));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block COMPACT_ZEITON_BRICKS = new Block(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block COMPACT_ZEITON_BRICK_STAIRS = new StairsBlock(
         COMPACT_ZEITON_BRICKS.getDefaultState(),
         ABlockSettings.create()
                 .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
                 .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK)
 );


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block COMPACT_ZEITON_BRICK_SLAB = new SlabBlock(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block COMPACT_ZEITON_BRICK_WALL = new WallBlock(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block POLISHED_COMPACT_ZEITON = new Block(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block POLISHED_COMPACT_ZEITON_STAIRS = new StairsBlock(
         COMPACT_ZEITON_BRICKS.getDefaultState(),
         ABlockSettings.create()
                 .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
                 .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK)
 );


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block POLISHED_COMPACT_ZEITON_SLAB = new SlabBlock(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));


 @NoEnglish
 @PickaxeMineable(tool = PickaxeMineable.Tool.IRON)
 public static final Block POLISHED_COMPACT_ZEITON_WALL = new WallBlock(ABlockSettings.create()
         .itemSettings(new AItemSettings().group(AITExtrasItemGroups.MAIN)).nonOpaque().requiresTool()
         .strength(2.0F, 3.0F).pistonBehavior(PistonBehavior.NORMAL).sounds(BlockSoundGroup.AMETHYST_BLOCK));
   };
