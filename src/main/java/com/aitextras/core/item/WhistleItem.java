package com.aitextras.core.item;

import static dev.amble.ait.core.tardis.handler.travel.TravelHandlerBase.State.LANDED;

import java.util.List;

import com.aitextras.core.AITExtrasSounds;
import dev.amble.ait.core.world.TardisServerWorld;
import dev.amble.lib.data.CachedDirectedGlobalPos;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.world.World;

import dev.amble.ait.api.tardis.link.LinkableItem;
import dev.amble.ait.core.tardis.Tardis;
import dev.amble.ait.core.tardis.control.impl.DirectionControl;
import dev.amble.ait.core.tardis.handler.travel.TravelUtil;

public class WhistleItem extends LinkableItem {

    public WhistleItem(Settings settings) {
        super(settings, true);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if (player == null)
            return ActionResult.PASS;

        if (!(world instanceof ServerWorld serverWorld))
            return ActionResult.PASS;

        Tardis tardis = WhistleItem.getTardisStatic(world, itemStack);

        if (tardis == null)
            return ActionResult.FAIL;

        if (tardis.getFuel() <= 0)
            player.sendMessage(Text.translatable("message.ait.remoteitem.warning1"));

        if (tardis.isRefueling())
            player.sendMessage(Text.translatable("message.ait.remoteitem.cancel.refuel"));

        CachedDirectedGlobalPos currentPosition = tardis.travel().position();

        if (currentPosition.getPos().equals(pos))
            return ActionResult.FAIL;

        if (!TardisServerWorld.isTardisDimension((ServerWorld) world)) {
            world.playSound(null, pos, AITExtrasSounds.WHISTLE, SoundCategory.BLOCKS);

            BlockPos temp = pos.up();

            if (world.getBlockState(pos).isReplaceable())
                temp = pos;

            tardis.travel().speed(tardis.travel().maxSpeed().get());

            TravelUtil.travelTo(tardis, CachedDirectedGlobalPos.create(serverWorld, temp, DirectionControl
                    .getGeneralizedRotation(RotationPropertyHelper.fromYaw(player.getBodyYaw()))));
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1F,
                    0.2F);
            player.sendMessage(Text.translatable("message.ait.remoteitem.warning3"), true);
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        Tardis tardis = WhistleItem.getTardisStatic(world, stack);

        if (tardis == null)
            return;

        if (tardis.travel().getState() != LANDED)
            tooltip.add(Text.literal("→ " + tardis.travel().getDurationAsPercentage() + "%")
                    .formatted(Formatting.AQUA));
    }
}
