package PlaneShooter.Combat;

import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.CollisionHelper;
import PlaneShooter.Plane.Plane;

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
    private Rectangle combatArea;
    public Point PlanePosition = new Point();
    private Stage stage;

    public Combat(Rectangle area) {
        combatArea=new Rectangle(area);
    }

    public Rectangle getCombatArea() {
        return combatArea;
    }

    public void paintCombat(Graphics g){
        g.drawRect(combatArea.x,combatArea.y,combatArea.width,combatArea.height);
        Graphics gn=g.create(combatArea.x,combatArea.y,combatArea.width,combatArea.height);
        gn.drawRect(0,0,combatArea.width,combatArea.height);
        for (ICombatUnit unit: combatUnits) {
            unit.paintUnit(gn,this);
        }
    }

    public void addCombatUnit(ICombatUnit unit){
        combatUnitsAdd.add(unit);
    }

    public void updateCombat(){
        worldTick++;
        if(stage!=null)stage.processCombat(this);
        combatUnits.addAll(combatUnitsAdd);
        combatUnitsAdd.clear();
        for (ICombatUnit unit: combatUnits) {
            unit.updateUnit(this);
            if (unit.getCollideType()==CollideType.PLANE) PlanePosition=unit.getPos();
//            if (unit.getCollideType()==CollideType.PLANE)
//                System.out.println("plane pos = "+unit.getPos());
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean canEndCombat(){
        if(combatUnitsAdd!=null)return false;
        if(!stage.isEmpty())return false;
        boolean yy=true;
        for(ICombatUnit combatUnit: combatUnits){
            //todo finish enemy check
        }
        return yy;
    }
}
