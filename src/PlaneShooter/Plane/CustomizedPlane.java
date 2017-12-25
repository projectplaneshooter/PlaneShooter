package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;

/**
 * 在设计器中设计出来的飞机都是这个类的实例。
 * 它扩展了Plane类，并加入了一些特有的方法使得设计器正常工作。
 */
public class CustomizedPlane extends Plane {

    public CustomizedPlane(Point pos){
        super(pos);
    }


    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        super.paintUnit(g, combat);
        g.setColor(Color.black);
        if(components.isEmpty()){
            g.drawLine(getPos().x-2,getPos().y-2,getPos().x+2,getPos().y+2);
            g.drawLine(getPos().x+2,getPos().y-2,getPos().x-2,getPos().y+2);
        }
        g.drawString("HP:"+String.valueOf(health),pos.x-20,pos.y+40);
    }

    @Override
    public void updateUnit(Combat combat) {
        super.updateUnit(combat);
    }

    @Override
    public int getPower() {
        return 1;
    }

    @Override
    public int getSize() {
        return 30;
    }

    @Override
    public Polygon getContour() {
        Polygon contour = new Polygon();
        return contour;
    }

    public void calculateStats(){
        int maxHealthNow=planeStat.maxHealth;
        planeStat=new PlaneStat();
        for(PlanePart c : components){
            c.calculateStats(planeStat);
        }
        health+=planeStat.maxHealth-maxHealthNow;
    }

    public boolean isStatLegal(){
        return planeStat.maxHealth>0&&planeStat.velocity>0;
    }

    public int getPartCount(){
        return components.size();
    }
}
