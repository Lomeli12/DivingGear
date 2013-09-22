package net.lomeli.diving.items.gear;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFlippers extends ItemArmor {

    public ItemFlippers(int par1) {
        super(par1, EnumArmorMaterial.CHAIN, 0, 3);
        this.setCreativeTab(DivingGear.modTab);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModStrings.MOD_ID
                .toLowerCase() + ":flippers");
    }

    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player,
            ItemStack itemStack) {
        player.capabilities.setFlySpeed(0.05F);
        if (player.isInWater()) {
            if (!player.capabilities.isCreativeMode)
                player.capabilities.setPlayerWalkSpeed(1F);
        } else
            player.capabilities.setPlayerWalkSpeed(0.1F);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot,
            int layer) {
        return "diving:textures/models/armor/snorkelModel.png";
    }
}
