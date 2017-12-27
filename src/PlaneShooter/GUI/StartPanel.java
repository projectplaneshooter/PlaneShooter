package PlaneShooter.GUI;

import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Helper.ResourceHelper;

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
    //JButton btnStart;
    //JButton btnDesigner;
    public StartPanel(MainFrame mf) {
        super();
        this.mf=mf;
        this.setLayout(new GridLayout(5, 1, 10, 10));
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
        //p.setBackground(null);
        //p.setOpaque(false);

        //JLabel lbl_Start=new JLabel("start");
        JLabel lbl_Blank01=new JLabel("   ");
        add(lbl_Blank01);

        JLabel lbl_Blank02=new JLabel("   ");
        add(lbl_Blank02);


        JLabel lbl_Start=new JLabel(new ImageIcon("res/start.png"));
        lbl_Start.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mf.requestFocus();
                mf.showPanel(mf.gamePanel);
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
        JPanel pnl_Blank03=new JPanel();
        pnl_Blank03.setOpaque(false);
        pnl_Blank03.add(lbl_Start);
        add(pnl_Blank03);

        JLabel lbl_Design=new JLabel(new ImageIcon("res/design.png"));

        lbl_Design.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mf.requestFocus();
                mf.planeDesignerPanel.timer.start();
                mf.showPanel(mf.planeDesignerPanel);
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
        JPanel pnl_Blank04=new JPanel();
        pnl_Blank04.setOpaque(false);
        pnl_Blank04.add(lbl_Design);
        add(pnl_Blank04);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(KeyHelper.hasBackground())g.drawImage(ResourceHelper.main,0,0,getWidth(),getHeight(),null);

    }
}
