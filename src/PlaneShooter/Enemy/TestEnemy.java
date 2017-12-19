package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Weapon.StrangeTrackGun;
import PlaneShooter.Enemy.Weapon.TrackGun;

import java.awt.*;
/*无health默认无法摧毁*/
public class TestEnemy extends Enemy {
    public TestEnemy(Point pos, Point speed, int health) {
        super(pos, speed, health);
        this.addComponent(new TrackGun(this.pos, 5, this));
    }

    public void paintUnit(Graphics g, Combat combat) {
        super.paintUnit(g,combat);
        g.setColor(Color.black);
        g.drawRect(getPos().x-25,getPos().y-25,50,50);
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (Math.random()<=0.01||this.pos.x<=0||this.pos.x>=1000) this.speed.setLocation(-this.speed.x,-this.speed.y);
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
