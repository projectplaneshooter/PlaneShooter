package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JLabel labelHeader=new JLabel("Plane Shooter");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
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
    }

}
