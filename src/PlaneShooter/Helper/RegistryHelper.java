package PlaneShooter.Helper;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.Body.IBody;
import PlaneShooter.Plane.Weapon.IWeapon;

import java.util.ArrayList;

public class RegistryHelper {
    private static ArrayList<Class<ICombatUnit>> combatUnitClasses=new ArrayList<>();
    private static ArrayList<Class<IBody>> bodyClasses=new ArrayList<>();
    private static ArrayList<Class<IWeapon>> weaponClasses=new ArrayList<>();

    public static void registerClass(Class<ICombatUnit> combatUnitClass){
        combatUnitClasses.add(combatUnitClass);
    }

}
