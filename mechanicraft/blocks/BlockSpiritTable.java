package mechanicraft.blocks;

import java.util.Random;

import mechanicraft.MechaniCraft;
import mechanicraft.tileentity.TileEntitySpiritTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpiritTable extends BlockContainer  
{  
	@SideOnly(Side.CLIENT)
    private Icon field_94461_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94460_b;
    
    public BlockSpiritTable(int par1)  
    {  
    	super(par1, Material.rock);  
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);  
    	this.setLightOpacity(0);   
    	this.setCreativeTab(CreativeTabs.tabBlock);
	}  
	
    /**  
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)  
	*/  
	public boolean renderAsNormalBlock()  
	{  
		return false;  
	}  
	
	@SideOnly(Side.CLIENT)  
	/**  
	* A randomly called display update to be able to add particles or other items for display  
	*/  
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)  
	{  
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);  
		for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6)  
		{  
			for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7)  
			{  
				if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)  
				{  
					var7 = par4 + 2;  
				}  
				if (par5Random.nextInt(16) == 0)  
				{  
					for (int var8 = par3; var8 <= par3 + 1; ++var8)  
					{  
						if (par1World.getBlockId(var6, var8, var7) == Block.bookShelf.blockID)  
						{  
							if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))  
							{  
								break;  
							}  
							par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);  
						}  
					}  
				}  
			}  
		}  
	}  
	/**  
	* Is this block (a) opaque and (B) a full 1m cube?  This determines whether or not to render the shared face of two  
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.  
	*/  
	public boolean isOpaqueCube()  
	{  
		return false;  
	}
		
	@SideOnly(Side.CLIENT)
	/**
	* From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	*/
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.field_94461_a : this.blockIcon);
	}
	
	/**  
	* Returns a new instance of a block's tile entity class. Called on placing the block.  
	*/  
	public TileEntity createNewTileEntity(World par1World)  
	{  
		return new TileEntitySpiritTable();  
	}  
	
	/**  
	* Called upon block activation (right click on the block.)  
	*/  
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)  
	{  
		if (!player.isSneaking())  
		{  
			TileEntitySpiritTable tileentityspirittable = (TileEntitySpiritTable)var1.getBlockTileEntity(var2, var3, var4);
			player.openGui(MechaniCraft.instance, 8, var1, var2, var3, var4);  
			return true;  
		}  
		else  
		{  
			return false;  
		}  
	}

	/**
	* Called when the block is placed in the world.
	*/
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {
        super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving, par6ItemStack);

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntitySpiritTable)par1World.getBlockTileEntity(par2, par3, par4)).setCustomName(par6ItemStack.getDisplayName());
        }
    }

    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockIcon = par1IconRegister.registerIcon("mechanicraft:enchantment_table_side");
    	this.field_94461_a = par1IconRegister.registerIcon("mechanicraft:enchantment_table_top");
    	this.field_94460_b = par1IconRegister.registerIcon("mechanicraft:enchantment_table_bottom");
    }
	
}
