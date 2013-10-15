package mechanicraft.render;

import mechanicraft.tileentity.TileEntityAnvilCraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileEntityAnvilCraftRenderer extends TileEntitySpecialRenderer
{
	private static final ResourceLocation forge = new ResourceLocation("mechanicraft", "textures/gui/Forge1.png");
	private ModelAnvilCraft model;

	public TileEntityAnvilCraftRenderer()
	{
		this.model = new ModelAnvilCraft();
	}

	public void renderAModelAt(TileEntityAnvilCraft tile, double d, double d1, double d2, float f)
	{
		int rotation = 0;
		if (tile.worldObj != null)
		{
			rotation = tile.getBlockMetadata();
		}
		this.bindTexture(forge);
		//bindTextureByName("/mods/BetterCraft/textures/Forge.png");
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		this.model.renderAll();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		renderAModelAt((TileEntityAnvilCraft)par1TileEntity, par2, par4, par6, par8);
	}
}