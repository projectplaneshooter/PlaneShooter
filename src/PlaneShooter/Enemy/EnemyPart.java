package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;

import java.awt.*;
import java.util.LinkedList;

abstract public class EnemyPart implements ICombatUnit{
    protected boolean alive;
    protected Enemy parent;
    protected Point pos=new Point(),speed=new Point(),acceleration=new Point(),angle=new Point();
    int health;//maybe INF

    public EnemyPart(Point pos,Point speed, int health, Enemy parent){
        this.pos.setLocation(pos);
        this.speed.setLocation(speed);
        this.alive=true;
        this.health=health;
        this.parent=parent;
    }

    @Override
    public void setPos(Point pos) {
        pos.setLocation(pos);
        alive=true;
    }

//     @Override
//     public void setAcceleration(Point acceleration) {
//        this.acceleration=acceleration;
//     }
//
//     @Override
//     public void setAngle(Point angle) {
//         this.angle=angle;
//     }

    @Override
    public Point getPos() {
        return this.pos;
    }

    public Point getSpeed() {
        return this.speed;
    }

    @Override
    abstract public void paintUnit(Graphics g,Combat combat);

    public void updateUnit(Combat combat){
        if (this.health <= 0) this.alive=false;
        this.pos.translate(this.speed.x,this.speed.y);
        this.speed.translate(this.acceleration.x,this.acceleration.y);
    }

    public CollideType getCollideType() {
        return CollideType.ENEMY;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
