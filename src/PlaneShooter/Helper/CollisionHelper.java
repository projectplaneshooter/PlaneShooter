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

import javax.smartcardio.CommandAPDU;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class CollisionHelper {
    private static void checkCollision(ICollidable enemy,ICollidable plane){
        if (enemy.getCollideType()==CollideType.ENEMYBULLET) System.out.println("EnemyBullet");
        if (plane.getCollideType()==CollideType.PLANEBULLET) System.out.println("PlaneBullet");
        if (enemy.getPos().distance(plane.getPos())<=enemy.getSize()+plane.getSize()){
            System.out.println("ATTACK enemy "+enemy.getPos()+" + "+plane.getPos());
            enemy.onCollide(plane);
            plane.onCollide(enemy);
        }
    }
    public static void updateCombat(ArrayList<ICombatUnit> combatUnits){
        ArrayList<ICollidable> enemyParts=new ArrayList<>();
        ArrayList<ICollidable> planeParts=new ArrayList<>();
        for (ICollidable unit:combatUnits) {
            switch (unit.getCollideType()){
                case ENEMY:
                case ENEMYBULLET:
                    enemyParts.add(unit);
                    break;
                case PLANE:
                case PLANEBULLET:
                    planeParts.add(unit);
            }
        }
        for (ICollidable enemy:enemyParts) {
            for (ICollidable plane : planeParts) {
                checkCollision(enemy, plane);
            }
        }
    }
}
