package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

abstract class Enemy implements IEnemy,ICombatUnit {
    boolean alive;
    protected Point pos=new Point();
    public Enemy(Point pos){
        this.pos.setLocation(pos);
    }
    @Override
    public void setPos(Point pos) {
        pos.setLocation(pos);
        alive=true;
    }

    @Override
    public Point getPos() {
        return this.pos;
    }

    @Override
    abstract public void paintUnit(Graphics g);

    @Override
    abstract public void updateUnit(Combat combat);

    @Override
    public boolean isAlive() {
        return alive;
    }
}
