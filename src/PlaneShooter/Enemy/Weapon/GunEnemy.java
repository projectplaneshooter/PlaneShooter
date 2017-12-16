package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.Weapon.Bullet.BulletEnemy;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

class GunEnemy extends EnemyPart implements IWeapon{
    int power=1;//默认战五渣
    public GunEnemy(Point pos, int power, Enemy parent) {
        super(pos,new Point(),1, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, int health, int power, Enemy parent) {
        super(pos,new Point(),health, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, Point speed, int power, Enemy parent) {
        super(pos, speed,1, parent);
        this.power=power;
    }

    public GunEnemy(Point pos, Point speed, int health, int power, Enemy parent) {
        super(pos, speed, health, parent);
        this.power=power;
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        Point parentPos=parent.getPos();
        Point parentSpeed=parent.getSpeed();
        g.drawLine(parentPos.x,parentPos.y,parentPos.x+parentSpeed.x*5,parentPos.y+parentSpeed.y*5);
    }

    public Point getPos(){
        Point pos;
        if (parent==null) pos=new Point();
        else pos=parent.getPos();
        pos.translate(this.getSpeed().x,this.getSpeed().y);
        return pos;
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed=speed;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void onCollide(ICollidable object) {
        this.alive=false;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
