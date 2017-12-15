package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Weapon.TankGun;

import java.awt.*;
import java.util.function.Predicate;

public class Tank extends Enemy{

    public Tank(Point pos) {
        super(pos);
        this.addComponent(new TankGun(pos,new Point(0,1)));
    }

    public Tank(Point pos, int health) {
        super(pos, health);
        this.addComponent(new TankGun(pos,new Point(0,1)));
    }

    public Tank(Point pos, Point speed) {
        super(pos, speed);
        this.addComponent(new TankGun(pos,speed));
    }

    public Tank(Point pos, Point speed, int health) {
        super(pos, speed, health);
        this.addComponent(new TankGun(pos,speed));
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.RED);
        g.drawRect(pos.x-25,pos.y-25,50,50);
        for (ICombatUnit unit:component)
            unit.paintUnit(g,combat);
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
