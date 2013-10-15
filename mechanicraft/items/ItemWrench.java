package mechanicraft.items;

import mechanicraft.lib.ItemMechaniCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemWrench extends ItemMechaniCraft{

	public ItemWrench(int itemID, String itemName, String unlocalizedName, int maxStackSize, String texture) {
		super(itemID, itemName, unlocalizedName, maxStackSize, texture);
		
	}

	@Override
	public boolean isFull3D()
    {
        return true;
    }

	@Override
	 public boolean shouldRotateAroundWhenRendering()
	    {
	        return true;
	    }
}
