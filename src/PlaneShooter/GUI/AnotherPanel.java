package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;


/**
 * Created by yuyuyzl on 2017/12/9.
 */
public class AnotherPanel extends JPanel{
    MainFrame mf;
    JLabel labelHeader;

    public AnotherPanel(MainFrame mf) {
        super();
        this.mf=mf;
        setPreferredSize(new Dimension(1000,600));
        labelHeader=new JLabel("Another Panel");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);


    }
}
