package mechanicraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNail extends Item
{

	public ItemNail(int i)
	{
		
		super(i);
		this.maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabTools);
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("mechanicraft:nail");
	}
	
}