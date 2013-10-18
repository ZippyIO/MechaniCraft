package mechanicraft.container;


import buildcraft.core.inventory.StackHelper;
import mechanicraft.MechaniCraft;
import mechanicraft.gui.IPhantomSlot;
import mechanicraft.gui.SlotGhost;
import mechanicraft.gui.SlotProj;
import mechanicraft.tileentity.TePT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;


public class ContainerProjectTable extends Container{

	
	
	private World worldObj;
	private EntityPlayer player;
	public TePT tileEntity;
	
	SlotProj FabSlot;
	private int posX;
	private int posY;
	private int posZ;

    /** The crafting matrix inventory (3x3). */          //container, width, length
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);


	
	
	public ContainerProjectTable(TePT tileFabTable, EntityPlayer player, World world, int x, int y, int z)
	{
		
		worldObj = world;
        posX = x;
        posY = y;
        posZ = z;
        addSlotToContainer(new SlotCrafting(player, tileFabTable.craftResult, tileFabTable, 0, 143, 36));
        int row;
        int col;
        tileEntity = tileFabTable;

        updateCraftingMatrix();


        for (row = 0; row < 3; ++row)
        {
                for (col = 0; col < 3; ++col)
                {
                        this.addSlotToContainer(new SlotGhost(this.craftMatrix, col + row * 3, 48 + col * 18, 18 + row * 18, player));
                }
        }

        for(int row1 = 0; row1 < 3; row1++)		
        {
            for(int col1 = 0; col1 < 9; col1++)
           	 this.addSlotToContainer(new Slot(tileFabTable.resources, col1 + row1 * 9, 8 + col1 * 18, 90 + row1 * 18));

        }


        for(int row2 = 0; row2 < 3; row2++)
        {
            for(int col2 = 0; col2 < 9; col2++)
           	 this.addSlotToContainer(new Slot(player.inventory, col2 + row2 * 9 + 9, 8 + col2 * 18, 140 + row2 * 18 + 18));

        }

        for (row = 0; row < 9; ++row)
        {
                this.addSlotToContainer(new Slot(player.inventory, row, 8 + row * 18, 198 + 18));
        }

        this.onCraftMatrixChanged(this.craftMatrix);

        //addSlotToContainer(new Slot(par1InventoryPlayer, 36, 17, 36));



	}
	

	@Override
	public ItemStack slotClick(int slotNum, int mouseButton, int modifier, EntityPlayer player) {
		Slot slot = slotNum < 0 ? null : (Slot) this.inventorySlots.get(slotNum);
		if (slot instanceof IPhantomSlot) {
			return slotClickPhantom(slot, mouseButton, modifier, player);
		}
		return super.slotClick(slotNum, mouseButton, modifier, player);
	}

	private ItemStack slotClickPhantom(Slot slot, int mouseButton, int modifier, EntityPlayer player) {
		ItemStack stack = null;

		if (mouseButton == 2) {
			if (((IPhantomSlot) slot).canAdjust()) {
				slot.putStack(null);
			}
		} else if (mouseButton == 0 || mouseButton == 1) {
			InventoryPlayer playerInv = player.inventory;
			slot.onSlotChanged();
			ItemStack stackSlot = slot.getStack();
			ItemStack stackHeld = playerInv.getItemStack();

			if (stackSlot != null) {
				stack = stackSlot.copy();
			}

			if (stackSlot == null) {
				if (stackHeld != null && slot.isItemValid(stackHeld)) {
					fillPhantomSlot(slot, stackHeld, mouseButton, modifier);
				}
			} else if (stackHeld == null) {
				adjustPhantomSlot(slot, mouseButton, modifier);
				slot.onPickupFromSlot(player, playerInv.getItemStack());
			} else if (slot.isItemValid(stackHeld)) {
				if (StackHelper.instance().canStacksMerge(stackSlot, stackHeld)) {
					adjustPhantomSlot(slot, mouseButton, modifier);
				} else {
					fillPhantomSlot(slot, stackHeld, mouseButton, modifier);
				}
			}
		}
		return stack;
	}

	protected void adjustPhantomSlot(Slot slot, int mouseButton, int modifier) {
		if (!((IPhantomSlot) slot).canAdjust()) {
			return;
		}
		ItemStack stackSlot = slot.getStack();
		int stackSize;
		if (modifier == 1) {
			stackSize = mouseButton == 0 ? (stackSlot.stackSize + 1) / 2 : stackSlot.stackSize * 2;
		} else {
			stackSize = mouseButton == 0 ? stackSlot.stackSize - 1 : stackSlot.stackSize + 1;
		}

		if (stackSize > slot.getSlotStackLimit()) {
			stackSize = slot.getSlotStackLimit();
		}

		stackSlot.stackSize = stackSize;

		if (stackSlot.stackSize <= 0) {
			slot.putStack((ItemStack) null);
		}
	}

	protected void fillPhantomSlot(Slot slot, ItemStack stackHeld, int mouseButton, int modifier) {
		if (!((IPhantomSlot) slot).canAdjust()) {
			return;
		}
		int stackSize = mouseButton == 0 ? stackHeld.stackSize : 1;
		if (stackSize > slot.getSlotStackLimit()) {
			stackSize = slot.getSlotStackLimit();
		}
		ItemStack phantomStack = stackHeld.copy();
		phantomStack.stackSize = stackSize;

		slot.putStack(phantomStack);
	}
	/**
	         * Callback for when the crafting matrix is changed.
	         */
	public void onCraftMatrixChanged(IInventory par1IInventory)
	{
	         this.tileEntity.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}

	private void updateCraftingMatrix() {
        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) 
            craftMatrix.setInventorySlotContents(i, tileEntity.craftMatrixInventory.getContentsII(i));
        }
    
	

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{
	         super.onContainerClosed(par1EntityPlayer);
	         saveCraftingMatrix();
	}
	
	private void saveCraftingMatrix() {
	    for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
	        tileEntity.craftMatrixInventory.setContentsII(i, craftMatrix.getStackInSlot(i));
        }
    }


	public boolean canInteractWith(EntityPlayer entityplayer)
    {
		if(worldObj.getBlockId(posX, posY, posZ) != MechaniCraft.projecttable.blockID)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
        }
    }

	/**
	         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	         */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
	         ItemStack itemstack = null;
	         Slot slot = (Slot)this.inventorySlots.get(par2);

	         if (slot != null && slot.getHasStack())
	         {
	                 ItemStack itemstack1 = slot.getStack();
	                 itemstack = itemstack1.copy();

	                 if (par2 == 0)
	                 {
	                         if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                         {
	                                 return null;
	                         }

	                         slot.onSlotChange(itemstack1, itemstack);
	                 }
	                 else if (par2 >= 10 && par2 < 37)
	                 {
	                         if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                         {
	                                 return null;
	                         }
	                 }
	                 else if (par2 >= 37 && par2 < 46)
	                 {
	                         if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                         {
	                                 return null;
	                         }
	                 }
	                 else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	                 {
	                         return null;
	                 }

	                 if (itemstack1.stackSize == 0)
	                 {
	                         slot.putStack((ItemStack)null);
	                 }
	                 else
	                 {
	                         slot.onSlotChanged();
	                 }

	                 if (itemstack1.stackSize == itemstack.stackSize)
	                 {
	                         return null;
	                 }

	                 slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	         }

	         return itemstack;
	}

	
}
