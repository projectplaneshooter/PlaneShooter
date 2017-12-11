package PlaneShooter.Plane.Body;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class TestBody implements IBody,ICollidable,ICombatUnit {

    int testNumber=0;
    int health=200;
    public TestBody(Point pos){
        this.pos.setLocation(pos.x,pos.y);
    }
    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.black);
        g.drawString(String.valueOf(health),pos.x,pos.y);
        //if(testNumber>5)g.setColor(Color.red);
        g.drawRect(pos.x-25-testNumber,pos.y-25-testNumber,50+testNumber*2,50+testNumber*2);

    }

    @Override
    public void updateUnit(Combat combat) {
        //testNumber=(int)(Math.random()*10);
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_DOWN))pos.y+=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_UP))pos.y-=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_LEFT))pos.x-=5;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_RIGHT))pos.x+=5;
        if(pos.x>300)health--;
        if(health<=0)combat.endCombat();
    }
}
