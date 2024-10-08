
package net.lepidodendron.block;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.block.base.IPottable;
import net.minecraft.block.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockFlowerpotPN extends BlockFlowerPot {

	public BlockFlowerpotPN()
	{
		super();
		this.setDefaultState(this.blockState.getBaseState().withProperty(CONTENTS, BlockFlowerPot.EnumFlowerType.EMPTY).withProperty(LEGACY_DATA, Integer.valueOf(0)));
		setSoundType(SoundType.STONE);
	}


	@Override
	public String getLocalizedName()
	{
		return I18n.translateToLocal("item.flowerPot.name");
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return FLOWER_POT_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity == null || (!(tileentity instanceof TileEntityFlowerPotPN))) {
			return false;
		}

		TileEntityFlowerPotPN tileentityflowerpot = (TileEntityFlowerPotPN) tileentity;
		if (tileentityflowerpot == null) {
			return false;
		} else {
			ItemStack itemstack1 = tileentityflowerpot.getFlowerItemStack();

			if (itemstack1.isEmpty()) {
				if (!this.canBePotted(itemstack)) {
					return false;
				}

				tileentityflowerpot.setItemStack(itemstack);
				playerIn.addStat(StatList.FLOWER_POTTED);

				if (!playerIn.capabilities.isCreativeMode) {
					itemstack.shrink(1);
				}
			} else {
				if (itemstack.isEmpty()) {
					playerIn.setHeldItem(hand, itemstack1);
				} else if (!playerIn.addItemStackToInventory(itemstack1)) {
					playerIn.dropItem(itemstack1, false);
				}

				tileentityflowerpot.setItemStack(ItemStack.EMPTY);
			}

			tileentityflowerpot.markDirty();
			worldIn.notifyBlockUpdate(pos, state, state, 3);
			return true;
		}
	}

	private boolean canBePotted(ItemStack stack) {

		//Special placing items:
		if (stack.getItem() instanceof IPottable) {
			return true;
		}

		//Inter-mod compats:
		for (String resourcelocation : LepidodendronConfig.genFlowerpotExtras) {
			int meta;
			//Is there a metadata tag? If so, keep it and strip it out of the string:
			int strPos = resourcelocation.indexOf(":", resourcelocation.indexOf(":") + 1);
			if (strPos > 0) {
				meta = (int) Integer.parseInt(resourcelocation.substring(strPos + 1));
				resourcelocation = resourcelocation.substring(0, strPos);
			} else {
				meta = 0;
			}
			if (stack.getItem().getRegistryName().toString().equalsIgnoreCase(resourcelocation)) {
				//This matches
				if (stack.getMetadata() == meta) {
					//This also matches
					return true;
				}
			}
		}

		Block block = Block.getBlockFromItem(stack.getItem());

		if (block instanceof IPottable) {
			return true;
		}
		if (block != Blocks.YELLOW_FLOWER && block != Blocks.RED_FLOWER && block != Blocks.CACTUS && block != Blocks.BROWN_MUSHROOM && block != Blocks.RED_MUSHROOM && block != Blocks.SAPLING && block != Blocks.DEADBUSH) {
			int i = stack.getMetadata();
			return block == Blocks.TALLGRASS && i == BlockTallGrass.EnumType.FERN.getMeta();
		} else {
			return true;
		}
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		//TileEntityFlowerPotPN tileentityflowerpot = this.getTileEntity(worldIn, pos);

		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity == null || (!(tileentity instanceof TileEntityFlowerPotPN))) {
			return ItemStack.EMPTY;
		}

		TileEntityFlowerPotPN tileentityflowerpot = (TileEntityFlowerPotPN) tileentity;

		if (tileentityflowerpot != null) {
			ItemStack itemstack = tileentityflowerpot.getFlowerItemStack();

			if (!itemstack.isEmpty()) {
				return itemstack;
			}
		}

		return new ItemStack(Items.FLOWER_POT);
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState downState = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos) && (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		IBlockState downState = worldIn.getBlockState(pos.down());
		if (!downState.isTopSolid() && downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) != BlockFaceShape.SOLID) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		super.onBlockHarvested(worldIn, pos, state, player);

		if (player.capabilities.isCreativeMode) {
//			TileEntityFlowerPotPN tileentityflowerpot = this.getTileEntity(worldIn, pos);

			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity == null || (!(tileentity instanceof TileEntityFlowerPotPN))) {
				return;
			}

			TileEntityFlowerPotPN tileentityflowerpot = (TileEntityFlowerPotPN) tileentity;

			if (tileentityflowerpot != null) {
				tileentityflowerpot.setItemStack(ItemStack.EMPTY);
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.FLOWER_POT;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new BlockFlowerpotPN.TileEntityFlowerPotPN();
	}

	public BlockFlowerpotPN.TileEntityFlowerPotPN createNewTileEntity(World worldIn, int meta) {
		return new BlockFlowerpotPN.TileEntityFlowerPotPN();
	}

	@Override
	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
		super.eventReceived(state, worldIn, pos, eventID, eventParam);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
	}


//	@Override
//	public TileEntity createNewTileEntity(World worldIn, int meta) {
//		Block block = null;
//		int i = 0;
//
//		switch (meta)
//		{
//			case 1:
//				block = Blocks.RED_FLOWER;
//				i = BlockFlower.EnumFlowerType.POPPY.getMeta();
//				break;
//			case 2:
//				block = Blocks.YELLOW_FLOWER;
//				break;
//			case 3:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.OAK.getMetadata();
//				break;
//			case 4:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.SPRUCE.getMetadata();
//				break;
//			case 5:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.BIRCH.getMetadata();
//				break;
//			case 6:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.JUNGLE.getMetadata();
//				break;
//			case 7:
//				block = Blocks.RED_MUSHROOM;
//				break;
//			case 8:
//				block = Blocks.BROWN_MUSHROOM;
//				break;
//			case 9:
//				block = Blocks.CACTUS;
//				break;
//			case 10:
//				block = Blocks.DEADBUSH;
//				break;
//			case 11:
//				block = Blocks.TALLGRASS;
//				i = BlockTallGrass.EnumType.FERN.getMeta();
//				break;
//			case 12:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.ACACIA.getMetadata();
//				break;
//			case 13:
//				block = Blocks.SAPLING;
//				i = BlockPlanks.EnumType.DARK_OAK.getMetadata();
//		}
//		if (i > 0) {
//			return new TileEntityFlowerPotPN(Item.getItemFromBlock(block), i);
//		}
//		else {
//			return new TileEntityFlowerPotPN();
//		}
//	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {CONTENTS, LEGACY_DATA});
	}

	public int getMetaFromState(IBlockState state)
	{
		return ((Integer)state.getValue(LEGACY_DATA)).intValue();
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		BlockFlowerPot.EnumFlowerType blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
		TileEntity tileentity = worldIn instanceof ChunkCache ? ((ChunkCache)worldIn).getTileEntity(pos, Chunk.EnumCreateEntityType.CHECK) : worldIn.getTileEntity(pos);

		if (tileentity instanceof TileEntityFlowerPotPN)
		{
			TileEntityFlowerPotPN tileentityflowerpot = (TileEntityFlowerPotPN)tileentity;
			Item item = tileentityflowerpot.getFlowerPotItem();

			if (item instanceof ItemBlock)
			{
				int i = tileentityflowerpot.getFlowerPotData();
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.SAPLING)
				{
					switch (BlockPlanks.EnumType.byMetadata(i))
					{
						case OAK:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.OAK_SAPLING;
							break;
						case SPRUCE:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.SPRUCE_SAPLING;
							break;
						case BIRCH:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.BIRCH_SAPLING;
							break;
						case JUNGLE:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.JUNGLE_SAPLING;
							break;
						case ACACIA:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ACACIA_SAPLING;
							break;
						case DARK_OAK:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DARK_OAK_SAPLING;
							break;
						default:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				}
				else if (block == Blocks.TALLGRASS)
				{
					switch (i)
					{
						case 0:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
							break;
						case 2:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.FERN;
							break;
						default:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				}
				else if (block == Blocks.YELLOW_FLOWER)
				{
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DANDELION;
				}
				else if (block == Blocks.RED_FLOWER)
				{
					switch (BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, i))
					{
						case POPPY:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.POPPY;
							break;
						case BLUE_ORCHID:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.BLUE_ORCHID;
							break;
						case ALLIUM:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ALLIUM;
							break;
						case HOUSTONIA:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.HOUSTONIA;
							break;
						case RED_TULIP:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.RED_TULIP;
							break;
						case ORANGE_TULIP:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.ORANGE_TULIP;
							break;
						case WHITE_TULIP:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.WHITE_TULIP;
							break;
						case PINK_TULIP:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.PINK_TULIP;
							break;
						case OXEYE_DAISY:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.OXEYE_DAISY;
							break;
						default:
							blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.EMPTY;
					}
				}
				else if (block == Blocks.RED_MUSHROOM)
				{
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.MUSHROOM_RED;
				}
				else if (block == Blocks.BROWN_MUSHROOM)
				{
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.MUSHROOM_BROWN;
				}
				else if (block == Blocks.DEADBUSH)
				{
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.DEAD_BUSH;
				}
				else if (block == Blocks.CACTUS)
				{
					blockflowerpot$enumflowertype = BlockFlowerPot.EnumFlowerType.CACTUS;
				}
			}
		}

		return state.withProperty(CONTENTS, blockflowerpot$enumflowertype);
	}


	/*============================FORGE START=====================================*/
	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : RANDOM;

		int count = quantityDropped(state, fortune, rand);
		for (int i = 0; i < count; i++)
		{
			Item item = this.getItemDropped(state, rand, fortune);
			if (item != Items.AIR)
			{
				drops.add(new ItemStack(item, 1, this.damageDropped(state)));
			}
		}
		TileEntityFlowerPotPN te = world.getTileEntity(pos) instanceof TileEntityFlowerPotPN ? (TileEntityFlowerPotPN) world.getTileEntity(pos) : null;
		if (te != null && te.getFlowerPotItem() != null)
			drops.add(new ItemStack(te.getFlowerPotItem(), 1, te.getFlowerPotData()));
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
		if (willHarvest) return true; //If it will harvest, delay deletion of the block until after getDrops
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack tool) {
		super.harvestBlock(world, player, pos, state, te, tool);
		world.setBlockToAir(pos);
	}

//	@Override
//	public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
//		super.eventReceived(state, worldIn, pos, eventID, eventParam);
//		TileEntity tileentity = worldIn.getTileEntity(pos);
//		return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
//	}

	public static class TileEntityFlowerPotPN extends TileEntityFlowerPot {

		@Override
		public AxisAlignedBB getRenderBoundingBox() {
			return new AxisAlignedBB(pos.add(-1, 0, -1), pos.add(2, 3, 2));
		}
	}
}
