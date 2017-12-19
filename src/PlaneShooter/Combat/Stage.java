package PlaneShooter.Combat;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by yuyuyzl on 2017/12/17.
 */
public class Stage {
    private PriorityQueue<StageUnit> units=new PriorityQueue<>();
    private int tickZero=0;

    public Stage(){}
    public Stage(Collection<StageUnit> units){
        this.units.addAll(units);
    }

    public void addStageUnit(StageUnit u){
        this.units.add(u);
    }

    public void processCombat(Combat combat){

        while(!units.isEmpty()&&combat.getWorldTick()>=(units.peek().appearTime+tickZero)){
            combat.addCombatUnit(units.peek().combatUnit);
            units.remove();
        }
    }

    public Stage setTickZero(int tickZero){
        this.tickZero=tickZero;
        return this;
    }

    public boolean isEmpty(){
        return units.isEmpty();
    }
}
