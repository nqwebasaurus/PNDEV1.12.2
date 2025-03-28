
package net.lepidodendron.entity;

import com.google.common.base.Predicate;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.block.base.IAdvancementGranter;
import net.lepidodendron.entity.ai.*;
import net.lepidodendron.entity.base.EntityPrehistoricFloraLandClimbingFlyingWalkingBase;
import net.lepidodendron.entity.util.IGuano;
import net.lepidodendron.entity.util.IScreamerFlier;
import net.lepidodendron.entity.util.ITrappableLand;
import net.lepidodendron.util.CustomTrigger;
import net.lepidodendron.util.ModTriggers;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.util.List;

public class EntityPrehistoricFloraSordes extends EntityPrehistoricFloraLandClimbingFlyingWalkingBase implements IAdvancementGranter, IScreamerFlier, IGuano, ITrappableLand {

	private boolean screaming;
	public int screamAlarmCooldown;

	public EntityPrehistoricFloraSordes(World world) {
		super(world);
		setSize(0.65F, 0.45F);
		minWidth = 0.10F;
		maxWidth = 0.65F;
		maxHeight = 0.45F;
		maxHealthAgeable = 6;
		setNoAI(!true);
		enablePersistence();
	}

	@Override
	public int getTalkInterval() {
		return 90;
	}

	@Override
	public boolean homesToNest() {
		return true;
	}

	@Override
	public int flyTransitionLength() {
		return 18;
	}

	@Override
	public int unflyTransitionLength() {
		return 18;
	}

	@Override
	public boolean canFloat() {
		return false;
	}

	@Override
	public boolean checkFlyConditions() {
		return this.world.isDaytime();
	}

	public boolean hasAlarm() {
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource ds, float i) {
		Entity e = ds.getTrueSource();
		if (e instanceof EntityLivingBase && this.hasAlarm() && !this.world.isRemote) {
			EntityLivingBase ee = (EntityLivingBase) e;
			this.setAlarmTarget(ee);
			List<EntityPrehistoricFloraSordes> pterodactylus = this.world.getEntitiesWithinAABB(EntityPrehistoricFloraSordes.class, new AxisAlignedBB(this.getPosition().add(-8, -4, -8), this.getPosition().add(8, 4, 8)));
			for (EntityPrehistoricFloraSordes currentPterodactylus : pterodactylus) {
				currentPterodactylus.setAnimation(NO_ANIMATION);
				currentPterodactylus.setAlarmTarget(ee);
				currentPterodactylus.setRevengeTarget(ee);
				currentPterodactylus.screamAlarmCooldown = rand.nextInt(20);
				currentPterodactylus.setFlying();
			}
		}
		return super.attackEntityFrom(ds, i);
	}

	public void setScreaming(boolean screaming) {
		this.screaming = screaming;
	}

	public boolean getScreaming() {
		return this.screaming;
	}

	@Override
	public float getClimbSpeed() {
		return 0.0035F;
	}

	@Override
	public ResourceLocation FlightSound() {
		return null;
	}

	@Nullable
	@Override
	public CustomTrigger getModTrigger() {
		return ModTriggers.CLICK_SORDES;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		if (!this.isPFAdult()) {
			return LepidodendronMod.SORDES_LOOT_YOUNG;
		}
		return LepidodendronMod.SORDES_LOOT;
	}

	@Override
	public int getAdultAge() {
		return 64000;
	}


	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (this.getAnimation() == ATTACK_ANIMATION && this.getAnimationTick() == 8 && this.getAttackTarget() != null) {
			launchAttack();
		}

		AnimationHandler.INSTANCE.updateAnimations(this);

	}

	@Override
	public boolean canJar() {
		return false;
	}

	public static String getPeriod() {return "Jurassic";}

	//public static String getHabitat() {return "Terrestrial";}

	@Override
	public boolean dropsEggs() {
		return false;
	}

	@Override
	public boolean laysEggs() {
		return true;
	}

	@Override
	public boolean placesNest() {
		return true;
	}

	@Override
	public boolean hasNest() {
		return true;
	}

	public boolean testLay(World world, BlockPos pos) {
		return (
				nestBlockMatch(world, pos)
		);
	}

	@Override
	public boolean nestBlockMatch(World world, BlockPos pos) {
		if (isLayableNest(world, pos)) {
			return true;
		}
		return world.getBlockState(pos.down()).getBlockFaceShape(world, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID;
	}

	@Override
	public boolean canSpawnOnLeaves() {
		return true;
	}

	@Override
	public float getAISpeedLand() {
		if (this.getTicks() < 0) {
			return 0.0F; //Is laying eggs
		}
		if (this.getAttachmentPos() != null) {
			if (this.getAttachmentFacing() == EnumFacing.UP) {
				return 0.266F;
			}
		}
		//Otherwise we are flying:
		if (this.getIsFast()) {
			return 1.065f;
		}
		return 0.565f;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6);
		//this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	public String getTexture() {
		return this.getTexture();
	}

	@Override
	public int getRoarLength() {
		return 12;
	}

	@Override
	public int getAttackLength() {
		return 12;
	}

	@Override
	public void playLivingSound() {
		if (this.getAnimation() == NO_ANIMATION && ((this.getAttachmentPos() != null && this.checkFlyConditions())
				|| this.getAttachmentPos() == null)) {
			if (!this.world.isRemote) {
				this.setAnimation(ROAR_ANIMATION);
				SoundEvent soundevent = this.getAmbientSound();
				if (soundevent != null)
				{
					this.playSound(soundevent, this.getSoundVolume(), this.getSoundPitch());
				}
			}
		}
	}

	@Override
	public SoundEvent getAmbientSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("lepidodendron:sordes_idle"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("lepidodendron:sordes_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("lepidodendron:sordes_death"));
	}

	public SoundEvent getAlarmSound() {
		return (SoundEvent) SoundEvent.REGISTRY
				.getObject(new ResourceLocation("lepidodendron:sordes_alarm"));
	}

	public void playAlarmSound()
	{
		SoundEvent soundevent = this.getAlarmSound();
		//System.err.println("looking for alarm sound");
		if (soundevent != null)
		{
			//System.err.println("playing alarm sound");
			this.playSound(soundevent, this.getSoundVolume(), this.getSoundPitch());
			this.screamAlarmCooldown = 25;
		}
	}

	@Override
	public String[] getFoodOreDicts() {
		return ArrayUtils.addAll(DietString.BUG);
	}

	protected void initEntityAI() {
		tasks.addTask(0, new EntityMateAIAgeableBase(this, 1.0D));
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(2, new AttackAI(this, 1.0D, false, this.getAttackLength()));
		tasks.addTask(3, new PanicScreamAI(this, 1.5F));
		tasks.addTask(4, new LandWanderNestInBlockAI(this));
		tasks.addTask(5, new LandWanderAvoidWaterAI(this, 1.0D, 20));
		tasks.addTask(6, new AgeableClimbingFlyingWalkingFlyHigh(this, true));
		tasks.addTask(7, new LandClimbingFlyingWalkingBaseWanderFlightNearGroundAI(this, false, false));
		tasks.addTask(8, new EntityLookIdleAI(this));
		this.targetTasks.addTask(0, new EatItemsEntityPrehistoricFloraAgeableBaseAI(this, 1));
		this.targetTasks.addTask(1, new HuntForDietEntityPrehistoricFloraAgeableBaseAI(this, EntityLivingBase.class, true, (Predicate<Entity>) entity -> entity instanceof EntityLivingBase, 0.1F, 1.2F, false));
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if (this.getAnimation() == NO_ANIMATION) {
			this.setAnimation(ATTACK_ANIMATION);
			//System.err.println("set attack");
		}
		return false;
	}

	@Override
	public void onEntityUpdate() {
		if (this.screamAlarmCooldown > 0) {
			this.screamAlarmCooldown -= 1;
		}
		if (this.getScreaming() && screamAlarmCooldown <= 0) {
			this.playAlarmSound();
		}

		super.onEntityUpdate();
	}

//	@Override
//	public String getEntityId(Entity entity) {
//		return "lepidodendron:prehistoric_flora_pterodactylus";
//	}

	@Override
	public int getEggType(@Nullable String variantIn) { //0-3
		return 0; //Small eggs
	}


	//Rendering taxidermy:
	//--------------------

}