package mechanicraft.render;

import mechanicraft.tileentity.TileEntityAnvilCraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemAnvilCraftRenderer implements IItemRenderer
{
private ModelAnvilCraft anvilCraftModel;

public void ItemTentItemRender()
{
  this.anvilCraftModel = new ModelAnvilCraft();
}

public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
{
  return true;
}

public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
{
  return true;
}

public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object[] data)
{
  TileEntityRenderer.instance.renderTileEntityAt(new TileEntityAnvilCraft(), 0.0D, 0.0D, 0.0D, 0.0F);
}
}