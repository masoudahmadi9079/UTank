package Data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BindsActionListener extends MenuActionListener {

    public int keyCode;

    public void keyPressed(KeyEvent event) {
        keyCode = event.getKeyCode();
        super.keyPressed(event);
    }
    public void keyReleased(KeyEvent event) {
        keyCode = -1;
        super.keyReleased(event);
    }
}
