package net.lomeli.diving.items.gear;

import net.lomeli.diving.DivingGear;
import net.lomeli.diving.inventory.ContainerDiving;
import net.lomeli.diving.items.IAirTanks;
import net.lomeli.diving.lib.ModStrings;

import net.lomeli.lomlib.util.NBTUtil;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAdvGear extends ItemArmor implements IGear {
    private int guiID, gearType;
    private String texture;
    private ContainerDiving container;
    private World itemWorld;

    public ItemAdvGear(int par1, EnumArmorMaterial par2EnumArmorMaterial,
            int par3, int par4, String textureItem, int inventorySize,
            int item, int type) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.texture = textureItem;
        this.guiID = item;
        this.gearType = type;
        this.setCreativeTab(DivingGear.modTab);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity,
            int indexInInventory, boolean isCurrentItem) {
        if (world.isRemote || !isCurrentItem)
            return;
        this.itemWorld = world;
        if (ContainerDiving.class
                .isAssignableFrom(((EntityPlayer) entity).openContainer
                        .getClass())) {
            container = (ContainerDiving) ((EntityPlayer) entity).openContainer;
            if (container.updateNotification) {
                container.helmInventory.writeToNBT(itemStack.stackTagCompound,
                        NBTUtil.getString(itemStack, "uniqueID"));
                container.updateNotification = false;
            }
        }

    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world,
            EntityPlayer player) {
        if (!world.isRemote) {
            if (player.isSneaking()) {
                player.openGui(DivingGear.instance, this.guiID, world,
                        (int) player.posX, (int) player.posY, (int) player.posZ);
            }
        }
        return itemStack;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModStrings.MOD_ID
                .toLowerCase() + ":" + this.texture);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot,
            int layer) {
        return "diving:textures/models/armor/" + this.texture + "helmModel.png";
    }

    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player,
            ItemStack itemStack) {
        if (this.container != null && this.container.helmInventory != null) {
            if (player.isInWater()) {
                player.addPotionEffect(new PotionEffect(16, -1, 10));
                if (player.getAir() <= 0) {
                    useAir(itemStack, player);
                }
            }
        }
    }

    private void useAir(ItemStack stack, EntityPlayer player) {
        for (int i = 0; i < this.container.helmInventory.getSizeInventory(); i++) {
            if (this.container.helmInventory.getStackInSlot(i) != null
                    && (this.container.helmInventory.getStackInSlot(i)
                            .getItem() instanceof IAirTanks)) {
                int usesLeft = (this.container.helmInventory.getStackInSlot(i)
                        .getMaxDamage() - this.container.helmInventory
                        .getStackInSlot(i).getItemDamage());
                if (this.container.helmInventory.getStackInSlot(i)
                        .getItemDamage() < this.container.helmInventory
                        .getStackInSlot(i).getMaxDamage()) {
                    player.setAir(300);
                    player.addChatMessage("[" + stack.getDisplayName() + "]: "
                            + usesLeft + "Uses left.");
                    this.container.helmInventory.getStackInSlot(i).damageItem(
                            1, player);
                    this.container.helmInventory.writeToNBT(
                            stack.stackTagCompound,
                            NBTUtil.getString(stack, "uniqueID"));
                    break;
                }
            }
        }
    }

    @Override
    public int getGearType() {
        return this.gearType;
    }

    @Override
    public void doKeybinding(EntityPlayer player) {
        player.openGui(DivingGear.instance, this.guiID, this.itemWorld,
                (int) player.posX, (int) player.posY, (int) player.posZ);
    }
}
