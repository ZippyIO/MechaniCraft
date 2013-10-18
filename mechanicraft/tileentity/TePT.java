package mechanicraft.tileentity;

import java.util.ArrayList;
import java.util.List;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mechanicraft.MechaniCraft;
import mechanicraft.blocks.BlockProjectTable;
import mechanicraft.container.ContainerProjectTable;
import mechanicraft.gui.ProjectTableGui;

import mechanicraft.lib.Utils;
import mechanicraft.lib.inventory.BasicInventoryII;
import mechanicraft.lib.inventory.InventoryUtilities;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TePT extends TileEntityMechaniCraft implements IInventory {
	// private World worldObj;
	private ItemStack[] inventory;
	public final BasicInventoryII resources;
	public IInventory craftResult = new InventoryCraftResult();
	public BasicInventoryII craftMatrixInventory;

	public TePT() {

		super();
		inventory = new ItemStack[20];
		craftMatrixInventory = new BasicInventoryII(9, "CraftGrid") {
			@Override
			public void onInventoryChanged() {
				TePT.this.onInventoryChanged();
			}
		};

		this.resources = new BasicInventoryII(3 * 9, "Resources") {
			@Override
			public void onInventoryChanged() {
				TePT.this.onInventoryChanged();
			}
		};
	}

	
	public boolean checkForAdjacentChests()
    {
		if(this.worldObj.getBlockId(this.xCoord + 1, this.yCoord, this.zCoord) == Block.chest.blockID
				|| this.worldObj.getBlockId(this.xCoord - 1, this.yCoord, this.zCoord) == Block.chest.blockID
					|| this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord + 1) == Block.chest.blockID
						|| this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord - 1) == Block.chest.blockID){
			return true;
			
		} else {
			
			return false;
			
		}
        
    }
	
	@SuppressWarnings("unchecked")
    public static List getAdjacentInventories(TePT machine) {
            List<TileEntity> tiles = Utils.getAdjacentTileEntities( machine.worldObj, machine.xCoord, machine.yCoord, machine.zCoord );
            List<Object> adjacentInventories = new ArrayList<Object>();
            for( TileEntity tile : tiles ) {
                    if( tile != null && InventoryUtilities.isValidInventory( tile ) )
                            adjacentInventories.add( tile );
            }
            return adjacentInventories;
    }

	
	public void updateEntity()
    {
		
		
        this.checkForAdjacentChests();
        
        
    }
	
	
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {

		return this.inventory[i];
	}

	@SuppressWarnings("unchecked")
	public List getAvailableInventories() {
		// Pulling from adjacent inventories
		List list = Utils.getAdjacentInventories(this.worldObj, this.xCoord,
				this.yCoord, this.zCoord);
		// The internal inventory is always the top priority.
		list.add(0, resources);
		return list;
		// List<IInventory> list = Utils.getAdjacentInventories( worldObj,
		// xCoord, yCoord, zCoord );
		// list.add( 0, resources );
		// return list.toArray( new IInventory[0] );
		// return Arrays.asList( resources );
	}

	// Hopper like item sucking method.
	
	@Override
	public ItemStack decrStackSize(int slot, int amount) {

		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			if (itemStack.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			} else {
				itemStack = itemStack.splitStack(amount);
				if (itemStack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}

		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {

		if (inventory[slot] != null) {
			ItemStack itemStack = inventory[slot];
			inventory[slot] = null;
			return itemStack;
		} else
			return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}

		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Project Table";
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
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		if (worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) != MechaniCraft.projecttable.blockID) {
			return false;
		} else {
			return entityplayer.getDistanceSq((double) this.xCoord + 0.5D,
					(double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64D;
		}
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) != MechaniCraft.projecttable.blockID) {
			return false;
		} else {
			return entityplayer.getDistanceSq((double) this.xCoord + 0.5D,
					(double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64D;
		}
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		resources.readFromNBT(compound);
		
		this.onInventoryChanged();
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		resources.writeToNBT(compound);

	}

	public double getXPos() {
		return (double) this.xCoord;
	}

	/**
	 * Gets the world Y position for this hopper entity.
	 */
	public double getYPos() {
		return (double) this.yCoord;
	}

	/**
	 * Gets the world Z position for this hopper entity.
	 */
	public double getZPos() {
		return (double) this.zCoord;
	}

	@Override
	public ArrayList<ItemStack> getDropItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public Container getContainerFor(EntityPlayer player) {
		return new ContainerProjectTable(this, player, worldObj, this.xCoord,
				this.yCoord, this.zCoord);
	}

	@SideOnly(Side.CLIENT)
	public GuiContainer getGuiContainerFor(EntityPlayer player) {
		return new ProjectTableGui(player, null, worldObj, this.xCoord,
				this.yCoord, this.zCoord);
	}



	

}
