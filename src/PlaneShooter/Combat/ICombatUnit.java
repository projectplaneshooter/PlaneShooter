package PlaneShooter.Combat;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public interface ICombatUnit {
    boolean isAlive();
    void setPos(Point pos);
    Point getPos();
    void paintUnit(Graphics g,Combat combat);
    void updateUnit(Combat combat);
}
