package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Weapon.BulletEnemy;

import java.awt.*;
/*无health默认无法摧毁*/
public class TestEnemy extends Enemy {
    public TestEnemy(Point pos) {
        super(pos);
    }

    public TestEnemy(Point pos, int health) {
        super(pos, health);
    }

    public TestEnemy(Point pos, Point speed) {
        super(pos, speed);
    }

    public TestEnemy(Point pos, Point speed, int health) {
        super(pos, speed, health);
    }

    public void paintUnit(Graphics g, Combat combat) {
        super.paintUnit(g,combat);
        g.setColor(Color.black);
        g.drawRect(getPos().x-25,getPos().y-25,50,50);
        g.setColor(Color.black);
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (Math.random()<=0.01) this.speed.setLocation(-this.speed.x,-this.speed.y);
        if (combat.getWorldTick()%50==0)
            combat.addCombatUnit(new BulletEnemy(new Point(this.pos),new Point(0,2), 10));
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
