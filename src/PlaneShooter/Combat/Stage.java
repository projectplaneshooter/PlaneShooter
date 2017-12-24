package PlaneShooter.Combat;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 这是关卡配置的抽象，主要保存了一系列敌人&出现时间的组合，并提供了一些方法来更新Combat并维护队列。
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

    /**
     * 这个方法会自动把应该添加到Combat但没有加进去的单位加到传入的Combat中。
     * @param combat
     */
    public void processCombat(Combat combat){

        while(!units.isEmpty()&&combat.getWorldTick()>=(units.peek().appearTime+tickZero)){
            combat.addCombatUnit(units.peek().combatUnit);
            units.remove();
        }
    }

    /**
     * 这个方法用于解决一些情况，
     * 例如需要把两个Stage接起来玩，你可能就需要把第二个Stage的起始时间设置成第一个Stage的结束时间。
     * @param tickZero
     * @return
     */
    public Stage setTickZero(int tickZero){
        this.tickZero=tickZero;
        return this;
    }

    public boolean isEmpty(){
        return units.isEmpty();
    }
}
