package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;
import java.util.LinkedList;

/**
 * 和plane有点区别，我觉得body不能改，这样我就把enemy自带一个body
 */
abstract public class Enemy extends EnemyPart implements IEnemy {
    LinkedList<EnemyPart> component=new LinkedList<>();
    public Enemy(Point pos) {
        super(pos);
    }

    public Enemy(Point pos, int health) {
        super(pos, health);
    }

    public Enemy(Point pos, Point speed) {
        super(pos, speed);
    }

    public Enemy(Point pos, Point speed, int health) {
        super(pos, speed, health);
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        for (EnemyPart unit:component){
            unit.paintUnit(g,combat);
        }
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    void addComponent(EnemyPart unit){
        component.add(unit);
    }

    @Override
    public void onCollide(ICollidable object) {
        this.health-=object.getPower();
    }
}
