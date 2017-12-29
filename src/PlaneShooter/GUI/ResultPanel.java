package PlaneShooter.GUI;

import PlaneShooter.Combat.CombatStat;
import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Helper.ProfileHelper;
import PlaneShooter.Helper.ResourceHelper;

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
    JLabel lblStat;
    JButton btnSwitch;
    public ResultPanel(MainFrame mf) {
        super();
        this.mf=mf;
        this.setLayout(null);
        JLabel lbl_Blank01=new JLabel("   ");
        add(lbl_Blank01);

        JPanel p = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("res/result.jpg");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, 1000, 600, icon.getImageObserver());
            }
        };
        labelHeader=new JLabel("Another Panel");
        labelHeader.setLocation(400,50);
        labelHeader.setSize(300, 100);
        labelHeader.setFont(new Font(null,0,42));
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
        lblStat=new JLabel();
        lblStat.setFont(new Font(null,0,20));
        lblStat.setForeground(Color.white);
        lblStat.setSize(400,400);
        lblStat.setLocation(300,150);
        add(lblStat);

        lbl_Back.setLocation(400,500);
        lbl_Back.setSize(lbl_Back.getPreferredSize());
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
        String str="<html>";
        if(combatStat.endStat==1){
            str+="Stage Clear: +300 cr<br>";
        }
        else {
            str+="Failed: +10 cr<br>";
        }
        str+="Bullet count: "+combatStat.bulletCount;
        str+="<br>";
        str+="Damage done: "+ combatStat.damageDone+"  …………  +"+combatStat.damageDone/10+" cr";
        str+="<br>";
        str+="Damage taken: "+ combatStat.damageTaken+"  …………  -"+combatStat.damageTaken/10+" cr";
        str+="<br>";
        str+="Your credit: "+ ProfileHelper.getCredits()+" cr";
        str+="<br>";
        if(combatStat.endStat==1){
            str+="Difficulty level +1, now "+ProfileHelper.getDLevel()+"<br>";
        }
        else {
            str+="Difficulty level -2, now "+ProfileHelper.getDLevel()+"<br>";
        }
        str+="</html>";
        System.out.println(combatStat);
        lblStat.setText(str);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(KeyHelper.hasBackground())g.drawImage(ResourceHelper.result,0,0,getWidth(),getHeight(),null);

    }
}
