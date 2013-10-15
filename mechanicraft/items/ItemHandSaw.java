package mechanicraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHandSaw extends Item
{

	public ItemHandSaw(int i)
	{
		
		super(i);
		this.maxStackSize = 1;
		this.setMaxDamage(32);
        //this.setContainerItem(this);
		this.setCreativeTab(CreativeTabs.tabTools);
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("mechanicraft:handsaw");
	}
	
}