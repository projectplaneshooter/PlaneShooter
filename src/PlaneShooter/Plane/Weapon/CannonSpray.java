package PlaneShooter.Plane.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Plane.Weapon.Projector.CannonBall;

/**
 * Created by yuyuyzl on 2017/12/28.
 */
public class CannonSpray extends Cannon {
    @Override
    public void updateUnit(Combat combat) {
        if(combat.getWorldTick()%30==0){
            combat.addCombatUnit(new CannonBall(this,0,-2.7));
            combat.addCombatUnit(new CannonBall(this,0.25,-2.6));
            combat.addCombatUnit(new CannonBall(this,-0.25,-2.6));
            combat.addCombatUnit(new CannonBall(this,0.6,-2.4));
            combat.addCombatUnit(new CannonBall(this,-0.6,-2.4));
            combat.addCombatUnit(new CannonBall(this,1,-2));
            combat.addCombatUnit(new CannonBall(this,-1,-2));
        }
    }

    @Override
    public String getName() {
        return "Sprayer";
    }

    @Override
    public int getPrice() {
        return 1100;
    }
}
