package PlaneShooter.GUI.Component;

import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.Plane.PlanePart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 这是一个封装好的用于展示飞机部件并且可以接收点击事件的JLabel。
 * 主要用于设计器中，实现了部件工具箱的自动化生成。
 */
public class PlaneComponentLabel extends JLabel {

    ICombatUnit planePart;
    Runnable onMouseClick=null;
    public PlaneComponentLabel(ICombatUnit planePart){
        super();
        if(planePart instanceof PlanePart){
            super.setText(((PlanePart)planePart).getName());
        }
        this.planePart=planePart;
        setVerticalAlignment(SwingConstants.BOTTOM);
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(100,100));
        setOpaque(true);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                onMouseClick.run();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        planePart.setPos(new Point(getPreferredSize().width/2,getPreferredSize().height/2));
        planePart.paintUnit(g,null);
    }

    public void setMouseClickAction(Runnable runnable){
        onMouseClick=runnable;
    }

}
