package com.lomeli.diving.item;

import com.lomeli.diving.DivingGear;

import net.minecraft.item.Item;

public class ItemDiving extends Item{

	public ItemDiving(int par1) {
		super(par1);
		this.setCreativeTab(DivingGear.divingGearTab);
	}
	
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/itemsheet1.png";
	}
	
}
