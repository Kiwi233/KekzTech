package common;

import common.blocks.Block_ControlRod;
import common.blocks.Block_GDCUnit;
import common.blocks.Block_ItemServerDrive;
import common.blocks.Block_ItemServerIOPort;
import common.blocks.Block_ItemServerRackCasing;
import common.blocks.Block_ReactorChamber_OFF;
import common.blocks.Block_TFFTCasing;
import common.blocks.Block_TFFTMultiHatch;
import common.blocks.Block_TFFTStorageFieldBlockT1;
import common.blocks.Block_TFFTStorageFieldBlockT2;
import common.blocks.Block_TFFTStorageFieldBlockT3;
import common.blocks.Block_TFFTStorageFieldBlockT4;
import common.blocks.Block_TFFTStorageFieldBlockT5;
import common.blocks.Block_YSZUnit;
import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import items.ErrorItem;
import items.MetaItem_CraftingComponent;
import kekztech.Items;
import kekztech.KekzCore;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import util.Util;

public class Recipes {
	
	public static void init() {
		registerRecipes_TFFT();
		registerRecipes_SOFC();
		registerRecipes_Nuclear();
		//registerRecipes_ItemServer();
	}
	
	private static void registerRecipes_TFFT() {
		
		// Controller
		final Object[] tfft_recipe = {
				"HFH", "PVP", "CFC",
				'H', OrePrefixes.pipeMedium.get(Materials.StainlessSteel),
				'F', ItemList.Field_Generator_MV.get(1L),
				'P', ItemList.Electric_Pump_HV.get(1L),
				'V', OrePrefixes.rotor.get(Materials.VibrantAlloy),
				'C', OrePrefixes.circuit.get(Materials.Data)
		};
		GT_ModHandler.addCraftingRecipe(KekzCore.fms.getStackForm(1), tfft_recipe);
		
		// Blocks
		final ItemStack[] tfftcasing = {
				GT_Utility.getIntegratedCircuit(6),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 3),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 3),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
			};
			GT_Values.RA.addAssemblerRecipe(
					tfftcasing, 
					FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144),
					new ItemStack(Block_TFFTCasing.getInstance(), 1), 
					200, 256);
			final ItemStack[] tfftstoragefield1 = {
				GT_Utility.getIntegratedCircuit(6),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 1),
				GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1),
				ItemList.Electric_Pump_LV.get(1L)
			};
			GT_Values.RA.addAssemblerRecipe(
					tfftstoragefield1, 
					FluidRegistry.getFluidStack("molten.glass", 144),
					new ItemStack(Block_TFFTStorageFieldBlockT1.getInstance(), 1), 
					200, 256);
			final ItemStack[] tfftstoragefield2 = {
					GT_Utility.getIntegratedCircuit(6),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.PulsatingIron, 4),
					GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1),
					ItemList.Electric_Pump_MV.get(1L)
				};
			GT_Values.RA.addAssemblerRecipe(
					tfftstoragefield2, 
					FluidRegistry.getFluidStack("molten.plastic", 576),
					new ItemStack(Block_TFFTStorageFieldBlockT2.getInstance(), 1), 
					200, 480);
			final ItemStack[] tfftstoragefield3 = {
					GT_Utility.getIntegratedCircuit(6),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VibrantAlloy, 2),
					GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1),
					ItemList.Field_Generator_MV.get(1L),
					ItemList.Electric_Pump_HV.get(2L)
				};
			GT_Values.RA.addAssemblerRecipe(
					tfftstoragefield3, 
					FluidRegistry.getFluidStack("molten.epoxid", 576),
					new ItemStack(Block_TFFTStorageFieldBlockT3.getInstance(), 1), 
					300, 1920);
			final ItemStack[] tfftstoragefield4 = {
					GT_Utility.getIntegratedCircuit(6),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
					GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.NiobiumTitanium, 1),
					GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.TungstenSteel, 1),
					ItemList.Field_Generator_HV.get(1L),
					ItemList.Electric_Pump_EV.get(1L)
				};
			GT_Values.RA.addAssemblerRecipe(
					tfftstoragefield4, 
					FluidRegistry.getFluidStack("molten.epoxid", 1152),
					new ItemStack(Block_TFFTStorageFieldBlockT4.getInstance(), 1), 
					400, 4098);
			final ItemStack[] tfftstoragefield5 = {
					GT_Utility.getIntegratedCircuit(6),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
					GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.HSSS, 1),
					GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Enderium, 1),
					ItemList.Field_Generator_EV.get(1L),
					ItemList.Electric_Pump_IV.get(1L)
				};
			GT_Values.RA.addAssemblerRecipe(
					tfftstoragefield5, 
					FluidRegistry.getFluidStack("molten.epoxid", 1152),
					new ItemStack(Block_TFFTStorageFieldBlockT5.getInstance(), 1), 
					400, 6147);
			final Object[] multi_hatch = {
					"PRP", "UFU", "PRP",
					'P', GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.NiobiumTitanium, 1),
					'R', GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
					'U', ItemList.Electric_Pump_IV.get(1L),
					'F', ItemList.Field_Generator_HV.get(1L)
			};		
			GT_ModHandler.addCraftingRecipe(new ItemStack(Block_TFFTMultiHatch.getInstance()), multi_hatch);
	}
	
	private static void registerRecipes_SOFC() {
		
		final MetaItem_CraftingComponent craftingItem = MetaItem_CraftingComponent.getInstance();
		
		// Controller
		final Object[] mk1_recipe = {
				"CCC", "PHP", "FBL",
				'C', OrePrefixes.circuit.get(Materials.Advanced),
				'P', ItemList.Electric_Pump_HV.get(1L),
				'H', ItemList.Hull_HV.get(1L),
				'F', GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1),
				'B', GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Gold, 1),
				'L', GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1)
		};		
		GT_ModHandler.addCraftingRecipe(KekzCore.sofc1.getStackForm(1), mk1_recipe);
		final Object[] mk2_recipe = {
				"CCC", "PHP", "FBL",
				'C', OrePrefixes.circuit.get(Materials.Master),
				'P', ItemList.Electric_Pump_IV.get(1L),
				'H', ItemList.Hull_IV.get(1L),
				'F', GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Ultimate, 1),
				'B', Util.getStackofAmountFromOreDict("wireGt04SuperconductorEV", 1),
				'L', GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Ultimate, 1)
		};
		GT_ModHandler.addCraftingRecipe(KekzCore.sofc2.getStackForm(1), mk2_recipe);
		
		// Blocks
		final ItemStack[] yszUnit = {
				GT_Utility.getIntegratedCircuit(6),
				craftingItem.getStackOfAmountFromDamage(Items.YSZCeramicPlate.getMetaID(), 4),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Yttrium, 1),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
				ItemList.Electric_Motor_HV.get(1L),
		};
		GT_Values.RA.addAssemblerRecipe(
				yszUnit, 
				Materials.Hydrogen.getGas(4000), 
				new ItemStack(Block_YSZUnit.getInstance(), 1), 
				1200, 480);
		final ItemStack[] gdcUnit = {
				GT_Utility.getIntegratedCircuit(6),
				craftingItem.getStackOfAmountFromDamage(Items.GDCCeramicPlate.getMetaID(), 8),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Gadolinium, new ItemStack(ErrorItem.getInstance(), 1), 1),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, new ItemStack(ErrorItem.getInstance(), 1), 1),
				ItemList.Electric_Motor_IV.get(1L),
		};
		GT_Values.RA.addAssemblerRecipe(
				gdcUnit, 
				Materials.Hydrogen.getGas(16000), 
				new ItemStack(Block_GDCUnit.getInstance(), 1), 
				2400, 1920);
		
		// Items
		GT_Values.RA.addAlloySmelterRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.YSZCeramicDust.getMetaID(), Loader.isModLoaded("bartworks") ? 3 : 10), 
				ItemList.Shape_Mold_Plate.get(0),
				craftingItem.getStackOfAmountFromDamage(Items.YSZCeramicPlate.getMetaID(), 1), 
				400, 480);
		GT_Values.RA.addFormingPressRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.GDCCeramicDust.getMetaID(), 10), 
				ItemList.Shape_Mold_Plate.get(0),
				craftingItem.getStackOfAmountFromDamage(Items.GDCCeramicPlate.getMetaID(), 1), 
				800, 480);
		
		if (!Loader.isModLoaded("bartworks")) {
			GT_Values.RA.addChemicalRecipe(
					Materials.Yttrium.getDust(1), GT_Utility.getIntegratedCircuit(6), Materials.Oxygen.getGas(3000),
					null, craftingItem.getStackOfAmountFromDamage(Items.YttriaDust.getMetaID(), 1), null,
					400, 30);
			GT_Values.RA.addChemicalRecipe(
					Util.getStackofAmountFromOreDict("dustZirconium", 1), GT_Utility.getIntegratedCircuit(6), Materials.Oxygen.getGas(2000),
					null, craftingItem.getStackOfAmountFromDamage(Items.ZirconiaDust.getMetaID(), 1), null,
					400, 30);
		}
		
		GT_Values.RA.addChemicalRecipe(
				Materials.Cerium.getDust(2), GT_Utility.getIntegratedCircuit(6), Materials.Oxygen.getGas(3000),
				null, craftingItem.getStackOfAmountFromDamage(Items.CeriaDust.getMetaID(), 2), null, 
				400, 30);
		GT_Values.RA.addMixerRecipe(
				Items.YttriaDust.getOreDictedItemStack(1),
				Items.ZirconiaDust.getOreDictedItemStack(5),
				GT_Utility.getIntegratedCircuit(6), null, null, null,
				craftingItem.getStackOfAmountFromDamage(Items.YSZCeramicDust.getMetaID(), 6), 
				400, 96);
		GT_Values.RA.addMixerRecipe(
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gadolinium, new ItemStack(ErrorItem.getInstance(), 1), 1),
				craftingItem.getStackOfAmountFromDamage(Items.CeriaDust.getMetaID(), 9),
				GT_Utility.getIntegratedCircuit(6), null, null, null,
				craftingItem.getStackOfAmountFromDamage(Items.GDCCeramicDust.getMetaID(), 10), 
				400, 1920);
	}
	
	private static void registerRecipes_Nuclear() {
		
		final MetaItem_CraftingComponent craftingItem = MetaItem_CraftingComponent.getInstance();
		
		// Controller
		
		// Blocks
		final ItemStack[] controlrod = {
				GT_Utility.getIntegratedCircuit(6),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Lead, 1),
				GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 4),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 64)
			};
		GT_Values.RA.addAssemblerRecipe(
				controlrod, 
				null,
				new ItemStack(Block_ControlRod.getInstance(), 1), 
				800, 480);
		final ItemStack[] reactorchamber = {
				GT_Utility.getIntegratedCircuit(6),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Lead, 1),
				GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Lead, 9),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 18),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 2),
			};
		GT_Values.RA.addAssemblerRecipe(
				reactorchamber, 
				FluidRegistry.getFluidStack("wet.concrete", 144),
				new ItemStack(Block_ReactorChamber_OFF.getInstance(), 1), 
				1600, 480);
		
		// Items
		GT_Values.RA.addMixerRecipe(Materials.Boron.getDust(1),	Materials.Arsenic.getDust(1), GT_Utility.getIntegratedCircuit(6), null, 
				null, null, craftingItem.getStackOfAmountFromDamage(Items.BoronArsenideDust.getMetaID(), 2), 
				100, 1920);
		GT_Values.RA.addChemicalRecipe(
				Materials.Ammonia.getCells(2),
				Materials.CarbonDioxide.getCells(1),
				null,
				null,
				craftingItem.getStackOfAmountFromDamage(Items.AmineCarbamiteDust.getMetaID(), 1),
				Util.getStackofAmountFromOreDict("cellEmpty", 3), 
				400, 30);
		GT_Values.RA.addChemicalRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.AmineCarbamiteDust.getMetaID(), 1),
				Materials.Diamond.getDust(16),
				Materials.CarbonDioxide.getGas(1000),
				null,
				craftingItem.getStackOfAmountFromDamage(Items.IsotopicallyPureDiamondDust.getMetaID(), 1),
				null, 1200, 480);
		
		GT_Values.RA.addAutoclaveRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.IsotopicallyPureDiamondDust.getMetaID(), 4), 
				Materials.CarbonDioxide.getGas(16000), 
				craftingItem.getStackOfAmountFromDamage(Items.IsotopicallyPureDiamondCrystal.getMetaID(), 1), 10000, 2400, 7680);
		GT_Values.RA.addAutoclaveRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.BoronArsenideDust.getMetaID(), 4), 
				Materials.Nitrogen.getGas(4000), 
				craftingItem.getStackOfAmountFromDamage(Items.BoronArsenideCrystal.getMetaID(), 1), 10000, 2400, 1920);
		
		GT_Values.RA.addLatheRecipe(
				GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnnealedCopper, 1),  
				craftingItem.getStackFromDamage(Items.CopperHeatPipe.getMetaID()),
				null, 120, 120);
		GT_Values.RA.addLatheRecipe(
				GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Silver, 1),
				craftingItem.getStackFromDamage(Items.SilverHeatPipe.getMetaID()),
				null, 120, 480);
		GT_Values.RA.addLatheRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.BoronArsenideCrystal.getMetaID(), 4),  
				craftingItem.getStackFromDamage(Items.BoronArsenideHeatPipe.getMetaID()),
				null, 1200, 1920);
		GT_Values.RA.addLatheRecipe(
				craftingItem.getStackOfAmountFromDamage(Items.IsotopicallyPureDiamondCrystal.getMetaID(), 4),  
				craftingItem.getStackFromDamage(Items.DiamondHeatPipe.getMetaID()),
				null, 1200, 7680);	
	}
	
	private static void registerRecipes_ItemServer() {
		
		final MetaItem_CraftingComponent craftingItem = MetaItem_CraftingComponent.getInstance();
		
		// Controller
		final Object[] is_recipe = {
				"FRF", "CGC", "PZP",
				'F', GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
				'R', GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
				'C', ItemList.Conveyor_Module_LuV.get(1L),
				'G', ItemList.Field_Generator_EV.get(1L),
				'P', GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.VanadiumGallium, 1),
				'Z', GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1)
		};
		GT_ModHandler.addCraftingRecipe(KekzCore.is.getStackForm(1), is_recipe);
		
		// Blocks
		final Object[] is_rack_recipe = {
				"BRB", "CFC", "BRB",
				'B', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlueSteel, 1),
				'R', GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 1),
				'C', GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Platinum, 1),
				'F', GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
		};
		GT_ModHandler.addCraftingRecipe(new ItemStack(Block_ItemServerRackCasing.getInstance()), is_rack_recipe);
		final ItemStack[] is_ioport = {
				GT_Utility.getIntegratedCircuit(6),
				new ItemStack(Block_ItemServerRackCasing.getInstance()),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16),
				GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Platinum, 2),
				ItemList.Field_Generator_HV.get(1L),
				ItemList.Robot_Arm_EV.get(4L)
			};
			GT_Values.RA.addAssemblerRecipe(
					is_ioport, 
					FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144),
					new ItemStack(Block_ItemServerIOPort.getInstance(), 1), 
					200, 7680);
		final Object[] is_blade = {
				"CRC", "CMC", "HPH",
				'C', GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
				'R', GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 1),
				'P', GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 1),
				'M', ItemList.Electric_Motor_EV.get(1L),
				'H', craftingItem.getStackFromDamage(Items.BoronArsenideHeatPipe.getMetaID()),
		};
		GT_ModHandler.addCraftingRecipe(craftingItem.getStackOfAmountFromDamage(Items.ItemServerBlade.getMetaID(), 8), is_blade);
		final ItemStack[] is_drive = {
				GT_Utility.getIntegratedCircuit(6),
				craftingItem.getStackOfAmountFromDamage(Items.ItemServerBlade.getMetaID(), 8),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlueSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 16)
			};
			GT_Values.RA.addAssemblerRecipe(
					is_drive, 
					FluidRegistry.getFluidStack("molten.polyethylene", 1152),
					new ItemStack(Block_ItemServerDrive.getInstance(), 1), 
					200, 7680);
	}
}