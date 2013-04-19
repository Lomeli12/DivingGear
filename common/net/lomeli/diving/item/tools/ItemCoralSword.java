package net.lomeli.diving.item.tools;

import net.lomeli.diving.config.RegisterItems;
import net.lomeli.diving.lib.ReferenceIntegers;
import net.lomeli.diving.lib.ReferenceStrings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoralSword extends ItemSword
{
    public ItemCoralSword(int par1)
    {
        super(par1, EnumToolMaterial.IRON);
        this.setMaxDamage(ReferenceIntegers.coralToolUsage);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":swordCoral");
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
                        if (((EntityPlayer) entity).inventory.getCurrentItem().itemID == RegisterItems.coralSword.itemID)
                        {
                            ((EntityPlayer) entity)
                                    .addPotionEffect(new PotionEffect(5, -1, 2));
                        }
                    }
                }
            }
        }
    }
}
