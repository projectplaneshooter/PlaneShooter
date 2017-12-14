package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public abstract class PlanePart implements ICombatUnit {
    protected Point pos;
    protected ICombatUnit parent;
    public Combat combat;

    public PlanePart(Point pos, ICombatUnit parent,Combat combat){
        this.pos=pos;
        this.parent=parent;
        this.combat=combat;
    }
    @Override
    public boolean isAlive() {
        return parent.isAlive();
    }

    @Override
    public void setPos(Point pos) {
        this.pos.setLocation(pos);
    }

    @Override
    public Point getPos() {
        return pos;
    }
}
