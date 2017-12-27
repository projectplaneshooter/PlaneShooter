package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ResourceHelper;
import PlaneShooter.Plane.PlanePart;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/27.
 */
public class TriangleBodyR extends TriangleBody {

    public TriangleBodyR() {
    }

    public TriangleBodyR(Point dpos, ICombatUnit parent) {
        super(dpos, parent);
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
        //contour.addPoint((int) (this.getPos().x - 25 * XAddx + 25 * YAddx),(int) (this.getPos().y - 25 * XAddy + 25 * YAddy));
        return contour;
    }


    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        //g.drawRect(getPos().x-25,getPos().y-25,50,50);
        g.drawImage(ResourceHelper.Part_TriangleBodyR_Full,getPos().x-25,getPos().y-25,50,50,null);
        //g.drawPolygon(this.getContour());
    }

    @Override
    public PlanePart getMirroredPart() {
        return new TriangleBodyL();
    }
}
