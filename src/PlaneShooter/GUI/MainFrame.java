package PlaneShooter.GUI;

import PlaneShooter.Helper.KeyHelper;
import PlaneShooter.Helper.ProfileHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class MainFrame extends JFrame{
    StartPanel startPanel;
    ResultPanel resultPanel;
    GamePanel gamePanel;
    PlaneDesignerPanel planeDesignerPanel;
    public MainFrame() throws HeadlessException {
        super("PlaneShooter");
        setPreferredSize(new Dimension(1020,655));
        startPanel=new StartPanel(this);
        resultPanel =new ResultPanel(this);
        gamePanel=new GamePanel(this);
        planeDesignerPanel=new PlaneDesignerPanel(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyHelper.init();
        setResizable(false);
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
