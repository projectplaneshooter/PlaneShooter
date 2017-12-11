package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by yuyuyzl on 2017/12/9.
 */
public class AnotherPanel extends JPanel{
    MainFrame mf;
    JLabel labelHeader;
    JButton btnSwitch;
    public AnotherPanel(MainFrame mf) {
        super();
        this.mf=mf;
        labelHeader=new JLabel("Another Panel");
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
}
