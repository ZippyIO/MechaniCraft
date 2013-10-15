package mechanicraft.crafting;

import mechanicraft.MechaniCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class BetterCraftingHandler implements ICraftingHandler 
{
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		for (int i = 0; i < craftMatrix.getSizeInventory(); i++) // Checks all the slots
		{
			if (craftMatrix.getStackInSlot(i) != null) // If there is an item
			{
				ItemStack j = craftMatrix.getStackInSlot(i); // Gets the item
				if (j.getItem() != null && j.getItem() == MechaniCraft.hammer) 
				{
					ItemStack k = new ItemStack(MechaniCraft.hammer, 2, (j.getItemDamage() + 1)); 
					if (k.getItemDamage() >= k.getMaxDamage()) 
					{ 
						k.stackSize--; 
					}
					craftMatrix.setInventorySlotContents(i, k);
				}
				if (j.getItem() != null && j.getItem() == MechaniCraft.handsaw) 
				{
					ItemStack k = new ItemStack(MechaniCraft.handsaw, 2, (j.getItemDamage() + 1)); 
					if (k.getItemDamage() >= k.getMaxDamage()) 
					{ 
						k.stackSize--; 
					}
					craftMatrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	}
}
