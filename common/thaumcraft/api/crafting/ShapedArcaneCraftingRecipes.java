package thaumcraft.api.crafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import thaumcraft.api.ThaumcraftApiHelper;

public class ShapedArcaneCraftingRecipes implements IArcaneRecipe
{
    /** How many horizontal slots this recipe is wide. */
    public int recipeWidth;

    /** How many vertical slots this recipe uses. */
    public int recipeHeight;

    public String key;

    public int cost;

    /** Is a array of ItemStack that composes the recipe. */
    public ItemStack[] recipeItems;

    /** Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;

    /** Is the itemID of the output item that you get when craft the recipe. */
    public final int recipeOutputItemID;

    public ShapedArcaneCraftingRecipes(String key, int par1, int par2,
            ItemStack[] par3ArrayOfItemStack, ItemStack par4ItemStack, int cost)
    {
        recipeOutputItemID = par4ItemStack.itemID;
        recipeWidth = par1;
        recipeHeight = par2;
        recipeItems = par3ArrayOfItemStack;
        recipeOutput = par4ItemStack;
        this.key = key;
        this.cost = cost;
    }

    @Override
    public ItemStack getRecipeOutput()
    {
        return recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(IInventory par1InventoryCrafting, EntityPlayer player)
    {
        if (key.length() > 0
                && !ThaumcraftApiHelper
                        .isResearchComplete(player.username, key))
            return false;
        for (int var2 = 0; var2 <= 3 - recipeWidth; ++var2)
        {
            for (int var3 = 0; var3 <= 3 - recipeHeight; ++var3)
            {
                if (this.checkMatch(par1InventoryCrafting, var2, var3, true))
                    return true;

                if (this.checkMatch(par1InventoryCrafting, var2, var3, false))
                    return true;
            }
        }

        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(IInventory par1InventoryCrafting, int par2,
            int par3, boolean par4)
    {
        for (int var5 = 0; var5 < 3; ++var5)
        {
            for (int var6 = 0; var6 < 3; ++var6)
            {
                int var7 = var5 - par2;
                int var8 = var6 - par3;
                ItemStack var9 = null;

                if (var7 >= 0 && var8 >= 0 && var7 < recipeWidth
                        && var8 < recipeHeight)
                {
                    if (par4)
                    {
                        var9 = recipeItems[recipeWidth - var7 - 1 + var8
                                * recipeWidth];
                    } else
                    {
                        var9 = recipeItems[var7 + var8 * recipeWidth];
                    }
                }

                ItemStack var10 = ThaumcraftApiHelper.getStackInRowAndColumn(
                        par1InventoryCrafting, var5, var6);

                if (var10 != null || var9 != null)
                {
                    if (var10 == null && var9 != null || var10 != null
                            && var9 == null)
                        return false;

                    if (var9.itemID != var10.itemID)
                        return false;

                    if (var9.getItemDamage() != -1
                            && var9.getItemDamage() != var10.getItemDamage())
                        return false;

                    if (var9.hasTagCompound())
                    {
                        NBTTagCompound tc = var9.getTagCompound();
                        for (Object tag : tc.getTags().toArray())
                        {
                            NBTBase base = (NBTBase) tag;
                            Class nc = NBTBase.newTag(base.getId(),
                                    base.getName()).getClass();
                            if (!(var10.hasTagCompound() && nc.cast(
                                    var10.getTagCompound().getTag(
                                            base.getName())).equals(
                                    nc.cast(base))))
                                return false;
                        }
                    }

                }
            }
        }

        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public ItemStack getCraftingResult(IInventory par1InventoryCrafting)
    {
        return new ItemStack(recipeOutput.itemID, recipeOutput.stackSize,
                recipeOutput.getItemDamage());
    }

    /**
     * Returns the size of the recipe area
     */
    @Override
    public int getRecipeSize()
    {
        return recipeWidth * recipeHeight;
    }

    @Override
    public int getCost()
    {
        return cost;
    }

    @Override
    public String getKey()
    {
        return key;
    }
}
