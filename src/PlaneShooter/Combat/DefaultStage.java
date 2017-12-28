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
                LinkedList<Route> routes1 = new LinkedList<>();
                routes1.add(new Route(50,200, RouteSpecies.DLARC));
                routes1.add(new Route(50,0, RouteSpecies.LUARC));
                routes1.add(new Route(50,0, RouteSpecies.ULARC));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(300,100),new Point(1,0),getEnemyHealth(200,level)),-1));
                stage.addStageUnit(new StageUnit(new Tank(new Point(500,50),new Point(0,1),getEnemyHealth(200,level)).addRoute(routes1),0));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(400,100),new Point(1,0),getEnemyHealth(200,level)),800));
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
