package mechanicraft.render;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mechanicraft.tileentity.TileEntitySoftCopperPipe;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class PipeRender extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{
	static final float scale = (float) (1.0 / 16.0);
	public static final PipeRender INSTANCE = new PipeRender();
    private ModelPipe Pipe = new ModelPipe(scale);

    @Override
    public void renderTileEntityAt(TileEntity tilezEntity, double x, double y, double z, float tick) {

       Pipe.render((TileEntitySoftCopperPipe)tilezEntity, x, y, z);
    }

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return 2402;
	}

}