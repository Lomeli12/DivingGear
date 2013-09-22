package net.lomeli.diving.items.gear;

import net.minecraft.entity.player.EntityPlayer;

public interface IGear {
    public int getGearType();

    public void doKeybinding(EntityPlayer player);
}
