package net.lomeli.diving.core;

import net.lomeli.diving.config.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabDiving extends CreativeTabs
{
    public CreativeTabDiving(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return RegisterItems.airTank.itemID;
    }

    @Override
    public String getTranslatedTabLabel()
    {
        return "Diving Gear";
    }
}
