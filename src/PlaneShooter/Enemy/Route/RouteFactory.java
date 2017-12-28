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
            firstRoute.centerPos = getCenter(enemy.getPos(),firstRoute.radius ,firstRoute.species);
            firstRoute.endTime= (int) (0.5+firstRoute.startTime + Math.PI / 2 / firstRoute.angle);
            enemy.setSpeed(new Point(0, 0));
        }
        if (firstRoute.startTime <= firstRoute.nowTime){
            enemy.setPos(getNextPos(firstRoute));
            if (firstRoute.nowTime == firstRoute.endTime){
                enemy.setSpeed(getNextSpeed(firstRoute));
                routes.removeFirst();
            }
        }
//        System.out.println("checking "+firstRoute + "  angle="+firstRoute.angle + "  center-pos="+firstRoute.centerPos);
//        System.out.println("checking  start="+firstRoute.startTime + " now="+firstRoute.nowTime + "   end="+firstRoute.endTime);
//        System.out.println("enemy_pos:"+enemy.getPos());
        firstRoute.nowTime++;
    }
    static private Point getCenter(Point enemyPos,int radius,RouteSpecies species){
        Point center = new Point(enemyPos);
        switch (species){
            case LUARC:
            case RUARC:
                center.translate(0,-radius);
                return center;
            case LDARC:
            case RDARC:
                center.translate(0,radius);
                return center;
            case DLARC:
            case ULARC:
                center.translate(-radius,0);
                return center;
            case DRARC:
            case URARC:
                center.translate(radius,0);
                return center;
        }
        return center;
    }
    static Point getNextPos(Route route){
        // TODO: 2017/12/28 zlclll4 : finish the switch
        Point nextPos=new Point(route.centerPos);
        switch (route.species){
            case DRARC:
                nextPos.translate((int)(0.5 - route.radius * Math.cos(route.angle*(route.nowTime-route.startTime))),
                                  (int)(0.5 + route.radius * Math.sin(route.angle*(route.nowTime-route.startTime))));
                return nextPos;
            case DLARC:
                nextPos.translate((int)(0.5 + route.radius * Math.cos(route.angle*(route.nowTime-route.startTime))),
                                  (int)(0.5 + route.radius * Math.sin(route.angle*(route.nowTime-route.startTime))));
                return nextPos;
            case RUARC:
                nextPos.translate((int)(0.5 + route.radius * Math.sin(route.angle*(route.nowTime-route.startTime))),
                                  (int)(0.5 + route.radius * Math.cos(route.angle*(route.nowTime-route.startTime))));
                return nextPos;
        }
//        System.out.println("nowAngle="+route.radius * Math.sin(route.angle*(route.nowTime-route.startTime)));
        return nextPos;
    }
    static private Point getNextSpeed(Route route){
        switch (route.species){
            case LUARC:
            case RUARC:
                return new Point(0,(int)(-0.5 - route.angle * route.radius));
            case LDARC:
            case RDARC:
                return new Point(0,(int)(0.5 + route.angle * route.radius));
            case DLARC:
            case ULARC:
                return new Point((int)(-0.5 - route.angle * route.radius),0);
            case DRARC:
            case URARC:
                return new Point((int)(0.5 + route.angle * route.radius),0);
        }
        return null;
    }
}
