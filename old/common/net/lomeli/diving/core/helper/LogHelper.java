package net.lomeli.diving.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper
{
    private static Logger roLogger = Logger.getLogger("DivingGear");

    public static void init()
    {

        roLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message)
    {

        roLogger.log(logLevel, message);
    }
}
