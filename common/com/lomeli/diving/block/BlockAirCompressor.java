package com.lomeli.diving.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.lib.ReferenceStrings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAirCompressor extends Block
{
    private Icon[] icons = new Icon[4];

    public BlockAirCompressor(int par1)
    {
        super(par1, Material.iron);
    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3,
            int par4)
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

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
            EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper
                .floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

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
    public void registerIcons(IconRegister iconRegister)
    {
        icons[0] = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":air_compressor/aircompressor_side_top");
        icons[1] = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":air_compressor/aircompressor_side_default");
        icons[2] = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":air_compressor/aircompressor_side_front");
        icons[3] = iconRegister
                .registerIcon(ReferenceStrings.modID.toLowerCase()
                        + ":air_compressor/aircompressor_side_front_off");
        blockIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":air_compressor/aircompressor_side_default");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
    {
        return side == 1 ? icons[0] : side == 0 ? icons[1]
                : side != meta ? icons[1] : icons[2];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int i, float f, float g, float t)
    {
        Item[] armor = new Item[] { RegisterItems.ADS_T, RegisterItems.Scuba1,
                RegisterItems.Scuba2 };
        Item[] refillable = new Item[] { RegisterItems.ADS_T,
                RegisterItems.Scuba1, RegisterItems.Scuba2,
                RegisterItems.airTank, RegisterItems.doubleTank };
        if (player.inventory.getCurrentItem() != null)
        {
            for (Item item : refillable)
            {
                if (player.inventory.getCurrentItem().itemID == item.itemID)
                {
                    if (world.isBlockIndirectlyGettingPowered(x, y, z))
                    {
                        player.inventory.getCurrentItem().setItemDamage(0);
                    }
                }
            }

        } else
        {
        }
        if (player.inventory.armorItemInSlot(3) != null)
        {
            for (Item item : armor)
            {
                if (player.inventory.armorItemInSlot(3).itemID == item.itemID)
                {
                    if (world.isBlockIndirectlyGettingPowered(x, y, z))
                    {
                        player.inventory.armorItemInSlot(3).setItemDamage(0);
                    }
                }
            }
        } else
        {
        }
        return true;
    }

}
