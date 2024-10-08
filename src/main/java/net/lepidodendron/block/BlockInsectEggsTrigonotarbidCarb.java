
package net.lepidodendron.block;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronSorter;
import net.lepidodendron.entity.EntityPrehistoricFloraTrigonotarbid_Cryptomartus;
import net.lepidodendron.entity.EntityPrehistoricFloraTrigonotarbid_Eophrynus;
import net.lepidodendron.entity.EntityPrehistoricFloraTrigonotarbid_Gondwanarachne;
import net.lepidodendron.entity.EntityPrehistoricFloraTrigonotarbid_Kreischeria;
import net.lepidodendron.entity.base.EntityPrehistoricFloraAgeableBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockInsectEggsTrigonotarbidCarb extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:insect_eggs_trigonotarbid_carb")
	public static final Block block = null;
	public BlockInsectEggsTrigonotarbidCarb(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.insect_eggs_trigonotarbid_carb);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("insect_eggs_trigonotarbid_carb"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerTileEntity(BlockInsectEggsTrigonotarbidCarb.TileEntityCustom.class, "lepidodendron:tileentityinsect_eggs_trigonotarbid_carb");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:insect_eggs_trigonotarbid_carb", "inventory"));
	}

	public static class BlockCustom extends BlockInsectEggs {
		public BlockCustom() {
			setTranslationKey("pf_insect_eggs_trigonotarbid_carb");
			this.setTickRandomly(true);
			setCreativeTab(null);
		}

		@Override
		public void breakBlock(World world, BlockPos pos, IBlockState state) {
			world.removeTileEntity(pos);
			super.breakBlock(world, pos, state);
		}

		@Override
		public boolean hasTileEntity(IBlockState state) {
			return true;
		}

		@Nullable
		@Override
		public TileEntity createTileEntity(World world, IBlockState state) {
			return new BlockInsectEggsTrigonotarbidCarb.TileEntityCustom();
		}

		public BlockInsectEggsTrigonotarbidCarb.TileEntityCustom createNewTileEntity(World worldIn, int meta) {
			return new BlockInsectEggsTrigonotarbidCarb.TileEntityCustom();
		}

		@Override
		public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, worldIn, pos, eventID, eventParam);
			TileEntity tileentity = worldIn.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
			super.updateTick(worldIn, pos, state, rand);

			if (worldIn.getBlockState(pos).getBlock() == this && !(worldIn.isRemote)) {
				//worldIn.destroyBlock(pos, false);
				Entity entity1 = null;
				Entity entity2 = null;

				int i = rand.nextInt(4);
				if (i == 0) {
					if (!(worldIn.isRemote)) {
						EntityPrehistoricFloraAgeableBase.summon(worldIn, EntityList.getKey(EntityPrehistoricFloraTrigonotarbid_Eophrynus.class).toString(), "", (double)pos.getX() , (double)pos.getY(), (double)pos.getZ());
					}
					worldIn.destroyBlock(pos, false);
				}
				if (i == 1) {
					if (!(worldIn.isRemote)) {
						EntityPrehistoricFloraAgeableBase.summon(worldIn, EntityList.getKey(EntityPrehistoricFloraTrigonotarbid_Kreischeria.class).toString(), "", (double)pos.getX() , (double)pos.getY(), (double)pos.getZ());
					}
					worldIn.destroyBlock(pos, false);
				}
				if (i == 2) {
					if (!(worldIn.isRemote)) {
						EntityPrehistoricFloraAgeableBase.summon(worldIn, EntityList.getKey(EntityPrehistoricFloraTrigonotarbid_Cryptomartus.class).toString(), "", (double)pos.getX() , (double)pos.getY(), (double)pos.getZ());
					}
					worldIn.destroyBlock(pos, false);
				}
				if (i == 3) {
					if (!(worldIn.isRemote)) {
						EntityPrehistoricFloraAgeableBase.summon(worldIn, EntityList.getKey(EntityPrehistoricFloraTrigonotarbid_Gondwanarachne.class).toString(), "", (double)pos.getX() , (double)pos.getY(), (double)pos.getZ());
					}
					worldIn.destroyBlock(pos, false);
				}
			}
		}

		/*@SideOnly(Side.CLIENT)
		@Override
		public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
			if (LepidodendronConfig.showTooltips) {
				tooltip.add("Type: " + EntityPrehistoricFloraTrigonotarbid_Cryptomartus.getHabitat() + " Arachnid");
				tooltip.add("Periods: " + EntityPrehistoricFloraTrigonotarbid_Cryptomartus.getPeriod());
				super.addInformation(stack, player, tooltip, advanced);
			}
		}*/
	}

	public static class TileEntityCustom extends TileEntity {

	}
}
