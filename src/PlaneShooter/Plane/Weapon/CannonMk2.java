package PlaneShooter.Plane.Weapon;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Plane.Weapon.Projector.CannonBall;

/**
 * Created by yuyuyzl on 2017/12/28.
 */
public class CannonMk2 extends Cannon {
    @Override
    public void updateUnit(Combat combat) {
        if(combat.getWorldTick()%5==0){
            combat.addCombatUnit(new CannonBall(this,0,-5));
        }
    }

    @Override
    public String getName() {
        return "Cannon Mk.II (Fast)";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
