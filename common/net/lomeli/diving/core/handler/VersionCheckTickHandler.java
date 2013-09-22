package net.lomeli.diving.core.handler;

import java.util.EnumSet;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;

import net.lomeli.lomlib.util.ToolTipUtil;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionCheckTickHandler implements ITickHandler {

    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if (!DivingGear.updater.isUpdate() && DivingGear.checkForUpdates) {
            if (!initialized) {
                for (TickType tickType : type) {
                    if (tickType == TickType.CLIENT) {
                        if (FMLClientHandler.instance().getClient().currentScreen == null) {
                            initialized = true;
                            FMLClientHandler.instance().getClient().ingameGUI
                                    .getChatGUI()
                                    .printChatMessage(
                                            ToolTipUtil.BLUE
                                                    + "["
                                                    + ToolTipUtil.ORANGE
                                                    + ModStrings.MOD_NAME
                                                    + ToolTipUtil.BLUE
                                                    + "]: There is a new version available at "
                                                    + DivingGear.updater
                                                            .getDownloadURL());
                        }
                    }
                }
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {
        return ModStrings.MOD_NAME + ": " + this.getClass().getSimpleName();
    }

}
