package net.lomeli.diving.items.gear;

import net.lomeli.diving.lib.ModStrings;

import net.lomeli.lomlib.util.NBTUtil;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSnorkel extends ItemArmor {
    public int uses;
    public int airAmount;

    public ItemSnorkel(int par1, EnumArmorMaterial par2EnumArmorMaterial,
            int par3, int par4, int amount, int uses) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.uses = uses;
        this.airAmount = amount;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(ModStrings.MOD_ID.toLowerCase()
                + ":snorkel");
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot,
            int layer) {
        return "diving:textures/models/armor/snorkelModel.png";
    }

    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player,
            ItemStack itemStack) {
        if (player.isInWater()) {
            player.addPotionEffect(new PotionEffect(16, -1, 10));
            if (player.getAir() <= 0 && usesLeft(itemStack) > 0) {
                player.setAir(airAmount);
                useAir(itemStack, 1);
            }
        } else
            setUses(itemStack);
    }

    private int usesLeft(ItemStack item) {
        return NBTUtil.getInt(item, "Uses");
    }

    private void setUses(ItemStack item) {
        NBTUtil.setInteger(item, "Uses", uses);
    }

    private void useAir(ItemStack item, int uses) {
        NBTUtil.setInteger(item, "Uses", (usesLeft(item) - uses));
    }

}
