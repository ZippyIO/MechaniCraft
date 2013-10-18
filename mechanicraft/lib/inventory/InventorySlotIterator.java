package mechanicraft.lib.inventory;


import java.util.Iterator;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

// used by InventoryUtils.inventoryIterator(IInventory)
public class InventorySlotIterator implements Iterable<InventorySlot>, Iterator<InventorySlot> {

	private IInventory inv;
	private int size;

	int currentSlot = -1;

	protected InventorySlotIterator(IInventory inventory) {
		this.inv = inventory;
		this.size = inventory.getSizeInventory();
	}

	
	public static InventorySlotIterator createNewFor(IInventory inventory) {
		if( inventory != null )
			return new InventorySlotIterator( inventory );
		return null;
	}

	@Override
	public Iterator<InventorySlot> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return (currentSlot - 1 < size);
	}

	@Override
	public InventorySlot next() {
		if( ++currentSlot < size ) {
			ItemStack stack = inv.getStackInSlot( currentSlot );
			return new InventorySlot( currentSlot, stack );
		}
		return null;
	}

	@Override
	public void remove() {
	} 

}