package Data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingsActionListener extends KeyAdapter {

    public boolean rightReleased = true, downReleased = true;
    boolean keyRight, keyDown,
            escape;

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = true;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = true;
                break;
            case KeyEvent.VK_ESCAPE:
                escape = true;
                break;

        }
    }
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = false;
                rightReleased = true;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = false;
                downReleased = true;
                break;
            case KeyEvent.VK_ESCAPE:
                escape = false;
                break;
        }
    }
}
