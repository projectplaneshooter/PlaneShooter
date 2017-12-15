package PlaneShooter.Enemy;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.ICollidable;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public interface IEnemy extends ICombatUnit,ICollidable{
    void setSpeed(Point speed);
//    void setAcceleration(Point acceleration);
//    void setAngle(Point angle);//设计角度，转弯的时候加速度可算
}
