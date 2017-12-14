package PlaneShooter.Plane;

import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public abstract class PlanePart implements ICombatUnit {
    protected Point pos;
    protected ICombatUnit parent;

    public PlanePart(Point pos, ICombatUnit parent){
        this.pos=pos;
        this.parent=parent;
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
