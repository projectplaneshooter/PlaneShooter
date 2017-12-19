package PlaneShooter.Helper;

import java.awt.event.KeyEvent;

public class MoveKeySet{

    public static final MoveKeySet KEY_SET_WASD=new MoveKeySet(KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_A,KeyEvent.VK_D);
    public static final MoveKeySet KEY_SET_ARROW=new MoveKeySet(KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_DOWN);

    public int KeyUp;
    public int KeyDown;
    public int KeyLeft;
    public int KeyRight;

    public MoveKeySet(int keyUp, int keyDown, int keyLeft, int keyRight) {
        KeyUp = keyUp;
        KeyDown = keyDown;
        KeyLeft = keyLeft;
        KeyRight = keyRight;
    }
}