package net.lomeli.diving.client.render;

import net.lomeli.diving.client.model.ModelCoral;
import net.lomeli.diving.lib.RenderIDs;
import net.lomeli.diving.tileentity.TileEntityCoral;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.world.IBlockAccess;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCoral implements ISimpleBlockRenderingHandler
{
    @SuppressWarnings("unused")
    private ModelCoral coralModel;

    public RenderCoral(int ID)
    {
        coralModel = new ModelCoral();
        RenderIDs.coralRenderID = ID;
    }

    @Override
    public int getRenderId()
    {
        return RenderIDs.coralRenderID;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID,
            RenderBlocks renderer)
    {
        TileEntityRenderer entityRenderer = TileEntityRenderer.instance;
        entityRenderer.renderTileEntityAt(new TileEntityCoral(), 0.0D, 0.0D,
                0.0D, 1.0F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
            Block block, int modelId, RenderBlocks renderer)
    {
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory()
    {
        return false;
    }
}
