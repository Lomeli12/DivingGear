package com.lomeli.diving.item;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

public class ItemDoubleAirTankFull extends Item
{
	public ItemDoubleAirTankFull(int par1) {
		super(par1);
		this.setCreativeTab(DivingGear.divingGearTab);
		this.setMaxDamage(51);
		this.setMaxStackSize(1);
		this.canRepair = false;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister iconRegister)
	{
		
		iconIndex = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":double");
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		if(entityPlayer != null)
		{
			if(itemStack.getItemDamage() < (itemStack.getMaxDamage() - 1))
			{
				if(entityPlayer.inventory.armorItemInSlot(3) != null)
				{
					if(entityPlayer.inventory.armorItemInSlot(3).itemID == RegisterItems.Scuba2.itemID)
					{
						entityPlayer.inventory.armorItemInSlot(3).setItemDamage(entityPlayer.inventory.armorItemInSlot(3).getItemDamage() - 2);
						itemStack.setItemDamage(itemStack.getItemDamage() + 25);
					}
				}
			}
		}
		return itemStack;
    }
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
	{
		if(entity != null)
		{
			if(entity instanceof EntityPlayer)
			{
				if(itemStack.getItemDamage() < (itemStack.getMaxDamage() -1))
				{
					if(((EntityPlayer) entity).inventory.armorItemInSlot(3) != null)
					{
						if(((EntityPlayer) entity).inventory.armorItemInSlot(3).getItemDamage() == (((EntityPlayer) entity).inventory.armorItemInSlot(3).getMaxDamage() -1))
						{
							if(((EntityPlayer) entity).inventory.armorItemInSlot(3).itemID == RegisterItems.Scuba2.itemID)
							{
								((EntityPlayer) entity).inventory.armorItemInSlot(3).setItemDamage(((EntityPlayer) entity).inventory.armorItemInSlot(3).getItemDamage() - 2);
								itemStack.setItemDamage(itemStack.getMaxDamage() - 1);
							}else{}
						}
					}
				}
			}
		}
	}*/
}
