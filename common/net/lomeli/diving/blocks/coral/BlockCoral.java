package net.lomeli.diving.blocks.coral;

import java.util.List;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.blocks.ModBlocks;
import net.lomeli.diving.lib.ModStrings;

import net.lomeli.lomlib.block.BlockUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCoral extends Block {
    private Icon[] iconArray;

    private String blockTexture;

    public BlockCoral(int id, String texture) {
        super(id, Material.coral);
        this.blockTexture = texture;
        this.setCreativeTab(DivingGear.modTab);
        this.setLightValue(1F);
        this.setTickRandomly(true);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public Icon getIcon(int par1, int par2) {
        return this.iconArray[par2 % this.iconArray.length];
    }

    @Override
    public int getDamageValue(World par1World, int par2, int par3, int par4) {
        return this.damageDropped(par1World.getBlockMetadata(par2, par3, par4));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
            List par3List) {
        for (int j = 0; j < 5; ++j) {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.iconArray = new Icon[5];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = iconRegister.registerIcon(ModStrings.MOD_ID
                    .toLowerCase() + ":" + this.blockTexture + "_" + i);
        }
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
            int y, int z) {
        return null;
    }

    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        if (BlockUtil.isBlockAdjacentToWater(world, x, y, z)
                || world.getBlockId(x, y - 1, z) != ModBlocks.coral.blockID)
            return true;
        else
            return false;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z,
            int meta) {
        if (BlockUtil.isBlockAdjacentToWater(world, x, y, z))
            this.dropBlockAsItem_do(world, x, y, z, new ItemStack(
                    ModBlocks.coral, 1, meta));
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z,
            int neighborBlockID) {
        if (!BlockUtil.isBlockAdjacentToWater(world, x, y, z)) {
            this.dropBlockAsItem_do(world, x, y, z, new ItemStack(
                    ModBlocks.coral, 1, world.getBlockMetadata(x, y, z)));
            world.setBlockToAir(x, y, z);
        }
    }
}
