
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.block.base.IAdvancementGranter;
import net.lepidodendron.item.ItemIraniaItem;
import net.lepidodendron.util.CustomTrigger;
import net.lepidodendron.util.ModTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockIraniaLand extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:irania_land")
	public static final Block block = null;
	public BlockIraniaLand(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.irania);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom());
	}

	public static final PropertyBool VAR = PropertyBool.create("var");

	public static class BlockCustom extends BlockBush implements IAdvancementGranter {
		public BlockCustom() {
			setSoundType(SoundType.PLANT);
			setHardness(0F);
			setResistance(0F);
			setLightLevel(0F);
			setTranslationKey("pf_irania_land");
			setRegistryName("irania_land");
			this.setDefaultState(this.blockState.getBaseState().withProperty(VAR, false));
		}

		@Nullable
		@Override
		public CustomTrigger getModTrigger() {
			return ModTriggers.CLICK_IRANIA;
		}

		@Override
		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
			super.updateTick(worldIn, pos, state, random);
			this.neighborChanged(state, worldIn, pos, BlockIrania3.block, pos.up(2));
		}

		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
			//super.neighborChanged(state, world, pos, neighborBlock, fromPos);
			{
				if (!this.canBlockStay(world, pos, state))
				{
					world.scheduleUpdate(pos, this, 1);
				}
			}
			if (world.getBlockState(pos.up(2)).getBlock() != BlockIrania3.block
				&& world.getBlockState(pos.up(2)).getBlock() != BlockIrania3Var.block) {
				world.destroyBlock(pos, false);
			}
		}

		public static boolean canSurviveAt(World worldIn, BlockPos pos) {
			if ((worldIn.getBlockState(pos.down()).getMaterial() != Material.SAND) &&
					(worldIn.getBlockState(pos.down()).getMaterial() != Material.CLAY) &&
					(worldIn.getBlockState(pos.down()).getMaterial() != Material.GROUND) &&
					(worldIn.getBlockState(pos.down()).getMaterial() != Material.GRASS)) {
				return false;
			}

			if (!(worldIn.getBlockState(pos.down()).getBlock().isFullCube(worldIn.getBlockState(pos.down()))))
			{
				return false;
			}
			return true;
		}

		@Override
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
			boolean isVar = false;
			if ((double) (pos.getX() + pos.getZ())/3 == (int) (pos.getX() + pos.getZ())/3) {
				isVar = true;
			}
			if (isVar) {
				if ((!worldIn.isAirBlock(pos.up()))
						|| (!worldIn.isAirBlock(pos.up(2)))
						|| (!worldIn.isAirBlock(pos.up(3)))
						|| (!worldIn.isAirBlock(pos.up(4)))
				) {
					return false;
				}
			}
			else {
				if ((!worldIn.isAirBlock(pos.up()))
						|| (!worldIn.isAirBlock(pos.up(2)))
						|| (!worldIn.isAirBlock(pos.up(3)))
				) {
					return false;
				}
			}
			return super.canPlaceBlockAt(worldIn, pos);
		}

		@Override
		public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
			super.onBlockAdded(worldIn, pos, state);
			boolean isVar = false;
			if ((double) (pos.getX() + pos.getZ())/3 == (int) (pos.getX() + pos.getZ())/3) {
				isVar = true;
			}
			if (isVar) {
				worldIn.setBlockState(pos.up(2), BlockIrania3Var.block.getDefaultState(), 2);
				worldIn.setBlockState(pos.up(3), BlockIrania4Var.block.getDefaultState(), 2);
				worldIn.setBlockState(pos.up(4), BlockIrania5Var.block.getDefaultState(), 2);
			}
			else {
				worldIn.setBlockState(pos.up(2), BlockIrania3.block.getDefaultState(), 2);
				worldIn.setBlockState(pos.up(3), BlockIrania4.block.getDefaultState(), 2);
			}
		}

		public static void onBlockAddedWorldgen(World worldIn, BlockPos pos, IBlockState state) {
			boolean isVar = false;
			if ((double) (pos.getX() + pos.getZ())/3 == (int) (pos.getX() + pos.getZ())/3) {
				isVar = true;
			}
			if (isVar) {
				worldIn.setBlockState(pos.up(2), BlockIrania3Var.block.getDefaultState(), 2);
				worldIn.setBlockState(pos.up(3), BlockIrania4Var.block.getDefaultState(), 2);
				if (worldIn.rand.nextInt(5) == 0) {
					worldIn.setBlockState(pos.up(4), BlockIrania5FlowerVar.block.getDefaultState(), 2);
				}
				else {
					worldIn.setBlockState(pos.up(4), BlockIrania5Var.block.getDefaultState(), 2);
				}
			}
			else {
				worldIn.setBlockState(pos.up(2), BlockIrania3.block.getDefaultState(), 2);
				if (worldIn.rand.nextInt(5) == 0) {
					worldIn.setBlockState(pos.up(3), BlockIrania4Flower.block.getDefaultState(), 2);
				}
				else {
					worldIn.setBlockState(pos.up(3), BlockIrania4.block.getDefaultState(), 2);
				}
			}
		}

		@Override
		public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
			super.onBlockAdded(worldIn, pos, state);
			boolean isVar = false;
			if ((double) (pos.getX() + pos.getZ())/3 == (int) (pos.getX() + pos.getZ())/3) {
				isVar = true;
			}
			if (isVar) {
				worldIn.scheduleUpdate(pos.up(2), BlockIrania3Var.block, 0);
			}
			else {
				worldIn.scheduleUpdate(pos.up(2), BlockIrania3.block, 0);
			}
		}

		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
		{
			boolean boolVar = false;
			if ((double) (pos.getX() + pos.getZ())/3 == (int) (pos.getX() + pos.getZ())/3) {
				boolVar = true;
			}
			return state.withProperty(VAR, boolVar);
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{VAR});
		}

		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState();
		}

		public int getMetaFromState(IBlockState state) {
			return 0;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getRenderLayer()
		{
			return BlockRenderLayer.CUTOUT;
		}

		@Override
		@Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return new AxisAlignedBB(0,0,0,1,2,1);
		}

		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0,0,0,1,2,1);
		}

		@Override
		public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
			AxisAlignedBB axisalignedbb = new AxisAlignedBB(0,0,0,1,2,1).offset(pos);
			if (entityBox.intersects(axisalignedbb))
			{
				collidingBoxes.add(axisalignedbb);
			}
		}

		@Override
		public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
			if (stack.getItem() == Items.SHEARS && LepidodendronConfig.doPropagation
					&&
					(worldIn.getBlockState(pos.down()).getMaterial() == Material.GROUND
							|| worldIn.getBlockState(pos.down()).getMaterial() == Material.SAND
							|| worldIn.getBlockState(pos.down()).getMaterial() == Material.ROCK
							|| worldIn.getBlockState(pos.down()).getMaterial() == Material.CLAY
							|| worldIn.getBlockState(pos.down()).getMaterial() == Material.GRASS
					)
			) {
				EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemIraniaItem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				worldIn.spawnEntity(entityToSpawn);
			}
			else {
				super.harvestBlock(worldIn, player, pos, state, te, stack);
			}
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 100;
		}

		@Override
		public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 60;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			if (LepidodendronConfig.doPropagation) {
				drops.add(new ItemStack(Blocks.AIR, (int) (1)));
			}
			else {
				drops.add(new ItemStack(ItemIraniaItem.block, (int) (1)));
			}
		}

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(ItemIraniaItem.block, (int) (1));
		}

		@Override
		public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
			return EnumPlantType.Plains;
		}

	}
	
}

