package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public abstract class Plane implements ICollidable,ICombatUnit,Serializable {
    protected Point pos=new Point();
    private LinkedList<PlanePart> components =new LinkedList<>();
    protected int velocity;

    int health=200;
    public Plane(Point pos){
        this.pos.setLocation(pos.x,pos.y);
    }



    public void addComponent(PlanePart component){
        this.components.add(component);
    }

    public void setHealth(int health){
        this.health=health;
    }

    public void setVelocity(int velocity){
        this.velocity=velocity;
    }


    @Override
    public abstract boolean isAlive();

    @Override
    public void setPos(Point pos) {
        this.pos.setLocation(pos);
    }

    @Override
    public Point getPos() {
        return pos;
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        for (ICombatUnit unit: components) {
            unit.paintUnit(g, combat);
        }
    }

    @Override
    public void updateUnit(Combat combat) {
        //testNumber=(int)(Math.random()*10);
        Point dp=KeyHelper.getMoveVector(velocity);
        pos.translate(dp.x,dp.y);
        for (ICombatUnit unit: components) {
            unit.updateUnit(combat);
        }
        //if(pos.x>300)health--;
        if(health<=0)combat.endCombat();
    }



}
