package com.lomeli.diving.core;

import net.minecraft.entity.player.EntityPlayer;

public class AirHandler 
{
	public static void givePlayerAir(EntityPlayer player, int used, int uses, int amount)
	{
		if(player.isWet())
		{
			if(player.getAir() <= 0)
			{
				if(used < uses)
				{
					player.setAir(amount);
					used = used + 1;
					player.sendChatToPlayer("[DivingGear] "+((uses-used)/2)+" uses left.");
				}else{}
			}
		}
		else
		{
			used = 0;
		}
	}
	

}
