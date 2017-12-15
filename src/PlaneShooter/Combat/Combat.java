package PlaneShooter.Combat;

import PlaneShooter.Helper.CollisionHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class Combat{

    private boolean stillAlive=true;
    private ArrayList<ICombatUnit> combatUnits=new ArrayList<>();
    private ArrayList<ICombatUnit> combatUnitsAdd=new ArrayList<>();
    private long worldTick=0;

    public void paintCombat(Graphics g){
        for (ICombatUnit unit: combatUnits) {
            unit.paintUnit(g,this);
        }
    }

    public void addCombatUnit(ICombatUnit unit){
        combatUnitsAdd.add(unit);
    }

    public void updateCombat(){
        worldTick++;
        combatUnits.addAll(combatUnitsAdd);
        combatUnitsAdd.clear();
        for (ICombatUnit unit: combatUnits) {
            unit.updateUnit(this);
        }
        if (worldTick % 1 == 0) {
            CollisionHelper.updateCombat(combatUnits);
        }
        Predicate<ICombatUnit> p=(u) -> !u.isAlive();
        combatUnits.removeIf(p);
    }

    public void endCombat(){
        stillAlive=false;
    }

    public boolean isCombatAlive(){
        return stillAlive;
    }

    public long getWorldTick() {
        return worldTick;
    }
}
