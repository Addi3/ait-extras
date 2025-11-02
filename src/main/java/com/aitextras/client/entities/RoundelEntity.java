package com.aitextras.client.entities;

import com.aitextras.core.AITExtrasItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class RoundelEntity extends Entity {

    private static final TrackedData<Integer> FACING =
            DataTracker.registerData(RoundelEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> COLOR =
            DataTracker.registerData(RoundelEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Boolean> CUSTOM_GLOWING =
            DataTracker.registerData(RoundelEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public RoundelEntity(EntityType<? extends RoundelEntity> type, net.minecraft.world.World world) {
        super(type, world);
    }

    public RoundelEntity(EntityType<? extends RoundelEntity> type, net.minecraft.world.World world, BlockPos pos, Direction facing) {
        this(type, world);
        setFacing(facing);
        this.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0f, 0f);
        setBoundingBoxFromFacing();
    }

    @Override
    protected void initDataTracker() {
        dataTracker.startTracking(FACING, Direction.NORTH.getId());
        dataTracker.startTracking(COLOR, DyeColor.WHITE.getId());
        dataTracker.startTracking(CUSTOM_GLOWING, false);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Facing")) setFacing(Direction.byId(nbt.getInt("Facing")));
        if (nbt.contains("Color")) setColor(DyeColor.byId(nbt.getInt("Color")));
        if (nbt.contains("CustomGlowing")) setCustomGlowing(nbt.getBoolean("CustomGlowing"));
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putInt("Facing", getFacing().getId());
        nbt.putInt("Color", getColor().getId());
        nbt.putBoolean("CustomGlowing", isCustomGlowing());
    }

    public Direction getFacing() {
        return Direction.byId(dataTracker.get(FACING));
    }

    public void setFacing(Direction dir) {
        dataTracker.set(FACING, dir.getId());
        setBoundingBoxFromFacing();
    }

    public DyeColor getColor() {
        return DyeColor.byId(dataTracker.get(COLOR));
    }

    public void setColor(DyeColor color) {
        dataTracker.set(COLOR, color.getId());
    }

    public boolean isCustomGlowing() {
        return dataTracker.get(CUSTOM_GLOWING);
    }

    public void setCustomGlowing(boolean glowing) {
        dataTracker.set(CUSTOM_GLOWING, glowing);
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    private void setBoundingBoxFromFacing() {
        float thickness = 1.0f / 16f;
        float half = 0.5f;
        Vec3d pos = this.getPos();
        double x = pos.x;
        double y = pos.y;
        double z = pos.z;

        Box box;
        switch (getFacing()) {
            case NORTH -> box = new Box(x - half, y - half, z - thickness, x + half, y + half, z + thickness);
            case SOUTH -> box = new Box(x - half, y - half, z - thickness, x + half, y + half, z + thickness);
            case WEST  -> box = new Box(x - thickness, y - half, z - half, x + thickness, y + half, z + half);
            case EAST  -> box = new Box(x - thickness, y - half, z - half, x + thickness, y + half, z + half);
            case UP    -> box = new Box(x - half, y - thickness, z - half, x + half, y + thickness, z + half);
            case DOWN  -> box = new Box(x - half, y - thickness, z - half, x + half, y + thickness, z + half);
            default    -> box = new Box(x - half, y - half, z - half, x + half, y + half, z + half);
        }
        super.setBoundingBox(box);
    }

    @Override
    public void tick() {
        super.tick();
        if (!getWorld().isClient) {
            BlockPos attachedPos = getBlockPos().offset(getFacing().getOpposite());
            if (getWorld().isAir(attachedPos)) {
                dropItem(true);
                discard();
            }
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() instanceof DyeItem dye) {
            setColor(dye.getColor());
            if (!player.isCreative()) stack.decrement(1);
            getWorld().playSound(null, getBlockPos(), SoundEvents.ITEM_DYE_USE, SoundCategory.PLAYERS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        if (stack.isOf(Items.GLOW_INK_SAC)) {
            setCustomGlowing(true);
            if (!player.isCreative()) stack.decrement(1);
            getWorld().playSound(null, getBlockPos(), SoundEvents.ITEM_GLOW_INK_SAC_USE, SoundCategory.PLAYERS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        if (stack.isOf(Items.BRUSH)) {
            setCustomGlowing(false);
            if (!player.isCreative()) stack.decrement(1);
            getWorld().playSound(null, getBlockPos(), SoundEvents.ITEM_BRUSH_BRUSHING_GRAVEL_COMPLETE, SoundCategory.PLAYERS, 1f, 1f);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public boolean damage(net.minecraft.entity.damage.DamageSource source, float amount) {
        if (!getWorld().isClient && !isRemoved()) {
            boolean drop = true;
            if (source.getAttacker() instanceof PlayerEntity player) {
                drop = !player.isCreative();
            }
            dropItem(drop);
            discard();
            return true;
        }
        return false;
    }

    private void dropItem(boolean drop) {
        if (!drop || getWorld().isClient) return;
        ItemStack stack = new ItemStack(AITExtrasItems.HEXAGON);
        getWorld().spawnEntity(new net.minecraft.entity.ItemEntity(getWorld(), getX(), getY(), getZ(), stack));
    }
}
