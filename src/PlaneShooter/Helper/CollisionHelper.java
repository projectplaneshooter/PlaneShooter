package PlaneShooter.Helper;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Enemy.Weapon.BulletEnemy;
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
    private static void checkCollision(EnemyPart enemy,PlanePart plane){
        System.out.println("ATTACK");
        if (enemy.getPos().distance(plane.getPos())<=100){
            if (enemy instanceof BulletEnemy) {
                plane.getHurt(((BulletEnemy) enemy).getPower());
                ((BulletEnemy) enemy).getHurt(1);
            }
        }
    }
    public static void updateCombat(ArrayList<ICombatUnit> combatUnits){
        ArrayList<EnemyPart> enemyParts=new ArrayList<>();
        ArrayList<PlanePart> planeParts=new ArrayList<>();
        for (ICombatUnit unit:combatUnits) {
            if (unit instanceof EnemyPart) enemyParts.add((EnemyPart) unit);
            else if (unit instanceof PlanePart) planeParts.add((PlanePart) unit);
        }
        for (EnemyPart enemy:enemyParts) {
            for (PlanePart plane : planeParts) {
                checkCollision(enemy, plane);
            }
        }
    }
}
