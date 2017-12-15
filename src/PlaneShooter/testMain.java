package PlaneShooter;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Helper.RegistryHelper;
import PlaneShooter.Plane.Body.IBody;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.TestPlane;
import PlaneShooter.Plane.Weapon.Cannon;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class testMain {
    public static void main(String[] args) {
        RegistryHelper.registerClass(Cannon.class);
        System.out.println(Cannon.class.isAssignableFrom(ICombatUnit.class));
        System.out.println(ICombatUnit.class.isAssignableFrom(Cannon.class));
    }
}
