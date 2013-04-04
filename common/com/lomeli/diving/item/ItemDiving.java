package com.lomeli.diving.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.lomeli.diving.lib.ReferenceStrings;

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
    public void updateIcons(IconRegister iconRegister)
    {
        iconIndex = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":" + texture);
    }
}
