package Data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameActionListener extends KeyAdapter {
    boolean p1Move, p1Left, p1Right, p1Fire,
            p2Move, p2Left, p2Right, p2Fire,
            escape;

    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.p1Left = true;
                break;
            case KeyEvent.VK_RIGHT:
                this.p1Right = true;
                break;
            case KeyEvent.VK_UP:
                this.p1Move = true;
                break;
            case KeyEvent.VK_ENTER:
                this.p1Fire = true;
                break;
            case KeyEvent.VK_A:
                this.p2Left = true;
                break;
            case KeyEvent.VK_D:
                this.p2Right = true;
                break;
            case KeyEvent.VK_W:
                this.p2Move = true;
                break;
            case KeyEvent.VK_SPACE:
                this.p2Fire = true;
                break;
            case KeyEvent.VK_ESCAPE:
                this.escape = true;
        }
        event.consume();
    }

    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                this.p1Left = false;
                break;
            case KeyEvent.VK_RIGHT:
                this.p1Right = false;
                break;
            case KeyEvent.VK_UP:
                this.p1Move = false;
                break;
            case KeyEvent.VK_ENTER:
                this.p1Fire = false;
                break;
            case KeyEvent.VK_A:
                this.p2Left = false;
                break;
            case KeyEvent.VK_D:
                this.p2Right = false;
                break;
            case KeyEvent.VK_W:
                this.p2Move = false;
                break;
            case KeyEvent.VK_SPACE:
                this.p2Fire = false;
                break;
            case KeyEvent.VK_ESCAPE:
                this.escape = false;
        }
        event.consume();
    }
}
