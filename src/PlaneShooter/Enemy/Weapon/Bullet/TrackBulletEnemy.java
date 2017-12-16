package PlaneShooter.Enemy.Weapon.Bullet;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Helper.CollideType;

import java.awt.*;

/**
 * 由于draw是int,这个bullet实际效果不佳
 * speed大于4时感觉OK
 * speed默认+4
 */
public class TrackBulletEnemy extends BulletEnemy {
    private boolean isChangeable;
    private int bulletSpeed=2;
    public TrackBulletEnemy(Point pos,int speed, int power) {
        super(pos,new Point(), power);
        this.bulletSpeed=speed;
        isChangeable=true;
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (this.pos.distance(combat.PlanePosition) < 300) isChangeable=false;
        if (isChangeable||this.speed.equals(new Point(0,0))){
            int speedX=combat.PlanePosition.x-this.getPos().x;
            int speedY=combat.PlanePosition.y-this.getPos().y;
            int length=(int) (Math.sqrt(speedX*speedX+speedY*speedY)+Math.random()*4);
            if (length!=0)
                this.speed.setLocation(speedX*this.bulletSpeed/length,speedY*this.bulletSpeed/length);
        }
    }

    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}
