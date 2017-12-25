package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Helper.ResourceHelper;
import PlaneShooter.Plane.Plane;
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
        super.onCollide(object);
    }

    @Override
    public int getSize() {
        return 30;
    }

    @Override
    public Polygon getContour() {
        Polygon contour=new Polygon();
        double XAddx,XAddy,YAddx,YAddy;
        if (parent == null ||!(parent instanceof Plane)){
            XAddx = 1;
            XAddy = 0;
            YAddx = 0;
            YAddy = 1;
        }else{
            Point dp=((Plane) parent).dp;
            double len = dp.distance(0,0);
            XAddx=dp.x / len / Math.sqrt(2);
            XAddy=dp.y / len / Math.sqrt(2);
            YAddx=-XAddy;
            YAddy=XAddx;
        }
        contour.addPoint((int) (this.getPos().x + 30 * XAddx + 30 * YAddx),(int) (this.getPos().y + 30 * XAddy + 30 * YAddy));
        contour.addPoint((int) (this.getPos().x + 30 * XAddx - 30 * YAddx),(int) (this.getPos().y + 30 * XAddy - 30 * YAddy));
        contour.addPoint((int) (this.getPos().x - 30 * XAddx - 30 * YAddx),(int) (this.getPos().y - 30 * XAddy - 30 * YAddy));
        contour.addPoint((int) (this.getPos().x - 30 * XAddx + 30 * YAddx),(int) (this.getPos().y - 30 * XAddy + 30 * YAddy));
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
}
