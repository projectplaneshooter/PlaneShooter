package PlaneShooter.Plane;

import PlaneShooter.Combat.ICombatUnit;

public interface IPlane extends ICombatUnit {
    void getHurt(int value);
}
