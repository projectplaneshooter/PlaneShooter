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
 * Created by yuyuyzl on 2017/12/14.
 */
public class RectangleBody extends PlanePart implements IBody {

    public RectangleBody(){
        super();
    }
    public RectangleBody(Point pos, ICombatUnit parent){
        super(pos,parent);
    }




    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        //g.drawRect(getPos().x-25,getPos().y-25,50,50);
        g.drawImage(ResourceHelper.Part_RectangleBody_Full,getPos().x-25,getPos().y-25,50,50,null);
//        g.drawPolygon(this.getContour());
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
    public void onCollide(ICollidable object, Combat combat) {
        super.onCollide(object, combat);
    }

    @Override
    public int getSize() {
        return 30;
    }

    @Override
    public Polygon getContour() {
        Polygon contour=new Polygon();
        double XAddx,XAddy,YAddx,YAddy;
        XAddx = 0;
        XAddy = 1;
        YAddx = -XAddy;
        YAddy = XAddx;
        contour.addPoint((int) (this.getPos().x + 25 * XAddx + 25 * YAddx),(int) (this.getPos().y + 25 * XAddy + 25 * YAddy));
        contour.addPoint((int) (this.getPos().x + 25 * XAddx - 25 * YAddx),(int) (this.getPos().y + 25 * XAddy - 25 * YAddy));
        contour.addPoint((int) (this.getPos().x - 25 * XAddx - 25 * YAddx),(int) (this.getPos().y - 25 * XAddy - 25 * YAddy));
        contour.addPoint((int) (this.getPos().x - 25 * XAddx + 25 * YAddx),(int) (this.getPos().y - 25 * XAddy + 25 * YAddy));
        return contour;
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
