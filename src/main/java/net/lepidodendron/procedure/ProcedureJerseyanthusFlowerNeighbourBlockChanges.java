package net.lepidodendron.procedure;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockJerseyanthusFlower;
import net.lepidodendron.block.BlockJerseyanthusLeaves;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@ElementsLepidodendronMod.ModElement.Tag
public class ProcedureJerseyanthusFlowerNeighbourBlockChanges extends ElementsLepidodendronMod.ModElement {
	public ProcedureJerseyanthusFlowerNeighbourBlockChanges(ElementsLepidodendronMod instance) {
		super(instance, 188);
	}

	public static void executeProcedure ( Object2ObjectOpenHashMap <String, Object> dependencies ) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure JerseyanthusFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure JerseyanthusFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure JerseyanthusFlowerNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure JerseyanthusFlowerNeighbourBlockChanges!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		EnumFacing facing = world.getBlockState(new BlockPos(x, y, z)).getValue(BlockJerseyanthusFlower.BlockCustom.FACING);
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		boolean decayable = false;
		if (tileEntity instanceof BlockJerseyanthusFlower.TileEntityCustom) {
			decayable = tileEntity.getTileData().getBoolean("decayable");
		}
		if (decayable) {
			if (world.getBlockState(new BlockPos(x, y, z).offset(facing.getOpposite())).getBlock() != BlockJerseyanthusLeaves.block) {
				world.setBlockToAir(new BlockPos(x, y, z));
			}
		}
	}
}
