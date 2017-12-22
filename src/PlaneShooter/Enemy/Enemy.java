package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * 和plane有点区别，我觉得body不能改，这样我就把enemy自带一个body
 */
public abstract class Enemy extends EnemyPart implements IEnemy {
    LinkedList<EnemyPart> components=new LinkedList<>();

    public Enemy(Point pos, Point speed, int health) {
        super(pos, speed, health, null);
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        for (EnemyPart unit:components){
            unit.paintUnit(g,combat);
        }
        g.setColor(Color.black);
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
        for (ICombatUnit unit:components)
            unit.updateUnit(combat);
        Predicate<ICombatUnit> p=(u) -> !u.isAlive();//组件打掉了
        components.removeIf(p);
    }

    @Override
    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    void addComponent(EnemyPart unit){
        components.add(unit);
    }

    public CollideType getCollideType() {
        return CollideType.ENEMY;
    }

    public LinkedList<EnemyPart> getComponents(){
        return components;
    }

    @Override
    public void onCollide(ICollidable object) {
        this.health-=object.getPower();
    }
}
