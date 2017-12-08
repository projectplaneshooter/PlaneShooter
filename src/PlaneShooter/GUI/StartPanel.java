package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class StartPanel extends JPanel{
    public StartPanel() {
        super();
        setPreferredSize(new Dimension(1000,600));
        JLabel labelHeader=new JLabel("Plane Shooter");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);
    }

}
