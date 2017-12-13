package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.IEnemy;

import java.awt.*;

public class Weapon extends Enemy {
    public Weapon(Point pos) {
        super(pos);
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(pos.x,pos.y,pos.x,pos.y+10);
    }

    @Override
    public void updateUnit(Combat combat) {

    }

}
