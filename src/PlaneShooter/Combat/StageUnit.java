package PlaneShooter.Combat;

import java.awt.*;

/**
 * 一个关卡单位=一个单位+应该出现的时间。
 */
public class StageUnit implements Comparable<StageUnit> {
    ICombatUnit combatUnit;
    int appearTime;

    public StageUnit(ICombatUnit combatUnit, int appearTime) {
        this.combatUnit = combatUnit;
        this.appearTime = appearTime;
    }

    @Override
    public int compareTo(StageUnit o) {
        return appearTime-o.appearTime;
    }
}
