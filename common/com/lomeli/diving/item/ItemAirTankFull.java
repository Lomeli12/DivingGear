package com.lomeli.diving.item;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

public class ItemAirTankFull extends Item{

	public ItemAirTankFull(int par1) {
		super(par1);
		this.setCreativeTab(DivingGear.divingGearTab);
		this.setMaxDamage(50);
		this.setMaxStackSize(1);
		this.canRepair = false;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":airtank");
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		return itemStack;
    }
	public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) 
	{
		itemStack.damageItem((itemStack.getMaxDamage() - 1), entityPlayer);
	}
}
