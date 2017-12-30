package PlaneShooter.Combat;

import PlaneShooter.Enemy.Route.Route;
import PlaneShooter.Enemy.Route.RouteSpecies;
import PlaneShooter.Enemy.Tank;
import PlaneShooter.Enemy.TestEnemy;
import sun.awt.image.ImageWatched;

import java.awt.*;
import java.util.LinkedList;

/**
 * 这个类提供默认的关卡配置。
 */
public class DefaultStage {
    public static Stage get(int type,int level){
        Stage stage=new Stage();
        switch (type){
            case 1:
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(300,100),new Point(1,0),getEnemyHealth(200,level)),-1));
                LinkedList<Route> routes1 = new LinkedList<>();
                routes1.add(new Route(50,200, RouteSpecies.DLARC));
                routes1.add(new Route(50,50, RouteSpecies.LUARC));
                routes1.add(new Route(50,50, RouteSpecies.URARC));
                LinkedList<Route> routes2 = new LinkedList<>();
                routes2.add(new Route(50,200, RouteSpecies.DRARC));
                routes2.add(new Route(50,50, RouteSpecies.RUARC));
                routes2.add(new Route(50,50, RouteSpecies.ULARC));
                stage.addStageUnit(new StageUnit(new Tank(new Point(500,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes1),0));
                stage.addStageUnit(new StageUnit(new Tank(new Point(400,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes2),0));
                stage.addStageUnit(new StageUnit(new Tank(new Point(200,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes1),0));
                stage.addStageUnit(new StageUnit(new Tank(new Point(100,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes2),0));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(400,100),new Point(1,0),getEnemyHealth(200,level)),800));
                LinkedList<Route> routes3 = new LinkedList<>();
                routes3.add(new Route(100,100, RouteSpecies.DRARC));
                routes3.add(new Route(100,0, RouteSpecies.RUARC));
                routes3.add(new Route(100,0, RouteSpecies.ULARC));
                routes3.add(new Route(100,0, RouteSpecies.LDARC));
                routes3.add(new Route(100,0, RouteSpecies.DLARC));
                routes3.add(new Route(100,0, RouteSpecies.LUARC));
                routes3.add(new Route(100,0, RouteSpecies.URARC));
                routes3.add(new Route(100,0, RouteSpecies.RDARC));
                LinkedList<Route> routes4 = new LinkedList<>();
                routes4.add(new Route(100,100, RouteSpecies.DLARC));
                routes4.add(new Route(100,0, RouteSpecies.LUARC));
                routes4.add(new Route(100,0, RouteSpecies.URARC));
                routes4.add(new Route(100,0, RouteSpecies.RDARC));
                routes4.add(new Route(100,0, RouteSpecies.DRARC));
                routes4.add(new Route(100,0, RouteSpecies.RUARC));
                routes4.add(new Route(100,0, RouteSpecies.ULARC));
                routes4.add(new Route(100,0, RouteSpecies.LDARC));
                stage.addStageUnit(new StageUnit(new Tank(new Point(300,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes3),2000));
                stage.addStageUnit(new StageUnit(new Tank(new Point(300,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes4),2000));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(500,100),new Point(1,0),getEnemyHealth(200,level)),2000));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(100,100),new Point(1,0),getEnemyHealth(200,level)),2000));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(300,100),new Point(1,0),getEnemyHealth(200,level)),2000));
                //stage.addStageUnit(new StageUnit(new Tank(new Point(500,50),new Point(0,1),getEnemyHealth(200,level)),1000));
        }

        return stage;
    }
    public static int getEnemyHealth(int base,int level){
        return (int)Math.round(Math.pow(1.3,level)*base);
    }
}
