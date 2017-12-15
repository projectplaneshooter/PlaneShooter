package PlaneShooter.Enemy.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

public class BulletEnemy extends EnemyPart {
    private int power;
    public BulletEnemy(Point pos,int power) {
        super(pos);
        this.power=power;
    }

    public BulletEnemy(Point pos, Point speed, int power) {
        super(pos, speed);
        this.power=power;
    }

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

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        g.setColor(Color.BLACK);
        g.drawRect(this.pos.x-1,this.pos.y-1,2,2);
    }
    public void updateUnit(Combat combat){
        super.updateUnit(combat);
    }
    public void getHurt(int value) {
        this.alive=false;
    }
    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}
