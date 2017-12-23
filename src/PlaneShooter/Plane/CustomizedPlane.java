package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;

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
