package com.aitextras.mixin.client;


import com.aitextras.AITExtras;
import com.aitextras.core.item.DifferingHandModelItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Final
    @Shadow
    private ItemModels models;

    @Inject(method = "getModel(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;I)Lnet/minecraft/client/render/model/BakedModel;", at = @At("HEAD"), cancellable = true)
    private void aitextras$getModel(ItemStack stack, World world, LivingEntity entity, int seed, CallbackInfoReturnable<BakedModel> cir) {
        if (stack.getItem() instanceof DifferingHandModelItem) {
            BakedModel bakedModel = this.models.getModelManager().getModel(new ModelIdentifier(AITExtras.MOD_ID, Registries.ITEM.getId(stack.getItem()).getPath(), "inventory"));
            ClientWorld clientWorld = world instanceof ClientWorld ? (ClientWorld)world : null;
            BakedModel bakedModel2 = bakedModel.getOverrides().apply(bakedModel, stack, clientWorld, entity, seed);
            cir.setReturnValue(bakedModel2 == null ? this.models.getModelManager().getMissingModel() : bakedModel2);
        }
    }

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel aitextras$renderMarshmallowStick(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.getItem() instanceof DifferingHandModelItem && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return this.models.getModelManager().getModel(new ModelIdentifier(AITExtras.MOD_ID, "handheld_" + Registries.ITEM.getId(stack.getItem()).getPath(), "inventory"));
        }
        return value;
    }
}