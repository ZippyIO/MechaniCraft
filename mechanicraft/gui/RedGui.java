package mechanicraft.gui;

import mechanicraft.container.RedContainer;
import mechanicraft.tileentity.TileEntityRedFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RedGui extends GuiContainer
{
	private ResourceLocation spf = new ResourceLocation("mechanicraft", "textures/gui/redfurnace.png");
    private TileEntityRedFurnace furnaceInventory;

    public RedGui(InventoryPlayer inventoryplayer, TileEntityRedFurnace tileentityRedFurnace)
    {
        super(new RedContainer(inventoryplayer, tileentityRedFurnace));
        furnaceInventory = tileentityRedFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Red Furnace", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(spf);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);

        if (furnaceInventory.isBurning())
        {
            int j1 = furnaceInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 57, (i1 + 36 + 22) - j1, 176, 12 - j1, 14, j1 + 2);
        }

        int k1 = furnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
    }
}