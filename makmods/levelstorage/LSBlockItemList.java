package makmods.levelstorage;

import makmods.levelstorage.armor.ItemArmorEnergeticChestplate;
import makmods.levelstorage.armor.ItemArmorEnhancedLappack;
import makmods.levelstorage.armor.ItemArmorEnhancedNanoChestplate;
import makmods.levelstorage.armor.ItemArmorLevitationBoots;
import makmods.levelstorage.armor.ItemArmorSupersonicLeggings;
import makmods.levelstorage.armor.ItemArmorTeslaHelmet;
import makmods.levelstorage.armor.antimatter.ItemArmorAntimatterBoots;
import makmods.levelstorage.armor.antimatter.ItemArmorAntimatterChestplate;
import makmods.levelstorage.armor.antimatter.ItemArmorAntimatterHelmet;
import makmods.levelstorage.armor.antimatter.ItemArmorAntimatterLeggings;
import makmods.levelstorage.block.BlockASU;
import makmods.levelstorage.block.BlockAntimatterStone;
import makmods.levelstorage.block.BlockChromiteOre;
import makmods.levelstorage.block.BlockIVGenerator;
import makmods.levelstorage.block.BlockLavaFabricator;
import makmods.levelstorage.block.BlockMassMelter;
import makmods.levelstorage.block.BlockMulticoreSolarPanel;
import makmods.levelstorage.block.BlockParticleAccelerator;
import makmods.levelstorage.block.BlockRockDesintegrator;
import makmods.levelstorage.block.BlockUnstableQuartz;
import makmods.levelstorage.block.BlockWirelessConductor;
import makmods.levelstorage.block.BlockWirelessPowerSynchronizer;
import makmods.levelstorage.init.ModUniversalInitializer;
import makmods.levelstorage.item.ItemAdvancedScanner;
import makmods.levelstorage.item.ItemAntimatterCrystal;
import makmods.levelstorage.item.ItemAntimatterRing;
import makmods.levelstorage.item.ItemAtomicDisassembler;
import makmods.levelstorage.item.ItemElectricLighter;
import makmods.levelstorage.item.ItemElectricMagnet;
import makmods.levelstorage.item.ItemElectricSickle;
import makmods.levelstorage.item.ItemEnergeticEnrichedMatterOrb;
import makmods.levelstorage.item.ItemEnhancedDiamondDrill;
import makmods.levelstorage.item.ItemFrequencyCard;
import makmods.levelstorage.item.ItemPocketRefrigerant;
import makmods.levelstorage.item.ItemQuantumRing;
import makmods.levelstorage.item.ItemQuantumSaber;
import makmods.levelstorage.item.ItemSuperconductor;
import makmods.levelstorage.item.ItemXPTome;

/**
 * Contains all the items and blocks mod has. These are initialized dynamically
 * via {@link ModUniversalInitializer} during LevelStorage's init-phase. Block's
 * type name MUST start with Block
 * 
 * @author mak326428
 * 
 */
public class LSBlockItemList {
	public static BlockWirelessConductor blockWlessConductor;
	public static BlockWirelessPowerSynchronizer blockWlessPowerSync;
	public static BlockMulticoreSolarPanel blockMulticoreSolarPanel;
	public static BlockAntimatterStone blockAntimatterStone;
	public static ItemXPTome itemLevelStorageBook;
	public static ItemAdvancedScanner itemAdvScanner;
	public static ItemFrequencyCard itemFreqCard;
	public static ItemEnhancedDiamondDrill itemEnhDiamondDrill;
	public static ItemPocketRefrigerant itemPocketRefrigerant;
	public static ItemArmorLevitationBoots itemLevitationBoots;
	public static ItemArmorSupersonicLeggings itemSupersonicLeggings;
	public static ItemArmorEnergeticChestplate itemArmorEnergeticChestplate;
	public static ItemArmorTeslaHelmet itemArmorTeslaHelmet;
	public static ItemSuperconductor itemSuperconductor;
	public static ItemEnergeticEnrichedMatterOrb itemStorageFourtyMillion;
	public static ItemElectricSickle itemElectricSickle;
	public static ItemQuantumSaber itemQuantumSaber;
	public static ItemQuantumRing itemQuantumRing;
	public static ItemElectricMagnet itemElectricMagnet;
	public static ItemAtomicDisassembler itemAtomicDisassembler;
	public static ItemArmorEnhancedLappack itemEnhLappack;
	public static ItemElectricLighter itemElectricLighter;
	public static BlockParticleAccelerator blockParticleAccelerator;
	public static ItemArmorEnhancedNanoChestplate itemArmorEnhancedNanoChestplate;
	public static BlockChromiteOre blockChromiteOre;
	public static BlockUnstableQuartz blockUnstableQuartz;
	public static BlockRockDesintegrator blockRockDesintegrator;
	public static BlockLavaFabricator blockLavaFabricator;
	public static BlockMassMelter blockMassMelter;
	public static ItemArmorAntimatterBoots itemArmorAntimatterBoots;
	public static ItemArmorAntimatterLeggings itemArmorAntimatterLeggings;
	public static ItemArmorAntimatterChestplate itemArmorAntimatterChestplate;
	public static ItemArmorAntimatterHelmet itemArmorAntimatterHelmet;
	public static BlockIVGenerator blockIVGenerator;
	public static BlockASU blockASU;
	public static ItemAntimatterCrystal itemAntimatterCrystal;
	public static ItemAntimatterRing itemAntimatterRing;
}
