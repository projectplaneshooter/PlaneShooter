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
        JPanel p = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("res/main.jpg");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, 1000, 600, icon.getImageObserver());
            }
        };
        //p.setBackground(null);
        //p.setOpaque(false);

        //JLabel lbl_Start=new JLabel("start");
        JLabel lbl_Start=new JLabel(new ImageIcon("res/start.png"));
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
        lbl_Start.add(p);

        JLabel lbl_Design=new JLabel(new ImageIcon("res/design.png"));

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
        lbl_Design.add(p);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(KeyHelper.hasBackground())g.drawImage(ResourceHelper.main,0,0,1000,600,null);
        repaint();
    }
}
