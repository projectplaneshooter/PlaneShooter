package PlaneShooter.Enemy.Weapon.Bullet;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

public class BulletEnemy extends EnemyPart {
    private int power;

    public BulletEnemy(Point pos, Point speed, int power) {
        super(pos, speed ,1, null);
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
        g.drawRect(this.getPos().x-1,this.getPos().y-1,2,2);
    }
    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if(getPos().getX()>combat.getCombatArea().getWidth()||getPos().getX()<0||
           getPos().getY()>combat.getCombatArea().getHeight()||getPos().getY()<0) this.alive=false;
    }
    
    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}
