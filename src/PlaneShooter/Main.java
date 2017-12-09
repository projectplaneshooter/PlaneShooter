package PlaneShooter;

import PlaneShooter.GUI.GamePanel;
import PlaneShooter.GUI.MainFrame;
import PlaneShooter.GUI.StartPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        System.out.println("hello world!");

        MainFrame mainFrame=new MainFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame=new MainFrame();
                GamePanel gamePanel=new GamePanel(mainFrame);
                mainFrame.showPanel(new StartPanel(mainFrame,gamePanel));
            }
        });
    }
}
