package net.lomeli.diving.items;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.items.ItemTanks;
import net.lomeli.diving.items.gear.ItemAdvGear;
import net.lomeli.diving.items.gear.ItemSnorkel;
import net.lomeli.diving.lib.ItemIDs;
import net.lomeli.diving.lib.ModInts;

import net.minecraft.item.Item;
import net.minecraft.item.EnumArmorMaterial;

public class ModItems
{
	//Gear
	public static Item snorkel, ADS, scuba, advScuba, aqualisHelm;
	
	//Items
	public static Item airTank, doubleAirTank, visTank, simpleGear, filter, sturdyCoral;
	
	public static void loadItems(){
		//Items
		airTank = new ItemTanks(ItemIDs.airTankID, "airtank", ModInts.airTankUses, false)
			.setUnlocalizedName("airTank");
		doubleAirTank = new ItemTanks(ItemIDs.doubleTankID, "double", ModInts.doubleAirTankUses, true)
			.setUnlocalizedName("doubleAirTank");
		simpleGear = new ItemDiving(ItemIDs.woodenGearID, "simpleGear").setUnlocalizedName("simpleGear");
		filter = new ItemDiving(ItemIDs.filterID, "filter").setUnlocalizedName("filter");
		
		LanguageRegistry.addName(airTank, "Air Tank");
		LanguageRegistry.addName(doubleAirTank, "Dual Air Tank");
		LanguageRegistry.addName(simpleGear, "Simple Gear");
		LanguageRegistry.addName(filter, "Air Filter");
		
		//Gear
		snorkel = new ItemSnorkel(ItemIDs.snorkelID, EnumArmorMaterial.CHAIN, 0, 0, 150, 1)
			.setUnlocalizedName("snorkel").setCreativeTab(DivingGear.modTab);
		ADS = new ItemAdvGear(ItemIDs.adsID, EnumArmorMaterial.CHAIN, 0, 0, "ads", 1, 1, 0)
			.setUnlocalizedName("ads");
		scuba = new ItemAdvGear(ItemIDs.scubaID, EnumArmorMaterial.IRON, 0, 0, "scuba", 3, 2, 1)
			.setUnlocalizedName("scuba");
		advScuba = new ItemAdvGear(ItemIDs.advScubaID, EnumArmorMaterial.IRON, 0, 0, "scuba2", 3, 3, 2)
			.setUnlocalizedName("advScuba");
		
		LanguageRegistry.addName(snorkel, "Snorkel");
		LanguageRegistry.addName(ADS, "ADS: Tritonia");
		LanguageRegistry.addName(scuba, "Scuba Helm");
		LanguageRegistry.addName(advScuba, "Advanced Scuba Helm");
	}
}
