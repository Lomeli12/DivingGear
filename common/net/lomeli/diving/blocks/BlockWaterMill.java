package net.lomeli.diving.blocks;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.tileentity.TileEntityWaterMill;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWaterMill extends BlockContainer
{
	public Icon[] iconArray;
	
	public BlockWaterMill(int par1)
    {
	    super(par1, Material.anvil);
	    this.setCreativeTab(DivingGear.modTab);
	    this.setResistance(15F);
	    this.setHardness(3F);
    }
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int i, float f, float g, float t)
    {
        if (player.isSneaking())
            return false;
        else
        {
            if (!world.isRemote)
            {
            	TileEntityWaterMill tile = (TileEntityWaterMill)world.getBlockTileEntity(x, y, z);
            	if(tile != null)
            	{
            		if(tile.isActive())
            			player.addChatMessage(tile.getCurrentPower() +" MJ");
            		else
            			player.addChatMessage("Needs to be in water.");
            	}
            }
            return true;
        }
    }

	@Override
    public void registerIcons(IconRegister iconRegister)
    {
		iconArray = new Icon[3];
		
		iconArray[0] = iconRegister.registerIcon(ModStrings.MOD_ID.toLowerCase() + ":watermill/top");
		iconArray[1] = iconRegister.registerIcon(ModStrings.MOD_ID.toLowerCase() + ":watermill/sideoff");
		iconArray[2] = iconRegister.registerIcon(ModStrings.MOD_ID.toLowerCase() + ":watermill/sideon");
    }
	
	@Override
    public Icon getIcon(int side, int metadata)
    {
		return side == 0 ? iconArray[0] : side == 1 ? iconArray[0] 
			: metadata >= 1 ? iconArray[2] : iconArray[1];
    }
	
	@Override
    public TileEntity createNewTileEntity(World world){
		return new TileEntityWaterMill();
    }

	@Override
    public boolean hasTileEntity(int metadata){
        return true;
    }
}
