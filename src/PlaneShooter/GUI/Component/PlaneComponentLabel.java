package PlaneShooter.GUI.Component;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.PlanePart;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/15.
 */
public class PlaneComponentLabel extends JLabel {

    ICombatUnit planePart;
    public PlaneComponentLabel(PlanePart planePart){
        this.planePart=planePart;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        planePart.setPos(this.getLocation());
        planePart.paintUnit(g,null);
    }
}
