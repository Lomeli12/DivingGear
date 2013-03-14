package com.lomeli.diving.armor;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraftforge.common.IArmorTextureProvider;;

public class ItemADS extends ItemArmor implements IArmorTextureProvider
{
	public ItemADS(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(DivingGear.divingGearTab);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.func_94245_a(ReferenceStrings.modID.toLowerCase() + ":ads");
	}
	
	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		return "/mods/divinggear/textures/models/ADSModel.png";
	}
	
	private int used = 0;
	public static int uses;
	public static int amount;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		if(player.isWet())
		{
			player.addPotionEffect(new PotionEffect(16, -1, 9));
			if(player.getAir() <= 0)
			{
				if(used < uses)
				{
					player.setAir(amount);
					used = used + 1;
					player.sendChatToPlayer("[DivingGear] "+((uses-used)/2)+" uses left.");
				}
			}
		}
		else
		{
			used = 0;
		}
	}
}
