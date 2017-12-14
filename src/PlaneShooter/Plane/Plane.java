package PlaneShooter.Plane;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;
import PlaneShooter.Helper.KeyHelper;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public abstract class Plane implements ICollidable,ICombatUnit {
    protected Point pos=new Point();
    private LinkedList<ICombatUnit> components =new LinkedList<>();
    public Combat combat;
    protected int velocity;

    int health;
    public Plane(Point pos, Combat combat){
        this.pos.setLocation(pos.x,pos.y);
        this.combat=combat;
    }

    public void addComponent(ICombatUnit component){
        this.components.add(component);
    }

    public void setHealth(int health){
        this.health=health;
    }

    public void setVelocity(int velocity){
        this.velocity=velocity;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
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
            unit.paintUnit(g, );
        }
    }

    @Override
    public void updateUnit(Combat combat) {
        //testNumber=(int)(Math.random()*10);
        Point dp=KeyHelper.getMoveVector(velocity);
        pos.translate(dp.x,dp.y);
        for (ICombatUnit unit: components) {
            unit.getPos().translate(dp.x,dp.y);
            unit.updateUnit(combat);
        }
        //if(pos.x>300)health--;
        if(health<=0)combat.endCombat();
    }
}
