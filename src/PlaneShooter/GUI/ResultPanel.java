package PlaneShooter.GUI;

import PlaneShooter.Combat.CombatStat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by yuyuyzl on 2017/12/9.
 */
public class ResultPanel extends JPanel{
    MainFrame mf;
    JLabel labelHeader;
    JButton btnSwitch;
    public ResultPanel(MainFrame mf) {
        super();
        this.mf=mf;
        labelHeader=new JLabel("Another Panel");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);
        JLabel lbl_Back=new JLabel(new ImageIcon("res/back02.png"));

        lbl_Back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mf.showPanel(mf.startPanel);
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        add(lbl_Back);
    }

    public void showCombatStat(CombatStat combatStat){
        switch (combatStat.endStat){
            case 1:
                labelHeader.setText("You Win!!!");
                break;
            case 2:

                labelHeader.setText("You Lose...");
                break;
        }
    }
}
