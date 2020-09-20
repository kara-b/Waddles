package nl.dyonb.waddles.common.entity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import nl.dyonb.waddles.registry.WaddlesConfig;
import nl.dyonb.waddles.registry.WaddlesEntities;
import nl.dyonb.waddles.registry.WaddlesSounds;
import org.jetbrains.annotations.Nullable;

public class AdeliePenguinEntity extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.ofItems(Items.COD, Items.SALMON);
    public short rotationFlipper;
    private boolean moveFlipper = false;

    public AdeliePenguinEntity(World world) {
        super(WaddlesEntities.ADELIE_PENGUIN, world);
    }

    public AdeliePenguinEntity(EntityType<? extends AdeliePenguinEntity> adelie, World world) {
        super(adelie, world);
        this.stepHeight = 1.0F;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EntityAIExtinguishFire());
        this.goalSelector.add(2, new EscapeDangerGoal(this, 1.5D));
        this.goalSelector.add(3, new AnimalMateGoal(this, 0.8D));
        this.goalSelector.add(4, new FleeEntityGoal<>(this, PolarBearEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.add(5, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.add(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(9, new LookAtEntityGoal(this, AdeliePenguinEntity.class, 6.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder getEntityAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.16D);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return this.isBaby() ? WaddlesSounds.ADELIE_BABY_AMBIENT : WaddlesSounds.ADELIE_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return WaddlesSounds.ADELIE_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return WaddlesSounds.ADELIE_DEATH;
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.world.isClient) {
            if (this.getX() != this.prevY) {
                if (this.moveFlipper) {
                    this.rotationFlipper++;
                }
            }
        }
    }

    @Override
    protected int getCurrentExperience(PlayerEntity player) {
        if (WaddlesConfig.drop_exp) {
            return super.getCurrentExperience(player);
        }
        return 0;
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack);
    }

    @Override
    protected Identifier getLootTableId() {
        return WaddlesConfig.drop_fish ? super.getLootTableId() : LootTables.EMPTY;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return WaddlesEntities.ADELIE_PENGUIN.create(this.world);
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? 0.5F : 0.9F;
    }

    private class EntityAIExtinguishFire extends EscapeDangerGoal {
        EntityAIExtinguishFire() {
            super(AdeliePenguinEntity.this, 2.0D);
        }

        @Override
        public boolean shouldContinue() {
            return AdeliePenguinEntity.this.isBaby() || AdeliePenguinEntity.this.isOnFire() && super.shouldContinue();
        }
    }
}
