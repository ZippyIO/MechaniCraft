package mechanicraft.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class SpiritRecipeSorter implements Comparator
{
    final SpiritCraftingManager spiritCraftingManager;

    public SpiritRecipeSorter(SpiritCraftingManager par1SpiritCraftingManager)
    {
        this.spiritCraftingManager = par1SpiritCraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof SpiritShapelessRecipes && par2IRecipe instanceof SpiritShapedRecipes ? 1 : (par2IRecipe instanceof SpiritShapelessRecipes && par1IRecipe instanceof SpiritShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}