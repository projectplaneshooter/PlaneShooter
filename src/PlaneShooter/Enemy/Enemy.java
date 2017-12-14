package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

public abstract class Enemy implements IEnemy,ICombatUnit {
    protected boolean alive;
    protected Point pos=new Point(),speed=new Point(),acceleration=new Point(),angle=new Point();
    public Enemy(Point pos){
        this.pos.setLocation(pos);
        this.alive=true;
    }

    public Enemy(Point pos,Point speed){
        this.pos.setLocation(pos);
        this.speed.setLocation(speed);
        this.alive=true;
    }

    @Override
    public void setPos(Point pos) {
        pos.setLocation(pos);
        alive=true;
    }

     @Override
     public void setSpeed(Point speed) {
        this.speed=speed;
     }

     @Override
     public void setAcceleration(Point acceleration) {
        this.acceleration=acceleration;
     }

     @Override
     public void setAngle(Point angle) {
         this.angle=angle;
     }

     @Override
    public Point getPos() {
        return this.pos;
    }

    @Override
    abstract public void paintUnit(Graphics g,Combat combat);

    public void updateUnit(Combat combat){
        this.pos.x+=this.speed.x;
        this.pos.y+=this.speed.y;
        this.speed.x+=this.acceleration.x;
        this.speed.y+=this.acceleration.y;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }


}
