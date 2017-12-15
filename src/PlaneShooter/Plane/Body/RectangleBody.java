package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Plane.PlanePart;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class RectangleBody extends PlanePart implements IBody {

    public RectangleBody(Point pos, ICombatUnit parent){
        super(pos,parent);
    }


    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        g.drawRect(getPos().x-25,getPos().y-25,50,50);
    }

    @Override
    public void updateUnit(Combat combat) {
    }

    @Override
    public String getName() {
        return "Rectangle Body";
    }

    @Override
    public int getPower() {
        return 1;
    }

    @Override
    public void onCollide(ICollidable object) {
    }

    @Override
    public int getSize() {
        return 70;
    }

    @Override
    public CollideType getCollideType() {
        return CollideType.PLANE;
    }
}
