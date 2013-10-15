package mechanicraft.tileentity;

import mechanicraft.blocks.BlockSolarFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntitySolarFurnace extends TileEntity implements IInventory, ISidedInventory
{
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 1000;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;
    public int maxCookTime = 250;
	private Minecraft minecraft;
	private String customName;

    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return this.furnaceItemStacks[par1];
    }
    
    public boolean isInSunlight()
    {
        World world = minecraft.getMinecraft().theWorld;
        return world != null && world.getBlockLightValue(xCoord, yCoord + 1, zCoord) >= 13 && world.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && world.getWorldTime() <= 12500L;
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.furnaceItemStacks[par1].stackSize <= par2)
            {
                var3 = this.furnaceItemStacks[par1];
                this.furnaceItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.furnaceItemStacks[par1].splitStack(par2);

                if (this.furnaceItemStacks[par1].stackSize == 0)
                {
                    this.furnaceItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack var2 = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "SolarFurnace";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
        {
            if (this.furnaceItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.furnaceItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
    	return (furnaceCookTime * par1) / maxCookTime;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
    	if (currentItemBurnTime == 0)
        {
            currentItemBurnTime = maxCookTime;
        }

        return (furnaceBurnTime * par1) / currentItemBurnTime;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean flag = furnaceBurnTime > 0;
        boolean flag1 = false;

        if (!isInSunlight())
        {
            furnaceBurnTime = 0;
            BlockSolarFurnace.updateFurnaceBlockState(false, worldObj, xCoord, yCoord, zCoord);
        }
        else if (isInSunlight())
        {
            furnaceBurnTime = 1000;
        }

        if (canSmelt())
        {
            currentItemBurnTime = furnaceBurnTime = getItemBurnTime(furnaceItemStacks[1]);

            if (furnaceBurnTime > 0)
            {
                flag1 = true;

                if (furnaceItemStacks[1] != null)
                {
                    if (furnaceItemStacks[1].getItem().hasContainerItem())
                    {
                        furnaceItemStacks[1] = new ItemStack(furnaceItemStacks[1].getItem().getContainerItem());
                    }
                    else
                    {
                        furnaceItemStacks[1].stackSize--;
                    }

                    if (furnaceItemStacks[1].stackSize == 0)
                    {
                        furnaceItemStacks[1] = null;
                    }
                }
            }
        }

        if (isBurning() && canSmelt())
        {
            furnaceCookTime++;
            BlockSolarFurnace.updateFurnaceBlockState(true, worldObj, xCoord, yCoord, zCoord);

            if (furnaceCookTime == maxCookTime)
            {
                furnaceCookTime = 0;
                BlockSolarFurnace.updateFurnaceBlockState(false, worldObj, xCoord, yCoord, zCoord);
                smeltItem();
                flag1 = true;
            }
        }
        else
        {
            furnaceCookTime = 0;
        }

        if (flag1)
        {
            onInventoryChanged();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
    	if (furnaceItemStacks[0] == null)
        {
            return false;
        }

        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(furnaceItemStacks[0].getItem().itemID);

        if (itemstack == null)
        {
            return false;
        }

        if (furnaceItemStacks[2] == null)
        {
            return true;
        }

        if (!furnaceItemStacks[2].isItemEqual(itemstack))
        {
            return false;
        }

        if (furnaceItemStacks[2].stackSize < getInventoryStackLimit() && furnaceItemStacks[2].stackSize < furnaceItemStacks[2].getMaxStackSize())
        {
            return true;
        }
        else
        {
            return furnaceItemStacks[2].stackSize < itemstack.getMaxStackSize();
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
    	if (!canSmelt())
        {
            return;
        }

        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(furnaceItemStacks[0].getItem().itemID);

        if (furnaceItemStacks[2] == null)
        {
            furnaceItemStacks[2] = itemstack.copy();
        }
        else if (furnaceItemStacks[2].itemID == itemstack.itemID)
        {
            furnaceItemStacks[2].stackSize += itemstack.stackSize;
        }

        if (furnaceItemStacks[0].getItem().hasContainerItem())
        {
            furnaceItemStacks[0] = new ItemStack(furnaceItemStacks[0].getItem().getContainerItem());
        }
        else
        {
            furnaceItemStacks[0].stackSize--;
        }

        if (furnaceItemStacks[0].stackSize <= 0)
        {
            furnaceItemStacks[0] = null;
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public int getItemBurnTime(ItemStack par0ItemStack)
    {
    	return !isInSunlight() ? 0 : 1000;
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

    @Override
	public boolean isInvNameLocalized()
	{
	    return (this.customName != null) && (this.customName.length() > 0);
	}

	public void setCustomName(String name) 
	{
	    this.customName = name;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
}