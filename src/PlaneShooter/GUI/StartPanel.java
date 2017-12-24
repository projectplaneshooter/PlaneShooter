package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class StartPanel extends JPanel{
    MainFrame mf;
    JButton btnStart;
    JButton btnDesigner;
    public StartPanel(MainFrame mf) {
        super();
        this.mf=mf;
/*
        JLabel labelHeader=new JLabel("Plane Shooter");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(null);
        add(labelHeader);
        btnStart =new JButton("Switch");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.showPanel(mf.gamePanel);
            }
        });

        btnDesigner =new JButton("Designer");
        btnDesigner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.showPanel(mf.planeDesignerPanel);
            }
        });


        add(btnStart);
        add(btnDesigner);
        //todo @ZST check this
*/

        JLabel lbl_Start=new JLabel("start");
        lbl_Start.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mf.showPanel(mf.gamePanel);
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
        add(lbl_Start);

        JLabel lbl_Design=new JLabel("design");
        lbl_Design.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mf.showPanel(mf.planeDesignerPanel);
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
        add(lbl_Design);


    }

}
