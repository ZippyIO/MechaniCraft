package mechanicraft.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mechanicraft.MechaniCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemMechaniCraft extends Item{

	String textureLocation;
	public ItemMechaniCraft(int itemID, String itemName, String unlocalizedName, int maxStackSize, String texture){
		super(itemID);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(MechaniCraft.tab);
		this.textureLocation = texture;
		//Register the item.
		GameRegistry.registerItem(this, itemName);
		LanguageRegistry.addName(this, itemName);
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(textureLocation);
	}
}
