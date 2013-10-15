package mechanicraft.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityAnvilCraft extends TileEntity
{
	private String customName;
	
	public TileEntityAnvilCraft()
	{
	}
	
	public void setCustomName(String name) 
	{
	    this.customName = name;
	}
}