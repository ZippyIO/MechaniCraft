package mechanicraft.container;

import mechanicraft.gui.SlotRedFurnace;
import mechanicraft.tileentity.TileEntityRedFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RedContainer extends Container
{
    private TileEntityRedFurnace solar;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public RedContainer(InventoryPlayer inventoryplayer, TileEntityRedFurnace tileentityRedFurnace)
    {
        solar = tileentityRedFurnace;
        this.addSlotToContainer(new Slot(tileentityRedFurnace, 0, 56, 27));
        this.addSlotToContainer(new SlotRedFurnace(inventoryplayer.player, tileentityRedFurnace, 2, 116, 35));

        for (int i = 0; i < 3; i++)
        {
            for (int k = 0; k < 9; k++)
            {
            	this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }

        for (int j = 0; j < 9; j++)
        {
        	this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }
    }
    
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.solar.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.solar.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.solar.currentItemBurnTime);
    }
    
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.lastCookTime != this.solar.furnaceCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.solar.furnaceCookTime);
            }

            if (this.lastBurnTime != this.solar.furnaceBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.solar.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.solar.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.solar.currentItemBurnTime);
            }
        }

        lastCookTime = solar.furnaceCookTime;
        lastBurnTime = solar.furnaceBurnTime;
        lastItemBurnTime = solar.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.solar.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.solar.furnaceBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.solar.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return solar.isUseableByPlayer(entityplayer);
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }
            }
            else if (par2 >= 3 && par2 < 30)
            {
                if (!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (par2 >= 30 && par2 < 39)
            {
                if (!mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            }
            else
            {
                return null;
            }
        }

        return itemstack;
    }
}