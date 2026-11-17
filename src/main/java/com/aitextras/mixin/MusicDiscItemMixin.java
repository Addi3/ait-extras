package com.aitextras.mixin;

import com.aitextras.core.AITExtrasBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.MusicDiscItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MusicDiscItem.class)
public class MusicDiscItemMixin {

    @Redirect(
            method = "useOnBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"
            )
    )
    private boolean aitExtras$allowCustomJukebox(BlockState state, Block block) {
        return state.isOf(Blocks.JUKEBOX) || state.isOf(AITExtrasBlocks.JUKEBOX) ;
    }
}