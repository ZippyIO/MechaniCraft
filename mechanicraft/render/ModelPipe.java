package mechanicraft.render;

import mechanicraft.MechaniCraft;
import mechanicraft.tileentity.TileEntitySoftCopperPipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

public class ModelPipe extends ModelBase
{
	//fields
	private ResourceLocation forge = new ResourceLocation("mechanicraft", "textures/pipes/softCopper.png");
	 protected Minecraft mc;
	ModelRenderer Pipe1;
	ModelRenderer Pipemid;
	ModelRenderer Pipe2;
	ModelRenderer Pipe3;
	ModelRenderer Pipe4;
	private float scale;

	public ModelPipe(float scale)
	{
		this.scale = scale;
		textureWidth = 64;
		textureHeight = 32;

		Pipemid = new ModelRenderer(this, 20, 0);
		Pipemid.addBox(0F, 0F, 0F, 4, 3, 4);
		Pipemid.setRotationPoint(6F, 0F, 6F);
		Pipemid.setTextureSize(64, 32);
		Pipemid.mirror = true;

		Pipe1 = new ModelRenderer(this, 0, 16);
		Pipe1.addBox(0F, 0F, 0F, 6, 3, 4);
		Pipe1.setRotationPoint(0F, 0F, 6F);
		Pipe1.setTextureSize(64, 32);
		Pipe1.mirror = true;

		Pipe2 = new ModelRenderer(this, 0, 0);
		Pipe2.addBox(0F, 0F, 0F, 4, 3, 6);
		Pipe2.setRotationPoint(6F, 0F, 0F);
		Pipe2.setTextureSize(64, 32);
		Pipe2.mirror = true;

		Pipe3 = new ModelRenderer(this, 0, 9);
		Pipe3.addBox(0F, 0F, 0F, 6, 3, 4);
		Pipe3.setRotationPoint(10F, 0F, 6F);
		Pipe3.setTextureSize(64, 32);
		Pipe3.mirror = true;

		Pipe4 = new ModelRenderer(this, 0, 23);
		Pipe4.addBox(0F, 0F, 0F, 4, 3, 6);
		Pipe4.setRotationPoint(6F, 0F, 10F);
		Pipe4.setTextureSize(64, 32);
		Pipe4.mirror = true;
	}

	public void render(float scale)
	{
		Pipe1.render(scale);
		Pipemid.render(scale);
		Pipe2.render(scale);
		Pipe3.render(scale);
		Pipe4.render(scale);
	}
	public void render(TileEntitySoftCopperPipe tileEntity, double x, double y, double z) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslated(x, y, z);
		
		this.mc.renderEngine.bindTexture(forge);
		variableRender(tileEntity);
		Pipemid.render(scale);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

	private void variableRender(TileEntitySoftCopperPipe tileEntity) {
		int BlockX = tileEntity.xCoord;
		int BlockY = tileEntity.yCoord;
		int BlockZ = tileEntity.zCoord;
		if(tileEntity.worldObj.getBlockId(BlockX+1, BlockY, BlockZ) == MechaniCraft.softCopper.blockID){
			Pipe3.render(scale);
		}
		if(tileEntity.worldObj.getBlockId(BlockX, BlockY, BlockZ+1) == MechaniCraft.softCopper.blockID){
			Pipe4.render(scale);
		}
		if(tileEntity.worldObj.getBlockId(BlockX-1, BlockY, BlockZ) == MechaniCraft.softCopper.blockID){
			Pipe1.render(scale);
		}
		if(tileEntity.worldObj.getBlockId(BlockX, BlockY, BlockZ-1) == MechaniCraft.softCopper.blockID){
			Pipe2.render(scale);
		}

	}

}