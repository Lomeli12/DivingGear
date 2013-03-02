package com.lomeli.diving.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.common.IArmorTextureProvider;

public class ItemScuba1 extends ItemArmor implements IArmorTextureProvider
{
	public ItemScuba1(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public String getTextureFile()
	{
		return "/com/lomeli/diving/art/itemsheet1.png";
	}
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		return "/com/lomeli/diving/art/models/scubahelm.png";

	}
	
	private int used = 0;
	public static int uses;
	public static int amount;
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		if(player.isWet()==true)
		{
			if(player.getAir() <= 0)
			{
				if(used <= uses)
				{
					player.setAir(amount);
					used = used + 1;
					player.sendChatToPlayer("[DivingGear] "+((uses-used)/2)+" uses left.");
				}else{}
			}
		}
		else
		{
			used = 0;
		}
	}
}
