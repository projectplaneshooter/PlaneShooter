package PlaneShooter.Helper;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类用于处理键盘相关的AWT事件，并封装成一些有用的模块以方便使用。
 */
public class KeyHelper implements AWTEventListener {
    private static KeyHelper INSTANCE=new KeyHelper();
    private Map<Integer, Boolean> keyMap = new HashMap<>();



    private void keyPressed(KeyEvent e) {
        keyMap.put(e.getKeyCode(),true);

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

    public static Point getMoveVector(int v,MoveKeySet keySet){
        int dx=0;
        int dy=0;
        if(KeyHelper.isKeyPressed(keySet.KeyDown))dy+=v;
        if(KeyHelper.isKeyPressed(keySet.KeyUp))dy-=v;
        if(KeyHelper.isKeyPressed(keySet.KeyLeft))dx-=v;
        if(KeyHelper.isKeyPressed(keySet.KeyRight))dx+=v;
        return new Point(dx,dy);
    }
}
