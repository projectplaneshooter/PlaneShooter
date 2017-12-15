package PlaneShooter.Helper;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public interface ICollidable {
    Point getPos();
    void getHurt(int value);
    int getPower();
    int getSize();//shape
    CollideType getCollideType();
}
