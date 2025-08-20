package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import dev.amble.ait.api.tardis.link.v2.block.InteriorLinkableBlockEntity;
import dev.amble.ait.client.tardis.ClientTardis;
import dev.amble.ait.core.AITSounds;
import dev.amble.ait.core.tardis.Tardis;
import dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class CrystalBlockEntity extends InteriorLinkableBlockEntity {

    public CrystalBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.CRYSTAL_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }


    public final AnimationState ANIM_STATE = new AnimationState();

    public int age;

    public int getAge() {
        return age;
    }

    @Override
    public void onLinked() {
        if (this.tardis().isEmpty())
            return;

        Tardis tardis = this.tardis().get();

        if (tardis instanceof ClientTardis)
            return;

        tardis.getDesktop().getConsolePos().add(this.pos);
        tardis.asServer().markDirty(tardis.getDesktop());
    }


//    public void tick(World world, BlockPos pos, BlockState blockState, CrystalBlockEntity blockEntity) {
//        if (!(world instanceof ServerWorld)) {
//            if (!blockEntity.isLinked()) return;
//            Tardis tardis = blockEntity.tardis().get();
//
//            TravelHandlerBase.State state = tardis.travel().getState();
//
//            this.age++;
//
//            ANIM_STATE.startIfNotRunning(this.getAge());
//
//            switch (state) {
//                case FLIGHT -> {
//
//                    }
//                }
//
//            }
//        }
    }


