package PlaneShooter;

import PlaneShooter.GUI.AnotherPanel;
import PlaneShooter.GUI.MainFrame;
import PlaneShooter.GUI.StartPanel;

import javax.swing.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        System.out.println("hello world! testing");

        MainFrame mainFrame=new MainFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame.init();
            }
        });
    }
}
