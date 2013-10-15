package mechanicraft.blocks;

import mechanicraft.MechaniCraft;
import mechanicraft.entity.EntityLaserblast;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPML2 extends Block
{
  public static final String modid = "mod_PML2";

  @SideOnly(Side.CLIENT)
  public Icon pml2IconBack;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconBottom;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconFront;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconHLeft;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconHRight;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconTop;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconVDLeft;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconVDRight;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconVULeft;

  @SideOnly(Side.CLIENT)
  public Icon pml2IconVURight;

  public BlockPML2(int var1)
  {
    super(var1, Material.iron);
    setCreativeTab(CreativeTabs.tabBlock);
  }

  public void onBlockAdded(World var1, int var2, int var3, int var4)
  {
    super.onBlockAdded(var1, var2, var3, var4);
  }

  @SideOnly(Side.CLIENT)
  public Icon getIcon(int var1, int var2)
  {
    if (var2 == 0)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconBottom;
      case 1:
        return this.pml2IconBottom;
      case 2:
        return this.pml2IconFront;
      case 3:
        return this.pml2IconBack;
      case 4:
        return this.pml2IconHLeft;
      case 5:
        return this.pml2IconHRight;
      }
    }

    if (var2 == 1)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconBottom;
      case 1:
        return this.pml2IconBottom;
      case 2:
        return this.pml2IconHLeft;
      case 3:
        return this.pml2IconHRight;
      case 4:
        return this.pml2IconBack;
      case 5:
        return this.pml2IconFront;
      }
    }

    if (var2 == 2)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconBottom;
      case 1:
        return this.pml2IconBottom;
      case 2:
        return this.pml2IconBack;
      case 3:
        return this.pml2IconFront;
      case 4:
        return this.pml2IconHRight;
      case 5:
        return this.pml2IconHLeft;
      }
    }

    if (var2 == 3)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconBottom;
      case 1:
        return this.pml2IconBottom;
      case 2:
        return this.pml2IconHRight;
      case 3:
        return this.pml2IconHLeft;
      case 4:
        return this.pml2IconFront;
      case 5:
        return this.pml2IconBack;
      }
    }

    if (var2 == 4)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconFront;
      case 1:
        return this.pml2IconBack;
      case 2:
        return this.pml2IconBottom;
      case 3:
        return this.pml2IconBottom;
      case 4:
        return this.pml2IconVDRight;
      case 5:
        return this.pml2IconVDLeft;
      }
    }

    if (var2 == 5)
    {
      switch (var1)
      {
      case 0:
        return this.pml2IconBack;
      case 1:
        return this.pml2IconFront;
      case 2:
        return this.pml2IconBottom;
      case 3:
        return this.pml2IconBottom;
      case 4:
        return this.pml2IconVULeft;
      case 5:
        return this.pml2IconVURight;
      }
    }

    return this.pml2IconBottom;
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister var1)
  {
    this.blockIcon = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 0);
    this.pml2IconBack = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 3);
    this.pml2IconBottom = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 0);
    this.pml2IconFront = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 2);
    this.pml2IconHLeft = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 4);
    this.pml2IconHRight = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 5);
    this.pml2IconTop = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 0);
    this.pml2IconVDLeft = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 9);
    this.pml2IconVDRight = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 7);
    this.pml2IconVULeft = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 6);
    this.pml2IconVURight = var1.registerIcon("PML2:" + getUnlocalizedName().substring(5) + 8);
  }

  public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
  {
    int var10 = 0;
    ItemStack var11 = var5.getCurrentEquippedItem();

    if (var11 != null)
    {
      var10 = var11.itemID;
    }

    int var12 = -1;

    if (var10 == Item.redstone.itemID)
    {
      var12 = MechaniCraft.RADIUS - 1;
    }
    else if (var10 == Item.ingotGold.itemID)
    {
      var12 = MechaniCraft.RADIUS;
    }
    else if (var10 == Item.diamond.itemID)
    {
      var12 = MechaniCraft.RADIUS + 1;
    }

    if (var12 >= 0)
    {
      System.out.println("Firing PML2!");
      activateLaser(var1, var2, var3, var4, var12);
      var1.playSound(var2, var3, var4, "random.breath", 0.5F, 1.5F, false);
      var5.inventory.consumeInventoryItem(var10);
    }
    else
    {
      var1.setBlockMetadataWithNotify(var2, var3, var4, (byte)((var1.getBlockMetadata(var2, var3, var4) + 1) % 6), 3);
    }

    return true;
  }

  private void activateLaser(World var1, int var2, int var3, int var4, int var5)
  {
    int var6 = var1.getBlockMetadata(var2, var3, var4);

    for (int var7 = 1; var7 <= MechaniCraft.RANGE; var7++)
    {
      int var8 = var2;
      int var9 = var3;
      int var10 = var4;

      switch (var6)
      {
      case 0:
        var10 = var4 - var7;
        break;
      case 1:
        var8 = var2 + var7;
        break;
      case 2:
        var10 = var4 + var7;
        break;
      case 3:
        var8 = var2 - var7;
        break;
      case 4:
        var9 = var3 - var7;
        break;
      case 5:
        var9 = var3 + var7;
      }

      for (int var11 = -1 * var5; var11 <= var5; var11++)
      {
        for (int var12 = -1 * var5; var12 <= var5; var12++)
        {
          int var13 = var8;
          int var14 = var9;
          int var15 = var10;

          switch (var6)
          {
          case 0:
          case 2:
            var13 = var8 + var12;
            var14 = var9 + var11;
            break;
          case 1:
          case 3:
            var15 = var10 + var12;
            var14 = var9 + var11;
            break;
          case 4:
          case 5:
            var13 = var8 + var11;
            var15 = var10 + var12;
          }

          int var16 = var1.getBlockId(var13, var14, var15);

          if (MechaniCraft.SELECTFIRE == 1)
          {
            if ((var16 != 1) && (var16 != 2) && (var16 != 3) && (var16 != 4) && (var16 != 12) && (var16 != 13))
            {
              System.out.println(var16);
              MechaniCraft.DROP = 1;
            }
            else
            {
              MechaniCraft.DROP = 0;
            }
          }

          if (MechaniCraft.LAVATUNNEL == 1)
          {
            if (var1.getBlockMaterial(var13, var14, var15 - 1) == Material.lava)
            {
              var1.setBlock(var13, var14, var15 - 1, 20);
            }

            if (var1.getBlockMaterial(var13, var14, var15 + 1) == Material.lava)
            {
              var1.setBlock(var13, var14, var15 + 1, 20);
            }

            if (var1.getBlockMaterial(var13 - 1, var14, var15) == Material.lava)
            {
              var1.setBlock(var13 - 1, var14, var15, 20);
            }

            if (var1.getBlockMaterial(var13 + 1, var14, var15) == Material.lava)
            {
              var1.setBlock(var13 + 1, var14, var15, 20);
            }

            if (var1.getBlockMaterial(var13, var14 + 1, var15) == Material.lava)
            {
              var1.setBlock(var13, var14 + 1, var15, 20);
            }

            if (var1.getBlockMaterial(var13, var14 - 1, var15) == Material.lava)
            {
              var1.setBlock(var13, var14 - 1, var15, 20);
            }
          }

          if (MechaniCraft.AQUATUNNEL == 1)
          {
            if (var1.getBlockMaterial(var13, var14, var15 - 1) == Material.water)
            {
              var1.setBlock(var13, var14, var15 - 1, 20);
            }

            if (var1.getBlockMaterial(var13, var14, var15 + 1) == Material.water)
            {
              var1.setBlock(var13, var14, var15 + 1, 20);
            }

            if (var1.getBlockMaterial(var13 - 1, var14, var15) == Material.water)
            {
              var1.setBlock(var13 - 1, var14, var15, 20);
            }

            if (var1.getBlockMaterial(var13 + 1, var14, var15) == Material.water)
            {
              var1.setBlock(var13 + 1, var14, var15, 20);
            }

            if (var1.getBlockMaterial(var13, var14 + 1, var15) == Material.water)
            {
              var1.setBlock(var13, var14 + 1, var15, 20);
            }

            if (var1.getBlockMaterial(var13, var14 - 1, var15) == Material.water)
            {
              var1.setBlock(var13, var14 - 1, var15, 20);
            }
          }

          if (var16 > 0)
          {
            if (MechaniCraft.DROP != 0)
            {
              if (var16 == 7)
              {
                if (MechaniCraft.BEDROCK != 1)
                  continue;
                Block.blocksList[var16].dropBlockAsItem(var1, var13, var14, var15, var1.getBlockMetadata(var13, var14, var15), 0);
              }
              else
              {
                Block.blocksList[var16].dropBlockAsItem(var1, var13, var14, var15, var1.getBlockMetadata(var13, var14, var15), 0);
              }
            }
            var1.spawnEntityInWorld(new EntityLaserblast(var1, var13, var14, var15));
            var1.setBlock(var13, var14, var15, 0, 0, 3);
          }
        }
      }
    }
  }

  public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5, ItemStack var6)
  {
    int var7 = MathHelper.floor_double(var5.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;

    if (var7 == 0)
    {
      var1.setBlockMetadataWithNotify(var2, var3, var4, 2, 2);
    }

    if (var7 == 1)
    {
      var1.setBlockMetadataWithNotify(var2, var3, var4, 3, 2);
    }

    if (var7 == 2)
    {
      var1.setBlockMetadataWithNotify(var2, var3, var4, 0, 2);
    }

    if (var7 == 3)
    {
      var1.setBlockMetadataWithNotify(var2, var3, var4, 1, 2);
    }
  }
}