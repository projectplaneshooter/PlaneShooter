package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.LinkedList;

public class Tank extends Enemy{
    LinkedList<ICombatUnit> component=new LinkedList<>();
    public Tank(Point pos){
        super(pos);
        this.component.add(new Weapon(this.pos));
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(pos.x-25,pos.y-25,50,50);
        for (ICombatUnit unit:component)
            unit.paintUnit(g);
    }

    @Override
    public void updateUnit(Combat combat) {
        int dx=0;
        int dy=1;
        pos.translate(dx,dy);
        for (ICombatUnit unit:component) {
            unit.getPos().translate(dx,dy);
            unit.updateUnit(combat);
        }
//        for (ICombatUnit unit:component);

    }

    void addComponent(ICombatUnit unit){
        component.add(unit);
    }
}
