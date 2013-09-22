package net.lomeli.diving.blocks;

import java.util.Random;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.lib.ModStrings;
import net.lomeli.diving.tileentity.TileEntityAirCompressor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAirCompressor extends BlockContainer {

    private Icon[] allTextures;

    public BlockAirCompressor(int par1) {
        super(par1, Material.iron);
        this.setCreativeTab(DivingGear.modTab);
        this.setResistance(15F);
        this.setHardness(3F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int i, float f, float g, float t) {
        if (player.isSneaking())
            return false;
        else {
            if (!world.isRemote) {
                TileEntityAirCompressor tile = (TileEntityAirCompressor) world
                        .getBlockTileEntity(x, y, z);
                if (tile != null) {
                    player.openGui(DivingGear.instance, 30, world, x, y, z);
                }
            }
        }
        return true;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        allTextures = new Icon[5];

        String loc = ModStrings.MOD_ID.toLowerCase() + ":aircompressor/";

        allTextures[0] = iconRegister.registerIcon(loc
                + "aircompressor_side_default");
        allTextures[1] = iconRegister.registerIcon(loc
                + "aircompressor_side_frong_off");
        allTextures[2] = iconRegister.registerIcon(loc
                + "aircompressor_side_front_on");
        allTextures[3] = iconRegister.registerIcon(loc
                + "aircompressor_side_top_off");
        allTextures[4] = iconRegister.registerIcon(loc
                + "aircompressor_side_top_on");
    }

    public Icon getIcon(int par1, int par2) {
        if (par1 == par2)
            return allTextures[2];
        else if (par1 == 1)
            return allTextures[4];
        else
            return allTextures[0];
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3,
            int par4) {
        if (!par1World.isRemote) {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
                b0 = 3;

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
                b0 = 2;

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
                b0 = 5;

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
                b0 = 4;

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
            EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
        int l = MathHelper
                .floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);

        if (l == 1)
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);

        if (l == 2)
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);

        if (l == 3)
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityAirCompressor();
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int id, int meta) {
        dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, id, meta);
    }

    private Random rand = new Random();

    private void dropInventory(World world, int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
            return;

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {

            ItemStack itemStack = inventory.getStackInSlot(i);

            if (itemStack != null && itemStack.stackSize > 0) {
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z
                        + dZ, new ItemStack(itemStack.itemID,
                        itemStack.stackSize, itemStack.getItemDamage()));

                if (itemStack.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound(
                            (NBTTagCompound) itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
}
