package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.Weapon.Bullet.BulletEnemy;

import java.awt.*;

public class TankGun extends GunEnemy {
    public TankGun(Point pos, int power, Enemy parent) {
        super(pos, power, parent);
    }

    public TankGun(Point pos, int health, int power, Enemy parent) {
        super(pos, health, power, parent);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
        if(combat.getWorldTick()%50==0) {
//            Point bulletSpeed = new Point(parent.getSpeed().x * 3, parent.getSpeed().y * 3);
            Point bulletSpeed = new Point(0, 3);
            combat.addCombatUnit(new BulletEnemy(this.getPos(), bulletSpeed, this.power));
        }
    }
}
