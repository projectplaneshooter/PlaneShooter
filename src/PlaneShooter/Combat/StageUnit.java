package PlaneShooter.Combat;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/17.
 */
public class StageUnit implements Comparable<StageUnit> {
    ICombatUnit combatUnit;
    int appearTime;

    public StageUnit(ICombatUnit combatUnit, int appearTime, Point position) {
        this.combatUnit = combatUnit;
        this.appearTime = appearTime;
    }

    @Override
    public int compareTo(StageUnit o) {
        return appearTime-o.appearTime;
    }
}
