package mechanicraft.proxy;

import mechanicraft.MechaniCraft;
import mechanicraft.render.ItemAnvilCraftRenderer;
import mechanicraft.render.RenderSpiritTable;
import mechanicraft.render.TileEntityAnvilCraftRenderer;
import mechanicraft.tileentity.TileEntityAnvilCraft;
import mechanicraft.tileentity.TileEntitySpiritTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
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
	
	
	 public static void spawnParticle(String s, double d, double d1, double d2, double d3, double d4, double d5, World worldObj, int opt)
     {
             Minecraft mc = Minecraft.getMinecraft();
             if (mc == null || mc.renderViewEntity == null || mc.effectRenderer == null) {
                     return;
             }
             int i = mc.gameSettings.particleSetting;
             if (i == 1 && worldObj.rand.nextInt(3) == 0) {
                     i = 2;
             }
             double d6 = mc.renderViewEntity.posX - d;
             double d7 = mc.renderViewEntity.posY - d1;
             double d8 = mc.renderViewEntity.posZ - d2;
             EntityFX obj = null;
             double d9 = 16D;
             if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9) {
                     return;
             }
             if (i > 1) {
                     return;
             }
             
             if (s.equals("frezadust"))
                     obj = new EntityFrezaDustFX(worldObj, d, d1, d2, (float)d3, (float)d4, (float)d5);
            
             if (obj != null) {
                     mc.effectRenderer.addEffect((EntityFX)obj);
                     FMLClientHandler.instance().getClient().effectRenderer.addEffect(obj);
             }
     }
	 
}
