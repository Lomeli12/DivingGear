package com.lomeli.diving.item;

import com.lomeli.diving.DivingGear;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class ItemAirTankFull extends Item{

	//private static int airAmount;
	public ItemAirTankFull(int par1) {
		super(par1);
		this.setCreativeTab(DivingGear.divingGearTab);
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
