package com.lomeli.diving.block;

import com.lomeli.diving.DivingGear;
import com.lomeli.diving.lib.ReferenceStrings;
import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.tileentity.TileEntityAirCompressor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAirCompressor extends BlockContainer
{

	private Icon[] icons = new Icon[3];
	
	public BlockAirCompressor(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(DivingGear.divingGearTab);
		
	}

	@Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAirCompressor();
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }
	
	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
    	
        icons[0] = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":air_compressor/aircompressor_side_top");
        icons[1] = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":air_compressor/aircompressor_side_default");
        icons[2] = iconRegister.registerIcon(ReferenceStrings.modID.toLowerCase() + ":air_compressor/aircompressor_side_front");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta) 
    {
    	return side == 1 ? icons[0] : (side == 0 ? icons[0] : (side != meta ? icons[1] : icons[2]));
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) 
    {
    	if(player.inventory.getCurrentItem() != null)
    	{
    		if(player.inventory.getCurrentItem().itemID == RegisterItems.airTank.itemID || player.inventory.getCurrentItem().itemID == RegisterItems.Scuba1.itemID ||
    			player.inventory.getCurrentItem().itemID == RegisterItems.Scuba2.itemID || player.inventory.getCurrentItem().itemID == RegisterItems.ADS_T.itemID)
    		{
    			if(world.isBlockIndirectlyGettingPowered(x, y, z))
    			{
    				player.inventory.getCurrentItem().setItemDamage(0);
    			}
    		}
    	}
    	return true;
    }
}