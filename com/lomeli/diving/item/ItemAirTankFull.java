package com.lomeli.diving.item;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class ItemAirTankFull extends Item{

	private static int airAmount;
	public ItemAirTankFull(int par1, int amount) {
		super(par1);
		airAmount = amount;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		
		return itemStack;
    }
}
