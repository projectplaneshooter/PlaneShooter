package PlaneShooter.Enemy.Route;

import java.awt.*;

/**
 * startTime是相对时间(即按照加入时间为0开始计算)
 */
public class Route {
    public Route(int radius, int startTime, RouteSpecies species) {
        this.radius = radius;
        this.startTime = Math.max(0,startTime);
        this.species = species;
        this.nowTime = 0;
    }
    int startTime,endTime,nowTime;
    int radius;
    double angle;
    Point centerPos;
    RouteSpecies species;
}
