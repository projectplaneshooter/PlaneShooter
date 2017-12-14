package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;

import java.awt.*;

public class BulletEnemy extends Enemy {
    public BulletEnemy(Point pos) {
        super(pos);
    }

    public BulletEnemy(Point pos, Point speed) {
        super(pos, speed);
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        g.drawRect(this.pos.x-1,this.pos.y-1,2,2);
    }
    public void updateUnit(Graphics g){
        /**
         * 这里得判断出界
         */
    }
}