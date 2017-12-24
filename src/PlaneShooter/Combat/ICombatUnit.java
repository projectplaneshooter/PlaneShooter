package PlaneShooter.Combat;

import PlaneShooter.Helper.ICollidable;

import java.awt.*;

/**
 * 这个接口作为所有可能出现在游戏中的单位（飞机 飞机零件 敌人 子弹 场景物体等）的抽象。
 */
public interface ICombatUnit{
    /**
     * 标记为不alive的元素会在Update后由Combat清除出列表。
     * @return
     */
    boolean isAlive();
    void setPos(Point pos);

    /**
     * 这个方法应当返回这个Unit在Combat上的位置。
     * 否则在绘制的时候会出现问题。
     * @return
     */
    Point getPos();

    /**
     * 通过这个方法把这个单位画在Graphics中。
     * @param g
     * @param combat
     */
    void paintUnit(Graphics g, Combat combat);

    /**
     * 通过这个方法和传入的combat来更新这个单位，例如发射子弹等操作应当写在这里。
     * @param combat
     */
    void updateUnit(Combat combat);
}
