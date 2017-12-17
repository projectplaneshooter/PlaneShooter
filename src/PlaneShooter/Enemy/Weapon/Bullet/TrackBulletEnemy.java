package PlaneShooter.Enemy.Weapon.Bullet;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Helper.CollideType;

import java.awt.*;

public class TrackBulletEnemy extends BulletEnemy {
    private boolean isChangeable;
    private int bulletSpeed = 3;
    private double posX,posY;//actual pos
    Point direction = new Point(0,0);
    public TrackBulletEnemy(Point pos,int speed, int power) {
        super(pos,new Point(), power);
        this.bulletSpeed=speed;
        this.posX=pos.x;
        this.posY=pos.y;
        isChangeable=true;
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (this.pos.distance(combat.PlanePosition) < 300) isChangeable=false;
        if (isChangeable || this.direction.equals(new Point(0,0))){
            int speedX = combat.PlanePosition.x - this.getPos().x;
            int speedY = combat.PlanePosition.y - this.getPos().y;
            this.direction = new Point(speedX, speedY);
        }
        double length = this.direction.distance(0,0);
        if (length != 0) {
            posX += this.direction.x * this.bulletSpeed / length;
            posY += this.direction.y * this.bulletSpeed / length;
        }
        this.pos.setLocation(posX,posY);
    }

    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}