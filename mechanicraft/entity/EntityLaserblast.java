package mechanicraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaserblast extends EntityThrowable
{
  public EntityLaserblast(World par1World)
  {
    super(par1World);
  }

  public EntityLaserblast(World par1World, EntityLiving par2EntityLiving)
  {
    super(par1World, par2EntityLiving);
  }

  public EntityLaserblast(World par1World, double par2, double par4, double par6)
  {
    super(par1World, par2, par4, par6);
  }

  protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
  {
    if (par1MovingObjectPosition.entityHit != null)
    {
      byte b0 = 0;

      if ((par1MovingObjectPosition.entityHit instanceof EntityBlaze))
      {
        b0 = 3;
      }

      par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), b0);
    }

    for (int i = 0; i < 8; i++)
    {
      this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }

    if (!this.worldObj.isRemote)
    {
      setDead();
    }
  }
}