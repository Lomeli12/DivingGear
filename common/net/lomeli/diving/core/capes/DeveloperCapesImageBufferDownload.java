package net.lomeli.diving.core.capes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import net.minecraft.client.renderer.IImageBuffer;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class DeveloperCapesImageBufferDownload implements IImageBuffer 
{
	private int imageWidth;
	private int imageHeight;
	
	public BufferedImage parseUserSkin(BufferedImage par1BufferedImage) 
	{
		if (par1BufferedImage == null) 
			return null;
		else
		{
			this.imageWidth = (par1BufferedImage.getWidth((ImageObserver)null) <= 64) ? 64: par1BufferedImage.getWidth((ImageObserver)null);
			this.imageHeight = (par1BufferedImage.getHeight((ImageObserver)null) <= 32) ? 32: par1BufferedImage.getHeight((ImageObserver)null);
			BufferedImage bufferedimage1 = new BufferedImage(this.imageWidth, this.imageHeight, 2);
			Graphics graphics = bufferedimage1.getGraphics();
			graphics.drawImage(par1BufferedImage, 0, 0, (ImageObserver)null);
			graphics.dispose();
			return bufferedimage1;
		}
	}
}