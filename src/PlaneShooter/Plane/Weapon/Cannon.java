package PlaneShooter.Plane.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Weapon;
import PlaneShooter.Plane.PlanePart;
import PlaneShooter.Plane.Weapon.Projector.CannonBall;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class Cannon extends PlanePart implements IWeapon {
    Point pos;
    ICombatUnit parent;
    public Combat combat;

    public Cannon(Point pos, ICombatUnit parent,Combat combat){
        super(pos,parent,combat);
    }

    @Override
    public void paintUnit(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(pos.x-5,pos.y,pos.x+5,pos.y);
        g.drawLine(pos.x,pos.y,pos.x,pos.y-10);
    }

    @Override
    public void updateUnit(Combat combat) {
        if(combat.getWorldTick()%10==0){
            combat.addCombatUnit(new CannonBall(this,combat,0,-5));
        }
    }
}
