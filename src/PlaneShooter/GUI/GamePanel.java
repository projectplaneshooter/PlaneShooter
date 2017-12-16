package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Tank;
import PlaneShooter.Enemy.TestEnemy;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.TestPlane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class GamePanel extends JPanel{
    MainFrame mf;
    JLabel labelHeader;
    JButton btnStart;
    Combat combat;
    Timer timer=new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(combat.isCombatAlive()){
                combat.updateCombat();
            }else timer.stop();
            repaint();
        }
    });

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(combat!=null)combat.paintCombat(g);
    }

    public GamePanel(MainFrame mf) {
        super();
        this.mf=mf;
        setBackground(Color.WHITE);
        btnStart =new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combat=new Combat(new Rectangle(0,100,1000,600));
                combat.addCombatUnit(new TestEnemy(new Point(300,100),new Point(1,0),200));
                combat.addCombatUnit(new TestEnemy(new Point(500,100),new Point(-1,0),200));
                combat.addCombatUnit(new Tank(new Point(500,50),new Point(0,1),500));
                Plane testPlane=new TestPlane(new Point(500,500));
                combat.addCombatUnit(testPlane);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        timer.start();
                    }
                });
            }
        });
        add(btnStart);
    }
}
