package net.lomeli.diving.blocks.coral;

import net.lomeli.diving.blocks.ModBlocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCoral extends ItemBlock {
    public ItemCoral(int par1) {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public Icon getIconFromDamage(int par1) {
        return ModBlocks.coral.getIcon(2, par1);
    }

    public int getMetadata(int meta) {
        return meta;
    }

    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName() + "." + "Coral"
                + itemStack.getItemDamage();
    }
}
