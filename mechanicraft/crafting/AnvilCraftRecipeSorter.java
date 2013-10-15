package mechanicraft.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AnvilCraftRecipeSorter implements Comparator
{
    final CraftingManagerAnvilCraft anvilCraftCraftingManager;

    public AnvilCraftRecipeSorter(CraftingManagerAnvilCraft par1CraftingManagerAnvilCraft)
    {
        this.anvilCraftCraftingManager = par1CraftingManagerAnvilCraft;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof AnvilCraftShapelessRecipes && par2IRecipe instanceof AnvilCraftShapedRecipes ? 1 : (par2IRecipe instanceof AnvilCraftShapelessRecipes && par1IRecipe instanceof AnvilCraftShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}