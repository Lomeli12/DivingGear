package net.lomeli.diving.items;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.items.ItemTanks;
import net.lomeli.diving.items.gear.ItemSnorkel;
import net.lomeli.diving.lib.ItemIDs;
import net.lomeli.diving.lib.ModInts;

import net.minecraft.item.Item;
import net.minecraft.item.EnumArmorMaterial;

public class ModItems
{
	//Gear
	public static Item snorkel, ADS, suba, advScuba, aqualisHelm;
	
	//Items
	public static Item airTank, doubleAirTank, visTank, woodenGear, sturdyCoral;
	
	public static void loadItems()
	{
		//Items
		airTank = new ItemTanks(ItemIDs.airTankID, "airtank", ModInts.airTankUses)
			.setUnlocalizedName("airTank");
		doubleAirTank = new ItemTanks(ItemIDs.doubleTankID, "double", ModInts.doubleAirTankUses)
			.setUnlocalizedName("doubleAirTank");
		
		LanguageRegistry.addName(airTank, "Air Tank");
		LanguageRegistry.addName(doubleAirTank, "Dual Air Tank");
		
		//Gear
		snorkel = new ItemSnorkel(ItemIDs.snorkelID, EnumArmorMaterial.CHAIN, 0, 0, 150, 1)
			.setUnlocalizedName("snorkel").setCreativeTab(DivingGear.modTab);
		
		LanguageRegistry.addName(snorkel, "Snorkel");
	}
}
