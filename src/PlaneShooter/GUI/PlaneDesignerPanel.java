package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.GUI.Component.PlaneComponentLabel;
import PlaneShooter.Helper.RegistryHelper;
import PlaneShooter.Plane.Body.RectangleBody;
import PlaneShooter.Plane.Plane;

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
    Plane result;
    ICombatUnit unitSelected=null;
    Timer timer=new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(unitSelected!=null){
                Point mousePos=getMousePosition();
                if(mousePos!=null)unitSelected.setPos(mousePos);
            }
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

        for(Class clazz : RegistryHelper.getCombatUnitClasses()){
            try {
                PlaneComponentLabel labelComponent=new PlaneComponentLabel((ICombatUnit)clazz.newInstance());
                labelComponent.setMouseClickAction(() -> {
                    try {
                        unitSelected = (ICombatUnit) clazz.newInstance();
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

        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(unitSelected!=null && getMousePosition()!=null)unitSelected.paintUnit(g,null);
    }

    public Plane getResult() {
        return result;
    }
}
