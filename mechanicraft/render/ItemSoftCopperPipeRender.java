package mechanicraft.render;


import mechanicraft.tileentity.TileEntitySoftCopperPipe;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemSoftCopperPipeRender implements IItemRenderer {
	private ModelPipe anvilCraftModel;

	public void ItemTentItemRender() {
		this.anvilCraftModel = new ModelPipe(1F);
	}

	public boolean handleRenderType(ItemStack item,
			IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type,
			ItemStack item, IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item,
			Object[] data) {
		TileEntityRenderer.instance.renderTileEntityAt(
				new TileEntitySoftCopperPipe(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}