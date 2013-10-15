package mechanicraft.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CraftingManagerAnvilCraft
{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
    /** The static instance of this class */
    private static final CraftingManagerAnvilCraft instance = new CraftingManagerAnvilCraft();

    /** A list of all the recipes added */
    private List recipes = new ArrayList();

    /**
     * Returns the static instance of this class
     */
    public static final CraftingManagerAnvilCraft getInstance()
    {
        return instance;
    }

    private CraftingManagerAnvilCraft()
    {
    	recipes = new ArrayList();
    	//Tools
    	this.func_92051_a(new ItemStack(Item.axeWood, 1), new Object[] {"W ", "AS",  Character.valueOf('W'), Block.planks, Character.valueOf('A'), new ItemStack(Item.axeWood, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.hoeWood, 1), new Object[] {"W ", "AS",  Character.valueOf('W'), Block.planks, Character.valueOf('A'), new ItemStack(Item.hoeWood, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.shovelWood, 1), new Object[] {"W ", "AS",  Character.valueOf('W'), Block.planks, Character.valueOf('A'), new ItemStack(Item.shovelWood, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.pickaxeWood, 1), new Object[] {"W ", "AS",  Character.valueOf('W'), Block.planks, Character.valueOf('A'), new ItemStack(Item.pickaxeWood, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.axeStone, 1), new Object[] {"R ", "AS",  Character.valueOf('R'), Block.stone, Character.valueOf('A'), new ItemStack(Item.axeStone, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.hoeStone, 1), new Object[] {"R ", "AS",  Character.valueOf('R'), Block.stone, Character.valueOf('A'), new ItemStack(Item.hoeStone, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.shovelStone, 1), new Object[] {"R ", "AS",  Character.valueOf('R'), Block.stone, Character.valueOf('A'), new ItemStack(Item.shovelStone, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.pickaxeStone, 1), new Object[] {"R ", "AS",  Character.valueOf('R'), Block.stone, Character.valueOf('A'), new ItemStack(Item.pickaxeStone, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.axeIron, 1), new Object[] {"I ", "AS",  Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.axeIron, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.hoeIron, 1), new Object[] {"I ", "AS",  Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.hoeIron, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.shovelIron, 1), new Object[] {"I ", "AS",  Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.shovelIron, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.pickaxeIron, 1), new Object[] {"I ", "AS",  Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.pickaxeIron, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.axeGold, 1), new Object[] {"G ", "AS",  Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.axeGold, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.hoeGold, 1), new Object[] {"G ", "AS",  Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.hoeGold, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.shovelGold, 1), new Object[] {"G ", "AS",  Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.shovelGold, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.pickaxeGold, 1), new Object[] {"G ", "AS",  Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.pickaxeGold, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.axeDiamond, 1), new Object[] {"D ", "AS",  Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.axeDiamond, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.hoeDiamond, 1), new Object[] {"D ", "AS",  Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.hoeDiamond, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.shovelDiamond, 1), new Object[] {"D ", "AS",  Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.shovelDiamond, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.pickaxeDiamond, 1), new Object[] {"D ", "AS",  Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.pickaxeDiamond, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
		//Swords
    	this.func_92051_a(new ItemStack(Item.swordWood, 1), new Object[] {"W ", "AS", Character.valueOf('W'), Block.planks, Character.valueOf('A'), new ItemStack(Item.swordWood, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.swordStone, 1), new Object[] {"R ", "AS", Character.valueOf('R'), Block.stone, Character.valueOf('A'), new ItemStack(Item.swordStone, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.swordIron, 1), new Object[] {"I ", "AS", Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.swordIron, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.swordGold, 1), new Object[] {"G ", "AS", Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.swordGold, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	this.func_92051_a(new ItemStack(Item.swordDiamond, 1), new Object[] {"D ", "AS", Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.swordDiamond, 1, WILDCARD_VALUE), Character.valueOf('S'), Item.stick});
    	//Armor
    	//Helmet
    	this.func_92051_a(new ItemStack(Item.helmetLeather, 1), new Object[] {"L ", "A ", Character.valueOf('L'), Item.leather, Character.valueOf('A'), new ItemStack(Item.helmetLeather, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.helmetIron, 1), new Object[] {"I ", "A ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.helmetIron, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.helmetChain, 1), new Object[] {"S ", "A ", Character.valueOf('S'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.helmetChain, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.helmetGold, 1), new Object[] {"G ", "A ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.helmetGold, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.helmetDiamond, 1), new Object[] {"D ", "A ", Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.helmetDiamond, 1, WILDCARD_VALUE)});
    	//Boots
    	this.func_92051_a(new ItemStack(Item.bootsLeather, 1), new Object[] {"L ", "A ", Character.valueOf('L'), Item.leather, Character.valueOf('A'), new ItemStack(Item.bootsLeather, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.bootsIron, 1), new Object[] {"I ", "A ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.bootsIron, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.bootsChain, 1), new Object[] {"S ", "A ", Character.valueOf('S'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.bootsChain, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.bootsGold, 1), new Object[] {"G ", "A ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.bootsGold, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.bootsDiamond, 1), new Object[] {"D ", "A ", Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.bootsDiamond, 1, WILDCARD_VALUE)});
    	//Legs
    	this.func_92051_a(new ItemStack(Item.legsLeather, 1), new Object[] {"LL", "A ", Character.valueOf('L'), Item.leather, Character.valueOf('A'), new ItemStack(Item.legsLeather, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.legsIron, 1), new Object[] {"II", "A ", Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.legsIron, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.legsChain, 1), new Object[] {"SS", "A ", Character.valueOf('S'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.legsChain, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.legsGold, 1), new Object[] {"GG", "A ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.legsGold, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.legsDiamond, 1), new Object[] {"DD", "A ", Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.legsDiamond, 1, WILDCARD_VALUE)});
    	//Chest
    	this.func_92051_a(new ItemStack(Item.plateLeather, 1), new Object[] {"LL", "AL", Character.valueOf('L'), Item.leather, Character.valueOf('A'), new ItemStack(Item.plateLeather, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.plateIron, 1), new Object[] {"II", "AI", Character.valueOf('I'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.plateIron, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.plateChain, 1), new Object[] {"SS", "AS", Character.valueOf('S'), Item.ingotIron, Character.valueOf('A'), new ItemStack(Item.plateChain, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.plateGold, 1), new Object[] {"GG", "AG", Character.valueOf('G'), Item.ingotGold, Character.valueOf('A'), new ItemStack(Item.plateGold, 1, WILDCARD_VALUE)});
    	this.func_92051_a(new ItemStack(Item.plateDiamond, 1), new Object[] {"DD", "AD", Character.valueOf('D'), Item.diamond, Character.valueOf('A'), new ItemStack(Item.plateDiamond, 1, WILDCARD_VALUE)});
    	Collections.sort(this.recipes, new AnvilCraftRecipeSorter(this)); 
        System.out.println(this.recipes.size() + " recipes");
    }

    public AnvilCraftShapedRecipes func_92051_a(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (par2ArrayOfObj[var4] instanceof String[])
        {
            String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (par2ArrayOfObj[var4] instanceof String)
            {
                String var11 = (String)par2ArrayOfObj[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
        {
            Character var13 = (Character)par2ArrayOfObj[var4];
            ItemStack var14 = null;

            if (par2ArrayOfObj[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        AnvilCraftShapedRecipes var17 = new AnvilCraftShapedRecipes(var5, var6, var15, par1ItemStack);
        this.recipes.add(var17);
        return var17;
    }

    public void addAnvilCraftShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList var3 = new ArrayList();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            if (var7 instanceof ItemStack)
            {
                var3.add(((ItemStack)var7).copy());
            }
            else if (var7 instanceof Item)
            {
                var3.add(new ItemStack((Item)var7));
            }
            else
            {
                if (!(var7 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.recipes.add(new AnvilCraftShapelessRecipes(par1ItemStack, var3));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
        {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null)
            {
                if (var3 == 0)
                {
                    var4 = var7;
                }

                if (var3 == 1)
                {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
        {
            Item var11 = Item.itemsList[var4.itemID];
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;

            if (var10 < 0)
            {
                var10 = 0;
            }

            return new ItemStack(var4.itemID, 1, var10);
        }
        else
        {
            for (var6 = 0; var6 < this.recipes.size(); ++var6)
            {
                IRecipe var12 = (IRecipe)this.recipes.get(var6);

                if (var12.matches(par1InventoryCrafting, par2World))
                {
                    return var12.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}