package PlaneShooter.Helper;

import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public interface ICollidable {
    Point getPos();
    int getPower();
    void onCollide(ICollidable object);
    int getSize();//shape
    CollideType getCollideType();
}
