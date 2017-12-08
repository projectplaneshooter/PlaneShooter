package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class MainFrame extends JFrame{
    public MainFrame() throws HeadlessException {
        super("PlaneShooter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void showPanel(JPanel panel){
        setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }

}
