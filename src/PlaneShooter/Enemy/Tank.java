package PlaneShooter.Enemy;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Weapon.TankGun;
import PlaneShooter.Helper.ResourceHelper;

import java.awt.*;

public class Tank extends Enemy{

    public Tank(Point pos) {
        super(pos,new Point(0,1),500);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, int health) {
        super(pos,new Point(0,1),health);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, Point speed) {
        super(pos, speed,500);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    public Tank(Point pos, Point speed, int health) {
        super(pos, speed, health);
        this.addComponent(new TankGun(new Point(), 10, this));
    }

    @Override
    public void paintUnit(Graphics g,Combat combat) {
        super.paintUnit(g,combat);
//        g.setColor(Color.RED);
//        g.drawRect(pos.x-25,pos.y-25,50,50);
        g.drawImage(ResourceHelper.Enemy_Tank,getPos().x-25,getPos().y-25,50,50,null);
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
        if (len == 0) {
            XAddx = 0;
            XAddy = 1;
            YAddx = -XAddy;
            YAddy = XAddx;
        } else{
            XAddx = this.getSpeed().x / len;
            XAddy = this.getSpeed().y / len;
            YAddx = -XAddy;
            YAddy = XAddx;
        }
        contour.addPoint((int) (this.getPos().x + 25 * XAddx + 25 * YAddx),(int) (this.getPos().y + 25 * XAddy + 25 * YAddy));
        contour.addPoint((int) (this.getPos().x + 25 * XAddx - 25 * YAddx),(int) (this.getPos().y + 25 * XAddy - 25 * YAddy));
        contour.addPoint((int) (this.getPos().x - 25 * XAddx - 25 * YAddx),(int) (this.getPos().y - 25 * XAddy - 25 * YAddy));
        contour.addPoint((int) (this.getPos().x - 25 * XAddx + 25 * YAddx),(int) (this.getPos().y - 25 * XAddy + 25 * YAddy));
        return contour;
    }
}
