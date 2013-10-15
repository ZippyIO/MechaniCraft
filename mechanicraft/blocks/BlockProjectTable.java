package mechanicraft.blocks;

import mechanicraft.MechaniCraft;
import mechanicraft.tileentity.TePT;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockProjectTable extends BlockContainer{
	
	private Icon workbenchIconTop;
	
	private Icon workbenchIconFront;
	private Icon workbenchSide2;
	private Icon workbenchIconBottom;

	public BlockProjectTable(int i) {
		super(i, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2F);
		this.setStepSound(Block.soundAnvilFootstep);
	}

	
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.workbenchIconTop
				: (par1 == 0 ? this.workbenchIconBottom
						: (par1 == 2 ? this.blockIcon
								: (par1 == 3 ? this.blockIcon
										: (par1 == 4 ? this.workbenchIconFront
												: this.workbenchIconFront))));
	}

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("mechanicraft:projside1");
		this.workbenchIconTop = par1IconRegister
				.registerIcon("mechanicraft:projtop");

		this.workbenchIconBottom = par1IconRegister
				.registerIcon("mechanicraft:projbottom");
		this.workbenchIconFront = par1IconRegister
				.registerIcon("mechanicraft:projside2");
	}

	public boolean onBlockActivated(World var1, int var2, int var3, int var4,
			EntityPlayer player, int var6, float var7, float var8, float var9) {
		TePT tile = new TePT();
		if (tile != null || !player.isSneaking()) {
			player.openGui(MechaniCraft.instance, 5, var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}

@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TePT();
	}


}