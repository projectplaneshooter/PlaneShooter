package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Helper.MoveKeySet;
import PlaneShooter.Plane.Body.IBody;

import java.awt.*;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * 这个类是玩家可操控的飞机的父类。
 * 它持有一系列PlanePart对象，并且负责在Update自己的时候更新它持有的所有PlanePart。
 */
public abstract class Plane implements Serializable,IPlane {
    protected Point pos=new Point();
    protected LinkedList<PlanePart> components =new LinkedList<>();
    protected PlaneStat planeStat=new PlaneStat();
    protected int health=0;
    private MoveKeySet moveKeySet=MoveKeySet.KEY_SET_ARROW;
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
        this.planeStat.velocity=velocity;
    }

    public void setMaxHealth(int maxHealth){
        this.planeStat.maxHealth=maxHealth;
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
    public void onCollide(ICollidable object) {
        health-=object.getPower();
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        for (ICombatUnit unit: components) {
            if(unit instanceof IBody)unit.paintUnit(g, combat);
        }
        for (ICombatUnit unit: components) {
            if(!(unit instanceof IBody))unit.paintUnit(g, combat);
        }
    }

    @Override
    public void updateUnit(Combat combat) {
        //testNumber=(int)(Math.random()*10);
        Point dp=KeyHelper.getMoveVector(this.planeStat.velocity,moveKeySet);
        pos.translate(dp.x,dp.y);
        for (ICombatUnit unit: components) {
            unit.updateUnit(combat);
        }
        //if(pos.x>300)health--;
        if(health<=0)combat.endCombat(2);
    }

    public LinkedList<PlanePart> getComponents() {
        return components;
    }

    public CollideType getCollideType() {
        return CollideType.PLANE;
    }


}
