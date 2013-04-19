package net.lomeli.diving.item;

import net.lomeli.diving.lib.ReferenceStrings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDiving extends Item
{

    private String texture;

    public ItemDiving(int par1, String parTexture)
    {
        super(par1);
        texture = parTexture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":" + texture);
    }
}
