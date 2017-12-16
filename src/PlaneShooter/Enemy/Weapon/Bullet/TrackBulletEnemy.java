package PlaneShooter.Enemy.Weapon.Bullet;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Helper.CollideType;

import java.awt.*;

public class TrackBulletEnemy extends BulletEnemy {
    private boolean isChangeable;
    private int bullerSpeed=5;
    public TrackBulletEnemy(Point pos,int speed, int power) {
        super(pos,new Point(), power);
        this.bullerSpeed=speed;
        isChangeable=true;
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (!combat.getCombatArea().contains(this.getPos()))
            this.alive=false;
        if (this.pos.distance(combat.PlanePosition) < 300) isChangeable=false;
        if (isChangeable){
            int speedX=combat.PlanePosition.x-this.pos.x;
            int speedY=combat.PlanePosition.y-this.pos.y;
            double length=Math.sqrt(speedX*speedX+speedY*speedY);
            if (length==0) this.speed.setLocation(0,0);
            this.speed.setLocation(speedX/length*this.bullerSpeed,speedY/length*this.bullerSpeed);
        }
    }

    public CollideType getCollideType() {
        return CollideType.ENEMYBULLET;
    }
}
