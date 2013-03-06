package com.lomeli.diving.item;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class ItemAirTankFull extends Item{

	//private static int airAmount;
	public ItemAirTankFull(int par1) {
		super(par1);
		//airAmount = amount;
	}
	
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/itemsheet1.png";
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		
		return itemStack;
    }
}
