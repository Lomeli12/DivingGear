package net.lomeli.diving.lib;

public class ModStrings
{
	public static final String MOD_ID = "diving";
	public static final String MOD_NAME = "Diving Gear";
	public static final String VERSION = ModInts.MAJOR + "." + ModInts.MINOR + "." + ModInts.REVISION;
	public static final String CLIENT = "net.lomeli.diving.core.ClientProxy";
	public static final String COMMON = "net.lomeli.diving.core.CommonProxy";
	public static final String UPDATE_URL = "https://dl.dropboxusercontent.com/u/17430088/Minecraft%20Mods/DivingGear/updateXML.xml";
	
	public static String UPDATE_DESC = "When true, will check for updates everytime minecraft loads. When false, nothing happens";
	
	public static String SNORKELUSES_DESC = "Determines how many times snorkel will refill your air. Default - 1";
	public static String SNORKELAIR_DESC = "Determines how much air the snorkel gives per uses. Default - 150";
	public static String AIRTANK_DESC = "Determines how many uses the standard air tank has. Default - 1";
	public static String DAIRTANK_DESC = "Determines how many uses the double air tank has. Default 2";
	
	public static String FLUX_DESC = "Determines how much flux the Aqualis Helm causes when used. Default - 5";
	public static String VISX_DESC = "Determines the X position of the vis tank research in the Thaumonomicon. Default - -5";
	public static String VISY_DESC = "Determines the Y position of the vis tank research in the Thaumonomicon. Default - 3";
	public static String AQUAX_DESC = "Determines the X position of the Aqualis Helm research in the Thaumonomicon. Default - -7";
	public static String AQUAY_DESC = "Determines the Y position of the Aqualis Helm research in the Thaumonomicon. Default - 3";
	public static String TICK_DESC = "Determines the number of ticks before the water mill produces power. Default - 40";
}
