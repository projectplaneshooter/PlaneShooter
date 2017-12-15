package PlaneShooter.Combat;

import PlaneShooter.Helper.ICollidable;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public interface ICombatUnit extends ICollidable{
    boolean isAlive();
    void setPos(Point pos);
    Point getPos();
    void paintUnit(Graphics g, Combat combat);
    void updateUnit(Combat combat);
}
