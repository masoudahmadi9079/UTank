package Data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuActionListener extends KeyAdapter {

    public boolean enterReleased = true, downReleased = true;
    boolean keyEnter, keyDown,
            escape;

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                keyEnter = true;
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
            case KeyEvent.VK_ENTER:
                keyEnter = false;
                enterReleased = true;
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
