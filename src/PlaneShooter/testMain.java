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
    static void doA(Integer n){
        n=n*3;
    }
    public static void main(String[] args) {
        Integer n=1;
        doA(n);
        System.out.println(n);
    }
}
