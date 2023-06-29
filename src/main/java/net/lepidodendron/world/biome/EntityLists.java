package net.lepidodendron.world.biome;

import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.util.*;
import net.lepidodendron.world.biome.precambrian.BiomePrecambrian;
import net.minecraft.world.biome.Biome;
import org.apache.commons.lang3.ArrayUtils;

public class EntityLists {

    public static String[] mobString(Biome biome, int genType) {

        //0 = WorldGen
        //1 = Air Trap
        //2 = Ground Trap
        //3 = Water Trap

        String[] MobString = new String[0];

        //PRECAMBRIAN:
        if (biome instanceof BiomePrecambrian) {
            if (((BiomePrecambrian) biome).getBiomeType() == EnumBiomeTypePrecambrian.Hadean) {
                switch (genType) {
                    case 0:
                    default:
                        if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                            MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimHadeanMobsPF);
                        }
                    case 1:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimHadeanTrapAirPF);
                    case 2:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimHadeanTrapGroundPF);
                    case 3:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimHadeanTrapWaterPF);
                }
            }

            else if (((BiomePrecambrian) biome).getBiomeType() == EnumBiomeTypePrecambrian.Archean) {
                switch (genType) {
                    case 0:
                    default:
                        if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                            MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimArcheanMobsPF);
                        }
                    case 1:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimArcheanTrapAirPF);
                    case 2:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimArcheanTrapGroundPF);
                    case 3:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimArcheanTrapWaterPF);
                }
            }
            else if (((BiomePrecambrian) biome).getBiomeType() == EnumBiomeTypePrecambrian.Paleoproterozoic) {
                switch (genType) {
                    case 0:
                    default:
                        if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                            MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimPaleoproterozoicMobsPF);
                        }
                    case 1:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimPaleoproterozoicTrapAirPF);
                    case 2:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimPaleoproterozoicTrapGroundPF);
                    case 3:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimPaleoproterozoicTrapWaterPF);
                }
            }
            else if (((BiomePrecambrian) biome).getBiomeType() == EnumBiomeTypePrecambrian.Mesoproterozoic) {
                switch (genType) {
                    case 0:
                    default:
                        if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                            MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimMesoproterozoicMobsPF);
                        }
                    case 1:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimMesoproterozoicTrapAirPF);
                    case 2:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimMesoproterozoicTrapGroundPF);
                    case 3:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimMesoproterozoicTrapWaterPF);
                }
            }
            else if (((BiomePrecambrian) biome).getBiomeType() == EnumBiomeTypePrecambrian.Neoproterozoic) {
                switch (genType) {
                    case 0:
                    default:
                        if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                            MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimNeoproterozoicMobsPF);
                        }
                    case 1:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimNeoproterozoicTrapAirPF);
                    case 2:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimNeoproterozoicTrapGroundPF);
                    case 3:
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimNeoproterozoicTrapWaterPF);
                }
            }
        }
        if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:precambrian_sea")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ediacaran_trench")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ediacaran_frondose_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ediacaran_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ediacaran_extreme_hills")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimEdiacaranMobsPF);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimEdiacaranTrapAirPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimEdiacaranTrapGroundPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPrecambrian.dimEdiacaranTrapWaterPF);
            }
        }

        //CAMBRIAN:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_creek_coastal")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea_shore")
        ) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianMobsOceanPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianMobsOceanFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianMobsOceanReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianTrapAirOceanPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianTrapGroundOceanPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianTrapWaterOceanPF);
            }

        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_estuary")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_estuary_helper")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryMobsPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryMobsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryMobsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryTrapAirPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryTrapGroundPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianEstuaryTrapWaterPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:cambrian_sea_reefs")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefMobsPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefMobsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefMobsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefTrapAirPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefTrapGroundPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCambrian.dimCambrianReefTrapWaterPF);
            }
        }

        //ORDOVICIAN:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_creek_coastal")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_shore")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsOceanPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsOceanFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsOceanReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirOceanPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundOceanPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterOceanPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_ice")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_icebergs")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_creek_coastal_frozen")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sea_shore_frozen")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_beach_frozen")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsOceanIcePF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianOceanIceMobsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianOceanIceMobsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirOceanIcePF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundOceanIcePF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterOceanIcePF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_lagoon")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_lagoon_helper")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsLagoonPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsLagoonFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsLagoonReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirLagoonPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundLagoonPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterLagoonPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_algal_reef")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsAlgalPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsAlgalFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsAlgalReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirAlgalPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundAlgalPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterAlgalPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_bryozoan_reef")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBryozoanPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBryozoanFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBryozoanReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirBryozoanPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundBryozoanPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterBryozoanPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_sponge_forest")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsSpongePF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsSpongeFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsSpongeReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirSpongePF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundSpongePF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterSpongePF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_bog")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:ordovician_creek_bog")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBogPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBogFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianMobsBogReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapAirBogPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapGroundBogPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsOrdovician.dimOrdovicianTrapWaterBogPF);
            }
        }

        //SILURIAN:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_sandy")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_shore")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_shore_helper")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_creek_coastal")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsOceanPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianOceanMobsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianOceanMobsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirOceanPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundOceanPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterOceanPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_lagoon")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_lagoon_helper")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsLagoonPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsLagoonFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsLagoonReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirLagoonPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundLagoonPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterLagoonPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_coral")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCoralPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCoralFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCoralReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirCoralPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundCoralPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterCoralPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_reef")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsReefPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsReefFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsReefReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirReefPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundReefPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterReefPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_sea_garden")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCrinoidPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCrinoidFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsCrinoidReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirCrinoidPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundCrinoidPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterCrinoidPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_lush_patch")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_silty_swamp")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_cooksonia")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_creek_silty_swamp")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:silurian_creek_cooksonia")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsSwampPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsSwampFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianMobsSwampReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapAirSwampPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapGroundSwampPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsSilurian.dimSilurianTrapWaterSwampPF);
            }
        }

        //DEVONIAN:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_deep_rocky")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_coastal")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsOceanPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsOceanFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsOceanReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirOceanPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundOceanPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterOceanPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_reef_transition")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsReefPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsReefFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsReefReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirReefPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundReefPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterReefPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_hypersaline_sinkhole")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSinkholePF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSinkholeFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSinkholeReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirSinkholePF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundSinkholePF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterSinkholePF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_ocean_dead_reef")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsDeadReefPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsDeadReefFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsDeadReefReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirDeadReefPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundDeadReefPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterDeadReefPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_brackish")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_brackish")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsBrackishPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsBrackishFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsBrackishReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirBrackishPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundBrackishPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterBrackishPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_lycopsid_spinney")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsForestPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsForestFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsForestReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirForestPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundForestPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterForestPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_floodplain")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_floodplain")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsFloodplainPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsFloodplainFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsFloodplainReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirFloodplainPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundFloodplainPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterFloodplainPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_swamp")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_swamp")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSwampPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSwampFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSwampReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirSwampPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundSwampPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterSwampPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_gilboa")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_gilboa")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsWattiezaPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsWattiezaFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsWattiezaReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirWattiezaPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundWattiezaPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterWattiezaPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_meadow")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_creek_meadow")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMeadowPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMeadowFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMeadowReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirMeadowPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundMeadowPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterMeadowPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_springs")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSpringsPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSpringsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSpringsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirSpringsPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundSpringsPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterSpringsPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_savanna")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSavannaPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSavannaFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsSavannaReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirSavannaPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundSavannaPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterSavannaPF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_vale")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsValePF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsValeFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsValeReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirValePF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundValePF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterValePF);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:devonian_mountains")) {
            switch (genType) {
                case 0:
                default:
                    if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMountainsPF);
                    }
                    if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMountainsFA);
                    }
                    if (LepidodendronConfig.doSpawnsReborn) {
                        MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianMobsMountainsReborn);
                    }
                case 1:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapAirMountainsPF);
                case 2:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapGroundMountainsPF);
                case 3:
                    MobString = ArrayUtils.addAll(MobString, SpawnerConfigsDevonian.dimDevonianTrapWaterMountainsPF);
            }
        }

        //CARBONIFEROUS:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_shore")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_creek_coastal")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_ocean_cliff")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanCliffPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsOceanReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_hills_edge")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_creek_hills")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsHillsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsHillsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsHillsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_estuary")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_estuary_helper")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsEstuaryPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsEstuaryFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsEstuaryReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_marsh")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_creek_marsh")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsMarshPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsMarshFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsMarshReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_polar_desert")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_polar_lakes")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_polar_desert_edge")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_polar_desert_spikes")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_creek_polar")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsIcePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsIceFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsIceReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_swamp")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_swamp_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_creek_swamp")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_swamp_river_border")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsSwampPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsSwampFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsSwampReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:carboniferous_swamp_burnt")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsBurntSwampPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsBurntSwampFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsCarboniferous.dimCarboniferousMobsBurntSwampReborn);
            }
        }

        //PERMIAN:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_stony_plains")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_stony_plains_spikes")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_stony")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsStonyPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsStonyFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsStonyReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_arid_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_arid_lands")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_arid")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_arid_lands_lush")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsLushPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsLushFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsAridLandsLushReborn);
            }

        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_cold_glossopteris_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_shore")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_coastal")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_cliff")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_ocean_sponge_reef")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanCliffPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanCliffFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsOceanCliffReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_cold_glossopteris_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_temperate_glossopteris_copse")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_temperate_glossopteris")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_cold_glossopteris_forest_light")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_cold_glossopteris_forest_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_cold_glossopteris")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisTemperatePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsGlossopterisReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_desert")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_desert")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsDesertPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsDesertFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsDesertReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_floodbasalt")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_floodbasalt_edge")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsFloodbasaltPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsFloodbasaltFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsFloodbasaltReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_highlands")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_highlands")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsHighlandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsHighlandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsHighlandsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_lowlands_floodplain")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_lowlands")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_lowlands")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_lowlands_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandForestPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandForestFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsLowlandForestReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_mountains")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsMountainsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsMountainsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsMountainsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_river")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsRiverPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsRiverFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsRiverReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_wetlands")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_wetlands_unwooded")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_wetlands_fern_copse")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:permian_creek_wetlands")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsWetlandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsWetlandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsPermian.dimPermianMobsWetlandsReborn);
            }
        }

        //TRIASSIC:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_shore")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_coastal_creek")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_ocean_clam_beds")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanClamBedsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanClamBedsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsOceanClamBedsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_river")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsRiverPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsRiverFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsRiverReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_xeric_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericForestPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericForestFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericForestReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_xeric_scrubland")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_xeric")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericScrublandPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericShrublandFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsXericShrublandReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_warm_lakeland")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_warm_lakeland")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsLakelandPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsLakelandFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsLakelandReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_warm_volcanic_hills")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsVolcanicHillsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsVolcanicHillsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsVolcanicHillsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_flooded_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_flooded_forest_dense")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_flooded_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsFloodedForestPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsFloodedForestFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsFloodedForestReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_gondwanan_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_gondwanan_forest_crags")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_gondwanan_forest_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_gondwanan_forest_clearing")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_gondwanan_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCoolForestPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCoolForestFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCoolForestReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_gondwanan_plain")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMossMeadowPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMossMeadowFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMossMeadowReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_rocky")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDesertPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDesertFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDesertReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_sandy")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_desert")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_pleuromeia_beds")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsPleuromeiaPF);
            }
//            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesFA);
//            }
//            if (LepidodendronConfig.doSpawnsReborn) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesReborn);
//            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_woodland_field")
            || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_woodland_polje_edge")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsSphenopterisPF);
            }
//            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesFA);
//            }
//            if (LepidodendronConfig.doSpawnsReborn) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesReborn);
//            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_woodland")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsWoodlandPF);
            }
//            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesFA);
//            }
//            if (LepidodendronConfig.doSpawnsReborn) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesReborn);
//            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_woodland_polje")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsPoljePF);
            }
//            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesFA);
//            }
//            if (LepidodendronConfig.doSpawnsReborn) {
//                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsDunesReborn);
//            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_plateau")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_plateau_broken")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_desert_plateau_canyons")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsPlateauPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsPlateauFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsPlateauReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_riverbank")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_riverbank_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCanyonsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCanyonsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsCanyonsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_volcanic_islands")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_beach_black")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_creek_coastal_black")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsIslandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsIslandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsIslandsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:triassic_mountains")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMountainsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMountainsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsTriassic.dimTriassicMobsMountainsReborn);
            }
        }

        //JURASSIC:
        else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_shore")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_beach")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_coastal_creek")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_glass_sponge_reef")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanGlassSpongePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanGlassSpongeFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanGlassSpongeReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_coral")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanCoralPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanCoralFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanCoralReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ocean_rafts")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanRaftPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanRaftFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOceanRaftReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_river")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_riverbank")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mudflats")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mudflats_helper")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRiverPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRiverFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRiverReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_garrigue")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_creek_garrigue")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarriguePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_garrigue_copse")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueTreesPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueTreesFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueTreesReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_boulders")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueBouldersPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueBouldersFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueBouldersReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_cycad_thickets")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueCycadsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueCycadsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGarrigueCycadsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_fern_pasture")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_creek_fern_pasture")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFernPasturePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFernPastureFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFernPastureReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_floodplain")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_creek_floodplain")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_floodplain_forested")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainForestedPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainForestedFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsFloodplainForestedReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ginkgo_parkland")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoParklandPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoParklandFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoParklandReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_ginkgo_woodland")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_creek_ginkgo_woodland")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_lakes")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_lake_shore")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoLakesPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoLakesFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsGinkgoLakesReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mire")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mire_helper")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mire_lakes")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMirePF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMireFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMireReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mudflats_estuary")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_mudflats_estuary_helper")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsPF);
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsFA);
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsReborn);
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsMudflatsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_outcrops_edge")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_outcrops")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsRocksPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsRocksFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsOutcropsRocksReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_redwood_forest")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_redwood_hills")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_redwood_mountains")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_creek_redwood_forest")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsConiferousPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsConiferousFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsConiferousReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_rough_hills")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRoughHillsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRoughHillsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsRoughHillsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_sandbanks")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_sandbanks_raised")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_sandbanks_solid")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsRaisedPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsRaisedFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsIslandsRaisedReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_southern_taiga")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_southern_taiga_basalt")
                || biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_southern_taiga_hills")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaReborn);
            }
        } else if (biome.getRegistryName().toString().equalsIgnoreCase("lepidodendron:jurassic_beach_black")) {
            if (LepidodendronConfig.doSpawnsPrehistoricFloraDefault) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaBeachPF);
            }
            if (LepidodendronConfig.doSpawnsFossilsArcheology) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaBeachFA);
            }
            if (LepidodendronConfig.doSpawnsReborn) {
                MobString = ArrayUtils.addAll(MobString, SpawnerConfigsJurassic.dimJurassicMobsTaigaBeachReborn);
            }
        }
        return MobString;
    }
}
