package mechanicraft.proxy;

import mechanicraft.MechaniCraft;
import mechanicraft.render.ItemAnvilCraftRenderer;
import mechanicraft.render.ItemSoftCopperPipeRender;
import mechanicraft.render.PipeRender;
import mechanicraft.render.RenderSpiritTable;
import mechanicraft.render.TileEntityAnvilCraftRenderer;
import mechanicraft.tileentity.TileEntityAnvilCraft;
import mechanicraft.tileentity.TileEntitySoftCopperPipe;
import mechanicraft.tileentity.TileEntitySpiritTable;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvilCraft.class, new TileEntityAnvilCraftRenderer());
		MinecraftForgeClient.registerItemRenderer(MechaniCraft.forge.blockID, new ItemAnvilCraftRenderer());
		//MinecraftForgeClient.registerItemRenderer(MechaniCraft.softCopper.blockID, new ItemSoftCopperPipeRender());
		
		
		
	}
	
	@Override
	public void registerTileEntitySpecialRenderer()
	{
    	    ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpiritTable.class, new RenderSpiritTable());
    	   // ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoftCopperPipe.class, new PipeRender());
	}
	
}
