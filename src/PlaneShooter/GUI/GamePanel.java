package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Enemy.Tank;
import PlaneShooter.Plane.Body.TestBody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                combat=new Combat();
                /**
                 * 这里可能出错了
                 * paint多个unit只会输出一个
                 */
//                combat.addCombatUnit(new TestBody(new Point(100,100)));
                combat.addCombatUnit(new Tank(new Point(200,200)));
//                combat.addCombatUnit(new Tank(new Point(400,400)));
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
