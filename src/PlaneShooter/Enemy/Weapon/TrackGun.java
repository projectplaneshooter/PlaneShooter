package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.Weapon.Bullet.BulletEnemy;
import PlaneShooter.Enemy.Weapon.Bullet.TrackBulletEnemy;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

public class TrackGun extends GunEnemy {

    public TrackGun(Point pos, int power, Enemy parent) {
        super(pos, power, parent);
    }

    public TrackGun(Point pos, int health, int power, Enemy parent) {
        super(pos, health, power, parent);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
        if(combat.getWorldTick()%50==0) {
//            combat.addCombatUnit(new BulletEnemy(this.getPos(), bulletSpeed, this.power));
            combat.addCombatUnit(new TrackBulletEnemy(parent.getPos(), 3, this.power));
        }
    }
}
