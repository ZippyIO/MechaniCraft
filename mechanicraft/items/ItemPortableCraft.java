package mechanicraft.items;

import mechanicraft.MechaniCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortableCraft extends Item
{
    private int id;

    public ItemPortableCraft(int var1)
    {
        super(var1);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        var3.openGui(MechaniCraft.instance, 4, var2, (int)var3.posX, (int)var3.posY, (int)var3.posZ);
        return var1;
    }
    
    @Override
	public void registerIcons(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("PortTable:porttable");
	}
}