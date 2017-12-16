package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Weapon.TankGun;

import java.awt.*;

public class Tank extends Enemy{

    public Tank(Point pos) {
        super(pos,new Point(0,1),500);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, int health) {
        super(pos,new Point(0,1),health);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, Point speed) {
        super(pos, speed,500);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, Point speed, int health) {
        super(pos, speed, health);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        super.paintUnit(g,combat);
        g.setColor(Color.RED);
        g.drawRect(pos.x-25,pos.y-25,50,50);
    }

    @Override
    public int getPower() {
        return 1;
    }

    @Override
    public int getSize() {
        return 30;
    }
}
