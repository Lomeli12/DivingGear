package net.lomeli.diving.core;

import net.lomeli.diving.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabDG extends CreativeTabs {

    public CreativeTabDG(int par1, String par2Str) {
        super(par1, par2Str);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.airTank);
    }

    @Override
    public String getTranslatedTabLabel() {
        return this.getTabLabel();
    }
}
