package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class MainFrame extends JFrame{
    StartPanel startPanel;
    AnotherPanel anotherPanel;
    public MainFrame() throws HeadlessException {
        super("PlaneShooter");
        setPreferredSize(new Dimension(1000,600));
        startPanel=new StartPanel(this);
        anotherPanel=new AnotherPanel(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public void showPanel(JPanel panel){
        setContentPane(panel);
        this.setVisible(true);
    }

    public void init(){
        this.showPanel(startPanel);
    }
}
