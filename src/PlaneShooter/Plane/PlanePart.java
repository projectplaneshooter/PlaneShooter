package PlaneShooter.Plane;

import PlaneShooter.Combat.ICombatUnit;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public abstract class PlanePart implements ICombatUnit,Serializable {
    protected Point dpos;
    protected ICombatUnit parent;

    public abstract String getName();

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
        Point pos;
        if(parent!=null) pos=new Point(parent.getPos());else pos=new Point(0,0);
        pos.translate(dpos.x,dpos.y);
        return pos;
    }

    public void getHurt(int power) {
    }
}
