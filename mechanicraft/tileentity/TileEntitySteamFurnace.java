package mechanicraft.tileentity;

import mechanicraft.blocks.BlockSteamFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;


public class TileEntitySteamFurnace extends TileEntity implements ISidedInventory
{
        private ItemStack[] furnaceItemStacks = new ItemStack[4];
        private static final int INPUT = 0, FUEL = 1, OUTPUT = 2, WATER = 3;
        public int furnaceBurnTime = 0;
        public int currentItemBurnTime = 0;
        public int furnaceCookTime = 0;

        private String customName;
        public boolean active = false;
        public int waterLevel = 0;

        public int getCookProgressScaled(int var1) {
                return this.furnaceCookTime * var1 / 200;
        }

        public int getWaterScaled(int var1) {
                return this.waterLevel > 0 ? (int)Math.ceil((double)(this.waterLevel * var1 / 4096)) : -2;
        }

        public int getBurnTimeRemainingScaled(int par1)
        {
                if (this.currentItemBurnTime == 0)
                {
                        this.currentItemBurnTime = 200;
                }

                return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
        }

        public boolean isBurning() {
                return furnaceBurnTime > 0 && waterLevel > 0;
        }

        public int getWater() {
                return this.waterLevel;
        }

        public int getSizeInventory() {
                return this.furnaceItemStacks.length;
        }

        public ItemStack getStackInSlot(int par1) {
                return this.furnaceItemStacks[par1];
        }

        public boolean hasWater() {
                return this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.waterStill.blockID
                                || this.worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == Block.waterMoving.blockID;
        }

        @Override
        public ItemStack decrStackSize(int slot, int amount)
        {
                ItemStack stack = getStackInSlot(slot);

                if(stack != null)
                {
                        if(stack.stackSize > amount)
                        {
                                stack = stack.splitStack(amount);
                                this.onInventoryChanged();
                        } else {
                                setInventorySlotContents(slot, null);
                        }
                }

                return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot)
        {
                ItemStack stack = getStackInSlot(slot);
                setInventorySlotContents(slot, null);
                return stack;
        }

        
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack)
        {
                furnaceItemStacks[slot] = stack;
                
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }
                
                onInventoryChanged();
        }

        public String getInvName() {
                return "steam_furnace";
        }

        public boolean isInvNameLocalized() {
                return (this.customName != null) && (this.customName.length() > 0);
        }

        public void readFromNBT(NBTTagCompound var1)
        {
                super.readFromNBT(var1);
                NBTTagList var2 = var1.getTagList("Items");
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

                this.furnaceBurnTime = var1.getShort("BurnTime");
                this.furnaceCookTime = var1.getShort("CookTime");
                this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
                this.waterLevel = var1.getShort("WaterLevel");
        }

        public void writeToNBT(NBTTagCompound var1)
        {
                super.writeToNBT(var1);
                var1.setShort("BurnTime", (short)this.furnaceBurnTime);
                var1.setShort("CookTime", (short)this.furnaceCookTime);
                var1.setShort("Water", (short)this.waterLevel);
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

                var1.setTag("Items", var2);
        }

        public int getInventoryStackLimit() {
                return 64;
        }

        public void setCustomName(String name) {
                this.customName = name;
        }

        public void updateEntity()
        {
                boolean flag = this.furnaceBurnTime > 0;
                boolean flag1 = false;
                

                if(hasWater()) {
                        this.waterLevel = 4096;
                }

                if(this.waterLevel > 4096){
                        waterLevel = 4096;
                }
                if(this.waterLevel < 0){
                        waterLevel = 0;
                }

                if (this.furnaceItemStacks[WATER] != null && this.furnaceItemStacks[WATER].itemID == Item.bucketWater.itemID)
                {
                        this.waterLevel += 1024;
                        BlockSteamFurnace.playSound(this.worldObj, this.xCoord, this.yCoord, this.zCoord, "SteamFurnace:ElectroFurnaceLoop");

                        this.furnaceItemStacks[WATER].itemID = Item.bucketEmpty.itemID;
                }


                if(this.isBurning()){
                        --this.furnaceBurnTime;
                }

                if (this.furnaceBurnTime == 0 && this.canSmelt())
                {
                        this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[FUEL]);

                        if (this.furnaceBurnTime > 0)
                        {
                                flag1 = true;

                                if (this.furnaceItemStacks[FUEL] != null)
                                {
                                        --this.furnaceItemStacks[FUEL].stackSize;

                                        if (this.furnaceItemStacks[FUEL].stackSize == 0)
                                        {
                                                this.furnaceItemStacks[FUEL] = this.furnaceItemStacks[FUEL].getItem().getContainerItemStack(furnaceItemStacks[FUEL]);
                                        }
                                }
                        }
                }

                if(isBurning() && canSmelt()){

                        furnaceCookTime += 2;

                        if(furnaceCookTime == 200){

                                this.smeltItem();
                                BlockSteamFurnace.playSound(this.worldObj, xCoord, yCoord, zCoord, "random.fizz");
                                furnaceCookTime = 0;
                        }

                } else {
                        furnaceCookTime = 0;
                }

                if (flag != this.furnaceBurnTime > 0)
                {
                        flag1 = true;
                        BlockSteamFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
                }

                if (flag1)
                {
                        this.onInventoryChanged();
                }
        }

        private boolean canSmelt()
        {
                if (this.furnaceItemStacks[INPUT] == null || this.waterLevel == 0) {
                        return false;
                } else {
                        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[INPUT]);
                        if (itemstack == null) return false;
                        if (this.furnaceItemStacks[OUTPUT] == null) return true;
                        if (!this.furnaceItemStacks[OUTPUT].isItemEqual(itemstack)) return false;
                        int result = furnaceItemStacks[OUTPUT].stackSize + itemstack.stackSize;
                        return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
                }
        }

        public void smeltItem()
        {
                if (this.canSmelt())
                {
                        ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

                        if (this.furnaceItemStacks[OUTPUT] == null)
                        {
                                this.furnaceItemStacks[OUTPUT] = itemstack.copy();
                        }
                        else if (this.furnaceItemStacks[OUTPUT].isItemEqual(itemstack))
                        {
                                furnaceItemStacks[OUTPUT].stackSize += itemstack.stackSize;
                        }

                        --this.furnaceItemStacks[INPUT].stackSize;
                        this.waterLevel -= 100;

                        if (this.furnaceItemStacks[INPUT].stackSize <= 0)
                        {
                                this.furnaceItemStacks[INPUT] = null;
                        }
                }
        }

        public static int getItemBurnTime(ItemStack par0ItemStack)
        {
                if (par0ItemStack == null) {
                        return 0;
                } else {
                        int i = par0ItemStack.getItem().itemID;
                        Item item = par0ItemStack.getItem();

                        if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[i] != null) {
                                Block block = Block.blocksList[i];

                                if (block == Block.woodSingleSlab) {
                                        return 150;
                                }

                                if (block.blockMaterial == Material.wood) {
                                        return 300;
                                }

                                if (block == Block.coalBlock) {
                                        return 16000;
                                }
                        }

                        if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD"))
                                return 200;
                        if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD"))
                                return 200;
                        if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD"))
                                return 200;
                        if (i == Item.stick.itemID)
                                return 100;
                        if (i == Item.coal.itemID)
                                return 1600;
                        if (i == Item.bucketLava.itemID)
                                return 20000;
                        if (i == Block.sapling.blockID)
                                return 100;
                        if (i == Item.blazeRod.itemID)
                                return 2400;
                        return GameRegistry.getFuelValue(par0ItemStack);
                }
        }

        public static boolean isItemFuel(ItemStack par0ItemStack) {
                return getItemBurnTime(par0ItemStack) > 0;
        }

        public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
                return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord,
                                this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq(
                                                (double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
                                                (double) this.zCoord + 0.5D) <= 64.0D;
        }

        public void openChest() {}

        public void closeChest() {}

        public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
                return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
        }

        public int[] getAccessibleSlotsFromSide(int par1) {
                return null;
        }

        public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
                return this.isItemValidForSlot(par1, par2ItemStack);
        }

        public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3) {
                return par3 != 0 || par1 != 1 || par2ItemStack.itemID == Item.bucketEmpty.itemID;
        }
}