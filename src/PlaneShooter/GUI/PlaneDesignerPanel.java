package PlaneShooter.GUI;

import PlaneShooter.GUI.Component.PlaneComponentLabel;
import PlaneShooter.Plane.Body.RectangleBody;
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

        PlaneComponentLabel labelComponent=new PlaneComponentLabel(new RectangleBody(new Point(0,0),null));
    }

    public Plane getResult() {
        return result;
    }
}
