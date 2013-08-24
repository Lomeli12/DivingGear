package net.lomeli.diving.items;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.lomlib.item.ItemGeneric;

public class ItemDiving extends ItemGeneric{

	public ItemDiving(int id, String Texture) {
		super(id, ModStrings.MOD_ID.toLowerCase(), Texture);
		this.setCreativeTab(DivingGear.modTab);
	}

}
