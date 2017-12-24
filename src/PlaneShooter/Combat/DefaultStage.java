package PlaneShooter.Combat;

import PlaneShooter.Enemy.Tank;
import PlaneShooter.Enemy.TestEnemy;

import java.awt.*;

/**
 * 这个类提供默认的关卡配置。
 */
public class DefaultStage {
    public static Stage get(int number){
        Stage stage=new Stage();
        switch (number){
            case 1:
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(300,100),new Point(1,0),200),-1));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(400,100),new Point(1,0),200),800));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(500,100),new Point(1,0),200),2000));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(100,100),new Point(1,0),200),2000));
                stage.addStageUnit(new StageUnit(new TestEnemy(new Point(300,100),new Point(1,0),200),2000));
                stage.addStageUnit(new StageUnit(new Tank(new Point(500,50),new Point(0,1),500),5000));
        }

        return stage;
    }
}
