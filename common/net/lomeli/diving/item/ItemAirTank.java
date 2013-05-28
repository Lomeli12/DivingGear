package net.lomeli.diving.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lomeli.diving.lib.ReferenceStrings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAirTank extends Item
{
	private String itemTexture;
	
	public ItemAirTank(int par1, String texture, int amount)
    {
	    super(par1);
	    this.itemTexture = texture;
	    this.setMaxDamage(amount);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
		this.itemIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":" + itemTexture);
    }

	@Override
    public void onCreated(ItemStack itemStack, World world,
            EntityPlayer entityPlayer)
    {
        itemStack.damageItem(itemStack.getMaxDamage() - 1, entityPlayer);
    }
}
