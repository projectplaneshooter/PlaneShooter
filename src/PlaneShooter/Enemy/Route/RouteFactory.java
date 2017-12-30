package PlaneShooter.Enemy.Route;

import PlaneShooter.Enemy.Enemy;

import java.awt.*;
import java.util.LinkedList;

public class RouteFactory {
    public static void turnAround(Enemy enemy, LinkedList<Route> routes){
        if (routes==null||routes.size()==0) return;
        Route firstRoute=routes.getFirst();
        if (firstRoute.startTime == firstRoute.nowTime) {
            firstRoute.angle = enemy.getSpeed().distance(new Point(0,0)) / firstRoute.radius;
            firstRoute.centerPos = firstRoute.getCenter(enemy.getPos());
            if (firstRoute.endTime == -1)
                firstRoute.endTime = (int) (0.5 + firstRoute.startTime + Math.PI / 2 / firstRoute.angle);
            else
                firstRoute.endTime = Math.min(firstRoute.endTime, (int) (0.5 + firstRoute.startTime + Math.PI / 2 / firstRoute.angle));
            enemy.setSpeed(new Point(0, 0));
        }
        if (firstRoute.startTime <= firstRoute.nowTime){
            enemy.setPos(firstRoute.getNextPos());
            if (firstRoute.nowTime == firstRoute.endTime){
                enemy.setSpeed(firstRoute.getNextSpeed());
                routes.removeFirst();
            }
        }
        firstRoute.nowTime++;
//        System.out.println("checking "+firstRoute + "  angle="+firstRoute.angle + "  center-pos="+firstRoute.centerPos);
//        System.out.println("checking  start="+firstRoute.startTime + " now="+firstRoute.nowTime + "   end="+firstRoute.endTime);
//        System.out.println("enemy_pos:"+enemy.getPos()+ "  way:"+firstRoute.species);
    }
}
