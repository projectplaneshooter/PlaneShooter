package PlaneShooter.Enemy;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public interface IEnemy extends ICombatUnit{
    void setSpeed(Point speed);
}
