package com.lomeli.diving.item;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;

public class ItemDoubleAirTankFull extends Item{

	public ItemDoubleAirTankFull(int par1) {
		super(par1);
		this.setCreativeTab(DivingGear.divingGearTab);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":double");
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		return itemStack;
    }
}
