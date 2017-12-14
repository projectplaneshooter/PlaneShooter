package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Plane.Body.IBody;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class TestPlane extends Plane{

    int testNumber=0;
    int health=200;
    public TestPlane(Point pos,Combat combat){
        super(pos,combat);
        addComponent(new Cannon(new Point(pos),this,combat));
        addComponent(new RectangleBody(new Point(pos),this,combat));
    }


    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void paintUnit(Graphics g) {
        super.paintUnit(g);
        g.setColor(Color.black);
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
    }
}