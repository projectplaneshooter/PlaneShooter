package PlaneShooter;

import PlaneShooter.GUI.MainFrame;
import PlaneShooter.Helper.RegistryHelper;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;

/**
 * Created by yuyuyzl on 2017/12/8.
 */
public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            //e.printStackTrace();
        }

        RegistryHelper.initRegistry();

        MainFrame mainFrame=new MainFrame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame.init();
            }
        });
    }
}
