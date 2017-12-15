package PlaneShooter.Plane.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.PlanePart;
import PlaneShooter.Plane.Weapon.Projector.CannonBall;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class Cannon extends PlanePart implements IWeapon {

    public Cannon(Point pos, ICombatUnit parent){
        super(pos,parent);
    }

    @Override
    public void paintUnit(Graphics g, Combat combat) {
        g.setColor(Color.black);
        g.drawLine(getPos().x-5,getPos().y,getPos().x+5,getPos().y);
        g.drawLine(getPos().x,getPos().y,getPos().x,getPos().y-10);
    }

    @Override
    public void updateUnit(Combat combat) {
        if(combat.getWorldTick()%10==0){
            combat.addCombatUnit(new CannonBall(this,0,-5));
        }
    }

    @Override
    public String getName() {
        return "Cannon";
    }

    @Override
    public int getPower() {
        return 10;
    }
}
