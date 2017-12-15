package PlaneShooter.Helper;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.IEnemy;
import PlaneShooter.Enemy.Weapon.BulletEnemy;
import PlaneShooter.Enemy.Weapon.IWeapon;
import PlaneShooter.Plane.IPlane;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.PlanePart;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class CollisionHelper {
    private static void checkCollision(IEnemy enemy,IPlane plane){
        if (enemy instanceof BulletEnemy) System.out.println("EnemyBullet");
        if (plane instanceof IWeapon) System.out.println("EnemyBullet");
        if (enemy.getPos().distance(plane.getPos())<=100){
            System.out.println("ATTACK enemy "+enemy.getPos()+" + "+plane.getPos());
            if (enemy instanceof IWeapon && plane instanceof Plane) {
                plane.getHurt(((IWeapon) enemy).getPower());
                enemy.getHurt(1);
            }else if (plane instanceof IWeapon){
                enemy.getHurt(((IWeapon) plane).getPower());
                plane.getHurt(1);
            }else{
                enemy.getHurt(1);
                plane.getHurt(1);
            }
        }
    }
    public static void updateCombat(ArrayList<ICombatUnit> combatUnits){
        ArrayList<IEnemy> enemyParts=new ArrayList<>();
        ArrayList<IPlane> planeParts=new ArrayList<>();
        for (ICombatUnit unit:combatUnits) {
            if (unit instanceof IEnemy) enemyParts.add((IEnemy) unit);
            else if (unit instanceof IPlane) planeParts.add((IPlane) unit);
        }
        for (IEnemy enemy:enemyParts) {
            for (IPlane plane : planeParts) {
                checkCollision(enemy, plane);
            }
        }
    }
}
