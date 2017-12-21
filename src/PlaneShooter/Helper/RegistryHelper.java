package PlaneShooter.Helper;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;

import java.util.ArrayList;

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
    }
}
