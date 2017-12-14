package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Tank extends Enemy{
    LinkedList<ICombatUnit> component=new LinkedList<>();

    public Tank(Point pos) {
        super(pos);
        this.addComponent(new Weapon(pos));
    }

    public Tank(Point pos, Point speed) {
        super(pos, speed);
        this.addComponent(new Weapon(pos,speed));
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(pos.x-25,pos.y-25,50,50);
        for (ICombatUnit unit:component)
            unit.paintUnit(g);
    }

    public void updateUnit(Combat combat) {
        super.updateUnit(combat);

//        int dx=0;
//        int dy=1;
//        pos.translate(dx,dy);
        for (ICombatUnit unit:component) {
//            unit.getPos().translate(dx,dy);
            unit.updateUnit(combat);
        }
        Predicate<ICombatUnit> p=(u) -> !u.isAlive();//组件打掉了
        component.removeIf(p);
    }

    void addComponent(ICombatUnit unit){
        component.add(unit);
    }
}
