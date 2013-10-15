package mechanicraft.gui;

import mechanicraft.container.ContainerProjectTable;
import mechanicraft.tileentity.TePT;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProjectTableGui extends GuiContainer{


	private static final ResourceLocation field_110422_t = new ResourceLocation("mechanicraft", "textures/gui/projgui.png");

	public ProjectTableGui(InventoryPlayer playerInv, TePT tile_entity, World world, int x, int y, int z)
	{
	         super(new ContainerProjectTable((TePT) tile_entity, playerInv, world, x, y, z));
	         xSize = 176;
	         ySize = 222;
	}

	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int x, int z)	
	{
	         this.fontRenderer.drawString(StatCollector.translateToLocal("\u00a74Project Table Rebirth"), 30, 6, 4210752);
	         this.fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	/**
	         * Draw the background layer for the GuiContainer (everything behind the items)
	         */
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
	{
	         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	         this.mc.renderEngine.bindTexture(field_110422_t);
	         int k = (this.width - this.xSize) / 2;
	         int l = (this.height - this.ySize) / 2;
	         this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	 @Override
	    public void onGuiClosed() {
	        super.onGuiClosed();
	    }

}