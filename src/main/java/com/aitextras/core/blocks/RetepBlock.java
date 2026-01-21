package com.aitextras.core.blocks;

import com.aitextras.core.AITExtrasSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class RetepBlock extends Block {

    public RetepBlock(Settings settings) {
        super(settings.strength(-1.0f, 3600000.0f).emissiveLighting((state, world, pos) -> true).luminance(value -> 128)
        );
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            Vec3d mid = Vec3d.ofCenter(pos);
            float pitch = 0.5f + world.random.nextFloat() * 1.5f;

            world.playSound(
                    null,
                    mid.getX(),
                    mid.getY(),
                    mid.getZ(),
                    getSound(state),
                    SoundCategory.BLOCKS,
                    1.0f,
                    pitch
            );

            if (!player.getAbilities().creativeMode) {
                PlayerInventory inv = player.getInventory();

                for (int i = 0; i < inv.size(); i++) {
                    ItemStack stack = inv.getStack(i);

                    if (!stack.isEmpty() && stack.isOf(this.asItem())) {
                        stack.decrement(64);
                        break;
                    }
                }

                player.sendMessage(
                        Text.translatable("message.ait-extras.noretep"),
                        true
                );
            }
        }

        return ActionResult.SUCCESS;
    }



    public static SoundEvent getSound(BlockState state) {
        SoundEvent ret;;

            ret = AITExtrasSounds.RETEP;

        return ret;
    }
    }



