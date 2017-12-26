package PlaneShooter.Combat;

import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Helper.CollideType;
import PlaneShooter.Helper.CollisionHelper;
import PlaneShooter.Plane.Plane;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Combat是一整场游戏的抽象，也可以被视作游戏世界。
 * 由这个类的实例持有所有的战斗单位，并在uodateCombat方法中统一更新他们。
 * 同时，这个类还负责接收父窗体Graphics并绘制这场战斗到窗体中。
 */
public class Combat{

    private boolean stillAlive=true;
    private ArrayList<ICombatUnit> combatUnits=new ArrayList<>();
    private ArrayList<ICombatUnit> combatUnitsAdd=new ArrayList<>();
    private long worldTick=0;
    private Rectangle combatArea;
    public Point PlanePosition = new Point();
    private Stage stage;
    public CombatStat combatStat=new CombatStat();

    /**
     * 构造器中需要传入这场战斗相对于父窗体的位置以便之后进行Graphics的裁剪。
     * @param area
     */
    public Combat(Rectangle area) {
        combatArea=new Rectangle(area);
    }

    public Rectangle getCombatArea() {
        return combatArea;
    }

    public void paintCombat(Graphics g){
        g.setColor(Color.black);
        g.drawRect(combatArea.x,combatArea.y,combatArea.width,combatArea.height);
        Graphics gn=g.create(combatArea.x,combatArea.y,combatArea.width,combatArea.height);
        gn.drawRect(0,0,combatArea.width,combatArea.height);
        for (ICombatUnit unit: combatUnits) {
            unit.paintUnit(gn,this);
        }
    }

    /**
     * 这个方法把传入的Unit添加到战斗中。
     * 为了避免在遍历数组的时候往数组中添加元素，使用一个combatUnitsAdd列表作为缓冲。
     * @param unit
     */
    public void addCombatUnit(ICombatUnit unit){
        combatUnitsAdd.add(unit);
        if (unit instanceof Plane)
            PlanePosition=unit.getPos();
    }

    /**
     * 这个方法遍历并调用其持有的所有单位的updateUnit方法从而完成更新。
     */
    public void updateCombat(){
        worldTick++;
        if(stage!=null)stage.processCombat(this);
        combatUnits.addAll(combatUnitsAdd);
        combatUnitsAdd.clear();
        for (ICombatUnit unit: combatUnits) {
            unit.updateUnit(this);
        }
        if (worldTick % 1 == 0) {
            CollisionHelper.updateCombat(combatUnits,this);
        }
        combatUnits.addAll(combatUnitsAdd);
        combatUnitsAdd.clear();
        Predicate<ICombatUnit> p=(u) -> !u.isAlive();
        combatUnits.removeIf(p);
        if(stage!=null) {
            if (canEndCombat()) endCombat();
            else {
                if (hasNoEnemy() && (stage.getNextEnemyTime() - worldTick > 100)) {
                    worldTick = stage.getNextEnemyTime() - 100;
                }
            }
        }

    }

    public void endCombat(){
        stillAlive=false;
    }
    public void endCombat(int endStat){
        this.combatStat.endStat=endStat;
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
        //if(combatUnitsAdd!=null)return false;
        if(!stage.isEmpty())return false;
        boolean yy=hasNoEnemy();
        if(yy)combatStat.endStat=1;
        return yy;
    }

    private boolean hasNoEnemy(){
        boolean yy=true;

        for(ICombatUnit combatUnit: combatUnits){
            if(combatUnit instanceof Enemy || combatUnit instanceof EnemyPart){
                yy=false;
                //System.out.println(combatUnit.getClass().getName());
            }
        }
        return yy;
    }

    public int getEndStat() {
        return combatStat.endStat;
    }


}
