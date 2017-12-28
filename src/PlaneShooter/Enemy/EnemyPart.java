package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;
import java.util.LinkedList;

abstract public class EnemyPart implements ICombatUnit, ICollidable {
    protected boolean alive;
    protected Enemy parent;
    protected Point pos=new Point(),speed=new Point();
    protected int health;//maybe INF

    public EnemyPart(Point pos,Point speed, int health, Enemy parent){
        this.pos.setLocation(pos);
        this.speed.setLocation(speed);
        this.alive=true;
        this.health=health;
        this.parent=parent;
    }

    @Override
    public void setPos(Point pos) {
        this.pos.setLocation(pos);
        alive=true;
    }

    @Override
    public Point getPos() {
        return this.pos;
    }

    public Point getSpeed() {
        return this.speed;
    }

    @Override
    public int getSize(){
        return 100;
    }

    @Override
    abstract public void paintUnit(Graphics g,Combat combat);

    public void updateUnit(Combat combat){
        if (this.health <= 0) this.alive=false;
        this.pos.translate(this.speed.x,this.speed.y);
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
