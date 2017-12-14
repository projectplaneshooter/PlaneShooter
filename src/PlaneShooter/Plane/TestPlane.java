package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class TestPlane extends Plane{

    int testNumber=0;
    int health=200;
    public TestPlane(Point pos){
        super(pos);
        addComponent(new Cannon(new Point(0,0),this));
        addComponent(new RectangleBody(new Point(0,0),this));
    }


    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        super.paintUnit(g, combat);
        g.setColor(Color.black);
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
    }
}
