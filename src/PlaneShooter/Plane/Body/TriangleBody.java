package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.ResourceHelper;
import PlaneShooter.Plane.PlanePart;
import PlaneShooter.Plane.PlaneStat;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/27.
 */
public abstract class TriangleBody extends PlanePart implements IBody {

    public TriangleBody() {
    }

    public TriangleBody(Point dpos, ICombatUnit parent) {
        super(dpos, parent);
    }



    @Override
    public void updateUnit(Combat combat) {
    }

    @Override
    public String getName() {
        return "Triangle Body";
    }

    @Override
    public int getPower() {
        return 1;
    }

    @Override
    public void onCollide(ICollidable object, Combat combat) {
        super.onCollide(object, combat);
    }

    @Override
    public int getSize() {
        return 30;
    }

    @Override
    public CollideType getCollideType() {
        return CollideType.PLANEPART;
    }

    @Override
    public PlaneStat calculateStats(PlaneStat planeStat) {
        planeStat.maxHealth+=200;
        if(planeStat.velocity<3)planeStat.velocity=3;
        return planeStat;
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
