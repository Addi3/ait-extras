package com.aitextras;

import com.aitextras.core.*;
import dev.amble.ait.core.AITSounds;
import dev.amble.ait.data.schema.exterior.category.PoliceBoxCategory;
import dev.amble.ait.data.schema.exterior.variant.addon.AddonExterior;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;


public class AITExtras implements ModInitializer {

    public static final String MOD_ID = "ait-extras";
    public static AddonExterior ECTO;
    public static AddonExterior POSTBOX;
    public static AddonExterior VANILLA;
    public static AddonExterior CLOCK;
    public static AddonExterior PIXELCONSISTENT;

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        registerAddonExteriors();
        RegistryContainer.register(AITExtrasItems.class, MOD_ID);
        RegistryContainer.register(AITExtrasBlocks.class, MOD_ID);
        RegistryContainer.register(AITExtrasBlockEntityTypes.class, MOD_ID);
        RegistryContainer.register(AITExtrasItemGroups.class, MOD_ID);
        AITExtrasSounds.init();
    }

    private void registerAddonExteriors() {
        //ECTO
           ECTO = new AddonExterior(PoliceBoxCategory.REFERENCE, MOD_ID, "ecto").register();
           ECTO.setDoor(new AddonExterior.Door(
                           ECTO, true, AITSounds.POLICE_BOX_DOOR_OPEN, AITSounds.POLICE_BOX_DOOR_CLOSE))
                   .toDoor().register();
           ECTO.hasPortals();
           ECTO.setPortalTranslations((pos, b) -> {
               return switch(b) {
                   case 0 -> pos.add(0, -0.05, -0.628); // NORTH
                   case 1, 2, 3 -> pos.add(0.43, -0.05, -0.43); // NORTH EAST p n
                   case 4 -> pos.add(0.628, -0.05, 0); // EAST
                   case 5, 6, 7 -> pos.add(0.43, -0.05, 0.43); // SOUTH EAST p p
                   case 8 -> pos.add(0, -0.05, 0.628); // SOUTH
                   case 9, 10, 11 -> pos.add(-0.43, -0.05, 0.43); // SOUTH WEST n p
                   case 12 -> pos.add(-0.628, -0.05, 0); // WEST
                   case 13, 14, 15 -> pos.add(-0.43, -0.05, -0.43); // NORTH WEST n n
                   default -> pos;
               };
           });
           ECTO.toDoor().setPortalTranslations((pos, b) -> {
               return switch(b) {
                   case DOWN, UP -> pos;
                   case NORTH -> pos.add(0, 0.05, -0.45);
                   case SOUTH -> pos.add(0, 0.05, 0.45);
                   case WEST -> pos.add(-0.45, 0.05, 0);
                   case EAST -> pos.add(0.45, 0.05, 0);
               };
           });

     //POSTBOX
            POSTBOX = new AddonExterior(new Identifier(MOD_ID, "post_box"), MOD_ID, "post_box").register();
            POSTBOX.setDoor(new AddonExterior.Door(
                         POSTBOX, false, net.minecraft.sound.SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN,
                         net.minecraft.sound.SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE))
                    .toDoor().register();
             POSTBOX.hasPortals();
             POSTBOX.setPortalTranslations((pos, b) -> {
             return switch(b) {
                 case 0 -> pos.add(0, -0.035, -0.4); // NORTH
                    case 1, 2, 3 -> pos.add(0.43, -0.035, -0.5); // NORTH EAST p n
                    case 4 -> pos.add(0.428, -0.035, 0); // EAST
                    case 5, 6, 7 -> pos.add(0.23, -0.035, 0.5); // SOUTH EAST p p
                    case 8 -> pos.add(0, -0.035, 0.424); // SOUTH
                    case 9, 10, 11 -> pos.add(-0.23, -0.035, 0.5); // SOUTH WEST n p
                    case 12 -> pos.add(-0.428, -0.235, 0); // WEST
                 case 13, 14, 15 -> pos.add(-0.23, -0.035, -0.5); // NORTH WEST n n
                 default -> pos;
             };
            });

         POSTBOX.toDoor().setPortalTranslations((pos, b) -> {
                return switch(b) {
                   case DOWN, UP -> pos;
                   case NORTH -> pos.add(-0.1, 0.075, -0.38);
                   case SOUTH -> pos.add(0, 0.075, 0.47);
                  case WEST -> pos.add(-0.47, 0.075, 0);
                  case EAST -> pos.add(0.47, 0.075, 0);
              };
         });

        //VANILLA
            VANILLA = new AddonExterior(new Identifier(MOD_ID, "vanilla"), MOD_ID, "vanilla").register();
            VANILLA.setDoor(new AddonExterior.Door(
                         VANILLA, false, SoundEvents.BLOCK_IRON_DOOR_OPEN,
                         net.minecraft.sound.SoundEvents.BLOCK_IRON_DOOR_CLOSE))
                .toDoor().register();
            VANILLA.hasPortals();
            VANILLA.setPortalTranslations((pos, b) -> {
             return switch(b) {
                    case 0 -> pos.add(0.1, -0.05, -0.42); // NORTH
                    case 1, 2, 3 -> pos.add(0.43, -0.05, -0.32); // NORTH EAST p n
                    case 4 -> pos.add(0.428, -0.05, 0); // EAST
                    case 5, 6, 7 -> pos.add(0.23, -0.05, 0.32); // SOUTH EAST p p
                    case 8 -> pos.add(0, -0.25, 0.428); // SOUTH
                   case 9, 10, 11 -> pos.add(-0.23, -0.05, 0.32); // SOUTH WEST n p
                   case 12 -> pos.add(-0.428, -0.25, 0); // WEST
                   case 13, 14, 15 -> pos.add(-0.23, -0.05, -0.32); // NORTH WEST n n
                   default -> pos;
                };
         });
          VANILLA.toDoor().setPortalTranslations((pos, b) -> {
                return switch(b) {
                 case DOWN, UP -> pos;
                    case NORTH -> pos.add(0, 0.075, -0.4);
                    case SOUTH -> pos.add(0, 0.075, 0.4);
                    case WEST -> pos.add(-0.47, 0.075, 0);
                    case EAST -> pos.add(0.47, 0.075, 0);
                };
         });



        //CLOCK
        CLOCK = new AddonExterior(new Identifier(MOD_ID, "clock"), MOD_ID, "clock").register();
        CLOCK.setDoor(new AddonExterior.Door(
                        CLOCK, false, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN,
                        SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE))
                .toDoor().register();
        CLOCK.hasPortals();
        CLOCK.setPortalTranslations((pos, b) -> {
            return switch(b) {
                case 0 -> pos.add(0, -0.35, -0.37); // NORTH
                case 1, 2, 3 -> pos.add(0, -0.35, -0.37); // NORTH EAST p n
                case 4 -> pos.add(0, -0.35, 0); // EAST
                case 5, 6, 7 -> pos.add(0, -0.35, 0.37); // SOUTH EAST p p
                case 8 -> pos.add(0, -0.35, 0.37); // SOUTH
                case 9, 10, 11 -> pos.add(-0, -0.35, 0.37); // SOUTH WEST n p
                case 12 -> pos.add(-0, -0.35, 0); // WEST
                case 13, 14, 15 -> pos.add(-0, -0.35, -0.37); // NORTH WEST n n
                default -> pos;
            };
        });
        CLOCK.toDoor().setPortalTranslations((pos, b) -> {
            return switch(b) {
                case DOWN, UP -> pos;
                case NORTH -> pos.add(0, -0.2, -0.4);
                case SOUTH -> pos.add(0, -0.2, 0.4);
                case WEST -> pos.add(-0, -0.2, 0);
                case EAST -> pos.add(0, -0.2, 0);
            };
        });



        //PIXELCONSISTENT
        PIXELCONSISTENT = new AddonExterior(new Identifier(MOD_ID, "pixel_consistent"), MOD_ID, "pixel_consistent").register();
        PIXELCONSISTENT.setDoor(new AddonExterior.Door(
                        PIXELCONSISTENT, true, AITExtrasSounds.CLASSIC_BOX_DOOR_OPEN,
                        AITExtrasSounds.CLASSIC_BOX_DOOR_CLOSE))
                .toDoor().register();
        PIXELCONSISTENT.hasPortals();
        PIXELCONSISTENT.setPortalTranslations((pos, b) -> {
            return switch(b) {
                case 0 -> pos.add(0, -0.08, -0.6); // NORTH
                case 1, 2, 3 -> pos.add(0, -0.08, -0.6); // NORTH EAST p n
                case 4 -> pos.add(0, -0.08, 0.6); // EAST
                case 5, 6, 7 -> pos.add(0, -0.08, 0.6); // SOUTH EAST p p
                case 8 -> pos.add(0, -0.08, 0.685); // SOUTH
                case 9, 10, 11 -> pos.add(-0, -0.08, 0.6); // SOUTH WEST n p
                case 12 -> pos.add(-0, -0.08, 0.6); // WEST
                case 13, 14, 15 -> pos.add(-0, -0.08, -0.6); // NORTH WEST n n
                default -> pos;
            };
        });
        PIXELCONSISTENT.toDoor().setPortalTranslations((pos, b) -> {
            return switch(b) {
                case DOWN, UP -> pos;
                case NORTH -> pos.add(0, -0, -0.4);
                case SOUTH -> pos.add(0, -0, 0.4);
                case WEST -> pos.add(-0, -0, 0);
                case EAST -> pos.add(0, -0, 0);
            };
        });
    }
}
