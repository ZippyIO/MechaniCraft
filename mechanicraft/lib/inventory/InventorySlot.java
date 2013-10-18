package mechanicraft.lib.inventory;

import net.minecraft.item.ItemStack;



public class InventorySlot {

	public int slotIndex = -1;
	public ItemStack stack = null;

	public InventorySlot(int index, ItemStack stack) {
		this.slotIndex = index;
		this.stack = stack;
	}

	public boolean isEmpty() {
		return this.stack == null;
	}

	public boolean isFull() {
		return !isEmpty() && this.stack.stackSize == this.stack.getMaxStackSize();
	}

	public boolean containsItemsFrom(ItemStack otherStack) {
		return InventoryUtilities.similarStacks( this.stack, otherStack, true );
	}

	public int getSpaceFor(ItemStack otherStack) {
		if( isEmpty() )
			return 64;
		if( isFull() )
			return 0;
		return InventoryUtilities.getSpaceInStackFor( this.stack, otherStack );
	}


}