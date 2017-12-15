package PlaneShooter.Helper;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.IEnemy;
import PlaneShooter.Enemy.Weapon.BulletEnemy;
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
//        if (enemy instanceof BulletEnemy) System.out.println();
        if (enemy.getPos().distance(plane.getPos())<=100){
//            System.out.println("ATTACK "+enemy.toString());
            if (enemy instanceof BulletEnemy) {
                plane.getHurt(((BulletEnemy) enemy).getPower());
                ((BulletEnemy) enemy).getHurt(1);
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
