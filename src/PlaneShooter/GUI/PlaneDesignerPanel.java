package PlaneShooter.GUI;

import PlaneShooter.Plane.Plane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yuyuyzl on 2017/12/14.
 */
public class PlaneDesignerPanel extends JPanel {
    MainFrame mf;
    JLabel labelHeader;
    JButton btnSwitch;
    Plane result;
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
    }

    public Plane getResult() {
        return result;
    }
}
