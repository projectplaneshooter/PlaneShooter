package PlaneShooter.Plane.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Weapon;
import PlaneShooter.Plane.IPlane;
import PlaneShooter.Plane.Weapon.Projector.CannonBall;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class Cannon implements IWeapon,ICombatUnit {
    Point pos;
    ICombatUnit parent;
    public Combat combat;

    public Cannon(Point pos, ICombatUnit parent,Combat combat){
        this.pos=pos;
        this.parent=parent;
        this.combat=combat;
    }

    @Override
    public boolean isAlive() {
        return parent.isAlive();
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
        g.drawLine(pos.x-5,pos.y,pos.x+5,pos.y);
        g.drawLine(pos.x,pos.y,pos.x,pos.y+10);
    }

    @Override
    public void updateUnit(Combat combat) {
        if(combat.getWorldTick()%10==0){
            combat.addCombatUnit(new CannonBall(this,combat,0,-5));
        }
    }
}
