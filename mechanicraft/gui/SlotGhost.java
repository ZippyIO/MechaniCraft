package mechanicraft.gui;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;


public class SlotGhost extends SlotBase implements IPhantomSlot {

	
        private EntityPlayer thePlayer;
		private int amountCrafted;
		private IInventory inv;

		public SlotGhost(IInventory iinventory, int slotIndex, int posX, int posY, EntityPlayer par1EntityPlayer) {
                super(iinventory, slotIndex, posX, posY);
                this.thePlayer = par1EntityPlayer;
                inv = iinventory;
                
        }

        @Override
        public boolean canAdjust() {
                return true;
        }
        
        
        
        @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer)
    {
        return false;
    }
        
        @Override
        public void onSlotChange(ItemStack par1ItemStack, ItemStack par2ItemStack)
        {
            if (par1ItemStack != null && par2ItemStack != null)
            {
                if (par1ItemStack.itemID == par2ItemStack.itemID)
                {
                    int i = par2ItemStack.stackSize - par1ItemStack.stackSize;

                    if (i > 0)
                    {
                        this.onCrafting(par1ItemStack, i);
                    }
                }
            }
        }
        
        
        
        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
         * internal count then calls onCrafting(item).
         */
        protected void onCrafting(ItemStack par1ItemStack, int par2) {
        	this.amountCrafted += par2;
        	this.onCrafting(par1ItemStack);
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
         */
        protected void onCrafting(ItemStack par1ItemStack) {
        	par1ItemStack.onCrafting(this.thePlayer.worldObj, thePlayer, amountCrafted);

            if (par1ItemStack.itemID == Block.workbench.blockID)
            {
                this.thePlayer.addStat(AchievementList.buildWorkBench, 1);
            }
            else if (par1ItemStack.itemID == Item.pickaxeWood.itemID)
            {
                this.thePlayer.addStat(AchievementList.buildPickaxe, 1);
            }
            else if (par1ItemStack.itemID == Block.furnaceIdle.blockID)
            {
                this.thePlayer.addStat(AchievementList.buildFurnace, 1);
            }
            else if (par1ItemStack.itemID == Item.hoeWood.itemID)
            {
                this.thePlayer.addStat(AchievementList.buildHoe, 1);
            }
            else if (par1ItemStack.itemID == Item.bread.itemID)
            {
                this.thePlayer.addStat(AchievementList.makeBread, 1);
            }
            else if (par1ItemStack.itemID == Item.cake.itemID)
            {
                this.thePlayer.addStat(AchievementList.bakeCake, 1);
            }
            else if (par1ItemStack.itemID == Item.pickaxeStone.itemID)
            {
                this.thePlayer.addStat(AchievementList.buildBetterPickaxe, 1);
            }
            else if (par1ItemStack.itemID == Item.swordWood.itemID)
            {
                this.thePlayer.addStat(AchievementList.buildSword, 1);
            }
            else if (par1ItemStack.itemID == Block.enchantmentTable.blockID)
            {
                this.thePlayer.addStat(AchievementList.enchantments, 1);
            }
            else if (par1ItemStack.itemID == Block.bookShelf.blockID)
            {
                this.thePlayer.addStat(AchievementList.bookcase, 1);
            }
        }

        public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
        {
            this.onSlotChanged();
        }
        
        public void onSlotChanged()
        {
            this.inv.onInventoryChanged();
        }

        
        
        
}