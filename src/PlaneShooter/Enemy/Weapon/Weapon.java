package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;

import java.awt.*;

public class Weapon extends EnemyPart implements IWeapon{
    int power=1;//默认战五渣
    public Weapon(Point pos) {
        super(pos);
    }

    public Weapon(Point pos, int health) {
        super(pos, health);
    }

    public Weapon(Point pos, Point speed) {
        super(pos, speed);
    }

    public Weapon(Point pos, Point speed, int health) {
        super(pos, speed, health);
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        /**
         * 这里的可能是错的，得判断，因为可能是负数
         */
        g.drawLine(this.pos.x,this.pos.y,this.pos.x+this.speed.x*4,this.pos.y+this.speed.y*4);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
        if(combat.getWorldTick()%50==0) {
            Point bulletSpeed = new Point(this.speed.x * 2, this.speed.y * 2);
            combat.addCombatUnit(new BulletEnemy(this.pos, bulletSpeed, this.power));
        }
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed=speed;
    }

    public void getHurt(int value) {
        this.alive=false;
    }
    @Override
    public int getPower() {
        return power;
    }
}
