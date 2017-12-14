package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Plane.Body.IBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class TestPlane implements IPlane,ICollidable,ICombatUnit {
    private Point pos=new Point();
    LinkedList<ICombatUnit> component=new LinkedList<>();
    public Combat combat;

    int testNumber=0;
    int health=200;
    public TestPlane(Point pos){
        this.pos.setLocation(pos.x,pos.y);
        this.component.add(new Cannon(new Point(pos),this,combat));
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void setPos(Point pos) {
        this.pos.setLocation(pos);
    }

    @Override
    public Point getPos() {
        return pos;
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.black);
        g.drawString(String.valueOf(health),pos.x,pos.y);
        //if(testNumber>5)g.setColorColor.red);
        g.drawRect(pos.x-25-testNumber,pos.y-25-testNumber,50+testNumber*2,50+testNumber*2);
    }

    @Override
    public void updateUnit(Combat combat) {
        //testNumber=(int)(Math.random()*10);
        int dx=0;
        int dy=0;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_DOWN))dy+=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_UP))dy-=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_LEFT))dx-=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_RIGHT))dx+=5;


        pos.translate(dx,dy);
        for (ICombatUnit unit:component) {
            unit.getPos().translate(dx,dy);
            unit.updateUnit(combat);
        }
        //if(pos.x>300)health--;
        if(health<=0)combat.endCombat();
    }
}
