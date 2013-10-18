package mechanicraft.lib;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mechanicraft.MechaniCraft;
import mechanicraft.lib.inventory.InventoryUtilities;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class Utils {

	public static void notifyPlayer(EntityPlayer player, String message) {
		player.addChatMessage( message );
	}

	public static String getStackDescription(ItemStack stack) {
		if( stack == null )
			return "null";

		return stack.stackSize + "x " + stack.getItem().getItemDisplayName( stack );
	}

	public static ItemStack copyOfStack(ItemStack stack) {
		if( stack == null )
			return null;
		return stack.copy();
	}

	public static boolean equalsStacks(ItemStack stack1, ItemStack stack2) {
		return stack1.itemID == stack2.itemID
				&& (!stack1.getHasSubtypes() || stack1.getItemDamage() == stack2.getItemDamage())
				&& ItemStack.areItemStackTagsEqual( stack1, stack2 );
	}

	/**
	 * Drops an item on the world as an EntityItem.
	 *
	 * @param itemStack the ItemStack to drop. Shall not be null.
	 */
	public static void dropItemAsEntity(World world, int x, int y, int z, ItemStack itemStack) {
		Random random = new Random();
		float var10 = random.nextFloat() * 0.8F + 0.1F;
		float var11 = random.nextFloat() * 0.8F + 0.1F;
		EntityItem item;

		for( float var12 = random.nextFloat() * 0.8F + 0.1F; itemStack.stackSize > 0; world.spawnEntityInWorld( item ) ) {
			int var13 = random.nextInt( 21 ) + 10;

			if( var13 > itemStack.stackSize ) {
				var13 = itemStack.stackSize;
			}

			itemStack.stackSize -= var13;
			item = new EntityItem( world, (double) (x + var10), (double) (y + var11), (double) (z + var12), new ItemStack( itemStack.itemID, var13, itemStack.getItemDamage() ) );
			float var15 = 0.05F;
			item.motionX = (random.nextGaussian() * var15);
			item.motionY = (random.nextGaussian() * var15 + 0.2F);
			item.motionZ = (random.nextGaussian() * var15);

			if( itemStack.hasTagCompound() ) {
				item.getEntityItem().setTagCompound( (NBTTagCompound) itemStack.getTagCompound().copy() );
			}
		}
	}

	public static ItemStack[] copyArray(ItemStack... oldArray) {
		int length = oldArray.length;
		ItemStack[] newArray = new ItemStack[length];
		for( int i = 0; i < length; i++ ) {
			newArray[i] = oldArray[i] == null ? null : oldArray[i].copy();
		}
		return newArray;
	}

	public static void writeItemStackToNBT(NBTTagCompound compound, ItemStack item, String tagName) {
		NBTTagCompound itemTag = new NBTTagCompound();
		item.writeToNBT( itemTag );
		compound.setTag( tagName, itemTag );
	}

	public static ItemStack readStackFromNBT(NBTTagCompound nbt) {
		try {
			return ItemStack.loadItemStackFromNBT( nbt );
		} catch( NullPointerException npe ) {
			return null;
		}
	}

	public static List<TileEntity> getAdjacentTileEntities(World world, int x, int y, int z) {
		List<TileEntity> tileEntities = new ArrayList<TileEntity>();
		for( ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS ) {
			int _x = x + dir.offsetX;
			int _y = y + dir.offsetY;
			int _z = z + dir.offsetZ;
			TileEntity te = world.getBlockTileEntity( _x, _y, _z );
			if( te != null )
				tileEntities.add( te );
		}
		return tileEntities;
	}

	public static List<IInventory> getAdjacentInventories(World world, int x, int y, int z) {
		List<IInventory> list = new ArrayList<IInventory>();
		for( ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS ) {
			int _x = x + dir.offsetX;
			int _y = y + dir.offsetY;
			int _z = z + dir.offsetZ;
			TileEntity te = world.getBlockTileEntity( _x, _y, _z );
			if( te != null && InventoryUtilities.isValidInventory( te ) ) {
				IInventory inv = InventoryUtilities.getInventoryFrom( te, dir.getOpposite() );
				if( inv != null )
					list.add( inv );
			}
		}
		return list;
	}

	public static boolean[] decodeInt(int source, int length) {
		boolean[] retValue = new boolean[length];
		for( int i = 0; i < length; i++ ) {
			retValue[i] = ((source >> i) & 1) == 1;
		}
		return retValue;
	}

	public static int encodeInt(boolean[] b) {
		int retValue = 0;
		for( int i = 0; i < b.length; i++ ) {
			int foo = b[i] ? 1 : 0;
			retValue = retValue | (foo << i);
		}
		return retValue;
	}

	public static boolean anyOf(boolean[] array) {
		for( boolean b : array ) {
			if( b ) return true;
		}
		return false;
	}

	public static boolean allOf(boolean[] array) {
		for( boolean b : array ) {
			if( b ) return false;
		}
		return true;
	}

	public static EntityPlayer getFakePlayerFor(TileEntity tile) {
		return MechaniCraft.proxy.getFakePlayer( tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord );
	}

}