package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;

import java.awt.*;

public class StrangeTrackGun extends GunEnemy {

    public StrangeTrackGun(Point pos, int power, Enemy parent) {
        super(pos, power, parent);
    }

    public StrangeTrackGun(Point pos, int health, int power, Enemy parent) {
        super(pos, health, power, parent);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
        if(combat.getWorldTick()%50==0) {
//            combat.addCombatUnit(new BulletEnemy(this.getPos(), bulletSpeed, this.power));
            combat.addCombatUnit(new PlaneShooter.Enemy.Weapon.Bullet.StrangeTrackBulletEnemy(parent.getPos(), 4, this.power));
        }
    }
}
