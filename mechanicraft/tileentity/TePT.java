package mechanicraft.tileentity;


import java.util.List;

import mechanicraft.MechaniCraft;
import mechanicraft.blocks.BlockProjectTable;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import net.minecraft.tileentity.TileEntity;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;




public class TePT extends TileEntity implements IInventory
{
	//private World worldObj;
	private ItemStack[] inventory;
    public IInventory craftResult = new InventoryCraftResult();
	public ItemStack[] craftMatrixInventory;
    
    public TePT() {

        super();
        inventory = new ItemStack[20];
        craftMatrixInventory = new ItemStack[9]; //TODO: magic number
    }
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		
		return this.inventory[i];
	}

	//Hopper like item sucking method.
	public boolean suckItems(){
		
		if(hasBlocksOrItemsAbove()){
			EntityItem entityitem = itemsAbove(this.worldObj, getXPos(), getYPos() + 1.0D, getZPos());

            if (entityitem != null)
            {
                return insertStackFromEntity(this, entityitem);
            }
		}
		
		return false;
	}
	
	public boolean hasBlocksOrItemsAbove(){
	
		return this.itemsAbove(this.worldObj, this.getXPos(), this.getYPos() + 1.0D, this.getZPos()) != null ? true : false;
	}
	
	public static boolean insertStackFromEntity(IInventory par0IInventory, EntityItem par1EntityItem)
    {
        boolean flag = false;

        if (par1EntityItem == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = par1EntityItem.getEntityItem().copy();
            ItemStack itemstack1 = insertStack(par0IInventory, itemstack, -1);

            if (itemstack1 != null && itemstack1.stackSize != 0)
            {
                par1EntityItem.setEntityItemStack(itemstack1);
            }
            else
            {
                flag = true;
                par1EntityItem.setDead();
            }

            return flag;
        }
    }

	public static ItemStack insertStack(IInventory par0IInventory, ItemStack par1ItemStack, int par2)
    {
        if (par0IInventory instanceof ISidedInventory && par2 > -1)
        {
            ISidedInventory isidedinventory = (ISidedInventory)par0IInventory;
            int[] aint = isidedinventory.getAccessibleSlotsFromSide(par2);

            for (int j = 0; j < aint.length && par1ItemStack != null && par1ItemStack.stackSize > 0; ++j)
            {
                par1ItemStack = func_102014_c(par0IInventory, par1ItemStack, aint[j], par2);
            }
        }
        else
        {
            int k = par0IInventory.getSizeInventory();

            for (int l = 0; l < k && par1ItemStack != null && par1ItemStack.stackSize > 0; ++l)
            {
                par1ItemStack = func_102014_c(par0IInventory, par1ItemStack, l, par2);
            }
        }

        if (par1ItemStack != null && par1ItemStack.stackSize == 0)
        {
            par1ItemStack = null;
        }

        return par1ItemStack;
    }
	
	private static ItemStack func_102014_c(IInventory par0IInventory, ItemStack par1ItemStack, int par2, int par3)
    {
        ItemStack itemstack1 = par0IInventory.getStackInSlot(par2);

        
            boolean flag = false;

            if (itemstack1 == null)
            {
                par0IInventory.setInventorySlotContents(par2, par1ItemStack);
                par1ItemStack = null;
                flag = true;
            }
            
            if (flag)
            {
                if (par0IInventory instanceof TePT)
                {
                    
                    par0IInventory.onInventoryChanged();
                }

                par0IInventory.onInventoryChanged();
            }
        

        return par1ItemStack;
    }
	 
	public EntityItem itemsAbove(World par0World, double par1, double par3, double par5){
		
		List list = par0World.selectEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getAABBPool().getAABB(par1, par3, par5, par1 + 1.0D, par3 + 1.0D, par5 + 1.0D), IEntitySelector.selectAnything);
        return list.size() > 0 ? (EntityItem)list.get(0) : null;
		
	}
	
    @Override
    public ItemStack decrStackSize(int slot, int amount) {

        ItemStack itemStack = getStackInSlot(slot);
        if (itemStack != null) {
            if (itemStack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            }
            else {
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
        }
        else
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
		 if(worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) != MechaniCraft.projecttable.blockID)
	        {
	            return false;
	        } else
	        {
	            return entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
	        }
	 }
	
	public boolean canInteractWith(EntityPlayer entityplayer)
    {
		if(worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord) != MechaniCraft.projecttable.blockID)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64D;
        }
    }

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items");
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        
     // Read in the Crafting Matrix from NBT
        NBTTagList craftingTag = nbtTagCompound.getTagList("CraftingMatrix");
        craftMatrixInventory = new ItemStack[9]; //TODO: magic number
        for (int i = 0; i < craftingTag.tagCount(); ++i) {
            NBTTagCompound tagCompound = (NBTTagCompound) craftingTag.tagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < craftMatrixInventory.length) {
                craftMatrixInventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

        // Read craftingResult from NBT
        NBTTagCompound tagCraftResult = nbtTagCompound.getCompoundTag("CraftingResult");
        craftResult.setInventorySlotContents(0, ItemStack.loadItemStackFromNBT(tagCraftResult));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
            if (inventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
        
        // Write Crafting Matrix to NBT
        NBTTagList craftingTag = new NBTTagList();
        for (int currentIndex = 0; currentIndex < craftMatrixInventory.length; ++currentIndex) {
            if (craftMatrixInventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                craftMatrixInventory[currentIndex].writeToNBT(tagCompound);
                craftingTag.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("CraftingMatrix", craftingTag);
        
        // Write craftingResult to NBT
        if (craftResult.getStackInSlot(0) != null)
            nbtTagCompound.setTag("CraftingResult", craftResult.getStackInSlot(0).writeToNBT(new NBTTagCompound()));

    }

    public double getXPos()
    {
        return (double)this.xCoord;
    }

    /**
     * Gets the world Y position for this hopper entity.
     */
    public double getYPos()
    {
        return (double)this.yCoord;
    }

    /**
     * Gets the world Z position for this hopper entity.
     */
    public double getZPos()
    {
        return (double)this.zCoord;
    }

    
}
