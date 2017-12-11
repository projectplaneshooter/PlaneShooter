package PlaneShooter.Combat;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public interface ICombatUnit {
    Point pos=new Point();
    void paintUnit(Graphics g);
    void updateUnit(Combat combat);
}
