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
    public PlaneComponentLabel(ICombatUnit planePart){
        super();
        if(planePart instanceof PlanePart){
            super.setText(((PlanePart)planePart).getName());
        }
        this.planePart=planePart;
        setVerticalAlignment(SwingConstants.BOTTOM);
        setPreferredSize(new Dimension(100,100));
        setOpaque(true);
        setBackground(Color.lightGray);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        planePart.setPos(new Point(getPreferredSize().width/2,getPreferredSize().height/2));
        planePart.paintUnit(g,null);
    }


}
