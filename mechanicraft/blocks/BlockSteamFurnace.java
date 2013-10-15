package mechanicraft.blocks;

import java.util.Random;

import mechanicraft.MechaniCraft;
import mechanicraft.tileentity.TileEntitySteamFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSteamFurnace extends BlockContainer
{
    private Random furnaceRand = new Random();
    private boolean active;
    private static boolean keepFurnaceInventory = false;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;
    TileEntitySteamFurnace tiley = new TileEntitySteamFurnace();
    
    public BlockSteamFurnace(int par1, boolean par2)
    {
    	super(par1, Material.rock);
        this.active = par2;
        
    }

    public int getRenderType()
    {
    	return 2105;
    }
    
    

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MechaniCraft.steamfurnace.blockID;
    }

    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int l = par1World.getBlockId(par2, par3, par4 - 1);
            int i1 = par1World.getBlockId(par2, par3, par4 + 1);
            int j1 = par1World.getBlockId(par2 - 1, par3, par4);
            int k1 = par1World.getBlockId(par2 + 1, par3, par4);
            byte b0 = 3;

            if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
            {
                b0 = 3;
            }

            if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
            {
                b0 = 2;
            }

            if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
            {
                b0 = 5;
            }

            if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
    	return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("mechanicraft:steamside4");
        this.furnaceIconFront = par1IconRegister.registerIcon(this.active ? "mechanicraft:steamon" : "mechanicraft:steamoff");
        this.furnaceIconTop = par1IconRegister.registerIcon("mechanicraft:steamtop");
    }
    
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (this.active)
        {
            TileEntitySteamFurnace var6 = (TileEntitySteamFurnace)var1.getBlockTileEntity(var2, var3, var4);
            int var7 = var1.getBlockMetadata(var2, var3, var4);
            float var8 = (float)var2 + 0.5F;
            float var9 = (float)var3 + 0.0F + var5.nextFloat() * 6.0F / 16.0F;
            float var10 = (float)var4 + 0.5F;
            float var11 = 0.52F;
            float var12 = var5.nextFloat() * 0.6F - 0.3F;

            if (var7 == 4)
            {
                var1.spawnParticle("smoke", (double)(var8 - var11), (double)var9, (double)(var10 + var12), 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", (double)(var8 - var11), (double)var9, (double)(var10 + var12), 0.0D, 0.0D, 0.0D);
            }
            else if (var7 == 5)
            {
                var1.spawnParticle("smoke", (double)(var8 + var11), (double)var9, (double)(var10 + var12), 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", (double)(var8 + var11), (double)var9, (double)(var10 + var12), 0.0D, 0.0D, 0.0D);
            }
            else if (var7 == 2)
            {
                var1.spawnParticle("smoke", (double)(var8 + var12), (double)var9, (double)(var10 - var11), 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", (double)(var8 + var12), (double)var9, (double)(var10 - var11), 0.0D, 0.0D, 0.0D);
            }
            else if (var7 == 3)
            {
                var1.spawnParticle("smoke", (double)(var8 + var12), (double)var9, (double)(var10 + var11), 0.0D, 0.0D, 0.0D);
                var1.spawnParticle("flame", (double)(var8 + var12), (double)var9, (double)(var10 + var11), 0.0D, 0.0D, 0.0D);
            }

            if (var6.getWater() > 0)
            {
                var1.spawnParticle("smoke", (double)var8, (double)(var9 + 1.0F), (double)var10, 0.0D, 0.1D, 0.0D);
                var1.spawnParticle("smoke", (double)var8, (double)(var9 + 1.0F), (double)var10, 0.0D, 0.1D, 0.0D);
            }
            
            
        }
    }
    
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        TileEntity var10 = var1.getBlockTileEntity(var2, var3, var4);

        if (var10 != null && !var5.isSneaking())
        {
            var5.openGui(MechaniCraft.instance, 9, var1, var2, var3, var4);
            return true;
        }
        else
        {
            return false;
        }
    }

    
    
    public static void playSound(World var0, int var1, int var2, int var3, String var4)
    {
        var0.playSoundEffect((double)((float)var1 + 0.5F), (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), var4, 0.5F, 2.08F);
    }

    public static void updateFurnaceBlockState(boolean var0, World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        TileEntity var6 = var1.getBlockTileEntity(var2, var3, var4);
        keepFurnaceInventory = true;

        if (var0)
        {
            var1.setBlock(var2, var3, var4, MechaniCraft.steamActive.blockID);
        }
        else
        {
            var1.setBlock(var2, var3, var4, MechaniCraft.steamfurnace.blockID);
        }

        keepFurnaceInventory = false;
        var1.setBlockMetadataWithNotify(var2, var3, var4, var5, 2);

        if (var6 != null)
        {
            var6.validate();
            var1.setBlockTileEntity(var2, var3, var4, var6);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntitySteamFurnace();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntitySteamFurnace)par1World.getBlockTileEntity(par2, par3, par4)).setCustomName(par6ItemStack.getDisplayName());
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6)
    {
            if (!keepFurnaceInventory)
                    this.dropItems(var1, var2, var3, var4);
            super.breakBlock(var1, var2, var3, var4, var5, var6);
    }
    private void dropItems(World var1, int var2, int var3, int var4)
    {
        Random var5 = new Random();
        TileEntity var6 = var1.getBlockTileEntity(var2, var3, var4);

        if (var6 instanceof IInventory)
        {
            IInventory var7 = (IInventory)var6;

            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null && var9.stackSize > 0)
                {
                    float var10 = var5.nextFloat() * 0.6F + 0.1F;
                    float var11 = var5.nextFloat() * 0.6F + 0.1F;
                    float var12 = var5.nextFloat() * 0.6F + 0.1F;
                    EntityItem var13 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), new ItemStack(var9.itemID, var9.stackSize, var9.getItemDamage()));
                    
                    if (var9.hasTagCompound())
                    {
                        var13.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                    }

                    float var14 = 0.5F;
                    var13.motionX = var5.nextGaussian() * (double)var14;
                    var13.motionY = var5.nextGaussian() * (double)var14 + 0.20000000298023224D;
                    var13.motionZ = var5.nextGaussian() * (double)var14;
                    var1.spawnEntityInWorld(var13);
                    var9.stackSize = 0;
                }
            }
        }
    }
}