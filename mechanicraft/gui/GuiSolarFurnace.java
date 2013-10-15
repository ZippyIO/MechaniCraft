package mechanicraft.gui;

import mechanicraft.container.ContainerSolarFurnace;
import mechanicraft.tileentity.TileEntitySolarFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiSolarFurnace extends GuiContainer
{
	private ResourceLocation spf = new ResourceLocation("mechanicraft", "textures/gui/GuiSolarFurnace1.png");
    private TileEntitySolarFurnace furnaceInventory;

    public GuiSolarFurnace(InventoryPlayer inventoryplayer, TileEntitySolarFurnace tileentitysolarfurnace)
    {
        super(new ContainerSolarFurnace(inventoryplayer, tileentitysolarfurnace));
        furnaceInventory = tileentitysolarfurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Solar Furnace", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(spf);
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        int var7;

        if (furnaceInventory.isBurning())
        {
        	var7 = furnaceInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(var5 + 57, var6 + 46 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = furnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    }
}