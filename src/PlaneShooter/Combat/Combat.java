package PlaneShooter.Combat;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class Combat{

    private boolean stillAlive=true;
    private ArrayList<ICombatUnit> combatUnits=new ArrayList<>();

    public void paintCombat(Graphics g){
        for (ICombatUnit unit: combatUnits) {
            unit.paintUnit(g);
        }
    }

    public void addCombatUnit(ICombatUnit unit){
        combatUnits.add(unit);
    }

    public void updateCombat(){
        for (ICombatUnit unit: combatUnits) {
            unit.updateUnit(this);
        }
    }

    public void endCombat(){
        stillAlive=false;
    }

    public boolean isCombatAlive(){
        return stillAlive;
    }

}
