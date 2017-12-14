package PlaneShooter.Plane;

import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public abstract class PlanePart implements ICombatUnit {
    protected Point dpos;
    protected ICombatUnit parent;

    public PlanePart(Point dpos, ICombatUnit parent){
        this.dpos=dpos;
        this.parent=parent;
    }
    @Override
    public boolean isAlive() {
        return parent.isAlive();
    }

    @Override
    public void setPos(Point pos) {
        this.dpos.setLocation(pos);
    }

    @Override
    public Point getPos() {
        Point pos=new Point(parent.getPos());
        pos.translate(dpos.x,dpos.y);
        return pos;
    }
}
