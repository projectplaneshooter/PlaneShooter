package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.DefaultStage;
import PlaneShooter.Enemy.Tank;
import PlaneShooter.Enemy.TestEnemy;
import PlaneShooter.Helper.FileHelper;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.TestPlane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 这是实际进行游戏时展示的JPanel。
 * 它持有一个Timer，用于进行（多线程的）Combat的更新操作。
 */
public class GamePanel extends JPanel{
    MainFrame mf;
    JLabel labelHeader;
    JButton btnStart;
    JButton btnBack;
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
                //combat.addCombatUnit(new TestEnemy(new Point(300,100),new Point(1,0),200));
                //combat.addCombatUnit(new TestEnemy(new Point(500,100),new Point(-1,0),200));
                //combat.addCombatUnit(new Tank(new Point(500,50),new Point(0,1),500));
                combat.setStage(DefaultStage.get(1));

                Plane plane= FileHelper.importPlane("PlaneFromDesigner.sav");
                if(plane==null) plane=new TestPlane(new Point(500,500));else {
                    plane.setPos(new Point(500,500));
                }
                combat.addCombatUnit(plane);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        timer.start();
                    }
                });
            }
        });
        add(btnStart);

        btnBack=new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                combat=null;
                timer.stop();
                mf.showPanel(mf.startPanel);
            }
        });
        add(btnBack);
    }
}
