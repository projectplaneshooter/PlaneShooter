package PlaneShooter.Helper;

import java.awt.*;

/**
 * 所有需要进行碰撞监测的战斗单位都应当实现这个接口。
 * 通过这个接口提供的信息来进行碰撞监测以及处理碰撞后的操作。
 */
public interface ICollidable {
    Point getPos();
    int getPower();
    void onCollide(ICollidable object);
    int getSize();//shape,Avoid over detection
    Polygon getContour();
    CollideType getCollideType();
}
