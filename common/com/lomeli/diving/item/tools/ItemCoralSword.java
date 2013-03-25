package com.lomeli.diving.item.tools;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceIntegers;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCoralSword extends ItemSword
{
	public ItemCoralSword(int par1) {
		super(par1, EnumToolMaterial.IRON);
		this.setCreativeTab(DivingGear.divingGearTab);
		this.setMaxDamage(ReferenceIntegers.coralToolUsage);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":swordCoral");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
	{
		if(entity != null)
		{
			if(entity instanceof EntityPlayer)
			{
				if(entity.isWet())
				{
					((EntityPlayer) entity).addPotionEffect(new PotionEffect(5, -1, 2));
				}
			}
		}
	}
}
