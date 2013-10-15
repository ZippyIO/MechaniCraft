package mechanicraft.gui;

import mechanicraft.container.ContainerHighSpeedFurnace;
import mechanicraft.tileentity.TileEntityHighSpeedFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiHighSpeedFurnace extends GuiContainer
{
	private ResourceLocation hsf = new ResourceLocation("mechanicraft", "textures/gui/extruder.png");
    private TileEntityHighSpeedFurnace highSpeedInventory;

    public GuiHighSpeedFurnace(InventoryPlayer par1InventoryPlayer, TileEntityHighSpeedFurnace par2TileEntityHighSpeedFurnace)
    {
        super(new ContainerHighSpeedFurnace(par1InventoryPlayer, par2TileEntityHighSpeedFurnace));
        this.highSpeedInventory = par2TileEntityHighSpeedFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("HighSpeed Furnace"), 40, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        //int var4 = this.mc.renderEngine.getTexture("/microjunk/trees/common/aart/furnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(hsf);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        if (this.highSpeedInventory.isBurning())
        {
            var7 = this.highSpeedInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = this.highSpeedInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    }
}