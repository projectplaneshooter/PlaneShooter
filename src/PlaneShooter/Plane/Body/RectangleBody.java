package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
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
        g.drawRect(pos.x-25,pos.y-25,50,50);
    }

    @Override
    public void updateUnit(Combat combat) {
    }
}
