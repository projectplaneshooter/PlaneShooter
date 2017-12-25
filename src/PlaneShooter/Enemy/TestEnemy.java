package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Weapon.StrangeTrackGun;
import PlaneShooter.Enemy.Weapon.TrackGun;
import PlaneShooter.Helper.ResourceHelper;

import java.awt.*;
/*无health默认无法摧毁*/
public class TestEnemy extends Enemy {
    public TestEnemy(Point pos, Point speed, int health) {
        super(pos, speed, health);
        this.addComponent(new TrackGun(this.pos, 5, this));
    }

    public void paintUnit(Graphics g, Combat combat) {
        super.paintUnit(g,combat);
//        g.setColor(Color.black);
        g.drawImage(ResourceHelper.Enemy_Plane,getPos().x-25, getPos().y-25,50,50,null);
//        g.drawPolygon(this.getContour());
    }

    public void updateUnit(Combat combat){
        super.updateUnit(combat);
        if (Math.random()<=0.01||this.pos.x<=0||this.pos.x>=1000) this.speed.setLocation(-this.speed.x,-this.speed.y);
    }

    @Override
    public int getPower() {
        return 1;
    }

    @Override
    public int getSize() {
        return 50;
    }

    @Override
    public Polygon getContour() {
        Polygon contour=new Polygon();
        double len = this.getSpeed().distance(0,0);
        double XAddx,XAddy,YAddx,YAddy;
        XAddx = 0;
        XAddy = 1 / Math.sqrt(2);
        YAddx = -XAddy;
        YAddy = XAddx;
//        if (len == 0) {
//            XAddx = 0;
//            XAddy = 1 / Math.sqrt(2);
//            YAddx = -XAddy;
//            YAddy = XAddx;
//        } else{
//            XAddx = this.getSpeed().x / len / Math.sqrt(2);
//            XAddy = this.getSpeed().y / len / Math.sqrt(2);
//            YAddx = -XAddy;
//            YAddy = XAddx;
//        }
        contour.addPoint((int) (this.getPos().x + 40 * XAddx),(int) (this.getPos().y + 40 * XAddy));
        contour.addPoint((int) (this.getPos().x + 10 * YAddx),(int) (this.getPos().y + 10 * YAddy));
        contour.addPoint((int) (this.getPos().x - 10 * XAddx + 30 * YAddx),(int) (this.getPos().y - 10 * XAddy + 30 * YAddy));
        contour.addPoint((int) (this.getPos().x - 10 * XAddx - 30 * YAddx),(int) (this.getPos().y - 10 * XAddy - 30 * YAddy));
        contour.addPoint((int) (this.getPos().x - 10 * YAddx),(int) (this.getPos().y - 10 * YAddy));
        return contour;
    }
}
