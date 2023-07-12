
package net.lepidodendron.entity;

import net.ilexiconn.llibrary.client.model.tools.ChainBuffer;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronMod;
import net.lepidodendron.entity.ai.EatFishFoodAIAgeable;
import net.lepidodendron.entity.ai.EntityMateAIAgeableBase;
import net.lepidodendron.entity.ai.NautiloidWanderBottomFeed;
import net.lepidodendron.entity.base.EntityPrehistoricFloraNautiloidBase;
import net.lepidodendron.entity.util.EnumCreatureAttributePN;
import net.lepidodendron.item.ItemFishFood;
import net.lepidodendron.item.entities.ItemNautiloidEggsCameroceras;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntityPrehistoricFloraCameroceras extends EntityPrehistoricFloraNautiloidBase {

	public BlockPos currentTarget;
	@SideOnly(Side.CLIENT)
	public ChainBuffer chainBuffer;

	public EntityPrehistoricFloraCameroceras(World world) {
		super(world);
		setSize(1.5F, 1.5F);
		minWidth = 0.1F;
		maxWidth = 1.5F;
		maxHeight = 1.5F;
		maxHealthAgeable = 32;
	}

	@Override
	public EnumCreatureAttributePN getPNCreatureAttribute() {
		return EnumCreatureAttributePN.INVERTEBRATE;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		if (LepidodendronConfig.renderBigMobsProperly) {
			return this.getEntityBoundingBox().grow(5, 0.1, 5);
		}
		return this.getEntityBoundingBox();
	}

	@Override
	public boolean isSmall() {
		return this.getAgeScale() < 0.2;
	}

	public static String getPeriod() {return "Ordovician - [Silurian]";}

	//public static String getHabitat() {return "Aquatic";}

	@Override
	public boolean dropsEggs() {
		return false;
	}
	
	@Override
	public boolean laysEggs() {
		return false;
	}

	@Override
	public int getAdultAge() {
		return 72000;
	}

	@Override
	protected float getAISpeedNautiloid() {
		return 0.1f;
	}

	protected void initEntityAI() {
		tasks.addTask(0, new EntityMateAIAgeableBase(this, 1));
		tasks.addTask(1, new NautiloidWanderBottomFeed(this, NO_ANIMATION));
		this.targetTasks.addTask(0, new EatFishFoodAIAgeable(this));
	}

	@Override
	public boolean isBreedingItem(ItemStack stack)
	{
		return (stack.getItem() == new ItemStack(ItemFishFood.block, (int) (1)).getItem());
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public String getTexture() {
		return this.getTexture();
	}

	@Override
	public SoundEvent getAmbientSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return (SoundEvent) SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
	}

	public void onEntityUpdate() {
		super.onEntityUpdate();
		//Drop an egg perhaps:
		if (!world.isRemote && this.isPFAdult() && this.getCanBreed() && (LepidodendronConfig.doMultiplyMobs || this.getLaying())) {
			if (Math.random() > 0.5) {
				ItemStack itemstack = new ItemStack(ItemNautiloidEggsCameroceras.block, (int) (1));
				EntityItem entityToSpawn = new EntityItem(world, this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ(), itemstack);
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
			this.setTicks(0);
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		//this.renderYawOffset = this.rotationYaw;
		if (this.isEntityAlive() && isInWater()) {
			if (this.isAtBottom()) {
				//Feeding from bottom pose:
				BlockPos posIn = this.getPosition();
				World worldIn = this.world;
				//worldIn.playSound(player, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
				if (worldIn instanceof WorldServer) {
					if (Math.random() > 0.3) {
						for (int k = 0; k < 8; ++k) {
							((WorldServer) worldIn).spawnParticle(EnumParticleTypes.WATER_BUBBLE, posIn.getX(), posIn.getY(), posIn.getZ(), (int) 1, 1, 1, 1, 0.2, new int[0]);
						}
					}
					if (Math.random() > 0.4) {
						for (int k = 0; k < 4; ++k) {
							((WorldServer) worldIn).spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posIn.getX(), posIn.getY(), posIn.getZ(), (int) 1, 1, 1, 1, 0.1, new int[0]);
						}
					}
				}
			}
		}
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		if (!this.isPFAdult()) {
			return LepidodendronMod.CAMEROCERAS_LOOT_YOUNG;
		}
		return LepidodendronMod.CAMEROCERAS_LOOT;
	}

}
