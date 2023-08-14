
package net.lepidodendron.block;

import net.lepidodendron.*;
import net.lepidodendron.block.base.IAdvancementGranter;
import net.lepidodendron.block.base.SeedSporeReedBase;
import net.lepidodendron.creativetab.TabLepidodendronPlants;
import net.lepidodendron.util.CustomTrigger;
import net.lepidodendron.util.EnumBiomeTypeDevonian;
import net.lepidodendron.util.ModTriggers;
import net.lepidodendron.world.biome.devonian.BiomeDevonian;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BlockPseudobornia extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:pseudobornia")
	public static final Block block = null;
	public BlockPseudobornia(ElementsLepidodendronMod instance) {
		super(instance, LepidodendronSorter.pseudobornia);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("lepidodendron:pseudobornia", "inventory"));
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		OreDictionary.registerOre("plantdnaPNlepidodendron:pseudobornia", BlockPseudobornia.block);
		OreDictionary.registerOre("plantPrehistoric", BlockPseudobornia.block);
		OreDictionary.registerOre("plant", BlockPseudobornia.block);
		OreDictionary.registerOre("stemHorsetail", BlockPseudobornia.block);
	}


	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		boolean isNetherType = false;
		if (shouldGenerateInDimension(dimID, LepidodendronConfigPlants.dimPseudobornia))
			dimensionCriteria = true;
		if (!LepidodendronConfigPlants.genPseudobornia && !LepidodendronConfig.genAllPlants)
			dimensionCriteria = false;
		if (LepidodendronConfig.dimDevonian == dimID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;

		boolean biomeCriteria = false;
		Biome biome = world.getBiome(new BlockPos(chunkX + 16, 128, chunkZ + 16));
		if ((!matchBiome(biome, LepidodendronConfig.genGlobalBlacklist)) && (!matchBiome(biome, LepidodendronConfigPlants.genPseudoborniaBlacklistBiomes))) {
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE))
				biomeCriteria = true;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.COLD))
				biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD))
				biomeCriteria = false;
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM))
				biomeCriteria = false;
		}
		if (matchBiome(biome, LepidodendronConfigPlants.genPseudoborniaOverrideBiomes))
			biomeCriteria = true;
		if (LepidodendronConfig.dimDevonian == dimID) {
			if (biome instanceof BiomeDevonian) {
				BiomeDevonian biomeDevonian = (BiomeDevonian) biome;
				if (biomeDevonian.getBiomeType() == EnumBiomeTypeDevonian.Forest
						|| biomeDevonian.getBiomeType() == EnumBiomeTypeDevonian.Swamp
						|| biomeDevonian.getBiomeType() == EnumBiomeTypeDevonian.Vale) {
					biomeCriteria = true;
				}
				else {
					biomeCriteria = false;
				}
			}
		}
		if (!biomeCriteria)
			return;
			
		int GenChance = 3;
		double GenMultiplier = LepidodendronConfigPlants.multiplierPseudobornia;
		if (GenMultiplier < 0) {GenMultiplier = 0;}
		GenChance = Math.min(15, (int) Math.round((double) GenChance * GenMultiplier));
		//Is this a transformed biome?
		if (LepidodendronDecorationHandler.matchBiome(biome, LepidodendronConfigPlants.genTransformBiomes)) {
			//if (biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":")).equalsIgnoreCase("minecraft"))
				GenChance = 15;
		}

		if (LepidodendronConfig.dimDevonian == dimID) {
			GenChance = 25;
		}

		if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_swamp")) {
			GenChance = 56;
		}

		if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_vale")
		)
			GenChance = 96;

		int maxheight = LepidodendronConfigPlants.maxheightPseudobornia;
		int minheight = LepidodendronConfigPlants.minheightPseudobornia;
		if (maxheight < 0) {maxheight = 0;}
		if (maxheight > 250) {maxheight = 250;}
		if (minheight < 1) {minheight = 1;}
		if (minheight > 250) {minheight = 250;}
		final int maxH = maxheight;
		final int minH = minheight;
			
		for (int i = 0; i < GenChance; i++) {
			int l6 = chunkX + random.nextInt(16) + 8;
			int i11 = random.nextInt(128);
			int l14 = chunkZ + random.nextInt(16) + 8;
			(new WorldGenReed() {
				@Override
				public boolean generate(World world, Random random, BlockPos pos) {
					for (int i = 0; i < 10; ++i) {
						BlockPos blockpos1 = pos.add(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
						if (world.isAirBlock(blockpos1) && world.isAirBlock(blockpos1.up()) && world.isAirBlock(blockpos1.up(2)) && blockpos1.getY() >= minH && (blockpos1.getY() <= maxH || maxH == 0)  && !(world.getBiome(blockpos1).getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_springs")) ) {
							int j = 1 + random.nextInt(random.nextInt(12) + 2);
							j = Math.max(3, j);
							int heightCheck = 3;
							boolean spaceCheck = true;
							for (int k = 1; k <= j; ++k) {
								if (((BlockCustomFlower) block).canBlockStay(world, blockpos1)
									&& (world.isAirBlock(blockpos1.up(k))) && spaceCheck) {
									heightCheck = k;
								}
								else {
									spaceCheck = false;
								}
							}
							j = heightCheck;
							for (int k = 0; k <= j; ++k) {
								if (((BlockCustomFlower) block).canBlockStay(world, blockpos1)) {
									if (k <= (j - 2)) {
										world.setBlockState(blockpos1.up(k), block.getDefaultState(), 2); 
									}									
									if (k == (j - 1)) {
										world.setBlockState(blockpos1.up(k), BlockPseudobornia2.block.getDefaultState(), 2);
									}
									if (k == j) {
										world.setBlockState(blockpos1.up(k), BlockPseudobornia3.block.getDefaultState(), 2);
									}
								}
							}
						}
					}
					return true;
				}
			}).generate(world, random, new BlockPos(l6, i11, l14));
		}
	}
	public static class BlockCustomFlower extends SeedSporeReedBase implements IAdvancementGranter {

		public static final PropertyBool BASE = PropertyBool.create("base");
		public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
		
		public BlockCustomFlower() {
			setSoundType(SoundType.PLANT);
			setCreativeTab(TabLepidodendronPlants.tab);
			setHardness(0.5F);
			setResistance(0.5F);
			setLightLevel(0F);
			setTranslationKey("pf_pseudobornia");
			setRegistryName("pseudobornia");
			this.setDefaultState(this.blockState.getBaseState().withProperty(BASE, false).withProperty(AGE, Integer.valueOf(0)));
		}

		@Nullable
		@Override
		public CustomTrigger getModTrigger() {
			return ModTriggers.CLICK_PSEUDOBORNIA;
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
				EntityItem entityToSpawn = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				worldIn.spawnEntity(entityToSpawn);
			}
			else {
				super.harvestBlock(worldIn, player, pos, state, te, stack);
			}
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			if (!LepidodendronConfig.doPropagation) {
				drops.add(new ItemStack(this));
			}
			else {
				drops.add(new ItemStack(Blocks.AIR));
			}
		}
		
		@Override
		public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos){
			
	    	Block block = worldIn.getBlockState(pos.down()).getBlock();
	    	Block block1 = worldIn.getBlockState(pos.up()).getBlock();

	        return state.withProperty(BASE, (block != this && block1 == this));
	    }

	    @Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{AGE, BASE});
		}
			
		@Override
		protected boolean canSilkHarvest()
	    {
	        return false;
	    }

		@Override
		public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
			return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(state));
		}

		@Override
		public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
			return EnumPlantType.Plains;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return new AxisAlignedBB(0.35D, 0.0D, 0.35D, 0.65D, 1.0D, 0.65D);
	    }



		@Override
		@Nullable
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
			return NULL_AABB;
		}

		@Override
		public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
			return true;
		}


		@Override
	    public boolean canBlockStay(World worldIn, BlockPos pos)
	    {
	        return canPlaceBlockAt(worldIn, pos);
	    }
	    
		@Override
		public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	    {
	        IBlockState state = worldIn.getBlockState(pos.down());
	        Block block = state.getBlock();

		    if (block == this)
		    {
		    	return true;
	        }
	        if (!block.canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this)) 
	        {
	            return false;
	        }
	        else
	        {
	            BlockPos blockpos = pos.down();

				int xx = -2;
				int zz;
	            while (xx <= 2) {
	            	zz = -2;
	            	while (zz <= 2) {
						IBlockState iblockstate = worldIn.getBlockState(blockpos.add(xx, 0, zz));
		
		                if (iblockstate.getMaterial() == Material.WATER || iblockstate.getBlock() == Blocks.FROSTED_ICE || iblockstate.getBlock() == Blocks.ICE)
	                	{
	                    	return true;
	                	}
	            		zz = zz + 1;
	            	}
	            	xx = xx + 1;
	            }
	        }
	        return false;
	    }

		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess p_149720_1_, BlockPos pos, int pass) {
			return 16777215;
		}

		@Override
		public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
			if (world.getBlockState(pos.down()).getBlock() == block || this.checkForDrop(world, pos, state)) {
				if (world.isAirBlock(pos.up())) {
					world.setBlockState(pos.up(), BlockPseudobornia2.block.getDefaultState(), 2);
				}
				if ((world.isAirBlock(pos.up(2))) && (world.getBlockState(pos.up()).getBlock() == BlockPseudobornia2.block)) {
					world.setBlockState(pos.up(2), BlockPseudobornia3.block.getDefaultState(), 2);
				}
				else {
					if ((world.isAirBlock(pos.up(3))) && ((world.getBlockState(pos.up())).getBlock() == BlockPseudobornia2.block)
						&& ((world.getBlockState(pos.up(2))).getBlock() == BlockPseudobornia3.block)) {
						int l;
						for (l = 1; world.getBlockState(pos.down(l)).getBlock() == this; ++l);
						if (l < 12) {
							int i1 = (Integer) state.getValue(AGE);
							if (i1 == 15) {
								//world.setBlockToAir(pos.up(2));
								world.setBlockState(pos.up(), this.getDefaultState());
								world.setBlockState(pos, state.withProperty(AGE, 0), 4);
								//if (world.isAirBlock(pos.up(2))) {
									world.setBlockState(pos.up(2), BlockPseudobornia2.block.getDefaultState(), 2);
								//}
								//if (world.isAirBlock(pos.up(3))) {
									world.setBlockState(pos.up(3), BlockPseudobornia3.block.getDefaultState(), 2);
								//}
							} else {
								world.setBlockState(pos, state.withProperty(AGE, i1 + 1), 4);
							}
						}
					}
				}
			}
		}

	    @SideOnly(Side.CLIENT)
		@Override
	    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
	        if (LepidodendronConfig.showTooltips) {
				tooltip.add("Type: Horsetail shrub");
	        tooltip.add("Periods: late Devonian");
			tooltip.add("Note: plant near water");
	        tooltip.add("Propagation: spores");}
	        super.addInformation(stack, player, tooltip, advanced);
	    }
	    
	    @Override
	    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
	    	if (world.isAirBlock(pos.up()) && world.isAirBlock(pos.up(2))) {
				world.setBlockState(pos.up(), BlockPseudobornia2.block.getDefaultState(), 3);
				world.setBlockState(pos.up(2), BlockPseudobornia3.block.getDefaultState(), 3);
	    	}
			super.onBlockAdded(world, pos, state);
	    }

		@Override
		public Block planted() {
			return BlockPseudobornia.block;
		}

		@Override
		public int offsetY() {
			return 1;
		}

		@Override
		public Item blockItem() {
			return null;
		}
	}
	
	public boolean shouldGenerateInDimension(int id, int[] dims) {
		int[] var2 = dims;
		int var3 = dims.length;
		for (int var4 = 0; var4 < var3; ++var4) {
			int dim = var2[var4];
			if (dim == id) {
				return true;
			}
		}
		return false;
	}

 	public static boolean matchBiome(Biome biome, String[] biomesList) {
    	
    	//String regName = biome.getRegistryName().toString();
    	
        String[] var2 = biomesList;
        int var3 = biomesList.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String checkBiome = var2[var4];
            if (!checkBiome.contains(":")) {
            	//System.err.println("modid test: " + biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":") - 1));
	            if (checkBiome.equalsIgnoreCase(
	            	biome.getRegistryName().toString().substring(0, biome.getRegistryName().toString().indexOf(":"))
	            	)) {
	                return true;
	            }
        	}
        	if (checkBiome.equalsIgnoreCase(biome.getRegistryName().toString())) {
                return true;
            }
        }

        return false;
    }
	
}

