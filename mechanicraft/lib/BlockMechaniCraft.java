package mechanicraft.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mechanicraft.MechaniCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockMechaniCraft extends Block {
	
	private Icon iconTop;
	private Icon iconSide;
	private Icon iconBottom;
	
	private String topTexture;
	private String sideTexture;
	private String bottomTexture;
	
	public BlockMechaniCraft(int id, Material material, String blockName,
			String unlocalizedName, int maxStackSize, String textureTop, String textureSide, String textureBottom) {
		super(id, material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(MechaniCraft.tab);
		this.topTexture = textureTop;
		this.sideTexture = textureSide;
		this.bottomTexture = textureBottom;
		// Register the item.
		GameRegistry.registerBlock(this, blockName);
		LanguageRegistry.addName(this, blockName);

	}

	@Override
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister
				.registerIcon(this.sideTexture);
		this.iconTop = iconRegister
				.registerIcon(this.topTexture);

		this.iconBottom = iconRegister
				.registerIcon(this.bottomTexture);
		this.iconSide = iconRegister
				.registerIcon(this.sideTexture);
	}

	
	public Icon getIcon(int par1, int par2) {
		return par1 == 1 ? this.iconTop
				: (par1 == 0 ? this.iconBottom
						: (par1 == 2 ? this.blockIcon
								: (par1 == 3 ? this.blockIcon
										: (par1 == 4 ? this.iconSide
												: this.iconSide))));
	}
	
}