package PlaneShooter.Helper;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Enemy.Enemy;
import PlaneShooter.Plane.Plane;

import java.awt.geom.Area;
import java.util.ArrayList;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class CollisionHelper {
    private static boolean checkCollision(ICollidable enemy,ICollidable plane){
//        if (enemy.getCollideType()==CollideType.ENEMYBULLET) System.out.println("EnemyBullet");
//        if (plane.getCollideType()==CollideType.PLANEBULLET) System.out.println("PlaneBullet");
        if (enemy.getPos().distance(plane.getPos())<=enemy.getSize()+plane.getSize()){
            Area area=new Area(enemy.getContour());
            area.intersect(new Area(plane.getContour()));
            return !area.isEmpty();
        }
        return false;
    }
    public static void updateCombat(ArrayList<ICombatUnit> combatUnits,Combat combat){

        ArrayList<ICollidable> enemyParts=new ArrayList<>();
        ArrayList<ICollidable> planeParts=new ArrayList<>();
        for (ICombatUnit Unit:combatUnits)
            if (Unit instanceof ICollidable){
                ICollidable unit=(ICollidable) Unit;
                switch (unit.getCollideType()){
                    case ENEMY:
                        enemyParts.add(unit);
                        enemyParts.addAll(((Enemy)unit).getComponents());//实现不同
                        break;
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
                if(checkCollision(enemy, plane)){
                    enemy.onCollide(plane, combat);
                    plane.onCollide(enemy, combat);
                }
            }
        }
    }
}
