package mechanicraft.blocks;

import java.util.Random;

import mechanicraft.MechaniCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSwissMinningBlock extends Block
{
	private Random workshopRand = new Random();
    private final boolean isActive;
    private final boolean powered;
    private static boolean keepWorkShopInventory = false;
	@SideOnly(Side.CLIENT)
    private Icon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private Icon workbenchIconFront;
	private int par4;
    
    public BlockSwissMinningBlock(int par1, boolean par2, boolean par3)
    {
        super(par1, Material.ground);
        this.isActive = par2;
        this.powered = par3;
        if (par3)
        {
            this.setLightValue(1.0F);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
	{
    	return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? Block.planks.getBlockTextureFromSide(par1) : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
	}
    	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
 	{
    	this.blockIcon = par1IconRegister.registerIcon("mechanicraft:swiss_side");
    	this.workbenchIconTop = par1IconRegister.registerIcon("mechanicraft:swiss_top");
    	this.workbenchIconFront = par1IconRegister.registerIcon("mechanicraft:swiss_front");
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, MechaniCraft.swissActive.blockID, 0, 2);
            }
        }
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, MechaniCraft.swissActive.blockID, 0, 2);
            }
        }
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, MechaniCraft.swissblock.blockID, 0, 2);
        }
    }
    	
 	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
	{
 		if (!player.isSneaking())
		{
			player.openGui(MechaniCraft.instance, 10, var1, var2, var3, var4);
			return true;
		}
		else
		{
			return false;
		}	
	}
}