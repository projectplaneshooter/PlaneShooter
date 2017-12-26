package PlaneShooter.GUI;

import PlaneShooter.Combat.Combat;
import PlaneShooter.Combat.ICombatUnit;
import PlaneShooter.GUI.Component.PlaneComponentLabel;
import PlaneShooter.Helper.*;
import PlaneShooter.Plane.CustomizedPlane;
import PlaneShooter.Plane.Plane;
import PlaneShooter.Plane.PlanePart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Stack;

/**
 * 这是飞机设计器窗体。
 * 使用了一个空白的Combat来进行飞机的建造和展示。
 */

public class PlaneDesignerPanel extends JPanel {
    MainFrame mf;
    JLabel labelHeader;
    JButton btnSwitch;
    JButton btnSave;
    JButton btnUndo;
    JCheckBox cbGrid;
    JCheckBox cbMirror;
    JLabel lblStat;
    PlanePart unitSelected=null;
    PlanePart unitSelectedMirror=null;
    Stack<byte[]> undoStack=new Stack<>();
    Combat combat=new Combat(new Rectangle(600,300,200,200));
    private PlaneDesignerPanel pdp=this;
    CustomizedPlane plane;
    Timer timer=new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mf.requestFocus();
            if (pdp.mf.getContentPane() == pdp) {
                if (unitSelected != null) {
                    Point mousePos = getMousePosition();
                    if (mousePos != null) {
                        if(cbGrid.isSelected())unitSelected.setPos(getGrided(mousePos));
                        else unitSelected.setPos(mousePos);
                    }

                }
                combat.updateCombat();
                repaint();
            }
        }
    });


    public PlaneDesignerPanel(MainFrame mf) {
        super();
        this.mf=mf;
        //setLayout(null);

        JLabel lbl_Undo=new JLabel(new ImageIcon("res/undo.png"));
        lbl_Undo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popFromUndo();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(lbl_Undo);

        JLabel lbl_Save=new JLabel(new ImageIcon("res/save.png"));
        lbl_Save.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(plane.getPartCount()==0){
                    JOptionPane.showMessageDialog(mf,"You have built nothing yet!");
                    return;
                }
                if(!plane.isStatLegal()){
                    JOptionPane.showMessageDialog(mf,"Illegal Plane Stats. Please rebuild it.");
                    return;
                }
                if(!KeyHelper.isKeyPressed(KeyEvent.VK_SHIFT)&&plane.getPrice()> ProfileHelper.getCredits()){
                    JOptionPane.showMessageDialog(mf,"You can't afford such a big plane! Play more to get more credit!");
                    return;
                }
                if(FileHelper.exportPlane("PlaneFromDesigner.sav",plane)){
                    JOptionPane.showMessageDialog(mf,"Plane Saved!");
                }else JOptionPane.showMessageDialog(mf,"Oops, something happened.");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(lbl_Save);

        JLabel lbl_Back=new JLabel(new ImageIcon("res/back01.png"));
        lbl_Back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reset();
                mf.showPanel(mf.startPanel);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(lbl_Back);

        lblStat=new JLabel();
        add(lblStat);


     /*
        labelHeader=new JLabel("Plane Designer");
        labelHeader.setFont(new Font(null,0,36));
        setBackground(Color.WHITE);
        add(labelHeader);

        btnUndo=new JButton("Undo");
        btnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popFromUndo();
            }
        });
        add(btnUndo);
        btnSave=new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(plane.getPartCount()==0){
                    JOptionPane.showMessageDialog(mf,"You have built nothing yet!");
                    return;
                }
                if(!plane.isStatLegal()){
                    JOptionPane.showMessageDialog(mf,"Illegal Plane Stats. Please rebuild it.");
                    return;
                }
                if(FileHelper.exportPlane("PlaneFromDesigner.sav",plane)){
                    JOptionPane.showMessageDialog(mf,"Plane Saved!");
                }else JOptionPane.showMessageDialog(mf,"Oops, something happened.");

            }
        });
        add(btnSave);
        btnSwitch=new JButton("Back");
        btnSwitch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                mf.showPanel(mf.startPanel);
            }
        });
        add(btnSwitch);
*/



        cbGrid=new JCheckBox("Grid");
        add(cbGrid);


        cbMirror=new JCheckBox("Mirror");
        add(cbMirror);

        //PlaneComponentLabel labelComponent=new PlaneComponentLabel(new RectangleBody(new Point(0,0),null));
        //add(labelComponent);
        //timer.start();

        for(Class clazz : RegistryHelper.getPlanePartClasses()){
            try {
                PlaneComponentLabel labelComponent=new PlaneComponentLabel((ICombatUnit)clazz.newInstance());
                labelComponent.setMouseClickAction(() -> {
                    try {
                        unitSelected = (PlanePart) clazz.newInstance();
                        unitSelectedMirror = (PlanePart) clazz.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                add(labelComponent);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println(e.getButton());
                switch (e.getButton()){
                    case MouseEvent.BUTTON1:
                        if(unitSelected!=null){
                            if(combat.getCombatArea().contains(e.getPoint())){
                                pushToUndo();
                                Point posOnPlane=new Point(e.getPoint());
                                if(cbGrid.isSelected())posOnPlane=getGrided(posOnPlane);
                                posOnPlane.translate(-combat.getCombatArea().x,-combat.getCombatArea().y);
                                posOnPlane.translate(-plane.getPos().x,-plane.getPos().y);
                                unitSelected.setPos(posOnPlane);
                                unitSelected.setParent(plane);
                                plane.addComponent(unitSelected);
                                if(cbMirror.isSelected()){
                                    Point posOnPlaneMirror=new Point(posOnPlane);
                                    posOnPlaneMirror.translate(-2*posOnPlane.x,0);
                                    unitSelectedMirror.setPos(posOnPlaneMirror);
                                    unitSelectedMirror.setParent(plane);
                                    plane.addComponent(unitSelectedMirror);
                                }
                                plane.calculateStats();
                                refreshLblStat();
                                unitSelected=null;
                                unitSelectedMirror=null;
                            }
                        }
                        break;
                    case MouseEvent.BUTTON3:
                        unitSelected=null;
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        reset();

        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(unitSelected!=null && getMousePosition()!=null)unitSelected.paintUnit(g,null);
        combat.paintCombat(g);
    }

    public void reset(){
        undoStack=new Stack<>();
        combat=new Combat(new Rectangle(600,300,200,200));
        plane=new CustomizedPlane(new Point(combat.getCombatArea().width/2,combat.getCombatArea().height/2));
        combat.addCombatUnit(plane);
        refreshLblStat();
    }

    /**
     * 这里使用了一个byte[]类型的列表来存储每一步操作前的飞机，利用Serializable接口和对象输入输出流简化了本应用DeepCopy实现的功能。
     * 自我感觉还算能用。
     */
    private void pushToUndo(){
        try {
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ObjectOutputStream os=new ObjectOutputStream(baos);
            os.writeObject(plane);
            undoStack.push(baos.toByteArray());
            os.close();
            baos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    private void popFromUndo(){
        if(!undoStack.empty())
        try {
            ByteArrayInputStream bais=new ByteArrayInputStream(undoStack.pop());
            ObjectInputStream is=new ObjectInputStream(bais);
            combat=new Combat(new Rectangle(600,300,200,200));
            plane=(CustomizedPlane)is.readObject();
            combat.addCombatUnit(plane);
            bais.close();
            is.close();
            refreshLblStat();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public Point getGrided(Point p){
        Point pp=new Point(p);
        int dx=pp.x%5;
        if(dx>=3)dx-=5;
        int dy=pp.y%5;
        if(dy>=3)dy-=5;
        pp.translate(-dx,-dy);
        return pp;
    }

    public Plane getResult() {
        return plane;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(KeyHelper.hasBackground())g.drawImage(ResourceHelper.Factory,0,0,getWidth(),getHeight(),null);
        repaint();
    }

    private void refreshLblStat(){
        lblStat.setText("<html><body>Plane Price: "+plane.getPrice()+"<br>Your Credits: "+ProfileHelper.getCredits()+"</body></html>");
    }
}
