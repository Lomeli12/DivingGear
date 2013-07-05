package net.lomeli.diving.client.render.item;

import net.lomeli.diving.client.model.ModelCoral;
import net.lomeli.diving.tileentity.TileEntityCoral;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemCoralRenderer implements IItemRenderer
{

    @SuppressWarnings("unused")
    private ModelCoral coralModel;

    public ItemCoralRenderer()
    {
        coralModel = new ModelCoral();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        TileEntityRenderer.instance.renderTileEntityAt(new TileEntityCoral(),
                0.1D, 0.1D, 0.1D, 0.1F);
    }

}
