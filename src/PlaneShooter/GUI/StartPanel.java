package PlaneShooter.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yuyuyzl on 2017/12/8.
 * 改变成两个panel，原因是我想保存下来这个panel的
 */
public class StartPanel extends JPanel{
    public StartPanel(MainFrame mainFrame,GamePanel gamePanel) {
        super();
//        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600,800));
        JLabel labelHeader=new JLabel("Plane Shooter");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);
        JButton startButton=new JButton("click to start");
        startButton.setPreferredSize(new Dimension(200,50));
//        Dimension thisSize=this.getSize();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension thisSize=new Dimension(600,800);
                System.out.println("start");
                System.out.println(thisSize);
                gamePanel.setPreferredSize(thisSize);
                mainFrame.showPanel(gamePanel);
            }
        });
        add(startButton);
    }
}
