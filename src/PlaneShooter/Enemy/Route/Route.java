package PlaneShooter.Enemy.Route;

import java.awt.*;

/**
 * startTime是相对时间(即按照加入时间为0开始计算)
 * startTime不是时间轴，是两个事件之间的相对时间
 * endTime是结束时间，即达到结束时间就这个route就停了，方向为四分之一圆弧之后的方向
 * 没有endTime会默认画满圆弧
 */
public class Route {
    public Route(int radius, int startTime, RouteSpecies species) {
        this.radius = radius;
        this.startTime = Math.max(0,startTime);
        this.endTime = -1;
        this.species = species;
        this.nowTime = 0;
    }
    public Route(int radius, int startTime, int endTime, RouteSpecies species) {
        this.radius = radius;
        this.startTime = Math.max(0,startTime);
        this.endTime = Math.max(startTime, endTime);
        this.species = species;
        this.nowTime = 0;
    }
    int startTime,endTime,nowTime;
    int radius;
    double angle;
    Point centerPos;
    RouteSpecies species;

    public Route(Route route) {
        this(route.radius,route.startTime,route.endTime,route.species);
    }

    public Point getCenter(Point enemyPos){
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
    public Point getNextPos(){
        Point nextPos=new Point(centerPos);
        int SIN = (int) (0.5 + radius * Math.sin(angle*(nowTime-startTime)));
        int COS = (int) (0.5 + radius * Math.cos(angle*(nowTime-startTime)));
        switch (species){
            case DRARC:
                nextPos.translate(-COS,SIN);
                return nextPos;
            case DLARC:
                nextPos.translate(COS,SIN);
                return nextPos;
            case URARC:
                nextPos.translate(-COS,-SIN);
                return nextPos;
            case ULARC:
                nextPos.translate(COS,-SIN);
                return nextPos;
            case RUARC:
                nextPos.translate(SIN,COS);
                return nextPos;
            case RDARC:
                nextPos.translate(SIN,-COS);
                return nextPos;
            case LUARC:
                nextPos.translate(-SIN,COS);
                return nextPos;
            case LDARC:
                nextPos.translate(-SIN,-COS);
                return nextPos;
        }
//        System.out.println("nowAngle="+route.radius * Math.sin(route.angle*(route.nowTime-route.startTime)));
        return nextPos;
    }
    public Point getNextSpeed(){
        switch (species){
            case LUARC:
            case RUARC:
                return new Point(0,(int)(-0.5 - angle * radius));
            case LDARC:
            case RDARC:
                return new Point(0,(int)(0.5 + angle * radius));
            case DLARC:
            case ULARC:
                return new Point((int)(-0.5 - angle * radius),0);
            case DRARC:
            case URARC:
                return new Point((int)(0.5 + angle * radius),0);
        }
        return null;
    }
}
