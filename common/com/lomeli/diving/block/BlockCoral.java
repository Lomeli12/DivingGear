package com.lomeli.diving.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.lomeli.diving.config.RegisterItems;
import com.lomeli.diving.lib.ReferenceStrings;
import com.lomeli.diving.lib.RenderIDs;
import com.lomeli.diving.tileentity.TileEntityCoral;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCoral extends Block
{
    public BlockCoral(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setBlockBoundsForItemRender();
        this.setLightValue(2F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(ReferenceStrings.modID
                .toLowerCase() + ":coralTexture");
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.coralRenderID;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return new TileEntityCoral();
    }

    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }

    // @Override
    // public void onBlockAdded(World par1World, int par2, int par3, int par4) {
    // super.onBlockAdded(par1World, par2, par3, par4);
    // par1World.setBlockTileEntity(par2, par3, par4,
    // createTileEntity(par1World, par1World.getBlockMetadata(par2, par3,
    // par4)));
    // }
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1 + par1Random.nextInt(3);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return RegisterItems.coralFragment.itemID;
    }
}