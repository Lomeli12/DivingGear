package com.lomeli.diving.item.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.lib.ReferenceIntegers;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoralPickaxe extends ItemPickaxe
{
    public ItemCoralPickaxe(int par1)
    {
        super(par1, EnumToolMaterial.IRON);
        this.setMaxDamage(ReferenceIntegers.coralToolUsage);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":pickaxeCoral");
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity,
            int par4, boolean par5)
    {
        if (entity != null)
        {
            if (entity instanceof EntityPlayer)
            {
                if (entity.isWet())
                {
                    if (((EntityPlayer) entity).inventory.getCurrentItem() != null)
                    {
                        if (((EntityPlayer) entity).inventory.getCurrentItem().itemID == RegisterItems.coralPick.itemID)
                        {
                            ((EntityPlayer) entity)
                                    .addPotionEffect(new PotionEffect(3, -1, 3));
                        }
                    }
                }
            }
        }
    }
}
