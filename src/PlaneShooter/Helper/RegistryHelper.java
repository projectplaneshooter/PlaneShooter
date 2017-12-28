package PlaneShooter.Helper;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Body.TriangleBodyL;
import PlaneShooter.Plane.Body.TriangleBodyR;
import PlaneShooter.Plane.Weapon.Cannon;
import PlaneShooter.Plane.Weapon.CannonMk2;
import PlaneShooter.Plane.Weapon.CannonSpray;

import java.util.ArrayList;

/**
 * 每一个需要加入到编辑器中的元件都应该在这个类中进行注册。
 */
public class RegistryHelper {
    private static ArrayList<Class> planePartClasses =new ArrayList<>();

    public static void registerClass(Class planePartClass){
        if (ICombatUnit.class.isAssignableFrom(planePartClass)) planePartClasses.add(planePartClass);
    }

    public static ArrayList<Class> getPlanePartClasses() {
        return planePartClasses;
    }

    public static void initRegistry(){
        registerClass(RectangleBody.class);
        registerClass(Cannon.class);
        registerClass(TriangleBodyL.class);
        registerClass(TriangleBodyR.class);
        registerClass(CannonMk2.class);
        registerClass(CannonSpray.class);
    }
}
