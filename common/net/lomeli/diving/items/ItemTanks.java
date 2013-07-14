package net.lomeli.diving.items;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.lomlib.item.ItemGeneric;

public class ItemTanks extends ItemGeneric
{
	public ItemTanks(int id, String Texture, int uses)
    {
	    super(id, ModStrings.MOD_ID.toLowerCase(), Texture);
	    this.setMaxDamage(uses);
	    this.setMaxStackSize(1);
	    this.setCreativeTab(DivingGear.modTab);
    }

}
