package mechanicraft.pipes;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



import mechanicraft.tileentity.TileEntitySoftCopperPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.liquids.LiquidStack;

public class BlockSoftCopperPipe extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	public Icon topTexture;

	public BlockSoftCopperPipe(int par1) 
	{
		super(par1, Material.rock);
		//this.setCreativeTab(EmasherGas.tabGasCraft);
	}

	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntitySoftCopperPipe();
	}

	@Override
	public boolean hasTileEntity(int metadata)
    {
        return true;
    }

	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
		this.blockIcon = par1IconRegister.registerIcon("brick");
		this.topTexture = par1IconRegister.registerIcon("stone");
    }

	@Override
	public Icon getIcon(int par1, int par2)
    {
		if(par1 != 0 && par1 != 1) return this.blockIcon;
		return this.topTexture;
    }

	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        
        float f = 0.250F;
        float f1 = 0.700F;
        float f2 = 0.250F;
        float f3 = 0.700F;

        
        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    
    
}