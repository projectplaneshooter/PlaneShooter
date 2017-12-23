package PlaneShooter.Helper;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Enemy.EnemyPart;
import PlaneShooter.Plane.Plane;

import java.util.ArrayList;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class CollisionHelper {
    private static void checkCollision(ICollidable enemy,ICollidable plane){
//        if (enemy.getCollideType()==CollideType.ENEMYBULLET) System.out.println("EnemyBullet");
//        if (plane.getCollideType()==CollideType.PLANEBULLET) System.out.println("PlaneBullet");
        if (enemy.getPos().distance(plane.getPos())<=enemy.getSize()+plane.getSize()){
//            System.out.println("ATTACK enemy "+enemy.getPos()+" + "+plane.getPos());
            enemy.onCollide(plane);
            plane.onCollide(enemy);
        }
    }
    public static void updateCombat(ArrayList<ICombatUnit> combatUnits){
        ArrayList<ICollidable> enemyParts=new ArrayList<>();
        ArrayList<ICollidable> planeParts=new ArrayList<>();
        for (ICombatUnit Unit:combatUnits)
            if (Unit instanceof ICollidable){
                ICollidable unit=(ICollidable) Unit;
                switch (unit.getCollideType()){
                    case ENEMY:
                        enemyParts.addAll(((Enemy)unit).getComponents());//实现不同
                    case ENEMYBULLET:
                        enemyParts.add(unit);
                        break;
                    case PLANE:
                        planeParts.addAll(((Plane)unit).getComponents());//实现不同
                        break;
                    case PLANEPART:
                    case PLANEBULLET:
                        planeParts.add(unit);
                }
        }
        //System.out.println("THIS SIZE : "+enemyParts.size()+"  "+planeParts.size());
        for (ICollidable enemy:enemyParts) {
            for (ICollidable plane : planeParts) {
                checkCollision(enemy, plane);
            }
        }
    }
}
