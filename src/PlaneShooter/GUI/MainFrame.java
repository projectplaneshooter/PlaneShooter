package PlaneShooter.GUI;

import PlaneShooter.Helper.KeyHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class MainFrame extends JFrame{
    StartPanel startPanel;
    AnotherPanel anotherPanel;
    GamePanel gamePanel;
    PlaneDesignerPanel planeDesignerPanel;
    public MainFrame() throws HeadlessException {
        super("PlaneShooter");
        setPreferredSize(new Dimension(1000,700));
        startPanel=new StartPanel(this);
        anotherPanel=new AnotherPanel(this);
        gamePanel=new GamePanel(this);
        planeDesignerPanel=new PlaneDesignerPanel(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyHelper.init();
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
