package PlaneShooter.Helper;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.Body.IBody;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Weapon.Cannon;
import PlaneShooter.Plane.Weapon.IWeapon;

import java.util.ArrayList;

public class RegistryHelper {
    private static ArrayList<Class> combatUnitClasses=new ArrayList<>();

    public static void registerClass(Class combatUnitClass){
        if (ICombatUnit.class.isAssignableFrom(combatUnitClass)) combatUnitClasses.add(combatUnitClass);
    }

    public static ArrayList<Class> getCombatUnitClasses() {
        return combatUnitClasses;
    }

    public static void initRegistry(){
        registerClass(RectangleBody.class);
        registerClass(Cannon.class);
    }
}
