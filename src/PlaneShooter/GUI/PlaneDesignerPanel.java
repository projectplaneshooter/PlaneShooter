package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.GUI.Component.PlaneComponentLabel;
import PlaneShooter.Helper.RegistryHelper;
import PlaneShooter.Plane.CustomizedPlane;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.PlanePart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yuyuyzl on 2017/12/14.
 */

public class PlaneDesignerPanel extends JPanel {
    MainFrame mf;
    JLabel labelHeader;
    JButton btnSwitch;
    PlanePart unitSelected=null;
    Combat combat=new Combat(new Rectangle(600,300,200,200));

    CustomizedPlane plane;
    Timer timer=new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(unitSelected!=null){
                Point mousePos=getMousePosition();
                if(mousePos!=null)unitSelected.setPos(mousePos);
            }
            combat.updateCombat();
            repaint();
        }
    });

    public PlaneDesignerPanel(MainFrame mf) {
        super();
        this.mf=mf;
        labelHeader=new JLabel("Plane Designer");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);
        btnSwitch=new JButton("Back");
        btnSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.showPanel(mf.startPanel);
            }
        });
        add(btnSwitch);

        //PlaneComponentLabel labelComponent=new PlaneComponentLabel(new RectangleBody(new Point(0,0),null));
        //add(labelComponent);
        //timer.start();

        for(Class clazz : RegistryHelper.getPlanePartClasses()){
            try {
                PlaneComponentLabel labelComponent=new PlaneComponentLabel((ICombatUnit)clazz.newInstance());
                labelComponent.setMouseClickAction(() -> {
                    try {
                        unitSelected = (PlanePart) clazz.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                add(labelComponent);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getButton());
                switch (e.getButton()){
                    case MouseEvent.BUTTON1:
                        if(unitSelected!=null){
                            if(combat.getCombatArea().contains(e.getPoint())){
                                Point posOnPlane=new Point(e.getPoint());
                                posOnPlane.translate(-combat.getCombatArea().x,-combat.getCombatArea().y);
                                unitSelected.setPos(posOnPlane);
                                plane.addComponent(unitSelected);
                                unitSelected=null;
                            }
                        }
                        break;
                    case MouseEvent.BUTTON3:
                        unitSelected=null;
                        break;
                }
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
        plane=new CustomizedPlane(new Point(combat.getCombatArea().width/2,combat.getCombatArea().height/2));
        combat.addCombatUnit(plane);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(unitSelected!=null && getMousePosition()!=null)unitSelected.paintUnit(g,null);
        combat.paintCombat(g);
    }

    public Plane getResult() {
        return plane;
    }
}
