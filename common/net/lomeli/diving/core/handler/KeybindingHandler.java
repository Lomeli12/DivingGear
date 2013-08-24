package net.lomeli.diving.core.handler;

import java.util.EnumSet;

import net.lomeli.diving.items.gear.IGear;
import net.lomeli.diving.lib.ModInts;
import net.lomeli.diving.lib.ModStrings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;

public class KeybindingHandler extends KeyBindingRegistry.KeyHandler{
	private static KeyBinding[] bind = new KeyBinding[2];
	
	public KeybindingHandler(){
		super(bind);
	}

	@Override
	public String getLabel() {
		return ModStrings.MOD_NAME + ":" + this.getClass().getSimpleName();
	}

	@Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        // Only operate at the end of the tick
        if (tickEnd) {
            // If we are not in a GUI of any kind, continue execution
            if (FMLClientHandler.instance().getClient().inGameHasFocus) {
                EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
                if (player != null) {
                    ItemStack currentItem = FMLClientHandler.instance().getClient().thePlayer.getCurrentArmor(0);
                    if (currentItem != null) {
                    	if(currentItem.getItem() instanceof IGear){
                    		if(kb.keyCode == ModInts.keyCode){
                    			((IGear)currentItem.getItem()).doKeybinding(player);
                    		}
                    	}
                    }
                }
            }
        }
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
