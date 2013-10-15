package mechanicraft.container;

import mechanicraft.gui.SlotLavaFurnace;
import mechanicraft.tileentity.TileEntityLavaFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerLavaFurnace extends Container {

	private TileEntityLavaFurnace furnace;
	private int cookTime = 0;
	private int burnTime = 0;
	private int itemBurnTime = 0;

	public ContainerLavaFurnace(InventoryPlayer inventoryplayer,
			TileEntityLavaFurnace tileentityLavaFurnace) {
		furnace = tileentityLavaFurnace;
		this.addSlotToContainer(new Slot(tileentityLavaFurnace, 0, 56, 27));
		this.addSlotToContainer(new SlotLavaFurnace(inventoryplayer.player,
				tileentityLavaFurnace, 2, 116, 35));

		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(inventoryplayer,
						k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (int j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18,
					142));
		}

	}

	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0,
				this.furnace.furnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1,
				this.furnace.furnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2,
				this.furnace.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int var1 = 0; var1 < this.crafters.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.crafters.get(var1);

			if (this.cookTime != this.furnace.furnaceCookTime) {
				var2.sendProgressBarUpdate(this, 0,
						this.furnace.furnaceCookTime);
			}

			if (this.burnTime != this.furnace.furnaceBurnTime) {
				var2.sendProgressBarUpdate(this, 1,
						this.furnace.furnaceBurnTime);
			}

			if (this.itemBurnTime != this.furnace.currentItemBurnTime) {
				var2.sendProgressBarUpdate(this, 2,
						this.furnace.currentItemBurnTime);
			}

		}

		this.cookTime = this.furnace.furnaceCookTime;
		this.burnTime = this.furnace.furnaceBurnTime;
		this.itemBurnTime = this.furnace.currentItemBurnTime;

	}

	public boolean canInteractWith(EntityPlayer var1) {
		return this.furnace.isUseableByPlayer(var1);
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2) {
				if (!mergeItemStack(itemstack1, 3, 38, true)) {
					return null;
				}
			} else if (par2 >= 3 && par2 < 30) {
				if (!mergeItemStack(itemstack1, 30, 38, false)) {
					return null;
				}
			} else if (par2 >= 30 && par2 < 39) {
				if (!mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!mergeItemStack(itemstack1, 3, 38, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize != itemstack.stackSize) {
				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			} else {
				return null;
			}
		}

		return itemstack;
	}

	/*
	 * public ItemStack transferStackInSlot(int var1) { ItemStack var2 = null;
	 * Slot var3 = (Slot)this.inventorySlots.get(var1);
	 * 
	 * if (var3 != null && var3.getHasStack()) { ItemStack var4 =
	 * var3.getStack(); var2 = var4.copy();
	 * 
	 * if (var1 == 0) { if (!this.mergeItemStack(var4, 1,
	 * this.inventorySlots.size(), true)) { return null; } } else if
	 * (!this.mergeItemStack(var4, 0, 1, false)) { return null; }
	 * 
	 * if (var4.stackSize == 0) { var3.putStack((ItemStack)null); } else {
	 * var3.onSlotChanged(); } }
	 * 
	 * return var2; }
	 */
}