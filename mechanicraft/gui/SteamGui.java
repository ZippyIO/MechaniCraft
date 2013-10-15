package mechanicraft.gui;

import java.util.ArrayList;
import java.util.List;

import mechanicraft.container.SteamContainer;
import mechanicraft.tileentity.TileEntitySteamFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class SteamGui extends GuiContainer
{
	private ResourceLocation hsf = new ResourceLocation("mechanicraft", "textures/gui/steamfurnace.png");
    private TileEntitySteamFurnace furnaceInventory;

    public SteamGui(InventoryPlayer var1, TileEntitySteamFurnace var2)
    {
        super(new SteamContainer(var1, var2));
        this.furnaceInventory = var2;
    }
    
    public void drawScreen(int mouseX, int mouseY, float gameTicks)
	{
		super.drawScreen(mouseX, mouseY, gameTicks);

		drawTooltips(mouseX, mouseY);
	}

    
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY, float gameTicks)
    {
    	
        this.fontRenderer.drawString(StatCollector.translateToLocal("Steam Furnace"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        this.drawTooltips(mouseX, mouseY);
    }

    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(hsf);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;
        

        if (this.furnaceInventory.isBurning())
        {
            var7 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
    
        
        int var8 = this.furnaceInventory.getWaterScaled(31);
        this.drawTexturedModalRect(var5 + 32, var6 + 16 + 31 - var8, 176, 62 - var8, 8, var8 + 2);
        
    
        
        
       }
    
    protected void drawTooltips(int mouseX, int mouseY)
	{
    	int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        
        
    	if(isPointInRegion(32, 16, 8, 30, mouseX, mouseY))
		{
    		if(furnaceInventory.waterLevel < 4096){
			drawBarTooltip("Capacity", "L", "0." + ((furnaceInventory.waterLevel / 1024) * 25) , 1, mouseX, mouseY);
    		} else {
    			drawBarTooltip("Capacity", "L", "1" , 1, mouseX, mouseY);
        		
    		}
		}

		
	
    }
    
    
	

	protected void drawBarTooltip(String name, String unit, String string, int max, int x, int y)
	{
		List<String> lines = new ArrayList<String>();
		lines.add(name);
		lines.add(string + " / " + max + " " + unit);
		drawTooltip(lines, x, y);
	}

	protected void drawTooltip(List<String> lines, int x, int y)
	{
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_LIGHTING);

		int tooltipWidth = 0;
		int tempWidth;
		int xStart;
		int yStart;

		for(int i = 0; i < lines.size(); i++)
		{
			tempWidth = this.fontRenderer.getStringWidth(lines.get(i));

			if(tempWidth > tooltipWidth)
			{
				tooltipWidth = tempWidth;
			}
		}

		xStart = x + 12;
		yStart = y - 12;
		int tooltipHeight = 8;

		if(lines.size() > 1)
		{
			tooltipHeight += 2 + (lines.size() - 1) * 10;
		}

		if(this.guiTop + yStart + tooltipHeight + 6 > this.height)
		{
			yStart = this.height - tooltipHeight - this.guiTop - 6;
		}

		this.zLevel = 300.0F;
		itemRenderer.zLevel = 300.0F;
		int color1 = -267386864;
		this.drawGradientRect(xStart - 3, yStart - 4, xStart + tooltipWidth + 3, yStart - 3, color1, color1);
		this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 4, color1, color1);
		this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color1, color1);
		this.drawGradientRect(xStart - 4, yStart - 3, xStart - 3, yStart + tooltipHeight + 3, color1, color1);
		this.drawGradientRect(xStart + tooltipWidth + 3, yStart - 3, xStart + tooltipWidth + 4, yStart + tooltipHeight + 3, color1, color1);
		int color2 = 1347420415;
		int color3 = (color2 & 16711422) >> 1 | color2 & -16777216;
		this.drawGradientRect(xStart - 3, yStart - 3 + 1, xStart - 3 + 1, yStart + tooltipHeight + 3 - 1, color2, color3);
		this.drawGradientRect(xStart + tooltipWidth + 2, yStart - 3 + 1, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3 - 1, color2, color3);
		this.drawGradientRect(xStart - 3, yStart - 3, xStart + tooltipWidth + 3, yStart - 3 + 1, color2, color2);
		this.drawGradientRect(xStart - 3, yStart + tooltipHeight + 2, xStart + tooltipWidth + 3, yStart + tooltipHeight + 3, color3, color3);

		for(int stringIndex = 0; stringIndex < lines.size(); ++stringIndex)
		{
			String line = lines.get(stringIndex);

			if(stringIndex == 0)
			{
				line = "\u00a7" + Integer.toHexString(15) + line;
			}
			else
			{
				line = "\u00a77" + line;
			}

			this.fontRenderer.drawStringWithShadow(line, xStart, yStart, -1);

			if(stringIndex == 0)
			{
				yStart += 2;
			}

			yStart += 10;
		}

		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		this.zLevel = 0.0F;
		itemRenderer.zLevel = 0.0F;
	}
	
    
}