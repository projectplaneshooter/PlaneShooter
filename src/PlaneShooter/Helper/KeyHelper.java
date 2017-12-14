package PlaneShooter.Helper;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyuyzl on 2017/12/11.
 */
public class KeyHelper implements AWTEventListener {
    private static KeyHelper INSTANCE=new KeyHelper();
    private Map<Integer, Boolean> keyMap = new HashMap<>();
    public static final int KEY_DOWN=40;
    public static final int KEY_UP=38;
    public static final int KEY_LEFT=37;
    public static final int KEY_RIGHT=39;

    private void keyPressed(KeyEvent e) {
        keyMap.put(e.getKeyCode(),true);
        System.out.println(e.getKeyCode());
    }

    private void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyCode(),false);
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        if (event.getClass() == KeyEvent.class) {
            KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
                keyPressed(keyEvent);
            } else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {
                keyReleased(keyEvent);
            }
        }
    }

    public static boolean isKeyPressed(int key) {
        return (INSTANCE.keyMap.containsKey(key)&&INSTANCE.keyMap.get(key));
    }

    public static void init(){
        Toolkit.getDefaultToolkit().addAWTEventListener(INSTANCE,AWTEvent.KEY_EVENT_MASK);
    }

    public static Point getMoveVector(int v){
        int dx=0;
        int dy=0;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_DOWN))dy+=v;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_UP))dy-=v;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_LEFT))dx-=v;
        if(KeyHelper.isKeyPressed(KeyHelper.KEY_RIGHT))dx+=v;
        return new Point(dx,dy);
    }
}
