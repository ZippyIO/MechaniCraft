package mechanicraft.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;


public class CommonProxy 
{

	public void registerRenderThings() 
	{
		
	}
	
	public void registerTileEntitySpecialRenderer() {}
	
    private EntityPlayer fakePlayer;

    public EntityPlayer getFakePlayer(World world, int x, int y, int z) {
            if( fakePlayer == null ) {
                    fakePlayer = createFakePlayer( world );
            }
            fakePlayer.worldObj = world;
            fakePlayer.posX = x;
            fakePlayer.posY = y;
            fakePlayer.posZ = z;
            return fakePlayer;
    }

    public static boolean isFakePlayer(EntityPlayer player) {
            return player.username.equals( "[MechaniCraft]" );
    }

    private EntityPlayer createFakePlayer(World world) {
            return new FakePlayer( world, "[MechaniCraft]" );
    }
    
}
