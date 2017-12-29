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
        if (Math.random()<=0.01||this.pos.x<=0||this.pos.x>=combat.getCombatArea().getWidth()) this.speed.setLocation(-this.speed.x,-this.speed.y);
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
//        if (len == 0) {
            XAddx = 0;
            XAddy = 1;
            YAddx = -XAddy;
            YAddy = XAddx;
//        } else{
//            XAddx = this.getSpeed().x / len / Math.sqrt(2);
//            XAddy = this.getSpeed().y / len / Math.sqrt(2);
//            YAddx = -XAddy;
//            YAddy = XAddx;
//        }
        contour.addPoint((int) (this.getPos().x - 20 * XAddx),(int) (this.getPos().y - 20 * XAddy));
        contour.addPoint((int) (this.getPos().x - 3 * XAddx  + 10 * YAddx),(int) (this.getPos().y - 3 * XAddy + 10 * YAddy));
        contour.addPoint((int) (this.getPos().x + 20 * YAddx),(int) (this.getPos().y + 20 * YAddy));
        contour.addPoint((int) (this.getPos().x + 8 * XAddx),(int) (this.getPos().y + 8 * XAddy));
        contour.addPoint((int) (this.getPos().x - 20 * YAddx),(int) (this.getPos().y - 20 * YAddy));
        contour.addPoint((int) (this.getPos().x - 3 * XAddx - 10 * YAddx),(int) (this.getPos().y - 3 * XAddy - 10 * YAddy));
        return contour;
    }
}
