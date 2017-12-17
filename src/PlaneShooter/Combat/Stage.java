package PlaneShooter.Combat;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by yuyuyzl on 2017/12/17.
 */
public class Stage {
    private SortedSet<StageUnit> units=new TreeSet<>();

    public Stage(){}
    public Stage(Collection<StageUnit> units){
        this.units.addAll(units);
    }

    public void addStageUnit(StageUnit u){
        this.units.add(u);
    }

    public void processCombat(Combat combat){
        while(combat.getWorldTick()>=units.first().appearTime){
            combat.addCombatUnit(units.first().combatUnit);
            units.remove(units.first());
        }
    }
}
