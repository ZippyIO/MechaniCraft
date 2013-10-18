
package mechanicraft.lib.inventory;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * Allows you to deal with multiple inventories through a single interface.
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class InventoryUnion implements IInventory {

	private final List<Integer> slots = new ArrayList<Integer>();
	private final List<IInventory> inventory = new ArrayList<IInventory>();

	private InventoryUnion() {
	}

	public static InventoryUnion make() {
		return new InventoryUnion();
	}

	public InventoryUnion add(IInventory inv) {
		for (int slot = 0; slot < inv.getSizeInventory(); slot++) {
			slots.add(slot);
			inventory.add(inv);
		}
		return this;
	}

	@Override
	public int getSizeInventory() {
		return slots.size();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory.get(slot).getStackInSlot(slots.get(slot));
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		return inventory.get(slot).decrStackSize(slots.get(slot), amount);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return inventory.get(slot).getStackInSlotOnClosing(slots.get(slot));
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory.get(slot).setInventorySlotContents(slots.get(slot), stack);
	}

	@Override
	public String getInvName() {
		return "";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return inventory.get(slot).isItemValidForSlot(slots.get(slot), stack);
	}
}