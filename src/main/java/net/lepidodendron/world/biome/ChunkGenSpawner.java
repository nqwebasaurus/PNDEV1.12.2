package net.lepidodendron.world.biome;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.block.BlockNest;
import net.lepidodendron.entity.EntityPrehistoricFloraDiictodon;
import net.lepidodendron.entity.EntityPrehistoricFloraHaldanodon;
import net.lepidodendron.entity.base.*;
import net.lepidodendron.util.*;
import net.lepidodendron.world.biome.cambrian.BiomeCambrian;
import net.lepidodendron.world.biome.carboniferous.BiomeCarboniferous;
import net.lepidodendron.world.biome.devonian.BiomeDevonian;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.lepidodendron.world.biome.ordovician.BiomeOrdovician;
import net.lepidodendron.world.biome.permian.BiomePermian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class ChunkGenSpawner extends ElementsLepidodendronMod.ModElement {
    public ChunkGenSpawner(ElementsLepidodendronMod instance) {
        super(instance, 42);
    }


    public static void executeProcedure(boolean onlyWater, World world, BlockPos pos, Random rand, @Nullable String[] mobList, boolean worldGen) {
        executeProcedure(onlyWater, world, pos, rand, mobList, worldGen, false);
    }

    public static void executeProcedure(boolean onlyWater, World world, BlockPos pos, Random rand, @Nullable String[] mobList, boolean worldGen, boolean genLakes) {

        double spawnDensity = LepidodendronConfig.spawnerDensity;
        if (spawnDensity < 0.0) {
            spawnDensity = 0.0;
        }
        if (spawnDensity > 100.0) {
            spawnDensity = 100.0;
        }

        //Hardcode to try to encourage more spawns

        int spawnerCycle = 0;
        int spawnCounter = 0;
        int throttle = 0; //Used as an absolute maximum and for dealing with invalid entries on the list etc.
        while (throttle <= 100 && spawnerCycle < (int)Math.ceil((10D * spawnDensity))) {
            BlockPos spawnPos = pos.add(16, 0, 16); //move to the centre of the 2x2 of chunks we are populating
            spawnPos = spawnPos.add(rand.nextInt(16) - 8, 0, rand.nextInt(16) - 8); //Pick a random coordinate around
            if (genLakes) {
                spawnPos = pos;
            }
            //Get mob list and pick a mob for this biome:
            boolean TriassicCanyons = false;
            boolean Creeks = false;
            String[] MobString = new String[0];
            if (mobList == null) {
                //Biome biome = world.getBiome(pos.add(16, 0, 16)); //move to the centre of the 2x2 of chunks we are populating so the biome is more "likely" to be right
                Biome biome = world.getBiome(spawnPos);
                MobString = EntityLists.mobString(biome, 0);
                if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek")
                        || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_riverbank")
                        || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_riverbank_forest")) {
                    TriassicCanyons = true;
                }
                if (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:lepidodendron:triassic_creek")) {
                    //That one is named differently :/
                    if (biome.getRegistryName().toString().startsWith("lepidodendron:")
                        && biome.getRegistryName().toString().indexOf("creek") > 0) {
                        Creeks = true;
                    }
                }
            } else {
                MobString = mobList;
            }

            if (MobString != null) {
                if (!(MobString.length >= 1)) {
                    break;
                }
            } else {
                break;
            }

            //System.err.println("Running");

            String mobToSpawn;
            String nbtStr = "";
            int locationID = 1;
            if (onlyWater) {
                locationID = 4;
            }
            boolean errFound;
            boolean posCheck;
            int strPos1;
            int strPos2;
            int strPos3;
            int strPos4;
            int strPos5;

            String[] var2 = MobString;
            //Shuffle the string so we pick a random mob later:
            List<String> list = Arrays.asList(var2);
            Collections.shuffle(list);
            list.toArray(var2);

            int var3 = var2.length;
            if (!(var3 >= 1)) { //No valid mobs here so move onto another blockPos to try
                break;
            }

            int var4 = rand.nextInt(var3); //Pick a mob from the list
            errFound = false;
            String checkEntity = var2[var4].trim();
            if (onlyWater) {
                checkEntity = var2[var4].trim() + ":4";
            }

            strPos1 = 0;
            strPos2 = 0;
            strPos3 = 0;
            strPos4 = 0;
            strPos5 = 0;
            nbtStr = "";

            strPos1 = checkEntity.indexOf(":");
            if (!(strPos1 > 0)) {
                errFound = true;
            }
            else {
                String modid = checkEntity.substring(0, strPos1);

                //Get the last two bits, first the rightmost colon:
                for (int i = checkEntity.length(); i > 0; i--) {
                    if (checkEntity.charAt(i - 1) == ':') {
                        strPos2 = i;
                        break;
                    }
                }

                if (strPos2 <= strPos1) {
                    //The position means that something is missing
                    errFound = true;
                } else {
                    String locationStr = checkEntity.substring(checkEntity.length() - 1, checkEntity.length());
                    if (!(locationStr.equals((String) "1") || locationStr.equals((String) "2") || locationStr.equals((String) "3") || locationStr.equals((String) "4") || locationStr.equals((String) "5") || locationStr.equals((String) "6") || locationStr.equals((String) "7") || locationStr.equals((String) "8"))) {
                        errFound = true;
                    } else {
                        locationID = (int) Integer.parseInt(locationStr);

                        //Get the next last bit:
                        strPos3 = 0;
                        String tmpStr = checkEntity.substring(0, checkEntity.length() - 2);
                        for (int i = tmpStr.length(); i > 0; i--) {
                            if (tmpStr.charAt(i - 1) == ':') {
                                strPos3 = i;
                                break;
                            }
                        }
                        if (strPos3 <= strPos1) {
                            //The position means that something is missing
                            errFound = true;
                        } else {
                            tmpStr = tmpStr.substring(strPos3, tmpStr.length());
                            if (!isNumeric(tmpStr)) {
                                errFound = true;
                            } else {
                                int weight = (int) Integer.parseInt(tmpStr);
                                if (weight < -100 || weight > 100) {
                                    errFound = true;
                                } else {

                                    //Get the next last bit:
                                    strPos5 = 0;
                                    tmpStr = checkEntity.substring(0, strPos3 - 1);
                                    for (int i = tmpStr.length(); i > 0; i--) {
                                        if (tmpStr.charAt(i - 1) == ':') {
                                            strPos5 = i;
                                            break;
                                        }
                                    }
                                    if (strPos5 <= strPos1) {
                                        //The position means that something is missing
                                        errFound = true;
                                    } else {
                                        tmpStr = tmpStr.substring(strPos5, tmpStr.length());
                                        if (!isNumeric(tmpStr)) {
                                            errFound = true;
                                        } else {
                                            int maxSpawn = (int) Integer.parseInt(tmpStr);
                                            if (maxSpawn < 0 || maxSpawn > 20) {
                                                errFound = true;
                                            }

                                            //Everything left is the mod plus nbt (which may be wrong of course!)
                                            else { //Get the mob:

                                                mobToSpawn = checkEntity.substring(0, strPos5 - 1);
                                                //Is there nbt?
                                                strPos4 = 0;
                                                strPos4 = mobToSpawn.indexOf("{");
                                                if (strPos4 > 0) {
                                                    //we have nbt:
                                                    nbtStr = mobToSpawn.substring(strPos4, mobToSpawn.length());
                                                    mobToSpawn = mobToSpawn.substring(0, strPos4);

                                                    //Is the nbt string made of alternates?
                                                    if (nbtStr.indexOf("@") > 0) {
                                                        String[] arrSplit = nbtStr.split("@");
                                                        nbtStr = arrSplit[rand.nextInt(arrSplit.length)];
                                                    }
                                                }

                                                if (findEntity(mobToSpawn) != null) {
                                                    //Spawn routine (finally!)
                                                    int i2;
                                                    int i18 = 0;
                                                    posCheck = false;

                                                    //System.err.println(mobToSpawn + " in ID " + locationID);
                                                    EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobToSpawn));
                                                    EntityLiving entity = (EntityLiving) ee.newInstance(world);
                                                    int offsetter = 0;

                                                    switch (locationID) {

                                                        case 1: //Land (or land near water)
                                                        case 8:
                                                        default:
                                                            offsetter = 2; //Trying to help avoid spawning into cliffsides :/
                                                            //System.err.println("Case: 1");
                                                            //We'll check a block is the biome topblock and that there are at least 4 blocks of non-solid blocks above it:
                                                            BlockPos pos1 = world.getTopSolidOrLiquidBlock(new BlockPos(spawnPos.getX(), 0, spawnPos.getZ()));
                                                            //pos1 = world.getTopSolidOrLiquidBlock(new BlockPos(pos.getX() + k7, 0, pos.getZ() + j11));
                                                            if (
                                                                    world.getBlockState(pos1.down()).getBlock().isSideSolid(world.getBlockState(pos1.down()), world, pos1.down(), EnumFacing.UP)
                                                                            && (world.getBlockState(pos1.down()).getMaterial() != Material.WOOD)
                                                                            && ((world.isAirBlock(pos1)) || (world.getBlockState(pos1).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up())) || (world.getBlockState(pos1.up()).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up(2))) || (world.getBlockState(pos1.up(2)).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up(3))) || (world.getBlockState(pos1.up(3)).getMaterial() == Material.PLANTS))
                                                            ) {
                                                                if (locationID == 1) {
                                                                    posCheck = true;
                                                                    //System.err.println("Spawnable " + checkEntity);
                                                                    spawnPos = pos1;
                                                                }
                                                                else if (locationID == 8) {
                                                                    //Check for water:
                                                                    boolean waterCriteria = false;
                                                                    int i = pos1.getX();
                                                                    int j = pos1.getY();
                                                                    int k = pos1.getZ();
                                                                    //Is there water nearby?
                                                                    int xct = -3;
                                                                    int yct;
                                                                    int zct;
                                                                    while ((xct < 4) && (!waterCriteria)) {
                                                                        yct = -2;
                                                                        while ((yct <= 0) && (!waterCriteria)) {
                                                                            zct = -3;
                                                                            while ((zct < 4) && (!waterCriteria)) {
                                                                                if ((world.getBlockState(new BlockPos(i + xct, j + yct, k + zct))).getMaterial() == Material.WATER) {
                                                                                    waterCriteria = true;
                                                                                }
                                                                                zct = zct + 1;
                                                                            }
                                                                            yct = yct + 1;
                                                                        }
                                                                        xct = xct + 1;
                                                                    }
                                                                    if (waterCriteria) {
                                                                        posCheck = true;
                                                                        //System.err.println("Spawnable " + checkEntity);
                                                                        spawnPos = pos1;
                                                                    }
                                                                }
                                                            }
                                                            break;

                                                        case 2: //Deep water
                                                            //System.err.println("Case: 2");
                                                            posCheck = false;

                                                            pos1 = getTopSolidBlock(spawnPos, world).up();
                                                            if (world.getBlockState(pos1).getMaterial() == Material.WATER) {
                                                                //System.err.println("y: " + i18);
                                                                //System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
                                                                //System.err.println("topblock: " + topBlock.getBlock());

                                                                //First check if we are in an ocean biome with distinct shallow and deep parts:
                                                                Biome biome = world.getBiome(pos1);
                                                                if (biome instanceof BiomeCambrian || biome instanceof BiomeOrdovician || biome instanceof BiomeSilurian || biome instanceof BiomeDevonian || biome instanceof BiomeCarboniferous || biome instanceof BiomePermian || biome instanceof BiomeTriassic || biome instanceof BiomeJurassic) {
                                                                    boolean isGenericOcean = false;
                                                                    if (biome instanceof BiomeCambrian) {
                                                                        if (((BiomeCambrian) biome).getBiomeType() == EnumBiomeTypeCambrian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeOrdovician) {
                                                                        if (((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.Ocean
                                                                            || ((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.FrozenOcean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeSilurian) {
                                                                        if (((BiomeSilurian) biome).getBiomeType() == EnumBiomeTypeSilurian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeDevonian) {
                                                                        if (((BiomeDevonian) biome).getBiomeType() == EnumBiomeTypeDevonian.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_dead_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef_transition"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeCarboniferous) {
                                                                        if (((BiomeCarboniferous) biome).getBiomeType() == EnumBiomeTypeCarboniferous.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_cliff"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomePermian) {
                                                                        if (((BiomePermian) biome).getBiomeType() == EnumBiomeTypePermian.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_cliff"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_sponge_reef"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeTriassic) {
                                                                        if (((BiomeTriassic) biome).getBiomeType() == EnumBiomeTypeTriassic.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_clam_beds"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeJurassic) {
                                                                        if (((BiomeJurassic) biome).getBiomeType() == EnumBiomeTypeJurassic.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_rafts"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_glass_sponge_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_coral"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (isGenericOcean) { //Test if we are in a deep ocean biome:
                                                                        if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_ice")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_sandy")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep_rocky")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean")) {
                                                                            //if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                            //        && (pos1.getY() > world.getSeaLevel() - 40)) {
                                                                                //EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobToSpawn));
                                                                                //EntityLiving entity = (EntityLiving) ee.newInstance(world);
                                                                                float entityHeight = entity.height;
                                                                                if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                                    entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                                }
                                                                                if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                                    posCheck = true;
                                                                                } else if (entityHeight < 1.9) {
                                                                                    if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                        posCheck = true;
                                                                                    }
                                                                                } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                                    posCheck = true;
                                                                                }
                                                                            //}
                                                                        } else {
                                                                            posCheck = false;
                                                                        }
                                                                    } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up()).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(3)).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(4)).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(5)).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(6)).getMaterial() == Material.WATER)
                                                                    ) {
                                                                        posCheck = true;
                                                                    }
                                                                } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up()).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(3)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(4)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(5)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(6)).getMaterial() == Material.WATER)
                                                                ) {
                                                                    posCheck = true;
                                                                }

                                                                //Set a position in the water column:
                                                                pos1 = pos1.add(0, rand.nextInt(6), 0);

                                                                int xx = -4;
                                                                while (xx <= 4 && posCheck) {
                                                                    int zz = -4;
                                                                    while (zz <= 4 && posCheck) {
                                                                        if (world.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
                                                                            posCheck = false;
                                                                        }
                                                                        zz = zz + 1;
                                                                    }
                                                                    xx = xx + 1;
                                                                }
                                                                spawnPos = pos1;
                                                            }
                                                            break;

                                                        case 3: //Shallow water
                                                            //System.err.println("Case: 3");
                                                            posCheck = false;

                                                            pos1 = getTopSolidBlock(spawnPos, world).up();
                                                            if (world.getBlockState(pos1).getMaterial() == Material.WATER) {
                                                                //System.err.println("y: " + i18);
                                                                //System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
                                                                //System.err.println("topblock: " + topBlock.getBlock());
                                                                //First check if we are in an ocean biome with distinct shallow and deep parts:
                                                                Biome biome = world.getBiome(pos1);
                                                                if (biome instanceof BiomeCambrian || biome instanceof BiomeOrdovician || biome instanceof BiomeSilurian || biome instanceof BiomeDevonian || biome instanceof BiomeCarboniferous || biome instanceof BiomePermian || biome instanceof BiomeTriassic || biome instanceof BiomeJurassic) {
                                                                    boolean isGenericOcean = false;
                                                                    if (biome instanceof BiomeCambrian) {
                                                                        if (((BiomeCambrian) biome).getBiomeType() == EnumBiomeTypeCambrian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeOrdovician) {
                                                                        if (((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.Ocean
                                                                                || ((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.FrozenOcean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeSilurian) {
                                                                        if (((BiomeSilurian) biome).getBiomeType() == EnumBiomeTypeSilurian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeDevonian) {
                                                                        if (((BiomeDevonian) biome).getBiomeType() == EnumBiomeTypeDevonian.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_dead_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef_transition"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeCarboniferous) {
                                                                        if (((BiomeCarboniferous) biome).getBiomeType() == EnumBiomeTypeCarboniferous.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_cliff"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomePermian) {
                                                                        if (((BiomePermian) biome).getBiomeType() == EnumBiomeTypePermian.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_cliff"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_sponge_reef"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeTriassic) {
                                                                        if (((BiomeTriassic) biome).getBiomeType() == EnumBiomeTypeTriassic.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_clam_beds"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeJurassic) {
                                                                        if (((BiomeJurassic) biome).getBiomeType() == EnumBiomeTypeJurassic.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_rafts"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_glass_sponge_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_coral"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (isGenericOcean) {
                                                                        if ((!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_ice"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_sandy"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep_rocky"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean"))) {
                                                                            //We are in the shallow ocean biomes:
                                                                            float entityHeight = entity.height;
                                                                            if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                                entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                            }
                                                                            if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                                posCheck = true;
                                                                            } else if (entityHeight < 1.9) {
                                                                                if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                    posCheck = true;
                                                                                }
                                                                            } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                                posCheck = true;
                                                                            }
                                                                            //This is OK to spawn here at the sea floor with enough headroom
                                                                        } else {
                                                                            posCheck = false; //This is deep ocean so we dont spawn here
                                                                        }
                                                                    } else { //Is there a column of water above us no more than 6 blocks deep?
                                                                        if (world.isAirBlock(pos1.up(6))
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.ICE
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.PACKED_ICE
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.VINE
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.LEAVES
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.PLANTS
                                                                                || world.getBlockState(pos1.up(6)).getMaterial() == Material.WEB) {
                                                                            posCheck = true;
                                                                        }

                                                                        //Get a position in the water column:
                                                                        if (posCheck) {
                                                                            posCheck = false; //final checks
                                                                            float entityHeight = entity.height;
                                                                            if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                                entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                            }
                                                                            if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                                posCheck = true; //These are fine in a single block deep
                                                                            } else if (entityHeight < 1.9) {
                                                                                if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                    posCheck = true; //These are fine in a double block deep
                                                                                }
                                                                            } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                                posCheck = true; //Else require triple block deep
                                                                            }
                                                                        }
                                                                    }
                                                                } else { //Is there a column of water above us no more than 6 blocks deep?
                                                                    if (world.isAirBlock(pos1.up(6))
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.ICE
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.PACKED_ICE
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.VINE
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.LEAVES
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.PLANTS
                                                                            || world.getBlockState(pos1.up(6)).getMaterial() == Material.WEB) {
                                                                        posCheck = true;
                                                                    }

                                                                    //Get a position in the water column:
                                                                    if (posCheck) {
                                                                        posCheck = false; //final checks
                                                                        float entityHeight = entity.height;
                                                                        if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                            entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                        }
                                                                        if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                            posCheck = true; //These are fine in a single block deep
                                                                        } else if (entityHeight < 1.9) {
                                                                            if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                posCheck = true; //These are fine in a double block deep
                                                                            }
                                                                        } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                            posCheck = true; //Else require triple block deep
                                                                        }
                                                                    }
                                                                }

                                                                //Finally validate it's not just a tiny puddle:
                                                                int xx = -1;
                                                                while (xx <= 1 && posCheck) {
                                                                    int zz = -1;
                                                                    while (zz <= 1 && posCheck) {
                                                                        if (world.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
                                                                            posCheck = false;
                                                                        }
                                                                        zz = zz + 1;
                                                                    }
                                                                    xx = xx + 1;
                                                                }
                                                            }
                                                            spawnPos = pos1;
                                                            break;

                                                        case 4: //In a 5x5 block of water anywhere under sea-level
                                                            //System.err.println("Case: 4");
                                                            posCheck = false;

                                                            i18 = 0;
                                                            while (i18 < 255 && !posCheck) {
                                                                i18 = i18 + 1;
                                                                pos1 = new BlockPos(spawnPos.getX(), i18, spawnPos.getZ());
                                                                //System.err.println("y: " + i18);
                                                                //System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
                                                                //System.err.println("topblock: " + topBlock.getBlock());
                                                                if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up()).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.down()).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.down(2)).getMaterial() == Material.WATER)
                                                                        && (pos1.getY() < (world.getSeaLevel() - 2))
                                                                ) {
                                                                    posCheck = true;
                                                                }
                                                                int xx = -2;
                                                                while (xx <= 2 && posCheck) {
                                                                    int zz = -2;
                                                                    while (zz <= 2 && posCheck) {
                                                                        if (world.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
                                                                            posCheck = false;
                                                                        }
                                                                        zz = zz + 1;
                                                                    }
                                                                    xx = xx + 1;
                                                                }
                                                                spawnPos = pos1;
                                                            }
                                                            break;

                                                        case 5: //On leaves
                                                            //System.err.println("Case: 5");
                                                            //We'll check a block is the biome topblock and that there are at least 4 blocks of non-solid blocks above it:
                                                            posCheck = false;

                                                            pos1 = getTopSolidOrLiquidBlockIncludingLeaves(new BlockPos(spawnPos.getX(), 0, spawnPos.getZ()), world);
                                                            IBlockState spawnBlock = world.getBlockState(pos1.down());
                                                            if (
                                                                    (
                                                                            (spawnBlock.getBlock() instanceof BlockLeaves
                                                                                    && spawnBlock.getBlock().isFullCube(spawnBlock))
                                                                    )
                                                                            && ((world.isAirBlock(pos1)) || (world.getBlockState(pos1).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up())) || (world.getBlockState(pos1.up()).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up(2))) || (world.getBlockState(pos1.up(2)).getMaterial() == Material.PLANTS))
                                                                            && ((world.isAirBlock(pos1.up(3))) || (world.getBlockState(pos1.up(3)).getMaterial() == Material.PLANTS))
                                                            ) {
                                                                posCheck = true;
                                                                //System.err.println("Spawnable " + checkEntity);
                                                                spawnPos = pos1;
                                                            }
                                                            break;

                                                        case 6: //Deep water in the upper parts
                                                            //System.err.println("Case: 6");
                                                            posCheck = false;

                                                            i18 = 0;
                                                            while (i18 < 255 && !posCheck) {
                                                                i18 = i18 + 1;
                                                                pos1 = new BlockPos(spawnPos.getX(), i18, spawnPos.getZ());
                                                                //System.err.println("pos1: " + pos1);
                                                                //System.err.println("block: " + (world.getBlockState(pos1).getBlock()));

                                                                //First check if we are in an ocean biome with distinct shallow and deep parts:
                                                                Biome biome = world.getBiome(pos1);
                                                                if (biome instanceof BiomeCambrian || biome instanceof BiomeOrdovician || biome instanceof BiomeSilurian || biome instanceof BiomeDevonian || biome instanceof BiomeCarboniferous || biome instanceof BiomePermian || biome instanceof BiomeTriassic) {
                                                                    boolean isGenericOcean = false;
                                                                    if (biome instanceof BiomeCambrian) {
                                                                        if (((BiomeCambrian) biome).getBiomeType() == EnumBiomeTypeCambrian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeOrdovician) {
                                                                        if (((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.Ocean
                                                                                || ((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.FrozenOcean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeSilurian) {
                                                                        if (((BiomeSilurian) biome).getBiomeType() == EnumBiomeTypeSilurian.Ocean) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeDevonian) {
                                                                        if (((BiomeDevonian) biome).getBiomeType() == EnumBiomeTypeDevonian.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_dead_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef_transition"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeCarboniferous) {
                                                                        if (((BiomeCarboniferous) biome).getBiomeType() == EnumBiomeTypeCarboniferous.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_cliff"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomePermian) {
                                                                        if (((BiomePermian) biome).getBiomeType() == EnumBiomeTypePermian.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_cliff"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_sponge_reef"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeTriassic) {
                                                                        if (((BiomeTriassic) biome).getBiomeType() == EnumBiomeTypeTriassic.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_clam_beds"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (biome instanceof BiomeJurassic) {
                                                                        if (((BiomeJurassic) biome).getBiomeType() == EnumBiomeTypeJurassic.Ocean
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_rafts"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_glass_sponge_reef"))
                                                                                && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_coral"))) {
                                                                            isGenericOcean = true;
                                                                        }
                                                                    }
                                                                    if (isGenericOcean) { //Test if we are in a deep ocean biome:
                                                                        if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_ice")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_sandy")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep_rocky")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean")
                                                                                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean")) {
                                                                            if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                                    && (pos1.getY() > world.getSeaLevel() - 40)) {
                                                                                //EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobToSpawn));
                                                                                //EntityLiving entity = (EntityLiving) ee.newInstance(world);
                                                                                float entityHeight = entity.height;
                                                                                if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                                    entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                                }
                                                                                if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                        || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                                    posCheck = true;
                                                                                } else if (entityHeight < 1.9) {
                                                                                    if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                        posCheck = true;
                                                                                    }
                                                                                } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                                    posCheck = true;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            posCheck = false;
                                                                        }
                                                                    } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                            && (world.isAirBlock(pos1.up(3)) || world.getBlockState(pos1.up(3)).getMaterial() == Material.ICE)
                                                                            && (world.getBlockState(pos1.up()).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.down()).getMaterial() == Material.WATER)
                                                                            && (world.getBlockState(pos1.down(2)).getMaterial() == Material.WATER)
                                                                    ) {
                                                                        posCheck = true;
                                                                    }
                                                                } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                        && (world.isAirBlock(pos1.up(3)) || world.getBlockState(pos1.up(3)).getMaterial() == Material.ICE)
                                                                        && (world.getBlockState(pos1.up()).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.down()).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.down(2)).getMaterial() == Material.WATER)
                                                                ) {
                                                                    posCheck = true;
                                                                }

                                                                if (pos1.getY() < world.getSeaLevel() - 8) {
                                                                    posCheck = false; //If this is well below sea level then deny it, simples
                                                                }

                                                                int xx = -4;
                                                                while (xx <= 4 && posCheck) {
                                                                    int zz = -4;
                                                                    while (zz <= 4 && posCheck) {
                                                                        if (world.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
                                                                            posCheck = false;
                                                                        }
                                                                        zz = zz + 1;
                                                                    }
                                                                    xx = xx + 1;
                                                                }

                                                                //System.err.println("posCheck: " + posCheck);
                                                                spawnPos = pos1;
                                                            }
                                                            break;


                                                        case 7: //Deep water in the lower parts
                                                            posCheck = false;
                                                            pos1 = (getTopSolidBlock(spawnPos, world)).up();
                                                            //System.err.println("y: " + i18);
                                                            //System.err.println("block: " + (worldIn.getBlockState(pos1).getBlock()));
                                                            //System.err.println("topblock: " + topBlock.getBlock());

                                                            //First check if we are in an ocean biome with distinct shallow and deep parts:
                                                            Biome biome = world.getBiome(pos1);
                                                            if (biome instanceof BiomeCambrian || biome instanceof BiomeOrdovician || biome instanceof BiomeSilurian || biome instanceof BiomeDevonian || biome instanceof BiomeCarboniferous || biome instanceof BiomePermian || biome instanceof BiomeTriassic) {
                                                                boolean isGenericOcean = false;
                                                                if (biome instanceof BiomeCambrian) {
                                                                    if (((BiomeCambrian) biome).getBiomeType() == EnumBiomeTypeCambrian.Ocean) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeOrdovician) {
                                                                    if (((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.Ocean
                                                                            || ((BiomeOrdovician) biome).getBiomeType() == EnumBiomeTypeOrdovician.FrozenOcean) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeSilurian) {
                                                                    if (((BiomeSilurian) biome).getBiomeType() == EnumBiomeTypeSilurian.Ocean) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeDevonian) {
                                                                    if (((BiomeDevonian) biome).getBiomeType() == EnumBiomeTypeDevonian.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_dead_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef_transition"))) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeCarboniferous) {
                                                                    if (((BiomeCarboniferous) biome).getBiomeType() == EnumBiomeTypeCarboniferous.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_cliff"))) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomePermian) {
                                                                    if (((BiomePermian) biome).getBiomeType() == EnumBiomeTypePermian.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_cliff"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_sponge_reef"))) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeTriassic) {
                                                                    if (((BiomeTriassic) biome).getBiomeType() == EnumBiomeTypeTriassic.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_clam_beds"))) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (biome instanceof BiomeJurassic) {
                                                                    if (((BiomeJurassic) biome).getBiomeType() == EnumBiomeTypeJurassic.Ocean
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_rafts"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_glass_sponge_reef"))
                                                                            && (!biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_coral"))) {
                                                                        isGenericOcean = true;
                                                                    }
                                                                }
                                                                if (isGenericOcean) { //Test if we are in a deep ocean biome:
                                                                    if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_ice")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_sandy")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep_rocky")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean")
                                                                            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean")) {
                                                                        if ((world.getBlockState(pos1).getMaterial() == Material.WATER))
                                                                        //&& (pos1.getY() > world.getSeaLevel() - 40))
                                                                        {
                                                                            //EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobToSpawn));
                                                                            //EntityLiving entity = (EntityLiving) ee.newInstance(world);
                                                                            float entityHeight = entity.height;
                                                                            if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                                entityHeight = ((EntityPrehistoricFloraAgeableBase) entity).maxHeight;
                                                                            }
                                                                            if (entityHeight < 0.9 || (entity instanceof EntityPrehistoricFloraAmphibianBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraFishBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraSlitheringWaterBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase)
                                                                                    || (entity instanceof EntityPrehistoricFloraTrilobiteSwimBase)) {
                                                                                posCheck = true;
                                                                            } else if (entityHeight < 1.9) {
                                                                                if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER) {
                                                                                    posCheck = true;
                                                                                }
                                                                            } else if (world.getBlockState(pos1.up()).getMaterial() == Material.WATER && world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER) {
                                                                                posCheck = true;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        posCheck = false; //By definition we are not in the deep oceans
                                                                    }
                                                                } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(3)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(4)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(5)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(6)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(7)).getMaterial() == Material.WATER)
                                                                        && (world.getBlockState(pos1.up(8)).getMaterial() == Material.WATER)
                                                                ) {
                                                                    posCheck = true;
                                                                }
                                                            } else if ((world.getBlockState(pos1).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(3)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(4)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(5)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(6)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(7)).getMaterial() == Material.WATER)
                                                                    && (world.getBlockState(pos1.up(8)).getMaterial() == Material.WATER)
                                                            ) {
                                                                posCheck = true;
                                                            }

                                                            int xx = -4;
                                                            while (xx <= 4 && posCheck) {
                                                                int zz = -4;
                                                                while (zz <= 4 && posCheck) {
                                                                    if (world.getBlockState(pos1.add(xx, 0, zz)).getMaterial() != Material.WATER) {
                                                                        posCheck = false;
                                                                    }
                                                                    zz = zz + 1;
                                                                }
                                                                xx = xx + 1;
                                                            }
                                                            spawnPos = pos1;

                                                            break;
                                                    }

                                                    //System.err.println("LocationID: " + locationID);
                                                    //System.err.println("Poscheck: " + posCheck);
                                                    //System.err.println("errFound: " + errFound);
                                                    if (posCheck && !errFound) {
                                                        //System.err.println("Spawning " + mobToSpawn + " with locationID " + locationID + " at: " + pos.add(k7, i18, j11).getX() + " " + pos.add(k7, i18, j11).getY() + " " + pos.add(k7, i18, j11).getZ());
                                                        //System.err.println("maxSpawn: " + maxSpawn);

                                                        boolean rare = (weight < 0);
                                                        weight = Math.abs(weight);

                                                        //System.err.println("weight: " + weight);
                                                        //System.err.println("rare: " + rare);

                                                        double weighter = 500D;
                                                        if (locationID == 2) { //Sea
                                                            weighter = 800D;
                                                        }
                                                        if (locationID == 1 | locationID == 6 || locationID == 7) { //Land and thin sea layers more common
                                                            weighter = 100D;
                                                        }

                                                        //trySpawn += 1;

                                                        //Deal with rare spawns:
                                                        if (rare) {
                                                            weighter = weighter * 2;
                                                            if (rand.nextInt(2) == 0) {
                                                                break;
                                                            }
                                                        }

                                                        //Deal with bumping up creek spawns:
                                                        if (Creeks) {
                                                            weight = weight * 10;
                                                        }

                                                        if ((Math.random() * weighter) <= (double) weight) {
                                                            //System.err.println("Trying......");
//                                                            if (entity instanceof EntityPrehistoricFloraKalbarria) {
//                                                                int ll = 0;
//                                                            }
                                                            int spawnQty = 0;
                                                            if (maxSpawn >= 1) {
                                                                spawnQty = rand.nextInt(maxSpawn) + 1;
                                                            }
                                                            if (entity instanceof EntityPrehistoricFloraAgeableBase) {
                                                                if (((EntityPrehistoricFloraAgeableBase)entity).canShoal() && ((EntityPrehistoricFloraAgeableBase)entity).getShoalSize() != 0) {
                                                                    int halfShoal = (int)Math.round((double)(((EntityPrehistoricFloraAgeableBase)entity).getShoalSize())/2D);
                                                                    int remainingShoal = ((EntityPrehistoricFloraAgeableBase)entity).getShoalSize() - halfShoal;
                                                                    spawnQty = Math.max(1, halfShoal + rand.nextInt(remainingShoal + 1));
                                                                }
                                                            }
                                                            if (entity instanceof EntityPrehistoricFloraFishBase) {
                                                                if (((EntityPrehistoricFloraFishBase)entity).canShoal() && ((EntityPrehistoricFloraFishBase)entity).getShoalSize() != 0) {
                                                                    int halfShoal = (int)Math.round((double)(((EntityPrehistoricFloraFishBase)entity).getShoalSize())/2D);
                                                                    int remainingShoal = ((EntityPrehistoricFloraFishBase)entity).getShoalSize() - halfShoal;
                                                                    spawnQty = Math.max(1, halfShoal + rand.nextInt(remainingShoal + 1));
                                                                }
                                                            }
                                                            if (entity instanceof EntityPrehistoricFloraTrilobiteBottomBase) {
                                                                if (((EntityPrehistoricFloraTrilobiteBottomBase)entity).canShoal() && ((EntityPrehistoricFloraTrilobiteBottomBase)entity).getShoalSize() != 0) {
                                                                    int halfShoal = (int)Math.round((double)(((EntityPrehistoricFloraTrilobiteBottomBase)entity).getShoalSize())/2D);
                                                                    int remainingShoal = ((EntityPrehistoricFloraTrilobiteBottomBase)entity).getShoalSize() - halfShoal;
                                                                    spawnQty = Math.max(1, halfShoal + rand.nextInt(remainingShoal + 1));
                                                                }
                                                            }
                                                            //System.err.println("spawnQty: " + spawnQty);
                                                            //Check if an associated block or structure is required:
                                                            //EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(mobToSpawn));
                                                            //EntityLiving entity = (EntityLiving) ee.newInstance(world);
                                                            if (entity instanceof EntityPrehistoricFloraDiictodon) {
                                                                EntityPrehistoricFloraLandBase EntityLandBase = (EntityPrehistoricFloraLandBase) entity;
                                                                if (EntityLandBase.hasNest() && (EntityLandBase.homesToNest() && worldGen)) {
                                                                    //Spawn a nest and burrow for it:
                                                                    //Buildburrow:
                                                                    BlockPos pos1 = EntityPrehistoricFloraDiictodon.buildBurrow(world, spawnPos, ((EntityPrehistoricFloraDiictodon) entity).hasLargeBurrow());
                                                                    if (rand.nextInt(3) == 0) {
                                                                        spawnPos = pos1; //Spawn sometimes at the nest burrow and sometime inside
                                                                    }
                                                                    world.setBlockState(pos1, BlockNest.block.getDefaultState());
                                                                    TileEntity te = world.getTileEntity(pos1);
                                                                    if (te != null) {
                                                                        if (te instanceof BlockNest.TileEntityNest) {
                                                                            te.getTileData().setString("creature", EntityRegistry.getEntry(entity.getClass()).getRegistryName().toString());
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            else if (entity instanceof EntityPrehistoricFloraHaldanodon) {
                                                                EntityPrehistoricFloraHaldanodon EntityPrehistoricFloraHaldanodon = (EntityPrehistoricFloraHaldanodon) entity;
                                                                if (EntityPrehistoricFloraHaldanodon.hasNest() && (EntityPrehistoricFloraHaldanodon.homesToNest() && worldGen)) {
                                                                    //Spawn a nest and burrow for it:
                                                                    //Buildburrow:
                                                                    BlockPos pos1 = EntityPrehistoricFloraHaldanodon.buildBurrow(world, spawnPos, ((EntityPrehistoricFloraHaldanodon) entity).hasLargeBurrow());
                                                                    if (rand.nextInt(3) == 0) {
                                                                        spawnPos = pos1; //Spawn sometimes at the nest burrow and sometime inside
                                                                    }
                                                                    world.setBlockState(pos1, BlockNest.block.getDefaultState());
                                                                    TileEntity te = world.getTileEntity(pos1);
                                                                    if (te != null) {
                                                                        if (te instanceof BlockNest.TileEntityNest) {
                                                                            te.getTileData().setString("creature", EntityRegistry.getEntry(entity.getClass()).getRegistryName().toString());
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            else if (entity instanceof EntityPrehistoricFloraLandBase && worldGen) {
                                                                if (Math.random() > 0.8) { // 1:5 chance of nest coming too
                                                                    EntityPrehistoricFloraLandBase EntityLandBase = (EntityPrehistoricFloraLandBase) entity;
                                                                    if (EntityLandBase.hasNest()) {
                                                                        if (!EntityLandBase.isNestMound()) {
                                                                            //Spawn a nest under the mob:
                                                                            world.setBlockState(spawnPos, BlockNest.block.getDefaultState());
                                                                            TileEntity te = world.getTileEntity(spawnPos);
                                                                            if (te != null) {
                                                                                if (te instanceof BlockNest.TileEntityNest) {
                                                                                    te.getTileData().setString("creature", EntityRegistry.getEntry(entity.getClass()).getRegistryName().toString());
                                                                                    te.getTileData().setBoolean("isMound", EntityLandBase.isNestMound());
                                                                                    if (Math.random() > 0.75) { // 1:4 chance of nest containing eggs
                                                                                        te.getTileData().setString("egg", EntityLandBase.getEggNBT());
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else { //Mound nests:
                                                                            if (EntityLandBase.nestBlockMatch(world, spawnPos)) {
                                                                                world.setBlockState(spawnPos, BlockNest.block.getDefaultState());
                                                                                TileEntity te = world.getTileEntity(spawnPos);
                                                                                if (te != null) {
                                                                                    if (te instanceof BlockNest.TileEntityNest) {
                                                                                        te.getTileData().setString("creature", EntityRegistry.getEntry(entity.getClass()).getRegistryName().toString());
                                                                                        te.getTileData().setBoolean("isMound", EntityLandBase.isNestMound());
                                                                                        // Mounds always contain eggs:
                                                                                        te.getTileData().setString("egg", EntityLandBase.getEggNBT());
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            boolean doAgeVar = false;
                                                            if (nbtStr.equalsIgnoreCase("")) {
                                                                doAgeVar = true;
                                                            }

                                                            if (!(TriassicCanyons && spawnPos.getY() > 70)) {
                                                                for (int i = 0; i < spawnQty; ++i) {
                                                                    if (entity instanceof EntityPrehistoricFloraAgeableBase && rand.nextInt(20) == 0 && doAgeVar) {
                                                                        EntityPrehistoricFloraAgeableBase ageableBase = (EntityPrehistoricFloraAgeableBase) entity;
                                                                        int adultAge = ageableBase.getAdultAge();
                                                                        if (adultAge > 0) {
                                                                            int spawnAge = rand.nextInt(adultAge) + 1;
                                                                            nbtStr = "{AgeTicks:" + spawnAge + "}";
                                                                        }
                                                                    }
                                                                    else if (entity instanceof EntityPrehistoricFloraAgeableFishBase && rand.nextInt(20) == 0 && doAgeVar) {
                                                                        EntityPrehistoricFloraAgeableFishBase ageableBase = (EntityPrehistoricFloraAgeableFishBase) entity;
                                                                        int adultAge = ageableBase.getAdultAge();
                                                                        if (adultAge > 0) {
                                                                            int spawnAge = rand.nextInt(adultAge) + 1;
                                                                            nbtStr = "{AgeTicks:" + spawnAge + "}";
                                                                        }
                                                                    }
                                                                    else if (mobToSpawn.startsWith("fossil:")) {
                                                                        if (nbtStr.equalsIgnoreCase("")) {
                                                                            nbtStr = "{Gender:" + rand.nextInt(2) + "}";
                                                                        }
                                                                        else {
                                                                            nbtStr = "{Gender:" + rand.nextInt(2) + "," + nbtStr.substring(1);
                                                                        }
                                                                    }
                                                                    //Spawn the mob via a command:
                                                                    if (!world.isRemote && world.getMinecraftServer() != null) {
                                                                        //System.err.println("summon " + mobToSpawn + " " + pos.add(k7, i18, j11).getX() + " " + pos.add(k7, i18, j11).getY() + " " + pos.add(k7, i18, j11).getZ() + " " + nbtStr);
                                                                        world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
                                                                            @Override
                                                                            public String getName() {
                                                                                return "";
                                                                            }

                                                                            @Override
                                                                            public boolean canUseCommand(int permission, String command) {
                                                                                return true;
                                                                            }

                                                                            @Override
                                                                            public World getEntityWorld() {
                                                                                return world;
                                                                            }

                                                                            @Override
                                                                            public MinecraftServer getServer() {
                                                                                return world.getMinecraftServer();
                                                                            }

                                                                            @Override
                                                                            public boolean sendCommandFeedback() {
                                                                                return false;
                                                                            }

                                                                        }, "pf_summon " + mobToSpawn + " " + spawnPos.getX() + " " + (spawnPos.getY() + offsetter) + " " + spawnPos.getZ() + " " + nbtStr);
                                                                    }

                                                                    //System.err.println("Spawned in " + world.getBiome(spawnPos).getBiomeName() + " at locID " + locationID + " " + mobToSpawn + " at " + spawnPos.getX() + " " + (spawnPos.getY() + 1) + " " + spawnPos.getZ());
                                                                }
                                                                spawnCounter ++;
                                                            }
                                                            if (spawnCounter > (int)Math.ceil((3D * spawnDensity))) {
                                                                //System.err.println("spawnCounter " + spawnCounter);
                                                                return; //Stop as we have spawned (or binned) our group in this chunk now
                                                            }
                                                        }
                                                        //System.err.println("Failed rarity test " + mobToSpawn);
                                                    }
                                                    if (entity != null) {
                                                        entity.setDead();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                if (errFound) {
                    System.err.println("Syntax error in mob spawn config: '" + checkEntity + "'!");
                }
            }
            if (!errFound) {
                spawnerCycle += 1;
            }
            throttle ++;
        }
    }

    private static Class<? extends Entity> findEntity(String entity) {
        Class<? extends Entity> entityClass;
        EntityEntry ee = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entity));
        entityClass = ee == null ? null : ee.getEntityClass();
        if (entityClass == null) {
            //System.err.println("Unknown mob requested for spawn: '" + entity + "'!");
            return null;
        }
        return entityClass;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static BlockPos getTopSolidOrLiquidBlockIncludingLeaves(BlockPos pos, World world)
    {
        Chunk chunk = world.getChunk(pos);
        BlockPos blockpos;
        BlockPos blockpos1;

        for (blockpos = new BlockPos(pos.getX(), chunk.getTopFilledSegment() + 16, pos.getZ()); blockpos.getY() >= 0; blockpos = blockpos1)
        {
            blockpos1 = blockpos.down();
            IBlockState state = chunk.getBlockState(blockpos1);

            if (state.getMaterial().blocksMovement())
            {
                break;
            }
        }

        return blockpos;
    }

    public static BlockPos getTopSolidBlock(BlockPos pos, World world)
    {
        Chunk chunk = world.getChunk(pos);
        BlockPos blockpos = new BlockPos(pos.getX(), chunk.getTopFilledSegment() + 16, pos.getZ());
        BlockPos blockpos1 = blockpos;
        int yy = blockpos.getY();
        while (yy > 0)
        {
            blockpos1 = new BlockPos(pos.getX(), yy, pos.getZ());
            IBlockState state = world.getBlockState(blockpos1);

            if (state.getMaterial().blocksMovement()
                    && state.getMaterial() != Material.WATER
                    && state.getMaterial() != Material.LEAVES
                    && state.getMaterial() != Material.VINE
                    && state.getMaterial() != Material.PLANTS)
            {
                break;
            }
            yy --;
        }

        return blockpos1;
    }

}
