package net.lepidodendron.procedure;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.Functions;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureWorldGenTreefernBlack extends ElementsLepidodendronMod.ModElement {
	public ProcedureWorldGenTreefernBlack(ElementsLepidodendronMod instance) {
		super(instance, 42);
	}

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public static void executeProcedure ( Object2ObjectOpenHashMap <String, Object> dependencies ) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WorldGenTreefernBlack!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WorldGenTreefernBlack!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WorldGenTreefernBlack!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WorldGenTreefernBlack!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		int xx = x;
		int yy = y;
		int zz = z;
		World world = (World) dependencies.get("world");
		int TrunkHeight = 0;
		double counter = 0;
		boolean TreeCheck = true;
		
		Material material = world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getMaterial();
		if ((world.canSeeSky(new BlockPos((int) x, (int) y, (int) z)))
			&& material != Material.GRASS
			&& material != Material.GROUND
			&& material != Material.GLASS
			&& material != Material.IRON
			&& material != Material.ROCK
			&& material != Material.SAND
			&& material != Material.WOOD
			) {			

			//Trunk:
			TrunkHeight = (int) (Math.round(Math.random() * 4D) + Math.round(Math.random() * 4D) + 1D);

			//Check there is space:
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x + counter, (int) y + TrunkHeight + 2, (int) z))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x, (int) y + TrunkHeight + 2, (int) z + counter))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x + counter, (int) y + TrunkHeight + 3, (int) z))) TreeCheck = false;
				counter = counter + 1;
			}
			counter = -3;
			while (counter <= 3 && TreeCheck) {
				if (!world.isAirBlock(new BlockPos((int) x, (int) y + TrunkHeight + 3, (int) z + counter))) TreeCheck = false;
				counter = counter + 1;
			}
			
			if (!TreeCheck) return;
			world.setBlockToAir(new BlockPos((int) x, (int) y, (int) z));

			counter = 0;
			while (counter <= TrunkHeight) {
				xx = x;
				yy = y + (int) counter;
				zz = z;
				ProcedureTreeLog.executeProcedure((int) xx, (int) yy, (int) zz, world, BlockTreefernBlackLog.block, EnumFacing.UP);
				
				counter = counter + 1;
			}

			//Place the crown:
			xx = x;
			yy = y + TrunkHeight + 1;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShoot.block.getDefaultState(), 3);

			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShoot02.block.getDefaultState(), 3);

			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShoot03.block.getDefaultState(), 3);

			xx = x - 2;
			yy = y + TrunkHeight + 2;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);

			xx = x + 2;
			yy = y + TrunkHeight + 2;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
			
			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z + 2;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
			
			xx = x;
			yy = y + TrunkHeight + 2;
			zz = z - 2;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide02.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);

			xx = x - 2;
			yy = y + TrunkHeight + 3;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);

			xx = x + 2;
			yy = y + TrunkHeight + 3;
			zz = z;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
			
			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z + 2;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
			
			xx = x;
			yy = y + TrunkHeight + 3;
			zz = z - 2;
			Functions.setBlockStateAndCheckForDoublePlant(world,new BlockPos((int) xx, (int) yy, (int) zz), BlockTreefernBlackShootSide03.block.getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);

		}
	}

}