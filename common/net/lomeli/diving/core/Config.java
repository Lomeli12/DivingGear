package net.lomeli.diving.core;

import java.awt.event.KeyEvent;
import java.io.File;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ItemIDs;
import net.lomeli.diving.lib.ModInts;
import net.lomeli.diving.lib.ModStrings;

import net.minecraftforge.common.Configuration;

public class Config
{
	private static String defaultCat = "Configurations";
	private static String itemID = "Item IDs";
	private static String gearID = "Gear IDs";
	private static String blockID = "Block IDs";
	
	public static void configureMod(File Loc)
	{
		configModIDs(Loc);
		configModOptionss(Loc);
	}
	
	public static void configModIDs(File Loc)
	{
		Configuration config = new Configuration(Loc);
		
		config.load();
		
		//Gear
		ItemIDs.snorkelID = config.get(gearID, "snorkel", 6050).getInt(6050);
		ItemIDs.adsID = config.get(gearID, "ADS", 6051).getInt(6051);
		ItemIDs.scubaID = config.get(gearID, "scuba", 6052).getInt(6052);
		ItemIDs.advScubaID = config.get(gearID, "adsScuba", 6053).getInt(6053);
		ItemIDs.aqualisHelmID = config.get(gearID, "aqualisHelm", 6054).getInt(6054);
		
		//Items
		ItemIDs.airTankID = config.get(itemID, "airTank", 6060).getInt(6060);
		ItemIDs.doubleTankID = config.get(itemID, "doubleAirTank", 6061).getInt(6061);
		ItemIDs.visTankID = config.get(itemID, "visTank", 6062).getInt(6062);
		ItemIDs.woodenGearID = config.get(itemID, "woodenGear", 6063).getInt(6063);
		ItemIDs.sturdyCoralID = config.get(itemID, "sturdyCoral", 6064).getInt(6064);
		ItemIDs.coralPick = config.get(itemID, "coralPick", 6065).getInt(6065);
		ItemIDs.coralShovel = config.get(itemID, "coralSpade", 6066).getInt(6066);
		ItemIDs.coralSword = config.get(itemID, "coralSword", 6067).getInt(6067);
		ItemIDs.coralAxe = config.get(itemID, "coralAxe", 6068).getInt(6068);
		ItemIDs.coralHoe = config.get(itemID, "coralHoe", 6069).getInt(6069);
		ItemIDs.filterID = config.get(itemID, "filter", 6070).getInt(6070);
		
		//Blocks
		ItemIDs.coralID = config.get(blockID, "coral", 600).getInt(600);
		ItemIDs.airCompressorID = config.get(blockID, "airCompressor", 601).getInt(601);
		ItemIDs.waterMillID = config.get(blockID, "waterMill", 602).getInt(602);
		
		config.save();
	}
	
	public static void configModOptionss(File Loc)
	{
		Configuration config = new Configuration(Loc);
		
		config.load();
		
		ModInts.keyCode = config.get(defaultCat, "gearGUIKeyCode", KeyEvent.VK_BACK_SLASH)
			.getInt(KeyEvent.VK_BACK_SLASH);
		
		ModInts.snorkelAir = config.get(defaultCat, "snorkelAir", 150, ModStrings.SNORKELAIR_DESC).getInt(150);
		ModInts.snorkelUses = config.get(defaultCat, "snorkelUses", 1, ModStrings.SNORKELUSES_DESC).getInt(1);
		ModInts.airTankUses = config.get(defaultCat, "airTankUses", 1, ModStrings.AIRTANK_DESC).getInt(1);
		ModInts.doubleAirTankUses = config.get(defaultCat, "doubleAirTankUses", 2, ModStrings.DAIRTANK_DESC)
			.getInt(2);
		
		ModInts.fluxAmount = config.get(defaultCat, "flux", 5, ModStrings.FLUX_DESC).getInt(5);
		ModInts.visTankX = config.get(defaultCat, "visTankX", -5, ModStrings.VISX_DESC).getInt(-5);
		ModInts.visTankY = config.get(defaultCat, "visTankY", 3, ModStrings.VISY_DESC).getInt(3);
		ModInts.aqualisX = config.get(defaultCat, "aquaX", -7, ModStrings.AQUAX_DESC).getInt(-7);
		ModInts.aqualisY = config.get(defaultCat, "aquaY", 3, ModStrings.AQUAY_DESC).getInt(3);
		ModInts.ticks	= config.get(defaultCat, "ticks", 100, ModStrings.TICK_DESC).getInt(100);
		
		DivingGear.checkForUpdates = config.get(defaultCat, "checkforupdates", true,
			ModStrings.UPDATE_DESC).getBoolean(true);
		
		config.save();
	}
}
